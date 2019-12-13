Feature: User is able to buy and to get information about events

  Background:
    Given Fest.md login page is displayed
    And User is logged in with valid credentials

  Scenario Outline: User is able to book a ticket
    Given Tickets  page is displayed
    When <section> is selected
    And User selects <nr> tickets for an event of the <section>
    And The total price is displayed correct for <nr> tickets
    And All fields of booking are filled with <firstName>, <lastName>, <phone> and submited
    Then Booking is successfully accepted

    Examples:
      | nr | section    | firstName                                          | lastName                                           | phone     |
      | 2  | Party      | Ion                                              | Ion                                            | 078524163 |
      | 10 | Conferințe | DoinaDoinaDoinaDoinaDoinaDoinaDoinaDoinaDoinaDoina | DoinaDoinaDoinaDoinaDoinaDoinaDoinaDoinaDoinaDoina | 076852146 |

  Scenario Outline: User is unable to book a ticket after checkout with invalid data
    Given Tickets  page is displayed
    When <section> is selected
    And User selects <nr> tickets for an event of the <section>
    And All fields of booking are filled with <firstName>, <lastName>, <phone> and submited
    Then <warningMessage> occurs under each field
    And Booking is not accepted
    Examples:
      | nr | section    | firstName                                           | lastName                                            | phone                                                                                                 | warningMessage                                     |
      | 1  | Party      |                                                     |                                                     |                                                                                                       | Acest câmp nu poate fi gol.                        |
      | 4  | Conferințe | latinlatinlatinlatinlatinlatinlatinlatinlatinlatinl | latinlatinlatinlatinlatinlatinlatinlatinlatinlatinl | 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789011234567890 | Acest câmp nu poate avea mai mult de  |

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