

Feature:  Connexion à l'application Orange HRM

  Scenario: Connexion réussite à l'application Orange HRM

    Given J'accède à l'application via l'url "https://opensource-demo.orangehrmlive.com/"
    When Je remplie la case username avec la valeur "Admin"
    And Je remplie la case password avec la valeur "admin123"
    And Je clique sur le bouton Login
    Then Je me dirige vers la page dashboard



  Scenario: Connexion échouée à l'application Orange HRM

    Given J'accède à l'application via l'url "https://opensource-demo.orangehrmlive.com/"
    When Je remplie la case username avec la valeur "Admin"
    And Je remplie la case password avec la valeur "admin1234"
    And Je clique sur le bouton Login
    Then Un message d'erreur sera affiché "Invalid credentials"