package lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;


public class Forecast5 {
    public static final String BASE_HOST = "dataservice.accuweather.com";
    public static final String FORECASTS = "forecasts";
    public static final String API_VERSION = "v1";
    public static final String PERIOD = "daily";
    public static final String DAYS_NUMBER = "5day";
    public static final String CITY = "295212";

    public static final String API_KEY = "GvAiQ3rejeRD7VYaj44XXE8PHh8T1C2N";

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECASTS)
                .addPathSegment(API_VERSION)
                .addPathSegment(PERIOD)
                .addPathSegment(DAYS_NUMBER)
                .addPathSegment(CITY)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("Language", "ru-ru")
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();
        String jsonResponse = client.newCall(request).execute().body().string();

        File file = new File("./forecast5.json");
        if (!file.exists()) {
            file.createNewFile();
        }
        try (PrintWriter out = new PrintWriter(file)) {
            out.print(jsonResponse);
            System.out.println("Погода за 5 дней записана в файл " + file.getName());
        }

    }
}
