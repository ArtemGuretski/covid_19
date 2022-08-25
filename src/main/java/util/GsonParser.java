package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Artem Guretski
 */
public class GsonParser {

    public static <T> T parse(String source, Class<T> targetClass) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        return gson.fromJson(source, targetClass);
    }
}
