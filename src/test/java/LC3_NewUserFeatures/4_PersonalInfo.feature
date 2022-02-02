@IINPersonalInfo
Feature: Student enter personal information.
         	

Scenario Outline: As a Student I need to enter personal information on Student portal

When Student selects "<Education>" from EducationLevel dropdown on Student Portal
And Student selects "<Occupation>" from Occupation dropdown on Student portal 
And Click on the "MilitaryMember" checkbox
#And Student selects the dropdown option from the readiness question1 "What is driving you to enroll in our Health Coach Training Program?"
#And Student selects the dropdown option from the readiness question2 "What are your goals after completing this program?"
#And Student selects the dropdown option from the readiness question3 "What are 2-3 things you can do to ensure you have a successful experience here at IIN?"
#And Student selects the dropdown option from the readiness question4 "As a distance education institution, all of our content is online. How will you access your material?"
And Student Clicks on the "Next" Button
Then Student Navigates to the "Please select a payment plan" page


Examples:

|Education|  Occupation |
|High school degree/GED|AP - Chiropractor|