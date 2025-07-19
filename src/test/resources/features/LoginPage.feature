Feature: Login to HRM Application

  Background: 
    Given User is on HRMLogin page "https://ui.freecrm.com"

  @ValidCredentials
  Scenario: Login with valid credentials
    When User enters username as "husainahamad055@gmail.com" and password as "Kaalo@1234"
    Then User should be able to login successfully and new page open

 # @InvalidCredentials
 # Scenario Outline: Login with invalid credentials
 #  When User enters username as "<username>" and password as "<password>"
 # Then User should be able to see error message "<errorMessage>"

  #   Examples: 
  #    | username | password  | errorMessage        |
  #    | Admin    | admin12$$ | Invalid credentials |
  #    | admin$$  | admin123  | Invalid credentials |
  #    | abc123   | xyz$$     | Invalid credentials |

    #@MissingUsername
    #Scenario Outline: Login with blank username
    #When User enters username as " " and password as "admin123"
    #Then User should be able to see a message "Required1" below Username
    
    
    
    
    