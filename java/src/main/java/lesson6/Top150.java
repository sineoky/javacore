package lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Top150 {
    public static final String BASE_HOST = "dataservice.accuweather.com";
    public static final String LOCATIONS = "locations";
    public static final String API_VERSION = "v1";
    public static final String TOP_CITIES = "topcities";
    public static final String CITIES_NUMBER = "150";

    public static final String API_KEY = "0E2atmhXpOan3HqdvRFaAkTx0ceEJITT";

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(API_VERSION)
                .addPathSegment(TOP_CITIES)
                .addPathSegment(CITIES_NUMBER)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("Language", "ru-ru")
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();
        String jsonResponse = client.newCall(request).execute().body().string();

        File file = new File("./top150.json");
        if (!file.exists()) {
            file.createNewFile();
        }
        try (PrintWriter out = new PrintWriter(file)) {
            out.print(jsonResponse);
            //из этого файла найдем id Санкт-Петербурга
            System.out.println("Информация по 150 городам записана в файл " + file.getName());
        }

        //System.out.println(jsonResponse);
    }
}
