@edit
Feature: Edit profile at Student Portal

 
           	

Scenario Outline: As a Student I need to Edit details of My profile

Given user is on application Login Page
When user Enters the "<Username>" and "<password>"
And User Clicks on "Continue" Button
Then Student Navigates to Course Enrollment Page 
And User Navigates to ManageAccount 
And User Clicks on Edit Button
And User Changes "<ProfilePic>","<Firstname>", "<Middlename>","<Lastname>", "<DOB>", "<Gender>" , "<Occupation>" , "<EducationLevel>", "<CountryCode>","<MobilePhone>" , "<HomePhone>" , "<WorkPhone>" , "<MailingAddress>" , "<BillingAddress>"
And User Clicks on Save Button
Then All Information along with "<Gender>","<DOB>","<EducationLevel>","<Occupation>","<Username>","<MobilePhone>","<HomePhone>","<WorkPhone>","<CountryCode>" will be saved and displayed on UI
And User should be Able to Logout
  

Examples:
 
|Username                   |password  |ProfilePic        |Firstname    |Middlename|Lastname| DOB        | Gender | Occupation            | EducationLevel         |CountryCode |MobilePhone | HomePhone | WorkPhone | MailingAddress														 | BillingAddress |
|amaziah.aryav@airadding.com |Subh@1988 |  DEXTER          | Abhishek    | king     |Rajput  | February/13/1990| Female | BP - Attorney / Legal | Some post graduate work|      +51   | 999998989  | 999998989 | 999998989 | 230 5th Avenue, New York,  NY 10001,  US  | turkey         |


 