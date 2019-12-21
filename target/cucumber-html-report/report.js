$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/features/EventsNavigation.feature");
formatter.feature({
  "name": "Buy/book a ticket and get event information",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Doina"
    }
  ]
});
formatter.scenarioOutline({
  "name": "User is able to visualise details of any event",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@UI"
    }
  ]
});
formatter.step({
  "name": "Events menu page is displayed",
  "keyword": "Given "
});
formatter.step({
  "name": "\u003csection\u003e is selected",
  "keyword": "When "
});
formatter.step({
  "name": "All events of \u003csection\u003e have \"Detalii\" button",
  "keyword": "And "
});
formatter.step({
  "name": "User clicks on \"Detalii\" button of an event of \u003csection\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "The information of the event is displayed",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "section"
      ]
    },
    {
      "cells": [
        "Expoziții"
      ]
    },
    {
      "cells": [
        "Sport"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Fest.md home page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "CommonDefinitions.HomePageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User is able to visualise details of any event",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Doina"
    },
    {
      "name": "@UI"
    }
  ]
});
formatter.step({
  "name": "Events menu page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "TicketsDefinitions.ticketEventPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Expoziții is selected",
  "keyword": "When "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsASection(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "All events of Expoziții have \"Detalii\" button",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.allEventsOnThePageHaveDetails(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on \"Detalii\" button of an event of Expoziții",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.userClicksOnButtonOfAnEvent(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The information of the event is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "TicketsDefinitions.theInformationOfTheEventIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Fest.md home page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "CommonDefinitions.HomePageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User is able to visualise details of any event",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Doina"
    },
    {
      "name": "@UI"
    }
  ]
});
formatter.step({
  "name": "Events menu page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "TicketsDefinitions.ticketEventPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Sport is selected",
  "keyword": "When "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsASection(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "All events of Sport have \"Detalii\" button",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.allEventsOnThePageHaveDetails(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on \"Detalii\" button of an event of Sport",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.userClicksOnButtonOfAnEvent(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The information of the event is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "TicketsDefinitions.theInformationOfTheEventIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});