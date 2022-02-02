@SSO
Feature: Check SSO Functionality is working as expected


  Scenario Outline: As a student I need to access the courses after clicking on continue learning
   
Given Student is on Student Portal
When Student Enters the "<Username>" and "<password>"
And Student Clicks on "Continue" Button
#Then Student Navigates to Course Enrollment Page  
#And Student clicks on My Courses
#And Student clicks on Continue Learning
#Then Student should be navigated to Modules Section
#And Student checks the FirstModule text
#And Student clicks on start button
And Student will be Navigated to same module page which was outside

Examples: 
 |Username                    |password    |NameOnTheCard  |CardNumber          |ExpirationDate|CVC|
 |keizer.emerick@airadding.com|Subh@1987  |Nikita         |4242 4242 4242 4242 |1223         |123|  


