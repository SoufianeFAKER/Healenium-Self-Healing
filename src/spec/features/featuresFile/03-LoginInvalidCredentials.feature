@invalid-login-user
Feature: Login User with incorrect email and password
  As User I want to login with Invalid credentials
  
  @invalid-login
  Scenario: Login with incorrect email and password
   Given User navigates to application 
   And User verify that home page is visible successfully
   When User clicks on SignupLogin button
   And User verify that login to your account "Login to your account" text is visible
   And User enters email "invalidemail@yahoo.fr" and password "999999"
   And User clicks on Login button
   Then User verify login error message "Your email or password is incorrect!" is visible