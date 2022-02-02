@StudentPortalLogin
Feature: Login at Student portal
         	

Scenario Outline: As a Student I need to Login to admin portal

Given Student is on Student Portal
When Student Enters the "<Username>" and "<password>"
And Student Clicks on "Continue" Button
And Student Navigates to Course Enrollment Page 
 
 


Examples:

| Username      | password      | 
|amaziah.aryav@airadding.com| Subh@1987|
