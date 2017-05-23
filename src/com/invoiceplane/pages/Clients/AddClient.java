package com.invoiceplane.pages.Clients;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by user on 2/12/2017.
 */
public class AddClient {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='client_name']")
    WebElement txtclientname;


    @FindBy(xpath = ".//*[@id='client_address_1']")
    WebElement txtstreetaddress;


    @FindBy(xpath = ".//*[@id='client_address_2']")
    WebElement txtstreetaddress2;

    @FindBy(xpath = ".//*[@id='client_city']")
    WebElement txtCity;

    @FindBy(xpath = ".//*[@id='client_state']")
    WebElement txtstate;

    @FindBy(xpath = ".//*[@id='client_zip']")
    WebElement txtzipcode;

    @FindBy(xpath = "//span[@id='select2-client_country-container']")
    WebElement containerCountry;
    //click

    @FindBy(xpath="//input[@type='search']")
    WebElement inputCountry;

    @FindBy(xpath = ".//*[@id='select2-client_country-container']")
    WebElement txtcountry;

    @FindBy(xpath = ".//*[@id='client_phone']")
    WebElement txtphonenumber;

    @FindBy(xpath = "//*[@id='client_fax']")
    WebElement txtfaxnumber;

    @FindBy(xpath = ".//*[@id='client_mobile']")
    WebElement txtmobilenumber;

    @FindBy(xpath = ".//*[@id='client_email']")
    WebElement txtemailaddress;

    @FindBy(xpath = ".//*[@id='client_web']")
    WebElement txtwebaddress;

    @FindBy(xpath = ".//*[@id='client_vat_id']")
    WebElement txtvatid;

    @FindBy(xpath = ".//*[@id='client_tax_code']")
    WebElement txttaxcode;

    @FindBy(xpath=".//*[@id='btn-submit']")
    WebElement btnsave;

public    AddClient(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    public void setclientname(String clientname) {
        txtclientname.sendKeys(clientname);
    }

    public void setstreetaddress1(String streetaddress) {
        txtstreetaddress.sendKeys(streetaddress);
    }

    public void setstreetaddress2(String streetaddress2) {
        txtstreetaddress2.sendKeys(streetaddress2);
    }

    public void setcity(String city) {
        txtCity.sendKeys(city);
    }

    public void setstate(String state) {
        txtstate.sendKeys(state);
    }

    public void setzipcode(String zipcode) {
        txtzipcode.sendKeys(zipcode);
    }

    public void setcountry(String country) {
       containerCountry.click();
        inputCountry.sendKeys(country);
driver.findElement(By.xpath("//li[text()='"+country+"']"));
    }

    public void setphonenumber(String phonenumber) {
        txtphonenumber.sendKeys(phonenumber);
    }

    public void setfaxnumber(String faxnumber) {
        txtfaxnumber.sendKeys(faxnumber);
    }

    public void setmobilenumber(String mobilenumber) {
        txtmobilenumber.sendKeys(mobilenumber);
    }

    public void setemailaddress(String emailaddress) {
        txtemailaddress.sendKeys(emailaddress);
    }

    public void setwebaddress(String webaddress) {
        txtwebaddress.sendKeys(webaddress);
    }
    public void setvatid(String vatid) {
        txtvatid.sendKeys(vatid);
    }
    public void settaxcode(String taxcode) {
        txttaxcode.sendKeys(taxcode);
    }

    public void setBtnsave() throws ClassNotFoundException, SQLException {
       // btnsave.click();

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", btnsave);


    }
}