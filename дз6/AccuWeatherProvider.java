import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import configuration.ApplicationGlobalState;
import dto.WeatherResponse;
import repository.DatabaseRepositorySQLiteImpl;
import entity.WeatherData;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import enums.Periods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import repository.DatabaseRepository;


public class AccuWeatherProvider implements WeatherProvider {
    public static final String BASE_HOST = "dataservice.accuweather.com";
    public static final String FORECAST_ENDPOINT = "forecasts";
    public static final String CURRENT_CONDITION_ENDPOINT = "currentconditions";
    public static final String API_VERSION = "v1";
    public static final String API_KEY = ApplicationGlobalState.getInstance().getAPI_KEY();
    public static final String fiveDay = "5day";
    private static final String FORECAST_TYPE = "daily";


    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final DatabaseRepository repository = new DatabaseRepositorySQLiteImpl();
    private entity.WeatherData WeatherData;


    @Override
    public void getWeather(Periods periods) throws IOException, SQLException {

        if (periods.equals(Periods.NOW)) {
            String cityKey = detectCityKey();
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITION_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", "ru-ru")
                    .addQueryParameter("metric", "true")
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            String responseList = client.newCall(request).execute().body().string();

            List<WeatherResponse> weatherResponseList = objectMapper.readValue(responseList, new TypeReference<List<WeatherResponse>>() {
            });

            WeatherResponse weather = weatherResponseList.get(0);

            System.out.println("Сейчас в городе " + ApplicationGlobalState.getInstance().getSelectedCity() +
                    " температура " + weather.getTemperature().getMetric().getValue() + "°С, и " + weather.getWeatherText() + ".");
        } else if (periods.equals(Periods.FIVE_DAYS)) {
            String cityKey = detectCityKey();
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(FORECAST_TYPE)
                    .addPathSegment(fiveDay)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", "ru-ru")
                    .addQueryParameter("metric", "true")
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();
            String responseList = client.newCall(request).execute().body().string();

            int firstIndexBody = responseList.indexOf("[{\"Date\"");
            int lastIndexBody = responseList.lastIndexOf("}");
            responseList = responseList.substring(firstIndexBody, lastIndexBody);

            List<WeatherResponse> weatherResponseList = objectMapper.readValue(responseList, new TypeReference<List<WeatherResponse>>() {
            });

            for (WeatherResponse weather : weatherResponseList) {
                System.out.println(("В городе " + ApplicationGlobalState.getInstance().getSelectedCity() + " на следующую дату " + weather.getDate().substring(0, 10) +
                        " ожидается такая погода: Минимальная температура " + weather.getTemperature().getMinimum().getValue() + "°С. Максимальная температура " +
                        weather.getTemperature().getMaximum().getValue() + "°С. Днём - " + weather.getDay().getIconPhrase() + ". Ночью - " + weather.getNight().getIconPhrase() + "."));

                WeatherData weatherData = new WeatherData(ApplicationGlobalState.getInstance().getSelectedCity(),
                        weather.getDate().substring(0, 10), weather.getDay().getIconPhrase(), weather.getNight().getIconPhrase(),
                        castFloatToDouble(weather.getTemperature().getMinimum().getValue()), castFloatToDouble(weather.getTemperature().getMaximum().getValue())
                );

                repository.saveWeatherData(weatherData);
            }
        }
        if (periods.equals(Periods.BASE)) {
            getAllFromDB();
        }
    }

    @Override
    public List<WeatherData> getAllFromDB() throws IOException, SQLException {
        List<WeatherData> weatherDataList = repository.getAllSavedData();
        for (WeatherData weatherData : weatherDataList){
            System.out.println(weatherData);
        }
        return weatherDataList;
    }

    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();
        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(detectLocationUrl)
                .build();
        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException(" Невозможнно прочесть информацию о городе " +
                    " код ответа сервер = " + response.code() + " тело ответа = " +
                    response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println(" Произвожу поиск города " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println(" Найден город " + cityName + " в стране " + countryName);
        } else throw new IOException(" Server returns 0 cities");
        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }

    private Double castFloatToDouble(float value) {
        //widening the float object
        return (double) value;
    }

    public String trimBrackets(JsonNode string) {
        int lastIndexBody = string.toString().lastIndexOf("\"");
        String newString = string.toString().substring(1, lastIndexBody);
        return newString;
    }
}
