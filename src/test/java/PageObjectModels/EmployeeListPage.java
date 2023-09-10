package PageObjectModels;

import Utilities.SeleniumLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeListPage {
    WebDriver driver ;
    SeleniumLib seleniumLib ;
    public EmployeeListPage(WebDriver driver){
        this.driver=driver;
        seleniumLib  = new SeleniumLib(driver);
    }
    // locators
    By pimbtn =By.xpath("//a[contains(@href, '/web/index.php/pim/viewPimModule')]");
    By emplyeenameinput =By.xpath("(//input[@placeholder='Type for hints...'])[1]");
    By searchbtn =By.xpath("//button[@type='submit']");
    By cellulename =By.xpath("(//div[@class=\"oxd-table-cell oxd-padding-cell\"])[3]");
    By cellulelastname =By.xpath("(//div[@class=\"oxd-table-cell oxd-padding-cell\"])[4]");

    By idinput =By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By celluleid =By.xpath("(//div[@class=\"oxd-table-cell oxd-padding-cell\"])[2]");
    By cellulesuperviseurname=By.xpath("(//div[@class=\"oxd-table-cell oxd-padding-cell\"])[8]");
    By superviseurnameinput=By.xpath("(//input[@placeholder='Type for hints...'])[2]");
    By supervisoroption=By.xpath("//div[@role='option']");
    By addbtn=By.xpath("//button[contains(.,' Add')]");
    By employmentstausld=By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    By option =By.xpath("(//div[@role='option'])[3]");
    By celluleemploymentstaus =By.xpath("(//div[@class=\"oxd-table-cell oxd-padding-cell\"])[6]");
    // methods de l'interaction avec les locateurs
    public void clickpimbtn(){
        seleniumLib.waitmethod();
        seleniumLib.clickbutton(pimbtn);
        seleniumLib.waitmethod();
    }

    public void fillemplyeename(String username){
        seleniumLib.saisirtexte(emplyeenameinput,username);
    }
    public void searchuser(){
        seleniumLib.clickbutton(searchbtn);
    }
    public String getcellulename(){
        return seleniumLib.gettext(cellulename);

    }
    public String getcellulelastname(){
        return seleniumLib.gettext(cellulelastname);

    }
    public void fillemplyeid(String id){
        seleniumLib.saisirtexte(idinput,id);
    }

    public void fillemplyesuperviseurname(String superviseurname){
        seleniumLib.saisirtexte(superviseurnameinput,superviseurname);
        seleniumLib.waitmethod();
        seleniumLib.clickbutton(supervisoroption);
        seleniumLib.waitmethod();
    }

    public String getcelluleid(){
        return seleniumLib.gettext(celluleid);

    }

    public String getcellulesuperviseurname(){
        return seleniumLib.gettext(cellulesuperviseurname);

    }
    public void clickaddbtn(){
            seleniumLib.waitmethod();
            seleniumLib.clickbutton(addbtn);
            seleniumLib.waitmethod();
        }
        public void selectlistederoulante(){
        seleniumLib.clickbutton(employmentstausld);
        seleniumLib.clickbutton(option);
        }
        public String getemploymentstatus(){
        return seleniumLib.gettext(celluleemploymentstaus);
        }


}
