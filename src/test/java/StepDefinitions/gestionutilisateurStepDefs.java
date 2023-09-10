package StepDefinitions;
import PageObjectModels.*;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class gestionutilisateurStepDefs {
    WebDriver driver;
    public static String  employeid;
    static EmployeeListPage employeeListPage;
    static AddEmployeePage addEmployeePage;
    ModifEmployeePage modifEmployeePage;
    SuppressionEmployeePage suppressionEmployeePage;
    public gestionutilisateurStepDefs(){
        driver=Hooks.driver;
        employeeListPage  = new EmployeeListPage(driver);
        addEmployeePage=new AddEmployeePage(driver);
        modifEmployeePage=new ModifEmployeePage(driver);
        suppressionEmployeePage=new SuppressionEmployeePage(driver);

    }


   // scenario 1
    @Given("Je clique sur le bouton PIM")
    public void je_clique_sur_le_bouton_pim() {

        employeeListPage.clickpimbtn();
    }
    @When("Je saisie le nom de l'utilisateur {string}")
    public void je_saisie_le_nom_de_l_utilisateur(String username) {

        employeeListPage.fillemplyeename(username);
    }
    @When("Je clique sur le bouton Search")
    public void je_clique_sur_le_bouton_search() {

        employeeListPage.searchuser();
    }
    @Then("all users with the name {string} appears")
    public void all_users_with_the_name_appears(String usernameinput) {

       String usernameoutput = employeeListPage.getcellulename();
        System.out.println("username output >>>>>>>>>>>>>>>>>"+usernameoutput);
       assertEquals(usernameoutput.toUpperCase(),usernameinput.toUpperCase());
    }
    // scenario 2
    @When("Je saisie le id de l'utilisateur {string}")
    public void je_saisie_le_id_de_l_utilisateur(String id) {
        employeeListPage.fillemplyeid(id);
    }
    @Then("all users with the id {string} appears")
    public void all_users_with_the_id_appears(String id) {
        String idoutput = employeeListPage.getcelluleid();
        System.out.println("id output >>>>>>>>>>>>>>>>>"+idoutput);
        assertEquals(idoutput.toUpperCase(),id.toUpperCase());
    }
    // scenario 4
    @When("Je saisie et je clique le nom  de superviseur {string}")
    public void je_saisie_et_je_clique_le_nom_de_superviseur(String superiviseurname) {
        employeeListPage.fillemplyesuperviseurname(superiviseurname);
    }
    @Then("all users with the supervisorname {string} appears")
    public void all_users_with_the_supervisorname_appears(String superviseurname) {
        String superviseurnameoutput = employeeListPage.getcellulesuperviseurname();
        System.out.println("superviseurname output >>>>>>>>>>>>>>>>>"+superviseurnameoutput);
        assertEquals(superviseurnameoutput.toUpperCase(),superviseurname.toUpperCase());
    }
    // scenario 5
    @When("Je clique sur le status de l'employment et je sélectionne  {string}")
    public void je_clique_sur_le_status_de_l_employment_et_je_sélectionne(String string) {
      employeeListPage.selectlistederoulante();
    }

    @Then("all users with the status employment {string} appears")
    public void all_users_with_the_status_employment_appears(String statusemployment) {
     String optiontext=employeeListPage.getemploymentstatus();
        System.out.println("l'employment status est>>>>>>>>>>>>>>>>>>>>"+optiontext);
        assertEquals(optiontext.toUpperCase(),statusemployment.toUpperCase());
    }

    // scenario ajout utilisateur
    @When("Je clique sur le boun ADD")
    public void je_clique_sur_le_boun_add() {
        employeeListPage.clickaddbtn();
    }
    @When("je saisie {string}  et {string} de l'utilisateur")
    public void je_saisie_et_de_l_utilisateur(String firstname, String lastname) {
        addEmployeePage.fillfirstnameandlastname(firstname,lastname);
    }
    @When("j'upload l'image de l'utilisateur {string}")
    public void j_upload_l_image_de_l_utilisateur(String imagepath) {
      addEmployeePage.uploadimage(imagepath);
    }
    @When("J'active le switcher  Create Login Details")
    public void j_active_le_switcher_create_login_details() {
       addEmployeePage.clickswtcher();
    }
    @When("Je saisie {string} et {string}")
    public void je_saisie_et(String username, String password) {
        addEmployeePage.fillusernamepasswordconfirmpassword(username,password);
    }
    @When("J'active l'utilisateur")
    public void j_active_l_utilisateur() {
      addEmployeePage.clickradiobuttonenabled();
    }
    @When("Je cliquer sur le bouton Save")
    public void je_cliquer_sur_le_bouton_save() {
        employeid=addEmployeePage.getemplyeeid();
        addEmployeePage.clicksavebtn();
    }
    @Then("l'utilisateur est bien crée avec les informations introduites {string} et {string}")
    public static void l_utilisateur_est_bien_crée_avec_les_informations_introduites_et(String expectedcfirstname, String expectedlastname) {
         System.out.println(employeid);
         addEmployeePage.clickemplyelist();
         employeeListPage.fillemplyeid(employeid);
         employeeListPage.fillemplyeename(expectedcfirstname);
         employeeListPage.searchuser();
         String actualfirstname=employeeListPage.getcellulename();
         String actuallastname=employeeListPage.getcellulelastname();
         String actualuser=actualfirstname.toUpperCase()+" "+actuallastname.toUpperCase();
         String expecteduser =expectedcfirstname.toUpperCase()+" "+expectedlastname.toUpperCase();
         System.out.println("actualuser >>>>>>>>>>>>>>>" +actualuser);
         System.out.println("expecteduser >>>>>>>>>>>>>>>" +expecteduser);
         Assertions.assertEquals(expecteduser,actualuser);
    }
    // modification du détail personnal d'un utilistauer
    @Given("Je cherche un employee par son id")
    public void je_cherche_un_employee_par_son_id() {

        System.out.println(employeid);
        addEmployeePage.clickemplyelist();
        employeeListPage.fillemplyeid(employeid);
        employeeListPage.searchuser();
    }
    @Given("Je clique sur le bouton modification")
    public void je_clique_sur_le_bouton_modification() {
        modifEmployeePage.clickmodif();
    }
    @Given("Je saisie driver licence number")
    public void je_saisie_driver_licence_number() {
        modifEmployeePage.filldrivernumber();

    }
    @Given("Je sélectionne une license expiry date  à partir du calendrier")
    public void je_sélectionne_une_license_expiry_date_à_partir_du_calendrier() {
        modifEmployeePage.saisirdate();
    }
    @Given("Je clique sur le bouton save")
    public void je_clique_sur_le_bouton_save() {
        modifEmployeePage.clicksave();
    }
    @Then("les informations sont bien ebnregistrés dans la page détail de l'employé")
    public void les_informations_sont_bien_ebnregistrés_dans_la_page_détail_de_l_employé() {

        String actuallicensenumber =modifEmployeePage.getlicensenumber();
        String actuallicensedate =modifEmployeePage.getlincensedate();
        Assertions.assertEquals("123456",actuallicensenumber);
        Assertions.assertEquals("2022-11-08",actuallicensedate);
    }
    // scenario suppression
    @When("Je clique sur le bouton supression")
    public void je_clique_sur_le_bouton_supression() {
        suppressionEmployeePage.clickbouttonsupprimer();
    }
    @When("Je clique sur le bouton Yes,delate")
    public void je_clique_sur_le_bouton_yes_delate() {
        suppressionEmployeePage.confirmationsuppression();
    }
    @Then("je vérifie que l'utilisateur est bien supprimé")
    public void je_vérifie_que_l_utilisateur_est_bien_supprimé() {

        searchuser();
        String expectedresult="No Records Found";
        String actualresult=suppressionEmployeePage.gettexte();
        Assertions.assertEquals(expectedresult,actualresult);

    }
    public void searchuser(){
        System.out.println(employeid);
        addEmployeePage.clickemplyelist();
        employeeListPage.fillemplyeid(employeid);
        employeeListPage.searchuser();
    }


}
