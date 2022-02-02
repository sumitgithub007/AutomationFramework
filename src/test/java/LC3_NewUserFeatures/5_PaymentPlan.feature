@IINPaymentPlan
Feature: Select payment plan
  I want to use this template for my feature file

  
  Scenario Outline: I need to select payment plan for enrolling myself in the course.
    
    When Student clicks on "View plans starting at $ 199.00/mo" hyperlink
    And select "<paymentplanname>"
    And click on the "Next" button
    And click on the "OK" button in the popup window
    Then user is directed to the "Enter the details" page 
    

  

    Examples: 
      | paymentplanname  | 
      |18 months at $399|