Feature: Account feature.
  Background:
    Given Fest.md page is displayed

  Scenario Outline: User is able to register
    Given Login page is displayed
    When Submit <email>, <password> and confirm password in registration form
    Then Home page is displayed
    And Register is successful

    Examples:
      | email        | password |
      | test2@gma.ru | 123123   |

#  Scenario Outline: User make registration negative
#    When Page is displayed in <language> characters
#    And Submit <email>, <password> and confirm <password> in registration form
#    Then <error> message is displayed
#    And Register is not successful
#
#    Examples:
#    |email|password|error|
#    |test |123123  |     |
#    |null |123123  |     |
#    |test2@gma.ru|null|  |
#
#  Scenario: Registration window functionality
#    When  Click on "Register" header
#    Then  the following elements are visible
#      |Register title|
#      |Email field|
#      |Password field|
#      |Confirm password field|
#      |Register button|
#      |Login button   |
#      |Login with facebook button|
#      |Recieve newletter checkbox|
#
#  Scenario: Login window functionality
#    When  Click on "Login" header
#    Then  the following elements are visible1
#      |Login title|
#      |Email field|
#      |Password field|
#      |Register button|
#      |Login button   |
#      |Login with facebook button|
#      |Forgot password link|
##
#  Scenario: User deletes account
#    When Account was deleted
#    Then Home page is displayed
#    And Checked that account was deleted

