Feature: Login

Scenario: Sucessful Login with Valid Credentials
Given User Launch Chrome browser
When User opens URL "http://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And Click on Login
Then page Title should be "Dashboard / nopCommerce adminstration"
When User click on Log out link
Then Page Title should be "Your store.Login"
And close browser