package PageObjectModels;

import Utilities.SeleniumLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConnexionPage {
    WebDriver driver ;
    SeleniumLib seleniumLib ;
    public ConnexionPage(WebDriver driver){
        this.driver=driver;
        seleniumLib  = new SeleniumLib(driver);
    }

    // locators
    By username = By.xpath("//input[@name='username']");
    By password = By.xpath("//input[@name='password']");
    By btnlogin= By.xpath("//button[@type='submit']");
    By errorMessage= By.xpath("//P[@class='oxd-text oxd-text--p oxd-alert-content-text']");

    // methods de l'interaction avec le locateur

    public void fillUsername(String usernaminput){

        seleniumLib.saisirtexte(username,usernaminput);
    }
    public void fillPasword(String passwordinput){

        seleniumLib.saisirtexte(password,passwordinput);
    }
    public void clickLoginbtn(){

        seleniumLib.clickbutton(btnlogin);
    }
    public String getpageurl(){
        return seleniumLib.geturl();
    }
    public String getMessageEror(){
        return seleniumLib.gettext(errorMessage);
    }

}
