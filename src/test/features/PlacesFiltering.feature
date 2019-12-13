Feature: 'Places' page

  Scenario Outline: See details of a chosen place
  Given Use is on Places page
    When User clicks on <category> dropdown
    And User clicks on <subcategory>
    And User clicks on one of the <subcategory> on the page
    Then User is able to see details, contact information and facilities of that <subcategory>

    Examples:
      | category    | subcategory    |
      | Restaurants | Bars and cafes |
      | Pizzerias   | Teahouses      |

  Scenario: See a category of places on the map
  Given User is on Places page
    When User clicks on "Cinema" category
    And User clicks on "See on map" button
    Then User is able to see all the "Cinema" places on the map

  Scenario Outline: Choose aa place from the map
    Given User is on Places page
    When User clicks on ""See on map" button
    And User checks <category> to be pointed on the map
    Then User is able to see <category> places on the map
    And User is able to click on a <category> place
    And User is able to see details of the <category>
    Examples:
      | category    |
      | Restaurants |
      | Pizzerias   |
#
#    Scenario Outline: Places filtering
#      Given User is on Places page
#      And User clicks "Options" button
#      And User checks values for <theme>, <priceLevel> and for <facilities>
#      And User clicks "Search" button
#      Then User is able to see a list of places corresponding filtering
#
#      Examples:
#      | theme     | priceLevel | facilities |
#      | Moldavian |   2; 3     | Playground |
#      | Italian   |   3; 3; 4  | Wi-Fi      |
#      | German    |   3        | Parking    |

# Scenario: UI checking
#      Given User is on main page page of Fest.md
#      And User clicks on "Places" tab
#      Then User can see all the <pageElements> of the page
#      | title | categories | btnSeeOnMan | btnOptions | Places |
#



