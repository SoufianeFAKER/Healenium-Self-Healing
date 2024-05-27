@valid-login-user
Feature: Login User with correct email and password
  As User I want to login with Valid credentials

  Background: 
    Given User navigates to application
    When User clicks on SignupLogin button
    And User enters name "Soufiane FAKER" and email address "sfaker_02@yahoo.fr"
    And User clicks on Signup button
    And User chooses Title
    And User enters the details into account information fields
      | name     | Soufiane FAKER |
      | password |          12345 |
    And User chooses Date of Birth
    And User select checkbox Sign up for our newsletter
    And User select checkbox Receive special offers from our partners
    And User enters the details into address information fields
      | firstName    | Soufiane        |
      | lastName     | FAKER           |
      | company      | Proservices     |
      | address      | Cité El Ghazala |
      | address2     | Tunisia         |
      | state        | Married         |
      | city         | Nabeul          |
      | zipcode      |       123456789 |
      | mobileNumber |   0021697564144 |
    And User select a Country
    And User clicks on Create Account button 
    And User clicks on Continue button
    And User clicks on Logout button

  @valid-login
  Scenario: Login with correct email and password
    Given User navigates to home Page
    And User verify that home page is visible successfully
    When User clicks on SignupLogin button
    And User verify that login to your account "Login to your account" text is visible
    And User enters email "sfaker_02@yahoo.fr" and password "12345"
    And User clicks on Login button
    And User verify that Logged UserName "Logged in as Soufiane FAKER" text is visible
    And User clicks on Delete Account button
    Then User verify that Account Deleted "ACCOUNT DELETED!" text is visible
