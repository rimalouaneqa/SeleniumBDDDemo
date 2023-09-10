Feature:  Gestion des utilisateurs à l'application Orange HRM
  Background:
    Given J'accède à l'application via l'url "https://opensource-demo.orangehrmlive.com/"
    When Je remplie la case username avec la valeur "Admin"
    And Je remplie la case password avec la valeur "admin123"
    And Je clique sur le bouton Login

  Scenario Outline: Recherche utilisateur par nom
    Given Je clique sur le bouton PIM
    When Je saisie le nom de l'utilisateur "<username>"
    And Je clique sur le bouton Search
    Then all users with the name "<username>" appears
    Examples:
      | username |
      |kevin       |
      |Kiyara      |
      |Linda Jane  |
    Scenario Outline: Recherche utilisateur par id
      Given Je clique sur le bouton PIM
      When Je saisie le id de l'utilisateur "<id>"
      And Je clique sur le bouton Search
      Then all users with the id "<id>" appears
      Examples:
        | id |
        | 0058|
        | 123456|

  Scenario Outline: Recherche utilisateur par le nom du superviseur
    Given Je clique sur le bouton PIM
    When Je saisie et je clique le nom  de superviseur "<superviseurname>"
    And Je clique sur le bouton Search
    Then all users with the supervisorname "<superviseurname>" appears
    Examples:
      | superviseurname |
      |Kevin Mathews|
  Scenario Outline: Recherche utilisateur par le status de l'employment
    Given Je clique sur le bouton PIM
    When Je clique sur le status de l'employment et je sélectionne  "<statusemployment>"
    And Je clique sur le bouton Search
    Then all users with the status employment "<statusemployment>" appears
    Examples:
      | statusemployment |
      |Full-Time Contract|
  #Scenario Outline: Recherche utilisateur par le titre de son travail
    #Given Je clique sur le bouton PIM
    #When Je clique sur job title et je sélectionne  "<jobtitle>"
    #And Je clique sur le bouton Search
    #Then all users with the jobtitle "<jobtitle>" appears
    #Examples:
     # | jobtitle |
      #|Account Assistant|

    Scenario Outline: Ajout utilisateur à l'application Orange HRM
      Given Je clique sur le bouton PIM
      When Je clique sur le boun ADD
      And je saisie "<firstname>"  et "<lastname>" de l'utilisateur
      And j'upload l'image de l'utilisateur "<imagepath>"
      And J'active le switcher  Create Login Details
      And Je saisie "<username>" et "<password>"
      And J'active l'utilisateur
      And Je cliquer sur le bouton Save
      Then l'utilisateur est bien crée avec les informations introduites "<firstname>" et "<lastname>"

      Examples:
        |firstname|lastname|imagepath|username|password|
        | ali | mohammed | C:\Users\rhadjalouane\FomationIHM\SeleniumBDDdemo\src\test\resources\Data\userun.jpg|medali|Abc1234567+|
    Scenario:Modification les détails personnal d'un utilisateur
    Given Je clique sur le bouton PIM
    And Je cherche un employee par son id
    And Je clique sur le bouton modification
    And Je saisie driver licence number
    And Je sélectionne une license expiry date  à partir du calendrier
    And Je clique sur le bouton save
    Then les informations sont bien ebnregistrés dans la page détail de l'employé



