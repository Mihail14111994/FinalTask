Feature: Account feature.

  Background:
    Given Fest.md page is displayed

  Scenario Outline: User is able to register
    Given Register page is displayed
    When Submit <email>, <password> and confirm password in registration form
    Then Home page is displayed
    And Register is successful

    Examples:
      | email        | password |
      | test2@gma.ru | 123123   |

  Scenario Outline: User fails to registrate
    Given Register page is displayed
    When Submit <email>, <password> and confirm password in registration form
    Then Registration fails with <error> message
    Examples:
      | email        | password               | error                                     |
      | test         | 123123                 | Adresa de email introdusă nu este validă. |
      | null         | 123123                 | Acest câmp nu poate fi gol.               |
      | test2@gma.ru | null                   | Acest câmp nu poate fi gol.               |
      | num2@ij.md   | PassWithAnotherConfirm | Parolele introduse nu coincid.            |
#
  Scenario: Registration window UI check
    When  Register page is displayed
    Then  the following elements are visible on Register page
      |Register title|
      |Email field|
      |Password field|
      |Confirm password field|
      |Register button|
      |Login button   |
      |Login with facebook button|
      |Recieve newletter checkbox|

##
  Scenario: Login window UI check
    When  Login page is displayed
    Then  the following elements are visible on Login page
      |Login title|
      |Email field|
      |Password field|
      |Register button|
      |Login button   |
      |Login with facebook button|
      |Forgot password link|
##
  Scenario Outline: User deletes account
    When Account with <email> and <password> was deleted
    Then Home page is displayed
    And Checked that account was deleted
    Examples:
      | email        | password |
      | test2@gma.ru | 123123   |

  Scenario: Registration/Login page UI check
    When  Register_Login page is displayed
    Then  the following elements are visible on Register_Login page
      |Register title|
      |Login title|
      |LoginRegister title|
      |Email register field|
      |Email login field|
      |Password register field|
      |Password login field|
      |Confirm password field|
      |Forgot Password Link  |
      |Register button|
      |Login button   |
      |Facebook login register button|
      |Recieve newletter checkbox|