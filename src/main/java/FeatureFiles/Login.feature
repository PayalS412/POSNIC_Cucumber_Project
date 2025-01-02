Feature: Login Page Validation
  Validate the login functionality of the website.

  @SmokeTest
  Scenario Outline: Validate login with valid and invalid credentials
    Given I am on the login page
    When I enter "<username>" and "<password>"
    And I click on the login button
    Then  I should be redirected to the "<dashboard>" Page or I should see "<expectedResult>"


    Examples:
      | username | password | expectedResult             | dashboard          |
      | admin    | admin    |                            | POSNIC - Dashboard |
      | root     | admin    | Wrong Username or Password |                    |
      | admin    | root     | Wrong Username or Password |                    |
      |          |          | Please enter a username    |                    |
      | admin    |          | Please provide a password  |                    |
      |          | admin    | Please provide a username  |                    |

  @UI
  Scenario: Validate UI elements on the login page
    Given I am on the login page
    Then I should see the username field
    And I should see the password field
    And I should see the login button

  @EdgeCase
  Scenario: Validate login with SQL injection
    Given I am on the login page
    When I enter "' OR '1'='1" and "AND 1=1 "
    And I click on the login button
    Then I should see "Wrong Username or Password"

  @Security
  Scenario: Validate password field masking
    Given I am on the login page
    When I enter "admin" into the password field
    Then the password field should be masked