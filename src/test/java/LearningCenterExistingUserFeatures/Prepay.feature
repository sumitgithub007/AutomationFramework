@PrePay
Feature: Prepay amount

  Scenario Outline: As a student I should be able to prepay amount of my choice
    Given Student is on Student Portal
    When Student Enters the "<Username>" and "<password>"
    And Student Clicks on "Continue" Button
    And Student Navigates to Course Enrollment Page 
    And Student clicks on Payment Information
    When Student clicks on Make a payment followed by Make Payment
    And Student enters the "<amount>" and clicks on pre-pay
    And Student checks total amount to be paid is correct
    When Student clicks on Submit Payment
    Then Student gets a message saying "Thanks for your Payment"
    And the current balanced owed should be updated accordingly
    And Total paid to date amount should be correct

    Examples: 
      | Username            | password  | amount |
      | antwann.haskell@colddots.com | Subh@1987 | 200|
