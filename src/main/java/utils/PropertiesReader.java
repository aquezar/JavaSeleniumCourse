package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static Properties getPropertiesFromFile(String propertiesFileName){
        String path = GetPathToResorce.getPath(propertiesFileName);

        File propertiesFile = new File(path);
        FileInputStream fileInput = null;
        try{
            fileInput = new FileInputStream(propertiesFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }
}
