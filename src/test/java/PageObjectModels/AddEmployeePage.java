package PageObjectModels;

import Utilities.SeleniumLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class AddEmployeePage {
    WebDriver driver ;
    SeleniumLib seleniumLib ;
    public AddEmployeePage(WebDriver driver){
        this.driver=driver;
        seleniumLib  = new SeleniumLib(driver);
    }
    // locators
        By firstnamebtn = By.xpath("//input[@placeholder='First Name'and@class='oxd-input oxd-input--active orangehrm-firstname']");
        By lastnamebtn = By.xpath("//input[@placeholder='Last Name'and@class='oxd-input oxd-input--active orangehrm-lastname']");
        By employeeid  = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
        By switcherbtn  = By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']");
        By  plusbtn =By.xpath("//i[@class='oxd-icon bi-plus']");
        By usernamebtn=By.xpath("(//input[@class='oxd-input oxd-input--active'and@autocomplete='off'])[1]");
        By passwordbtn=By.xpath("(//input[@type = 'password'])[1]");
        By confirmpasswordbtn=By.xpath("(//input[@type = 'password'])[2]");
        By radioboxactive=By.xpath("//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input']");
        By savebtn =By.xpath("//button[@type='submit'and @ class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
        By employelistbtn=By.xpath("//li[contains(.,'Employee List')]");

    // methods

         public void fillfirstnameandlastname(String firstname,String lastname){
             seleniumLib.saisirtexte(firstnamebtn,firstname);
             seleniumLib.saisirtexte(lastnamebtn,lastname);
             seleniumLib.waitmethod();
         }
         public void uploadimage(String imagepath){
             seleniumLib.uploaddocument(plusbtn,imagepath);
             seleniumLib.waitmethod();
         }
         public void clickswtcher(){
             seleniumLib.setunswitcher(switcherbtn);
             seleniumLib.waitmethod();
         }
        public void fillusernamepasswordconfirmpassword(String username,String password)
        {
            Random random = new Random();
            int suffix = random.nextInt(1000)+1;
            String uniqueusername = username+String.valueOf(suffix);
            seleniumLib.saisirtexte(usernamebtn,uniqueusername);
            seleniumLib.waitmethod();
            seleniumLib.saisirtexte(passwordbtn,password);
            seleniumLib.waitmethod();
            seleniumLib.saisirtexte(confirmpasswordbtn,password);
            seleniumLib.waitmethod();
        }
        public void clickradiobuttonenabled(){
            seleniumLib.setradiobox(radioboxactive);
            seleniumLib.waitmethod();
        }
        public String getemplyeeid(){
             //return seleniumLib.gettext(employeeid);
            String id=driver.findElement(employeeid).getAttribute("value");
            return id;


        }
        public void clicksavebtn(){
             seleniumLib.clickbutton(savebtn);
        }
        public void clickemplyelist(){
            seleniumLib.clickbutton(employelistbtn);
            //seleniumLib.waitmethod();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }



        }



















