Feature: Dashboard Page Functional Validation
  Validate the functionality of the dashboard page.

  @SmokeTest
  Scenario: Validate that the dashboard page is accessible
    Given I am logged in as "admin" and Entered the "admin" and on the dashboard page
    Then I should be redirected to the dashboard page



  @UI
  Scenario: Validate UI elements on the dashboard
    Given I am logged in as "admin" and Entered the "admin" and on the dashboard page
    Then I should see the logo
    And I should see the navigation menu
    And I should see the sidebar
    And I should see the logout button



  @Functionality
  Scenario: Validate the dashboard user greeting
    Given I am logged in as "admin" and Entered the "admin" and on the dashboard page
    Then I should get "Logged in as <username>"



  @Functionality
  Scenario: Validate the "Logout" button functionality
    Given I am logged in as "admin" and Entered the "admin" and on the dashboard page
    When I click on the "Logout" button
    Then I should be redirected to the login page

  @Navigation
  Scenario: Validate the navigation functionality from the dashboard to reports
    Given I am logged in as "admin" and Entered the "admin" and on the dashboard page
    When I click on the Reports link
    Then I should be redirected to the Reports page

  @Navigation
  Scenario: Validate the navigation functionality from the dashboard to settings
    Given I am logged in as "admin" and Entered the "admin" and on the dashboard page
    When I click on the Settings link
    Then I should be redirected to the Settings page that is "https://stock.scriptinglogic.in/update_details.php"


