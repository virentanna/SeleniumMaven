$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("myFirst.feature");
formatter.feature({
  "line": 1,
  "name": "Application Login with different cucumber options",
  "description": "",
  "id": "application-login-with-different-cucumber-options",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 30,
  "name": "Application Login through Page Object Model",
  "description": "",
  "id": "application-login-with-different-cucumber-options;application-login-through-page-object-model",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 29,
      "name": "@SC04"
    }
  ]
});
formatter.step({
  "line": 31,
  "name": "User opens the Guru99.com website",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "User enters the credentials and click on Login button",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "User is able to view the welcome page",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "Application should be closed",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "99",
      "offset": 19
    }
  ],
  "location": "LoginSteps.user_opens_the_Guru_com_website(int)"
});
formatter.result({
  "duration": 7205524177,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.user_enters_the_credentials_and_click_on_Login_button()"
});
formatter.result({
  "duration": 3459801287,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.user_is_able_to_view_the_welcome_page()"
});
formatter.result({
  "duration": 59256350,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.application_should_be_closed()"
});
formatter.result({
  "duration": 5656862794,
  "status": "passed"
});
});