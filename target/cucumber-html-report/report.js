$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/features/Registration.feature");
formatter.feature({
  "name": "Registration",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Valik"
    }
  ]
});
formatter.scenarioOutline({
  "name": "User is able to register",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Registration"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Register page is displayed",
  "keyword": "Given "
});
formatter.step({
  "name": "Submit \u003cemail\u003e, \u003cpassword\u003e and confirm password in registration form",
  "keyword": "When "
});
formatter.step({
  "name": "Home page is displayed",
  "keyword": "Then "
});
formatter.step({
  "name": "User unable to register with the same credentials",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "test2@gma.ru",
        "123123"
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
  "name": "User is able to register",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Valik"
    },
    {
      "name": "@Registration"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Register page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "RegistrationStepDefinition.registerPageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Submit test2@gma.ru, 123123 and confirm password in registration form",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrationStepDefinition.submitEmailPasswordAndConfirmPasswordInRegistrationForm(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Home page is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrationStepDefinition.homePageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User unable to register with the same credentials",
  "keyword": "And "
});
formatter.match({
  "location": "RegistrationStepDefinition.registerIsSuccessful()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "User fails to registrate",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Negative"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Register page is displayed",
  "keyword": "Given "
});
formatter.step({
  "name": "Submit \u003cemail\u003e, \u003cpassword\u003e and confirm password in registration form",
  "keyword": "When "
});
formatter.step({
  "name": "Registration fails with \u003cerror\u003e message",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email",
        "password",
        "error"
      ]
    },
    {
      "cells": [
        "test",
        "123123",
        "Adresa de email introdusă nu este validă."
      ]
    },
    {
      "cells": [
        "null",
        "123123",
        "Acest câmp nu poate fi gol."
      ]
    },
    {
      "cells": [
        "test2@gma.ru",
        "null",
        "Acest câmp nu poate fi gol."
      ]
    },
    {
      "cells": [
        "num2@ij.md",
        "PassWithAnotherConfirm",
        "Parolele introduse nu coincid."
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
  "name": "User fails to registrate",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Valik"
    },
    {
      "name": "@Negative"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Register page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "RegistrationStepDefinition.registerPageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Submit test, 123123 and confirm password in registration form",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrationStepDefinition.submitEmailPasswordAndConfirmPasswordInRegistrationForm(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Registration fails with Adresa de email introdusă nu este validă. message",
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrationStepDefinition.registrationFailsWithErrorMessage(String)"
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
  "name": "User fails to registrate",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Valik"
    },
    {
      "name": "@Negative"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Register page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "RegistrationStepDefinition.registerPageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Submit null, 123123 and confirm password in registration form",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrationStepDefinition.submitEmailPasswordAndConfirmPasswordInRegistrationForm(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Registration fails with Acest câmp nu poate fi gol. message",
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrationStepDefinition.registrationFailsWithErrorMessage(String)"
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
  "name": "User fails to registrate",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Valik"
    },
    {
      "name": "@Negative"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Register page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "RegistrationStepDefinition.registerPageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Submit test2@gma.ru, null and confirm password in registration form",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrationStepDefinition.submitEmailPasswordAndConfirmPasswordInRegistrationForm(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Registration fails with Acest câmp nu poate fi gol. message",
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrationStepDefinition.registrationFailsWithErrorMessage(String)"
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
  "name": "User fails to registrate",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Valik"
    },
    {
      "name": "@Negative"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Register page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "RegistrationStepDefinition.registerPageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Submit num2@ij.md, PassWithAnotherConfirm and confirm password in registration form",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrationStepDefinition.submitEmailPasswordAndConfirmPasswordInRegistrationForm(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Registration fails with Parolele introduse nu coincid. message",
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrationStepDefinition.registrationFailsWithErrorMessage(String)"
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
  "name": "Registration window UI check",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Valik"
    },
    {
      "name": "@UI"
    },
    {
      "name": "@Valik"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Register page is displayed",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrationStepDefinition.registerPageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the following elements are visible on Register page",
  "rows": [
    {
      "cells": [
        "Register title"
      ]
    },
    {
      "cells": [
        "Email field"
      ]
    },
    {
      "cells": [
        "Password field"
      ]
    },
    {
      "cells": [
        "Confirm password field"
      ]
    },
    {
      "cells": [
        "Register button"
      ]
    },
    {
      "cells": [
        "Login button"
      ]
    },
    {
      "cells": [
        "Login with facebook button"
      ]
    },
    {
      "cells": [
        "Recieve newletter checkbox"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrationStepDefinition.theFollowingElementsAreVisible(DataTable)"
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
  "name": "Login window UI check",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Valik"
    },
    {
      "name": "@UI"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Login page is displayed",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrationStepDefinition.loginPageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the following elements are visible on Login page",
  "rows": [
    {
      "cells": [
        "Login title"
      ]
    },
    {
      "cells": [
        "Email field"
      ]
    },
    {
      "cells": [
        "Password field"
      ]
    },
    {
      "cells": [
        "Register button"
      ]
    },
    {
      "cells": [
        "Login button"
      ]
    },
    {
      "cells": [
        "Login with facebook button"
      ]
    },
    {
      "cells": [
        "Forgot password link"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrationStepDefinition.theFollowingElementsAreVisibleOnLoginPage(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "User deletes account",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Registration"
    },
    {
      "name": "@Deleting"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Account with \u003cemail\u003e and \u003cpassword\u003e was deleted",
  "keyword": "When "
});
formatter.step({
  "name": "Home page is displayed",
  "keyword": "Then "
});
formatter.step({
  "name": "Checked that account was deleted",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "test2@gma.ru",
        "123123"
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
  "name": "User deletes account",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Valik"
    },
    {
      "name": "@Registration"
    },
    {
      "name": "@Deleting"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Account with test2@gma.ru and 123123 was deleted",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrationStepDefinition.accountWasDeleted(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Home page is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrationStepDefinition.homePageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Checked that account was deleted",
  "keyword": "And "
});
formatter.match({
  "location": "RegistrationStepDefinition.checkedThatAccountWasDeleted()"
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
  "name": "Registration/Login page UI check",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Valik"
    },
    {
      "name": "@UI"
    },
    {
      "name": "@Fest"
    }
  ]
});
formatter.step({
  "name": "Register_Login page is displayed",
  "keyword": "When "
});
formatter.match({
  "location": "RegistrationStepDefinition.registerLoginPageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the following elements are visible on Register_Login page",
  "rows": [
    {
      "cells": [
        "Register title"
      ]
    },
    {
      "cells": [
        "Login title"
      ]
    },
    {
      "cells": [
        "LoginRegister title"
      ]
    },
    {
      "cells": [
        "Email register field"
      ]
    },
    {
      "cells": [
        "Email login field"
      ]
    },
    {
      "cells": [
        "Password register field"
      ]
    },
    {
      "cells": [
        "Password login field"
      ]
    },
    {
      "cells": [
        "Confirm password field"
      ]
    },
    {
      "cells": [
        "Forgot Password Link"
      ]
    },
    {
      "cells": [
        "Register button"
      ]
    },
    {
      "cells": [
        "Login button"
      ]
    },
    {
      "cells": [
        "Facebook login register button"
      ]
    },
    {
      "cells": [
        "Recieve newletter checkbox"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "RegistrationStepDefinition.theFollowingElementsAreVisibleOnRegisterLoginPage(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});