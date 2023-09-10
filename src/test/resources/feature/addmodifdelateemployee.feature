Feature:  Gestion des utilisateurs à l'application Orange HRM
  Background:
    Given J'accède à l'application via l'url "https://opensource-demo.orangehrmlive.com/"
    When Je remplie la case username avec la valeur "Admin"
    And Je remplie la case password avec la valeur "admin123"
    And Je clique sur le bouton Login
    Given Je clique sur le bouton PIM
    When Je clique sur le boun ADD
    And je saisie "ali"  et "mohammed" de l'utilisateur
    And j'upload l'image de l'utilisateur "C:\Users\rhadjalouane\FomationIHM\SeleniumBDDdemo\src\test\resources\Data\userun.jpg"
    And J'active le switcher  Create Login Details
    And Je saisie "medali" et "Abc1234567+"
    And J'active l'utilisateur
    And Je cliquer sur le bouton Save

  Scenario:Modification les détails personnal d'un utilisateur
    Given Je cherche un employee par son id
    And Je clique sur le bouton modification
    And Je saisie driver licence number
    And Je sélectionne une license expiry date  à partir du calendrier
    And Je clique sur le bouton save
    Then les informations sont bien ebnregistrés dans la page détail de l'employé

  Scenario:Suppression d'un utilisateur
    Given Je cherche un employee par son id
    When Je clique sur le bouton supression
    And Je clique sur le bouton Yes,delate
    Then je vérifie que l'utilisateur est bien supprimé




