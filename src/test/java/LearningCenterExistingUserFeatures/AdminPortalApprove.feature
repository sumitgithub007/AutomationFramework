@ApproveStudent
Feature: Approve student application	


  Scenario Outline: As an admin I need to Approve the student application
 
Given Admin is on Admin Portal
When Admin Enters the "<Username>" and "<password>"
And Admin Clicks on "Continue" Button
Then Admin Navigates to "Dashboard" Page  
And Admin clicks on Menu Icon 
And Admin clicks on Admissions > Enrollments
And Admin searches user based on email
When admin opens the student detail
Then Admin should be able to approve student

Examples: 
 |							Username                  |password  |  
 | Bailey.Jeffko@integrativenutrition.com | admin.password|

