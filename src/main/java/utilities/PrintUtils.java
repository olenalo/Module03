package utilities;

import models.Cell;
import models.Sheet;

import java.util.List;

public class PrintUtils {

    public static void printSheets(List<Sheet> sheets) {
        for (Sheet sheet : sheets) {
            System.out.println(sheet);
        }
    }

    public static void printCells(List<Cell> cells) {
        for (Cell cell : cells) {
            System.out.println(cell);
        }
    }

}
