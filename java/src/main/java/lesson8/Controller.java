package lesson8;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static lesson8.Periods.IN5DAYS;

public class Controller {
    WeatherProvider weatherProvider = new AccuWeatherProvider();
    Map<Integer, Functionality> variantResult = new HashMap();

    public Controller() {
        variantResult.put(1, Functionality.GET_WEATHER_IN_NEXT_5_DAYS);
    }

    public void onUserInput(String input) throws IOException {
        int command = Integer.parseInt(input);
        if (!variantResult.containsKey(command)) {
            throw new IOException("There is no command for command-key " + command);
        }
        switch (variantResult.get(command)) {
            case GET_WEATHER_IN_NEXT_5_DAYS:
                WeatherProvider.getWeather(IN5DAYS);
                break;
        }

    }

}