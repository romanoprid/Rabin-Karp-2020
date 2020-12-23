package ua.lviv.iot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.manager.ReadWriteManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RabinCarpManagerTest {

  private Scanner scanner;

    @BeforeEach
    public void initializeScanner() {
      try {
        scanner = new Scanner(new File("result.txt"));
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }

    @Test
    void testExample() throws FileNotFoundException {
      ReadWriteManager.readFromFile("rabin.txt");

      List<String> expected = new ArrayList<>();
      expected.add("(0,3)");
      expected.add("(13,16)");
      for (String expectedLine : expected) {
        assertEquals(expectedLine, scanner.nextLine());
      }

    }
}