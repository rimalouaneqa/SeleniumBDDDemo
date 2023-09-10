package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

public class SeleniumLib {


    public static WebDriver driver;
    public SeleniumLib (WebDriver driver){

        this.driver=driver;
    }
    public void  waitmethod (){

        try {

            Thread.sleep(2000);
        } catch (Exception e){
            System.out.println(e);
        }

    }

  // recherche d'un element
    public WebElement findElement (By locator){

      WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));

      wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        //scrolltoelement
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement webelement = driver.findElement(locator);
        jse.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", webelement);

        highlightelement(webelement);
      return  webelement;

  }
  // cliquer sur un element premier methode
    public void clickbutton(By locator){
        WebElement button =findElement(locator);
        button.click();
        waitmethod();
    }
// cliquer sur un element deuxiéme méthode
    //
    public void clickbuttonforce(By locator){

        WebElement button =findElement(locator);
        Actions actions =new Actions(driver);
        actions.click(button).perform();
        waitmethod();
    }
// cliquer sur un element avec js
    public void clickbuttonforcejs(By locator){
        WebElement button=findElement(locator);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",button);
        waitmethod();
    }
// remplir un champ texte
    public void saisirtexte(By locator,String texte){

        WebElement element=findElement(locator);
        //placeholder.clear();
        element.sendKeys(texte);
        //waitmethod();
    }

    public String gettext(By locator){

        WebElement element =findElement(locator);
        String text=element.getText();
        return  text;
    }
    public String geturl(){
        return driver.getCurrentUrl();
    }





    public void highlightelement(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String originalBorderStyle = element.getCssValue("border");
        String originalBackgroundColor = element.getCssValue("background-color");


        try {
            js.executeScript("arguments[0].style.border='2px solid red';" +
                    "arguments[0].style.backgroundColor='yellow';", element);
            Thread.sleep(1000);
            js.executeScript("arguments[0].style.border='" + originalBorderStyle +
                    "';" + "arguments[0].style.backgroundColor='" +
                    originalBackgroundColor + "';", element); }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    //chargement d'une image
    public void uploaddocument(By locator,String filepath){

     WebElement element=findElement(locator);
     element.click();
     waitmethod();
     uploadFileWithRobot(filepath);
     waitmethod();

    }
    public static void uploadFileWithRobot(String filePath) {

        String relativeFilePath = filePath;

        File file = new File(relativeFilePath);

        String absoluteFilePath = file.getAbsolutePath();
        StringSelection stringSelection = new StringSelection(filePath);
        Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipBoard.setContents(
                stringSelection, null);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(150);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    // cocher un switcher
    public void setunswitcher(By locator){
        WebElement element=findElement(locator);
        element.click();
    }
    // cocher un radiobox
    public void setradiobox(By locator){
        WebElement element=findElement(locator);
        element.click();
    }
    public void cleartext(By locator){
        WebElement element =findElement(locator);
        element.clear();
        waitmethod();
    }
    public String getvalueattribute(By locator){

        WebElement element =findElement(locator);
        String text=element.getAttribute("value");
        return  text;
    }



}
