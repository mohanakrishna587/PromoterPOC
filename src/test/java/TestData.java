
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class TestData {

    /*@DataProvider(name = "Additions")
    public Object[][] additionData(){
        return new Object[][]{{"3","5","8"},{"25","5","30"},{"30","20","51"}};
    }

    @DataProvider(name = "Names")
    public static Object[] getNames() throws IOException {

        File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\Data.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet("Names");
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        String[] names = new String[rowCount+1];
        for (int i = 0; i < rowCount+1; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                names[i] = row.getCell(j).getStringCellValue();
                System.out.println(row.getCell(j).getStringCellValue()+" || ");
            }
        }
        return names;
    }

    public static void main(String[] args) throws IOException {
        getNames();
    }*/
}
