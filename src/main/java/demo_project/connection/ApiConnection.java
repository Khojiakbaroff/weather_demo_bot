package demo_project.connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import demo_project.model.Weather;
import demo_project.service.ApiConnectionService;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ApiConnection implements ApiConnectionService<Weather> {
    private static final Gson gson = new Gson();

    @Override
    public Weather getConnection(String val) {
        BufferedReader reader = null;
        try {
            URL url = new URL("https://api.weatherapi.com/v1/current.json?key=625e889ecc544af3a6d74305220712&q=" + val + "&aqi=no");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            return  gson.fromJson(reader, TypeToken.get(Weather.class));
        } catch (IOException e) {
           e.printStackTrace(System.err);
        }
        finally {
            try {
                assert reader != null;
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
