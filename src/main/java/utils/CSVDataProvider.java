package utils;

import com.opencsv.CSVReader;

import java.io.*;

public class CSVDataProvider {

    private static CSVReader reader = null;
    private static Object[][] data = null;


    private static String getFilePath(String fileName){
        String path = CSVReader.class.getClassLoader().getResource(fileName).getPath();
        return path;
    }

    public static Object[][] convertCSVFileToDataproviderObject(String fileName, boolean fileWithHeader) throws IOException {
        String[] csvRow;
        data = new Object[linesInAFile(fileName, fileWithHeader)][getColsInCSVLine(fileName)];
        int row = 0;
        int col = 0;
        try {
            reader = new CSVReader(new FileReader(getFilePath(fileName)), ',' , '"' , 1);

            try {
                while((csvRow = reader.readNext()) != null ){
                    int i = csvRow.length;
                    if (row <= data.length){
                        while (col < csvRow.length) {
                            data[row][col] = csvRow[col];
                            col++;
                        }
                    }
                    col = 0;
                    row++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    //counting lines in CSV file
    private static int linesInAFile(String fileName, boolean withHeader) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(getFilePath(fileName)));
        int lines = 0;
        while (reader.readLine() != null)
            lines++;
        reader.close();
        if(withHeader)
            return (lines - 1);
        else
            return lines;
    }

    //Counting number of elements in line of CSV file
    private static  int getColsInCSVLine(String fileName) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(getFilePath(fileName)));
        String[] csvLine = reader.readNext();
        return csvLine.length;
    }

}
