Feature: 'Places' page

  Scenario:
  Given Use is on Places page
    When User clicks on Bars and cafes dropdown
    And User clicks on Teahouses
    And User clicks on one of the Teahouses name
    Then User is able to see details, contact information and facilities of that place
#
#  Scenario:
#  Given User is on Places page
#    When User clicks on Cinema category
#    And User clicks on See on map button
#    Then User is able to see all the Cinema places on the map
#
#  Scenario:
#    Given User is on Places page
#    When User clicks on See on map button
#    And User checks Karting Places to be pointed on the map
#    Then User is able to se Karting places on the map
#    And User is able to click on a Karting place
#    And User is able to see details of the place
#
#    Scenario Outline:
#      Given User is on Places page
#      And User clicks Options button
#      And User checks values for <theme>, <priceLevel> and for <facilities>
#      And User clicks Search button
#      Then User is able to see a list of places corresponding filtering
#
#
#      Examples:
#      | theme     | priceLevel | facilities |
#      | Moldavian |   2; 3     | Playground |
#      | Italian   |   3; 3; 4  | Wi-Fi      |
#      | German    |   3        | Parking    |
#
