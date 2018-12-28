package utilities;

import models.Sheet;

import java.util.List;

public class PrintUtils {

    public static void printAllSheets(List<Sheet> sheets) {
        for (Sheet sheet : sheets) {
            System.out.println(sheet);
        }
    }

}
