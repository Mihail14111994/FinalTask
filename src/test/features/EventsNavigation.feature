Feature: User is able to buy and to get information about events

#  Background:
#  Given "Fest.md" page is displayed
  Scenario Outline: User is able to book a ticket
#     User is logged in with valid credentials
    Given User is on Tickets page
    When User selects a <section>
    And User selects <nr> of tickets for an event of the <section>
    And The total price of tickets is displayed correct
    And All fields of booking are filled with <firstname>, <lastname>, <phone> and submited
    Then Booking is successfully accepted

    Examples:
      | nr | section    | firstname | lastname | phone     |
      | 2  | Concerte   | Doina     | Spataru  | 076852146 |
      | 10 | Conferințe | Doina     | Spataru  | 076852146 |

#  Scenario Outline: User is unable to book a ticket after checkout with invalid data
#    Given User is logged in with valid credentials
#    And User is on Tickets page
#    When User select a <section>
#    And User select a <nr> of tickets for an event
#    And All fields of booking are filled with <firstname>, <lastname>, <phone> and submited
#    Then A <warningMessage> occurs under each field
#    And Booking is not accepted
#
#    Examples:
#      | nr | section    | firstname                                           | lastname                                            | phone                                                                                                 | warningMessage                                     |
#      | 1  | Concerte   |                                                     |                                                     |                                                                                                       | Acest câmp nu poate fi gol.                        |
#      | 2  | Conferințe | 1                                                   | 2                                                   | f                                                                                                     | Introduceti date valide.                           |
#      | 3  | Conferințe | b                                                   | f                                                   | 2                                                                                                     | Introduceti date valide.                           |
#      | 4  | Toate      | latinlatinlatinlatinlatinlatinlatinlatinlatinlatinl | latinlatinlatinlatinlatinlatinlatinlatinlatinlatinl | 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789011234567890 | Acest câmp nu poate avea mai mult de 50 caractere. |
#
#    @DoinaS
#  Scenario Outline: User is not able to book a empty number of tickets
#    Given User is logged in with valid credentials
#    And User is on Tickets page
#    When User selects a <section>
#    And User selects a <nr> of tickets for an event
#    And Submit button is enabled
#    And User selects a <nr> of tickets for an event
#    Then Submit button is disabled
#    Examples:
#      | nr | section    | nr |
#      | 2  | Conferințe |    |
#
#  Scenario Outline: User is able to visualise details of any event
#    Given User is on Events page
#    When User selects a <section>
#    And All events on the page have "Detalii" button
#    And User clicks on "Detalii" button of an event
#    Then The information of the event is displayed
#
#    Examples:
#      | section |
#      | Filme   |
#      | Party   |
#
#  Scenario Outline: User is able to set an alert for an event
#    Given User is logged in with valid credentials
#    And User is on Events page
#    When User selects a <section>
#    And User clicks on "Detalii" button of an event
#    And User clicks on "Alert" button
#    And User selects an <option> for alert and submit
#    Then The alert is successfully set
##alert is deleted finally
#    Examples:
#      | section |
#      | Party   |
#      | Sport   |
##
#  #alternatives:
#  #"Voi merge" button