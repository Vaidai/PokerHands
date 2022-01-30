package com.game.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class InputDataReader {

    public static List<String> ReadFile(String fileName) {
        return ReadFile("main", fileName);
    }

    public static List<String> ReadTestData(String fileName) {
        return ReadFile("test", fileName);
    }

    private static List<String> ReadFile(String resource, String fileName) {
        try {
            return Files.readAllLines(Paths.get("src", resource, "resources", fileName));
        } catch (IOException e) {

            throw new RuntimeException("There is no file with this name.", e);
        }
    }
}
