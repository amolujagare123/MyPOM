package DatabaseTest;

import com.invoiceplane.pages.Clients.AddClient;
import com.invoiceplane.pages.Login;
import com.invoiceplane.pages.Menu;
import com.invoiceplane.utilities.Driver;
import com.invoiceplane.utilities.initExtentReport;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.invoiceplane.utilities.ConvertCountry.convertCountry;
import static com.invoiceplane.utilities.TakeScreenshot.takeScreenshot;

/**
 * Created by user on 23/04/2017.
 */
public class AddClientDbTest {
    WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);

    ExtentReports extent;

    @BeforeMethod
    public void login() {

        extent = initExtentReport.init();
        ResourceBundle rb = ResourceBundle.getBundle("InvoicePlane");

        driver.get("http://localhost/invoiceplane2/index.php/sessions/login");


        Login login = new Login(driver);
        login.setUsername("talkswap369patil@gmail.com");
        login.setPassword("swap@369");
        login.clickLogin();
    }
  /*  @Test
    public void myTest() throws IOException {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        driver = new ChromeDriver();
        ExtentReports extent = new ExtentReports("Extent-Report/report.html", true, NetworkMode.OFFLINE);
        ExtentTest test = extent.startTest("Login Test", "Login test for valid user");
        driver.get("http://billing.scriptinglogic.net");
        test.log(LogStatus.INFO, "url is opened");
        driver.findElement(By.xpath("./*//*[@id='email']")).sendKeys("amolujagare@gmail.com");
        test.log(LogStatus.INFO, "username is set");

        driver.findElement(By.xpath("./*//*[@id='password']")).sendKeys("admin123");

        test.log(LogStatus.INFO, "password is set");
        driver.findElement(By.xpath("./*//*[@id='login']/form/input")).click();
       test.log(LogStatus.INFO, "login button clicked");

        test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/" + takeScreenshot(driver)));


        extent.endTest(test);
        extent.flush();
    }
*/

    @Test(dataProvider = "getData")
    public void addclienttest(String clientname, String Streetaddress, String Streetaddress2, String city, String state, String zipcode,String country,
                              String phonenumber, String faxnumber, String mobilenumber, String emailaddress, String webaddress, String vatid, String taxcode) throws IOException, SQLException, ClassNotFoundException {

        ArrayList<String> alExpected = new ArrayList<>();  //we write here expected array
       //clientname,Steetaddress1,Steetaddress2,city,state,zipcode,country,phonenumber,faxnumber,mobilenumber,emailaddress,webaddress,vatid,taxcode);
        alExpected.add(clientname);
        alExpected.add(Streetaddress);
        alExpected.add(Streetaddress2);
        alExpected.add(city);
        alExpected.add(state);
        alExpected.add(zipcode);
        alExpected.add(country);
        alExpected.add(phonenumber);
        alExpected.add(faxnumber);
        alExpected.add(mobilenumber);
        alExpected.add(emailaddress);
        alExpected.add(webaddress);
        alExpected.add(vatid);
        alExpected.add(taxcode);

        ExtentReports extent = new ExtentReports("Extent-Report/report.html", true, NetworkMode.OFFLINE);
        ExtentTest test = extent.startTest("Add client Test", "Add client test for enter input");// for extent report

        Menu menu = new Menu(driver);

        menu.clickAddclient();

        //ExtentReports extent = new ExtentReports("Extent-Report/report.html", true, NetworkMode.OFFLINE);// for extent report


        AddClient addClient = new AddClient(driver);

        addClient.setclientname(clientname);
        test.log(LogStatus.INFO, "client name is Enter as "+clientname); //log for extent report

        addClient.setstreetaddress1(Streetaddress);
        test.log(LogStatus.INFO, "Street address is Enter as" + Streetaddress);
        addClient.setstreetaddress2(Streetaddress2);
        test.log(LogStatus.INFO, "Street address 2 is Enter as " + Streetaddress2);
        addClient.setcity(city);
        test.log(LogStatus.INFO, "City is Enter as " + city);
        addClient.setstate(state);
        test.log(LogStatus.INFO, "state is Enter as " + state);
        addClient.setzipcode(zipcode);
        test.log(LogStatus.INFO, "Zipcode is Enter as " + zipcode);
        addClient.setcountry(country);
        test.log(LogStatus.INFO,"country is Enter as "+country);
        addClient.setphonenumber(phonenumber);
        test.log(LogStatus.INFO, "Phonenumber is Enter as "+phonenumber);

        addClient.setfaxnumber(faxnumber);
        test.log(LogStatus.INFO, "Faxnumber is Enter as "+faxnumber);

        addClient.setmobilenumber(mobilenumber);
        test.log(LogStatus.INFO, "mobilenumber is Enter as "+mobilenumber);
        addClient.setemailaddress(emailaddress);
        test.log(LogStatus.INFO, "emailaddress is Enter as "+emailaddress);
        addClient.setwebaddress(webaddress);
        test.log(LogStatus.INFO, "webaddress is Enter as "+webaddress);

        addClient.setvatid(vatid);
        test.log(LogStatus.INFO, "vatid is Enter as "+vatid);
        addClient.settaxcode(taxcode);
        test.log(LogStatus.INFO, "taxcode is Enter as "+taxcode);
        addClient.setBtnsave();
        test.log(LogStatus.INFO, "save is clicked");

        Class.forName("com.mysql.jdbc.Driver");//for loading driver

        String url="jdbc:mysql://localhost:3306/invoice";  //jdbc code here we add the table name "invoice" which i want to access

        String user="root";                   //crating connection with database for that  we write 4 line

        String password="root";

        Connection con = DriverManager.getConnection(url, user, password);

        Statement st = con.createStatement(); //Creating statment:- sataement will create using this

        String sql = "select * from ip_clients where client_name='"+clientname+"'"; //Execute the query

        ResultSet rs = st.executeQuery(sql);// it will return output which is defined below eg; rs.getString("client_name");

        ArrayList <String> alActual = new ArrayList<>();  ////we write here Actual array
       // Steetaddress1,Steetaddress2,city,state,zipcode,country,phonenumber,faxnumber,mobilenumber,emailaddress,webaddress,vatid,taxcode);
        while(rs.next())
        {
            alActual.add(rs.getString("client_name")); //we use the names same as in database table mention.also datatype  according to  table
            alActual.add(rs.getString("client_address_1"));
            alActual.add(rs.getString("client_address_2"));
            alActual.add(rs.getString("client_city"));
            alActual.add(rs.getString("client_State"));
            alActual.add(rs.getString("client_zip"));
            alActual.add(convertCountry(rs.getString("client_country")));
            alActual.add(rs.getString("client_phone"));
            alActual.add(rs.getString("client_fax"));
            alActual.add(rs.getString("client_mobile"));
            alActual.add(rs.getString("client_email"));
            alActual.add(rs.getString("client_web"));
            alActual.add(rs.getString("client_vat_id"));
            alActual.add(rs.getString("client_tax_code"));

        }
        Assert.assertEquals(alActual,alExpected);

        test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/" + takeScreenshot(driver)));//log for snapshot

        extent.endTest(test);
        extent.flush();

    }

    @DataProvider

    public String[][] getData() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("Data/Pomdatasheet.xls");//copy path of Exelsheet here

        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream); //create object for workbook

        HSSFSheet worksheet = workbook.getSheet("Sheet2"); // get the proper sheet from exel

        int rowcount = worksheet.getPhysicalNumberOfRows();

        String[][] data = new String[rowcount - 1][14];
        for (int i = 1; i < rowcount; i++) {
            HSSFRow row = worksheet.getRow(i);

            HSSFCell clientname = row.getCell(0);

            if (clientname == null)
                data[i - 1][0] = "";
            else {
                clientname.setCellType(CellType.STRING);// to convert numbers into string we use setCell type
                data[i - 1][0] = clientname.getStringCellValue();
            }

            HSSFCell address1 = row.getCell(1);//for get cell
            if (address1 == null)
                data[i - 1][1] = "";
            else {
                address1.setCellType(CellType.STRING);

                data[i - 1][1] = address1.getStringCellValue();
            }

            HSSFCell address2 = row.getCell(2);
            if (address2 == null)
                data[i - 1][2] = "";
            else {
                address2.setCellType(CellType.STRING);
                data[i - 1][2] = address2.getStringCellValue();
            }

            HSSFCell city = row.getCell(3);
            if (city == null)
                data[i - 1][3] = "";
            else {
                city.setCellType(CellType.STRING);
                data[i - 1][3] = city.getStringCellValue();
            }

            HSSFCell state = row.getCell(4);
            if (state == null)
                data[i - 1][4] = "";
            else {
                state.setCellType(CellType.STRING);
                data[i - 1][4] = state.getStringCellValue();
            }


            HSSFCell zipcode = row.getCell(5);
            if (zipcode == null)
                data[i - 1][5] = "";
            else {
                zipcode.setCellType(CellType.STRING);
                data[i - 1][5] = zipcode.getStringCellValue();
            }

            HSSFCell county = row.getCell(6);
            if (county == null)
                data[i - 1][6] = "";
            else {
                county.setCellType(CellType.STRING);
                data[i - 1][6] = county.getStringCellValue();
            }

            HSSFCell phonenumber = row.getCell(7);
            if (phonenumber == null)
                data[i - 1][7] = "";
            else {
                phonenumber.setCellType(CellType.STRING);
                data[i - 1][7] = phonenumber.getStringCellValue();
            }

            HSSFCell faxno = row.getCell(8);
            if (faxno == null)
                data[i - 1][8] = "";
            else {
                faxno.setCellType(CellType.STRING);
                data[i - 1][8] = faxno.getStringCellValue();
            }

            HSSFCell mobno = row.getCell(9);
            if (mobno == null)
                data[i - 1][9] = "";
            else {
                mobno.setCellType(CellType.STRING);
                data[i - 1][9] = mobno.getStringCellValue();
            }


            HSSFCell emailadd = row.getCell(10);
            if (emailadd == null)
                data[i - 1][10] = "";
            else {
                emailadd.setCellType(CellType.STRING);
                data[i - 1][10] = emailadd.getStringCellValue();
            }

            HSSFCell webaddress = row.getCell(11);
            if (webaddress == null)
                data[i - 1][11] = "";
            else {
                webaddress.setCellType(CellType.STRING);
                data[i - 1][11] = webaddress.getStringCellValue();
            }

            HSSFCell vatid = row.getCell(12);
            if (vatid == null)
                data[i - 1][12] = "";
            else {
                vatid.setCellType(CellType.STRING);
                data[i - 1][12] = vatid.getStringCellValue();
            }

            HSSFCell taxcode = row.getCell(13);
            if (taxcode == null)
                data[i - 1][13] = "";
            else {
                taxcode.setCellType(CellType.STRING);
                data[i - 1][13] = taxcode.getStringCellValue();
            }


        }

        return data;
    }
}

