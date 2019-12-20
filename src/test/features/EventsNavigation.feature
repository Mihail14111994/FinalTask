@Doina
Feature: Buy/book a ticket and get event information

  Background:
    Given Fest.md home page is displayed

  @positive @book
  Scenario Outline: User is able to book a ticket
    Given User is logged in with valid credentials
    And Tickets menu page is displayed
    When <section> is selected
    And User submits <nr> tickets for an event of the <section>
    And The total price is displayed correct for <nr> tickets
    And All fields of booking are filled with <firstName>, <lastName>, <phone> and submited
    Then Booking is successfully accepted

    Examples:
      | nr | section    | firstName                                          | lastName                                           | phone     |
      | 2  | Party      | latinlatinlatinlatinlatinlatinlatinlatinlatinlatin | latinlatinlatinlatinlatinlatinlatinlatinlatinlatin | 078524163 |
      | 10 | Conferințe | Ion                                                | Ion                                                | 076852146 |

  @negative @book
  Scenario Outline: User is unable to book a ticket after checkout with invalid data
#    Given User is logged in with valid credentials
    Given Tickets menu page is displayed
    When <section> is selected
    And User submits <nr> tickets for an event of the <section>
    And All fields of booking are filled with <firstName>, <lastName>, <phone> and submited
    Then <errorMessage> occurs under each field

    Examples:
      | nr | section    | firstName                                           | lastName                                            | phone                                                                                                 | errorMessage                         |
      | 1  | Party      |                                                     |                                                     |                                                                                                       | Acest câmp nu poate fi gol.          |
      | 4  | Conferințe | latinlatinlatinlatinlatinlatinlatinlatinlatinlatinl | latinlatinlatinlatinlatinlatinlatinlatinlatinlatinl | 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789011234567890 | Acest câmp nu poate avea mai mult de |

  @alert @functional
  Scenario Outline: User is able to set an alert for an event
    Given User is logged in with valid credentials
    And Events menu page is displayed
    When Sport is selected
    And User clicks on "Detalii" button of an event of <section>
    And <option> for alert is selected and submited
    Then The alert is successfully set and deleted

    Examples:
      | section | option                |
      | Sport   | сu 1 zi înainte       |
      | Sport   | În ziua evenimentului |

  @negative @tickets
  Scenario Outline: User is not able to book a empty number of tickets
    Given Tickets menu page is displayed
    When <section> is selected
    And User selects <nr> tickets for an event of the <section>
    And Submit button is enabled
    And User selects <empty> tickets for the same event
    Then Submit button is disabled

    Examples:
      | nr | section    | empty |
      | 2  | Conferințe | 0     |

  @UI
  Scenario Outline: User is able to visualise details of any event
    Given Events menu page is displayed
    When <section> is selected
    And All events of <section> have "Detalii" button
    And User clicks on "Detalii" button of an event of <section>
    Then The information of the event is displayed

    Examples:
      | section   |
      | Expoziții |
      | Sport     |

