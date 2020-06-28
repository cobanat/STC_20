package homework.part1.lesson16;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("App started.");
        logger.debug("debug");

        try {
            Files.readAllBytes(Paths.get("file not exist"));
        } catch (IOException e) {
            logger.error("Error:", e);
        }

        int[] array = new int[5];
        try {
            array[3] = array[6]++;
        } catch (IndexOutOfBoundsException e) {
            logger.error("Error:", e);
        }
    }
}
