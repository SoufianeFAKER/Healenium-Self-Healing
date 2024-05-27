@logout-user
Feature: Logout User
  As User I want to logout from my accout (Account must be already exist)

  @logout-user
  Scenario: Logout User
    Given User navigates to application
    When User verify that home page is visible successfully
    And User clicks on SignupLogin button
    And User verify that login to your account "Login to your account" text is visible
    And User enters email "sfaker@yahoo.fr" and password "12345"
    And User clicks on Login button
    And User verify that Logged UserName "Logged in as Soufiane FAKER" text is visible
    And User clicks on Logout button
    Then User verify that user is navigated to login page
