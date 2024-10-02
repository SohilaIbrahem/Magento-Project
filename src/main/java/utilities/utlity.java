package utilities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class utlity {


    // TODO: Read Data From Excel Sheet
    public static String getExcelData(int RowNum, int ColNum, String SheetName) {
        XSSFWorkbook workBook;
        XSSFSheet sheet;
        String projectPath = System.getProperty("user.dir");
        String cellData = null;
        try {
            workBook = new XSSFWorkbook(projectPath + "/src/test/resources/testData/test_data.xlsx");
            sheet = workBook.getSheet(SheetName);
            cellData = sheet.getRow(RowNum).getCell(ColNum).getStringCellValue();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return cellData;
    }
    // TODO: capture screenshot
    public static void captureScreenshot(WebDriver driver,String screenshotName){
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
        Date currntDate=new Date();
        String screenshot=currntDate.toString().replace(" ","-").
                replace(":","-");
        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE),
                    new File(System.getProperty("user.dir")+"/src/test/resources/screenshots/"
                            +screenshot+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //TODO: Read data from json file
    public static String getData(String jsonPath, String field) {
        try {
            //Define object of json parser
            JsonParser parser = new JsonParser();
            //Define object of file Reader
            FileReader reader = new FileReader(jsonPath);
            Object object = parser.parse(reader);

            JsonObject jsonOject = (JsonObject) object;

            return jsonOject.get(field).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public static int generateRandomNumber(int lowerBound , int upperBound)
    {
        Random random =new Random();
        int randomNumbers =random.nextInt(upperBound-lowerBound+1) +lowerBound;

        return randomNumbers;
    }
}
