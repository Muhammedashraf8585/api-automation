package utils;

import org.json.JSONObject;

public class TestUtils {
    public static String getLoginPayload() {
        JSONObject payload = new JSONObject();
        payload.put("email", config.Config.EMAIL);
        payload.put("password", config.Config.PASSWORD);
        return payload.toString();
    }
}