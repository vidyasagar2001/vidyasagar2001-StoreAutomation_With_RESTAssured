package api.utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "Data")
    public String[][] getAllData() throws IOException {
        String path = "D:\\seleniumwebdriver\\RestAssuredLearningTesting\\RestAssuredFramework\\testData\\TestedAPIData.xlsx"; // Fixed path
        XLUtility xl = new XLUtility(path);

        int rownum = xl.getRowCount("Sheet1");
        int colcount = xl.getCellCount("Sheet1", 1);

        String apidata[][] = new String[rownum][colcount];

        for (int i = 1; i <= rownum; i++) {  // Start from 1
            for (int j = 0; j < colcount; j++) {
                apidata[i - 1][j] = xl.getCellData("Sheet1", i, j); // Adjust indexing
            }
        }
        return apidata;
    }

    @DataProvider(name = "UserNames")
    public String[] getUserNames() throws IOException {
        String path = "D:\\seleniumwebdriver\\RestAssuredLearningTesting\\RestAssuredFramework\\testData\\TestedAPIData.xlsx"; // Fixed path
        XLUtility xl = new XLUtility(path);

        int rownum = xl.getRowCount("Sheet1");
        String apidata[] = new String[rownum];

        for (int i = 1; i <= rownum; i++) { // Start from 1
            apidata[i - 1] = xl.getCellData("Sheet1", i, 1); // Adjust indexing
        }
        return apidata;
    }
}
