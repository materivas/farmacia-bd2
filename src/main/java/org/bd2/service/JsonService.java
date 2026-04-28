package org.bd2.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bd2.model.Sistema;

import java.io.FileWriter;
import java.io.IOException;

public class JsonService {

    private static final String OUTPUT_PATH = "src/main/resources/output.json";

    public static void generarJson(Sistema sistema) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try (FileWriter writer = new FileWriter(OUTPUT_PATH)) {
            gson.toJson(sistema, writer);
            System.out.println("JSON generado en: " + OUTPUT_PATH);
        } catch (IOException e) {
            throw new RuntimeException("Error al generar JSON", e);
        }
    }

    public static String toJson(Sistema sistema) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        return gson.toJson(sistema);
    }
}