@IINSIGNUP
Feature: Create profile for Student 

 
           	

Scenario Outline: As a Student I need to create My profile


When user Enters the "<password>"
And User Enters "<Firstname>","<Middlename>","<Lastname>"
And User Enters "<DOB>","<Gender>","<CountryCode>","<MobilePhone>","<Address>"
And User clicks to Continue Button 
Then User lands on "Please choose your language and program duration" page

Examples:
 
|Username                   |password  |Firstname    |Middlename|Lastname| DOB        | Gender   |CountryCode |MobilePhone |Address|
|jediel.khalee@colddots.com |Subh@1987 |Abhishek     | Singh    |Rajput  | 11111990   | Female   |      +91   | 9540060668 |230 5th Avenue, New York, NY, USA|
