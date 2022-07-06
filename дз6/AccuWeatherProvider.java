import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import enums.Periods;

import java.io.IOException;

public class AccuWeatherProvider implements WeatherProvider{
    public static final String BASE_HOST = "dataservice.accuweather.com";
    public static final String FORECAST_ENDPOINT = "forecasts";
    public static final String CURRENT_CONDITION_ENDPOINT = "currentconditions";
    public static final String API_VERSION = "v1";
    public static final String API_KEY = ApplicationGlobalState.getINSTANCE().getAPI_KEY();
    public static final String fiveDay = "5day";


    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void getWeather(Periods periods) throws IOException {
        String cityKey = detectCityKey();
        if (periods.equals(Periods.NOW)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITION_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        }
        else if (periods.equals(Periods.FIVE_DAYS)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(ApplicationGlobalState.getINSTANCE().getDaily())
                    .addPathSegment(fiveDay)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        }
    }

    public String detectCityKey () throws IOException {
        String selectedCity = ApplicationGlobalState.getINSTANCE().getSelectedCity();

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
}
