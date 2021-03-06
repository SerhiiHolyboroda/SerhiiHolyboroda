package DataTransformation.Main;

import DataTransformation.Classes.FileCreation;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, CsvException {
        FileCreation a = new FileCreation();
        a.createCSV("Random");
//        FileTransformer f = new FileTransformer();
//        f.transformData();
    }
}
