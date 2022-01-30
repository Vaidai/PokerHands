package com.game.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputDataReaderTest {
    protected static final String TEST_FILE_NAME = "poker.txt";

    @Test
    void whenReadingFileAsListOfString_thenGetArrayListWith5Lines() {
        List<String> testFileLines = InputDataReader.ReadTestData(TEST_FILE_NAME);
        assertEquals(5, testFileLines.size());
    }

    @Test
    void readFirstLine() {
        List<String> lines = InputDataReader.ReadTestData(TEST_FILE_NAME);
        assertEquals("5H 5C 6S 7S KD 2C 3S 8S 8D TD", lines.get(0));
    }

    @Test
    void wrongFileName() {
        assertThrows(RuntimeException.class, () -> {
            InputDataReader.ReadTestData("wrongFileName.txt");
        });
    }

}