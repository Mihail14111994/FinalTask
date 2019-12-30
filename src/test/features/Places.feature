@All @Fest @Mihail @places
Feature: Places page navigation

  Background:
    Given The https://www.fest.md/en page is displayed

  @placesCategories @UI
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

  @placesCategories
  Scenario Outline: See a category of Places on the map
    Given User is on Places page
    When User clicks on <category> category
    And User clicks on See on map button
    Then User is able to see the places off the chosen <category> places on the map
    Examples:
      | category          |
      | Clubs             |
      | Cinema            |
      | Theatres          |
      | Museums/Galleries |

  @search
  Scenario Outline: Check Search-bar
    Given User is on Home page
    And User type a potential <locationName> location name in Searchbar
    Then User see the results matching his <locationName> request
    Examples:
      | locationName |
      |              |
#      | restaurants  |
#      | best music   |

  @placesMap @placesFiltering
  Scenario Outline: Places filtering
    Given User is on Places page
    And User clicks Options button
    And User choose values for <theme>, <priceLevel> and for <facilities>
    Then User is able to see a list of places corresponding to filters <theme>, <priceLevel>, <facilities>

    Examples:
      | theme     | priceLevel | facilities |
      | Moldavian | 4          | Playground |
      | Italian   | 2          | Wi-Fi      |
      | German    | 3          | Parking    |

  @placesMap @map
  Scenario: Select Places from the  Map
    Given User is on Places page
    And User clicks on See on map button
    And Check any Places Category from the checkboxes list
    Then User can see the places of the chosen category on the Map




