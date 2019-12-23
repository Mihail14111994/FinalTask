$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/features/EventsNavigation.feature");
formatter.feature({
  "name": "Buy/book a ticket and get event information",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Doina"
    },
    {
      "name": "@All"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.scenarioOutline({
  "name": "User is able to book a ticket",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    },
    {
      "name": "@book"
    }
  ]
});
formatter.step({
  "name": "User is logged in with valid credentials",
  "keyword": "Given "
});
formatter.step({
  "name": "Tickets menu page is displayed",
  "keyword": "And "
});
formatter.step({
  "name": "\u003csection\u003e is selected",
  "keyword": "When "
});
formatter.step({
  "name": "User submits \u003cnr\u003e tickets for an event of the \u003csection\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "The total price is displayed correct for \u003cnr\u003e tickets",
  "keyword": "And "
});
formatter.step({
  "name": "All fields of booking are filled with \u003cfirstName\u003e, \u003clastName\u003e, \u003cphone\u003e and submited",
  "keyword": "And "
});
formatter.step({
  "name": "Booking is successfully accepted",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "nr",
        "section",
        "firstName",
        "lastName",
        "phone"
      ]
    },
    {
      "cells": [
        "2",
        "Party",
        "latinlatinlatinlatinlatinlatinlatinlatinlatinlatin",
        "latinlatinlatinlatinlatinlatinlatinlatinlatinlatin",
        "078524163"
      ]
    },
    {
      "cells": [
        "10",
        "Conferințe",
        "Ion",
        "Ion",
        "076852146"
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
  "name": "User is able to book a ticket",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Doina"
    },
    {
      "name": "@All"
    },
    {
      "name": "@Fest"
    },
    {
      "name": "@positive"
    },
    {
      "name": "@book"
    }
  ]
});
formatter.step({
  "name": "User is logged in with valid credentials",
  "keyword": "Given "
});
formatter.match({
  "location": "TicketsDefinitions.userIsLoggedInWithValidCredentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Tickets menu page is displayed",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.ticketEventPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Party is selected",
  "keyword": "When "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsASection(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User submits 2 tickets for an event of the Party",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsAnEvent(String,int,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The total price is displayed correct for 2 tickets",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.theTotalPriceOfTicketsIsDisplayedCorrect(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "All fields of booking are filled with latinlatinlatinlatinlatinlatinlatinlatinlatinlatin, latinlatinlatinlatinlatinlatinlatinlatinlatinlatin, 078524163 and submited",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.allFieldsOfBookingAreFilledWithFirstnameLastnamePhoneAndSubmited(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Booking is successfully accepted",
  "keyword": "Then "
});
formatter.match({
  "location": "TicketsDefinitions.bookingIsSuccessfullyAccepted()"
});
