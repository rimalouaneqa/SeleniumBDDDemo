package StepDefinitions;

import PageObjectModels.ConnexionPage;
import Utilities.SeleniumLib;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class connexionStepDefs {
    WebDriver driver;
    ConnexionPage connexionPage;
    public connexionStepDefs(){
        driver=Hooks.driver;
        connexionPage  = new ConnexionPage(driver);

    }


    @Given("J'accède à l'application via l'url {string}")
    public void j_accède_à_l_application_via_l_url(String url) {
        // open orange hrm application
        driver.get(url);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @When("Je remplie la case username avec la valeur {string}")
    public void je_remplie_la_case_username_avec_la_valeur(String username) {
       // remplir le champ username
        connexionPage.fillUsername(username);

    }
    @When("Je remplie la case password avec la valeur {string}")
    public void je_remplie_la_case_password_avec_la_valeur(String password) {
       connexionPage.fillPasword(password);
    }
    @When("Je clique sur le bouton Login")
    public void je_clique_sur_le_bouton_login() {
       connexionPage.clickLoginbtn();
    }
    @Then("Je me dirige vers la page dashboard")
    public void je_me_dirige_vers_la_page_dashboard() {
        String currenturl=connexionPage.getpageurl();

        currenturl.contains("dashboard");
    }
    @Then("Un message d'erreur sera affiché {string}")
    public void un_message_d_erreur_sera_affiché(String errorMessage) {

        assertEquals(errorMessage,connexionPage.getMessageEror());
    }





}
