Feature:Admin

@Valid
Scenario: Login with valid Credential
 Given User Lanch Chrome Browser
 When  User open url "https://admin-demo.nopcommerce.com/login"
 When  User enter Email as "admin@yourstore.com" and password as "admin"  
 When User click on Login button
 Then  User verify page title should be "Dashboard / nopCommerce administration"
 Then  close browser
 
@Valid
 Scenario Outline: Login Data Driven 
 Given User Lanch Chrome Browser
 When  User open url "<url>"
 And  User enter Email as "<email>" and password as "<password>"  
 And User click on Login button
 Then  User verify page title should be "Dashboard / nopCommerce administration"
 And  close browser
 Examples:
 |url                                     |email                 |password   |
 |https://admin-demo.nopcommerce.com/login|admin@yourstore.com   |admin      |
 |https://admin-demo.nopcommerce.com/login|admin123@yourstore.com|admin123   |
