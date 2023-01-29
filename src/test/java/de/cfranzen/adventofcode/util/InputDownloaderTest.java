package de.cfranzen.adventofcode.util;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled("Since the session-id will not be committed in application.properties, these tests can only run " +
        "locally after providing a session-id")
class InputDownloaderTest {

    @Test
    void testDownloadingInput() throws IOException {
        InputDownloader downloader = new InputDownloader();
        try (BufferedReader reader = downloader.download(2022, 1)) {
            assertThat(reader.lines().toList()).isNotEmpty();
        }
    }
}