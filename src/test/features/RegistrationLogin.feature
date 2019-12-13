#Feature: Registration

#  Scenario Outline: User make registration
#    Given Fest.md page is displayed
#    When Fill in <email> at email field
#    And Fill in <password> and confirm <password>
#    And Click on Register button
#    And Click on user account header
#    And Click on Logout button
#    Then Home page is displayed
#    Examples:
#      | email        | password |
#      | test2@gma.ru | 123123   |
#
#  Scenario Outline: User make registration negative
#    Given Fest.md page is displayed
#    When Language changed to English
#    When Fill in <email> at email field
#    And Fill in <password> and confirm <password>
#    And Click on Register button
#    Then See error
#
#    Examples:
#      |email|password|
#      |test1|123123|
#
#  Scenario: Registration window functionality
#    Given Fest.md page is displayed
#    When  Click on "Register" header2
#    Then  the following elements are visible
#      |Register title|
#      |Email field|
#      |Password field|
#      |Confirm password field|
#      |Register button|
#      |Login button   |
#      |Login with facebook button|
#      |Recieve newletter checkbox|
##
#  Scenario: Login window functionality
#    Given Fest.md page is displayed
#    When  Click on "Login" header
#    Then  the following elements are visible1
#      |Login title|
#      |Email field|
#      |Password field|
#      |Register button|
#      |Login button   |
#      |Login with facebook button|
#      |Forgot password link|
##  Scenario Outline: Login / Register page functionality
##    Given Fest.md page is displayed
##    When  Open https://www.fest.md/en/login-register
##    Then  the following <elements> are visible
##    Examples:
##      |elements|
##      |Login / Register title|
##      |Login title|
##      |Register title|
##      |Email field 1st|
##      |Email field 2nd|
##      |Password field 1st|
##      |Password field 2nd|
##      |Confirm password field|
##      |Register button|
##      |Login button   |
##      |Login with facebook button|
##      |Forgot password link|
##      |Recieve newletters checkbox|
##
##    Scenario Login
##      Given Fest.md page is displayed
##      When  Click on "Login" header
##      And Fill in email
##      And Fill in password and confirm password
##      And Click on Login
##      And Click on user header
##      And Click on My account link
##      Then My account page is displayed
##
##      Scenario Outline: My account page functionality
##        Given Fest.md page is displayed
##        When Click on user header
##        And Click on My account link
##        Then My account page is displayed
##        And the following <elements> are visible
##        Examples:
##          |elements|
##          |My Account title|
##          |PERSONAL INFORMATION title|
##          |Change personal information button|
##          |Delete account button|
##          |Change password button|
##
##
#  Scenario: User deletes account
#    Given Fest.md page is displayed
#    When  And Fill in email at email field1
#    And Fill password in Current Password field
#    And Click on Login button
#    And Click on user account header
#    And Click on My Account button
#    And Click on Delete account link
#    And Fill in current password in the window
#    And Click on Delete account button
#    Then Home page is displayed
##
#
#
#
