package dataProviders;

import org.testng.annotations.DataProvider;
import utils.CSVDataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "users")
    public static Object[][] users() throws IOException {
        Object[][] data = CSVDataProvider.convertCSVFileToDataproviderObject("users.csv", true);
        return data;
    }
}
