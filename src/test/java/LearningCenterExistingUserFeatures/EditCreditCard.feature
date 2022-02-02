@CreditCardsEdit
Feature: Edit credit cards details to the student profile


  Scenario Outline: As a student I need to edit credit card to my profile
 
Given Student is on Student Portal
When Student Enters the "<Username>" and "<password>"
And Student Clicks on "Continue" Button
Then Student Navigates to Course Enrollment Page  
And Student clicks on Payment Information
And Student clicks on Wallet
And Student clicks on Add a Payment method Button
And Student clicks on Add a credit or debit card 
And Student enters "<Address>","<NameOnTheCard>","<CardNumber>", "<ExpirationDate>","<CVC>"
And student clicks on Add payment method Button
Then the new credit card details "<NameOnTheCard>","<ExpirationDate>","<Address>" will be saved and displayed on the screen
And Student edits the credit card "<NewCardDate>","<NewAddress>" details by clicking on Edit Button
And User should be Able to Logout

    Examples: 
 |Username                    |password   |NameOnTheCard  |CardNumber            |ExpirationDate     |CVC |Address														  |NewCardDate|NewAddress|
 |amaziah.aryav@airadding.com|Subh@1988  |Nikita Goel       |4242 4242 4242 4242 |10/2029            |123 |  Arcos 2319, Buenos Aires, Argentina|12/2025    |23 India St, Brooklyn, NY 11222, USA|