package PageObjectModels;

import Utilities.SeleniumLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuppressionEmployeePage
{

    WebDriver driver ;
    SeleniumLib seleniumLib ;
    public SuppressionEmployeePage(WebDriver driver){
        this.driver=driver;
        seleniumLib  = new SeleniumLib(driver);
    }



    // locators
    By boutonsupprimer = By.xpath("(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[1]");
    By confirmationsuppression=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");
    By wordingnorecordfound =By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]");
    // methods
    public void clickbouttonsupprimer(){seleniumLib.clickbutton(boutonsupprimer);}
    public void confirmationsuppression(){seleniumLib.clickbutton(confirmationsuppression);}
    public String gettexte(){
        return seleniumLib.gettext(wordingnorecordfound);
    }

}
