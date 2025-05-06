package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.openqa.selenium.devtools.v120.network.model.Request;
import org.openqa.selenium.devtools.v120.network.model.Response;

import java.io.IOException;

public class AIUtility {

    private static final String OPENAI_API_KEY = "your-openai-api-key";
    private static final String API_URL = "https://api.openai.com/v1/completions";

    public static String generateTestData(String prompt) throws IOException {
        OkHttpClient client = new OkHttpClient();

        JsonObject json = new JsonObject();
        json.addProperty("model", "text-davinci-003");
        json.addProperty("prompt", prompt);
        json.addProperty("max_tokens", 50);

        RequestBody body = RequestBody.create(
                json.toString(), MediaType.get("application/json; charset=utf-8"));

        Request request = new Request.Builder()
                .url(API_URL)
                .addHeader("Authorization", "Bearer " + OPENAI_API_KEY)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseData = response.body().string();
            JsonObject result = JsonParser.parseString(responseData).getAsJsonObject();
            return result.getAsJsonArray("choices")
                    .get(0).getAsJsonObject()
                    .get("text").getAsString().trim();
        }
    }
}
