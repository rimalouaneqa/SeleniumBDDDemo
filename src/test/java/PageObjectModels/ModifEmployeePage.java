package PageObjectModels;

import Utilities.SeleniumLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ModifEmployeePage {
    WebDriver driver ;
    SeleniumLib seleniumLib ;
    public ModifEmployeePage(WebDriver driver){
        this.driver=driver;
        seleniumLib  = new SeleniumLib(driver);
    }
    // locators

    By boutonmodif= By.xpath("(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[2]");
    By DriverNumber=By.xpath("(//input[@class='oxd-input oxd-input--active'])[5]");
    By Datesaisie=By.xpath("(//input[@class='oxd-input oxd-input--active'and @placeholder='yyyy-mm-dd'])[1]");


    By savebtn=By.xpath("(//button[@type='submit'])[1]");
    //methods
    public void clickmodif() {
        seleniumLib.clickbutton(boutonmodif);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void filldrivernumber(){

        //seleniumLib.saisirtexte(DriverNumber,"");
        //seleniumLib.cleartext(DriverNumber);
        seleniumLib.saisirtexte(DriverNumber,"123456");

        /*WebElement element=driver.findElement(DriverNumber);
        element.sendKeys("1234567");*/

    }
    public void saisirdate(){
        /*
        seleniumLib.saisirtexte(Datesaisie,"");
        //seleniumLib.cleartext(Datesaisie);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        seleniumLib.saisirtexte(Datesaisie,"2022-11-08");*/
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element=driver.findElement(Datesaisie);
        element.sendKeys("2022-11-08");
    }
    public void clicksave(){
        seleniumLib.clickbutton(savebtn);
    }
    public String getlicensenumber(){
        return seleniumLib.getvalueattribute(DriverNumber);
    }
    public String getlincensedate(){
        return seleniumLib.getvalueattribute(Datesaisie);
    }
}
