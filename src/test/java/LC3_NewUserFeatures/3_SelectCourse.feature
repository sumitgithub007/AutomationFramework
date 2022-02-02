@CourseAndLanguageSelection
Feature: Student select Course and Language
         	

Scenario Outline: As a Student I need to select Course and Language.

When Student clicks and select "<courseandlanguage>" from Language and Program track field dropdown
And Student Clicks the "Next" button 
Then Student Navigates to "Personal Details" page.

Examples:
 
|courseandlanguage |
| HCTP ENG |