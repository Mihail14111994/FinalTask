@Valik @All @Fest
Feature: Registration

  Background:
    Given Fest.md home page is displayed

  @Registration
  Scenario Outline: User is able to register
    Given Register page is displayed
    When <email> filled in "Email field in register window"
    And <password> filled in "Password field in register window"
    And <password> filled in "Confirm password field in register window"
    And "Register button" was clicked
    Then Home page is displayed
    And User unable to register with the same credentials
    Examples:
      | email        | password |
      | test2@gma.ru | 123123   |

  @Negative
  Scenario Outline: User fails to registrate
    Given Register page is displayed
    When <email> filled in "Email field in register window"
    And <password> filled in "Password field in register window"
    And <password> filled in "Confirm password field in register window"
    And "Register button" was clicked
    Then Registration fails with <error> message
    Examples:
      | email        | password               | error                                     |
      | test         | 123123                 | Adresa de email introdusă nu este validă. |
      | null         | 123123                 | Acest câmp nu poate fi gol.               |
      | test2@gma.ru | null                   | Acest câmp nu poate fi gol.               |
      | num2@ij.md   | PassWithAnotherConfirm | Parolele introduse nu coincid.            |

  @Registration @Deleting
  Scenario Outline: User deletes account
    When "Open Login page" was clicked
    And <email> filled in "Email field in login window"
    And <password> filled in "Password field in login window"
    And "Login button" was clicked
    And "User drop-down" was clicked
    And "My account button" was clicked
    And "Delete link" was clicked
    And <password> filled in "Current password field in delete window"
    And "Delete button" was clicked
    Then Home page is displayed
    And Checked that account was deleted
    Examples:
      | email        | password |
      | test2@gma.ru | 123123   |

  @UI
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

  @UI
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

  @UI
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