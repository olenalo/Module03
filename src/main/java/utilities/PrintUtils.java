package utilities;

import models.DataCell;
import models.Sheet;

import java.util.List;

public class PrintUtils {

    public static void printSheets(List<Sheet> sheets) {
        for (Sheet sheet : sheets) {
            System.out.println(sheet);
        }
    }

    public static void printCells(List<DataCell> cells) {
        for (DataCell cell : cells) {
            System.out.println(cell);
        }
    }

}
