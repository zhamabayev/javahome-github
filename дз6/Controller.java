import enums.Functionality;
import enums.Periods;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    WeatherProvider weatherProvider = new AccuWeatherProvider();
    Map<Integer, Functionality> variantResult = new HashMap<>();

    public Controller () {
        variantResult.put(1,Functionality.GET_CURRENT_WEATHER);
        variantResult.put(2,Functionality.GET_WEATHER_IN_NEXT_5_DAYS);
    }

    public void onUserInput(String input) throws IOException {
        int command = Integer.parseInt((input));
        if (!variantResult.containsKey(command)) {
            throw new IOException("there is no command for command - key " + command);
        }
        switch (variantResult.get(command)) {
            case GET_CURRENT_WEATHER:
                getCurrentWeather();
                break;
            case GET_WEATHER_IN_NEXT_5_DAYS:
                getWeatherIn5Days();
                break;
            case EXIT:
                exitApp();
                break;
        }
    }
        public void getCurrentWeather () throws IOException {
            weatherProvider.getWeather(Periods.NOW);
        } //throw new RuntimeException("Implement in h/w");
        public void getWeatherIn5Days() throws IOException {
        weatherProvider.getWeather(Periods.FIVE_DAYS);
        }
        public void exitApp() throws IOException {
            System.out.println("Завершаю рабооту");
            System.exit(4);
        }

    }
