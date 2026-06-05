package org.bd2.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.bd2.model.Sistema;
import org.bd2.model.Venta;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class JsonService {

    private static final String OUTPUT_PATH = "src/main/resources/output.json";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static Gson buildGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new TypeAdapter<LocalDateTime>() {
                    @Override
                    public void write(JsonWriter out, LocalDateTime value) throws IOException {
                        if (value == null) {
                            out.nullValue();
                        } else {
                            out.value(value.format(FORMATTER));
                        }
                    }

                    @Override
                    public LocalDateTime read(JsonReader in) throws IOException {
                        return LocalDateTime.parse(in.nextString(), FORMATTER);
                    }
                })
                .create();
    }

    public static void generarJson(Sistema sistema) {
        Gson gson = buildGson();
        try (FileWriter writer = new FileWriter(OUTPUT_PATH)) {
            gson.toJson(sistema, writer);
            System.out.println("JSON generado en: " + OUTPUT_PATH);
        } catch (IOException e) {
            throw new RuntimeException("Error al generar JSON", e);
        }
    }

    public static String toJson(Sistema sistema) {
        return buildGson().toJson(sistema);
    }
    
    public static void generarJsonVentas(List<Venta> ventas) {
        Gson gson = buildGson();
        try (FileWriter writer = new FileWriter(OUTPUT_PATH)) {
            gson.toJson(ventas, writer);
            System.out.println("JSON generado en: " + OUTPUT_PATH);
        } catch (IOException e) {
            throw new RuntimeException("Error al generar JSON", e);
        }
    }
}