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
  "error_message": "org.openqa.selenium.NoSuchWindowException: no such window: target window already closed\nfrom unknown error: web view not found\n  (Session info: chrome\u003d79.0.3945.88)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027EN410025\u0027, ip: \u0027192.168.1.22\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 79.0.3945.88, chrome: {chromedriverVersion: 79.0.3945.36 (3582db32b3389..., userDataDir: C:\\Users\\DOSPAT~1\\AppData\\L...}, goog:chromeOptions: {debuggerAddress: localhost:54266}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 710def8a918a09a2bc729019bdb17bbd\n*** Element info: {Using\u003dcss selector, value\u003dbody \u003e div.main-nav \u003e div \u003e div.links \u003e ul \u003e li:nth-child(1) \u003e a}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByCssSelector(RemoteWebDriver.java:420)\r\n\tat org.openqa.selenium.By$ByCssSelector.findElement(By.java:431)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.getText(Unknown Source)\r\n\tat actionMethods.Click.click(Click.java:36)\r\n\tat stepImplementation.TicketsSteps.eventTicketsPageIsDisplayed(TicketsSteps.java:43)\r\n\tat stepDefinition.TicketsDefinitions.ticketEventPage(TicketsDefinitions.java:17)\r\n\tat ✽.Tickets menu page is displayed(file:src/test/features/EventsNavigation.feature:10)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Party is selected",
  "keyword": "When "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsASection(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User submits 2 tickets for an event of the Party",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsAnEvent(String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The total price is displayed correct for 2 tickets",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.theTotalPriceOfTicketsIsDisplayedCorrect(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "All fields of booking are filled with latinlatinlatinlatinlatinlatinlatinlatinlatinlatin, latinlatinlatinlatinlatinlatinlatinlatinlatinlatin, 078524163 and submited",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.allFieldsOfBookingAreFilledWithFirstnameLastnamePhoneAndSubmited(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Booking is successfully accepted",
  "keyword": "Then "
});
formatter.match({
  "location": "TicketsDefinitions.bookingIsSuccessfullyAccepted()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "error_message": "org.openqa.selenium.WebDriverException: chrome not reachable\n  (Session info: chrome\u003d79.0.3945.88)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027EN410025\u0027, ip: \u0027192.168.1.22\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 79.0.3945.88, chrome: {chromedriverVersion: 79.0.3945.36 (3582db32b3389..., userDataDir: C:\\Users\\DOSPAT~1\\AppData\\L...}, goog:chromeOptions: {debuggerAddress: localhost:54266}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 710def8a918a09a2bc729019bdb17bbd\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.close(RemoteWebDriver.java:442)\r\n\tat stepDefinition.CommonDefinitions.teardown(CommonDefinitions.java:38)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:65)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:50)\r\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:144)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:65)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:174)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\r\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\r\n\tat com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)\r\n",
  "status": "failed"
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
  "error_message": "org.openqa.selenium.NoSuchWindowException: no such window: target window already closed\nfrom unknown error: web view not found\n  (Session info: chrome\u003d79.0.3945.88)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027EN410025\u0027, ip: \u0027192.168.1.22\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_231\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 79.0.3945.88, chrome: {chromedriverVersion: 79.0.3945.36 (3582db32b3389..., userDataDir: C:\\Users\\DOSPAT~1\\AppData\\L...}, goog:chromeOptions: {debuggerAddress: localhost:54266}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 710def8a918a09a2bc729019bdb17bbd\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver$RemoteWebDriverOptions$RemoteWindow.maximize(RemoteWebDriver.java:837)\r\n\tat stepDefinition.CommonDefinitions.HomePageIsDisplayed(CommonDefinitions.java:24)\r\n\tat ✽.Fest.md home page is displayed(file:src/test/features/EventsNavigation.feature:5)\r\n",
  "status": "failed"
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
  "status": "skipped"
});
formatter.step({
  "name": "Tickets menu page is displayed",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.ticketEventPage(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Conferințe is selected",
  "keyword": "When "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsASection(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User submits 10 tickets for an event of the Conferințe",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.userSelectsAnEvent(String,int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The total price is displayed correct for 10 tickets",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.theTotalPriceOfTicketsIsDisplayedCorrect(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "All fields of booking are filled with Ion, Ion, 076852146 and submited",
  "keyword": "And "
});
formatter.match({
  "location": "TicketsDefinitions.allFieldsOfBookingAreFilledWithFirstnameLastnamePhoneAndSubmited(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Booking is successfully accepted",
  "keyword": "Then "
});
formatter.match({
  "location": "TicketsDefinitions.bookingIsSuccessfullyAccepted()"
});
formatter.result({
  "status": "skipped"
});
