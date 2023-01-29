package de.cfranzen.adventofcode.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

public class InputDownloader {

    private static final URI BASE_URI = URI.create("https://adventofcode.com/");
    private final HttpClient httpClient;
    private final String sessionId;

    public InputDownloader() {
        this.sessionId = loadSessionId();
        this.httpClient = HttpClient.newBuilder().build();
    }

    public List<String> downloadLines(int year, int day) {
        try (BufferedReader reader = download(year, day)) {
            return reader.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedReader download(int year, int day) {
        final URI uri = BASE_URI.resolve("/" + year + "/day/" + day + "/input");

        final HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("cookie", "session=" + sessionId)
                .GET()
                .build();

        try {
            final HttpResponse<InputStream> response = httpClient.send(request, BodyHandlers.ofInputStream());
            if (response.statusCode() < 200 || response.statusCode() >= 300) {
                throw new IllegalStateException("Unable to retrieve input: error " + response.statusCode());
            }
            return new BufferedReader(new InputStreamReader(response.body(), StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String loadSessionId() {
        final Properties properties = new Properties();
        try (final InputStream is = InputDownloader.class.getResourceAsStream("/application.properties")) {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        final String sessionId = properties.getProperty("adventofcode.session-id");
        if (sessionId == null) {
            throw new IllegalStateException("Unable to load sessionId from application.properties");
        }
        return sessionId;
    }
}
