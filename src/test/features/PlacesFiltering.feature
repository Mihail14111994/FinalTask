Feature: 'Places' page

  Background:
    Given User is on Fest.md page

  Scenario Outline: See details of places from dropdown lists
  Given User is on Places page
    When User clicks on <category> dropdown
    And User clicks on subcategory
    Then User is able to see the places that belong to subcategories
    Examples:
    | category             |
    | Restaurants          |
    | Bars and cafes       |
    | Sports/Entertainment |

  Scenario Outline: See a category of Places on the map
    Given User is on Places page
    When User clicks on <category> category
    And User clicks on See on map button
    Then User is able to see all the places on the map
    Examples:
      | category          |
      | Clubs             |
      | Cinema            |
      | Theatres          |
      | Museums/Galleries |

  Scenario Outline: Check Search-bar
    Given User is on Home page
    And User type a potential <locationName> location name in Searchbar
    Then User see the results matching his <locationName> request
    Examples:
      | locationName |
      |              |
      | restaurants  |
      | best music   |

    Scenario Outline: Places filtering
      Given User is on Places page
      And User clicks Options button
      And User choose values for <theme>, <priceLevel> and for <facilities>
      Then User is able to see a list of places corresponding to filters

      Examples:
      | theme     | priceLevel | facilities |
      | Moldavian |           | Playground |
#      | Italian   |   2        | Wi-Fi      |
#      | German    |   3        | Parking    |

# Scenario: UI checking
#      Given User is on main page page of Fest.md
#      And User clicks on "Places" tab
#      Then User can see all the <pageElements> of the page
#      | title | categories | btnSeeOnMan | btnOptions | Places |
#



