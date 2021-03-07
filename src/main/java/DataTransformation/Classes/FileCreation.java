package DataTransformation.Classes;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class FileCreation {




    public void createCSV(String fileName) throws IOException {

        Workbook workbook = new HSSFWorkbook();


        ArrayList<Integer> random = new ArrayList<Integer>() ;
        IntStream stream = IntStream.generate(() -> { return (int)(Math.random() * 10000); });


        Sheet sheet = workbook.createSheet(fileName);
        stream.limit(10).forEach(value -> random.add(value));

        Iterator<Integer> iterator = random.iterator();

        int rowIndex = 0;
        while(iterator.hasNext()){
//            Random r = new Random();
//            Integer e = random.get(r.nextInt(random.size()));
            Random r = new Random();
            char c = (char)(r.nextInt(26) + 'a');

            System.out.println(c + "e!");
            Integer randomIterator= iterator.next();
            Row row = (Row) sheet.createRow(rowIndex++);
            Cell cell0 = row.createCell(0);
            cell0.setCellValue(c);
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(c);
        }



        Path resourceDirectory = Paths.get("src","test","resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();




        File targetFile =new File(absolutePath , fileName + ".csv");
        FileOutputStream fos1 = new FileOutputStream(targetFile);
        workbook.write(fos1);
    }

}
