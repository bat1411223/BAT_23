Feature:Customer

Scenario Outline: Add New Customer
 Given User Lanch Chrome Browser
 When  User open url "<url>"
 When  User enter Email as "<email>" and password as "<password>"  
 When User click on Login button
 Then  User verify page title should be "Dashboard / nopCommerce administration"
 When User click on Customer Menu
 And  User click on Customer mentu item
 And  User Click On add new button
 Then User verify Add new customer page
 When User enter cutomer info as "<newEmail>" and "<newPass>" and "<fname>" and "<lname>" and "<gender>" and "<DOB>" and "<ComName>" and "<AdminComment>"
 And User click on save button
 Then User can view confirmation msg "The new customer has been added successfully."
 Then  close browser
  
Examples:
|url |email | password |newEmail |newPass |fname |lname |gender |DOB | ComName |AdminComment |
|https://admin-demo.nopcommerce.com/login |admin@yourstore.com | admin |bRaj3434@gmail.com |raj3434 |Bali |raj |Male |23/09/1988 | ABC |Test123 |
|https://admin-demo.nopcommerce.com/login |admin@yourstore.com | admin |Radhika@gmail.com |Radhika12 |Radhika |Sharma |Female |23/09/1999 | xyz |Test1234 |
|https://admin-demo.nopcommerce.com/login |admin@yourstore.com | admin |Mahesh@gmail.com |Mahesh23 |Mahesh |Jadhav |Male |23/09/1995 | pqr |Test123456 |
 