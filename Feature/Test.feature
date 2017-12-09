Feature: Login Action

Scenario Outline: Successful Login with Valid Credentials
Given User is on Home Page
When User enters "<username>" and "<password>"
Then Message displayed Login Successfully
  Examples:
    |username|password|
    |buquxahu@cars2.club|kisulea|

  Scenario: Update user name
    Given User is logged into application
    When Click on user's link
    And Click on editProfile button
    And Type name into Name textInput field
    And Click update Button
    Then Successful message is displayed

  Scenario:Update company information
    Given User is logged into application
    When Type all required fields
    Then Successfully updated company info

    Scenario Outline:Create new Entity
      Given User is logged into application
      When Type required fields "<name>", "<country>", "<address1>", "<city>", "<state>", "<zip>", "<phone>", "<email>", "<RUemail>", "<AUemail>" and pay subscription
      Then Successful paymant message is displayed
      Examples:
      |name|country|address1|city|state|zip|phone|email|RUemail|AUemail|
      |Entity98|US|123 easy rd.|Tampa|NJ|56787|8789878988|cosmo@gmail.com|seccer@gmail.com|Cuma@gmail.com|


