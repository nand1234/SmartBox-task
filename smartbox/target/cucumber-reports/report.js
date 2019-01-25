$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("addToCart.feature");
formatter.feature({
  "line": 1,
  "name": "Fizz Buzz Game",
  "description": "",
  "id": "fizz-buzz-game",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Get answers based on played numbers",
  "description": "",
  "id": "fizz-buzz-game;get-answers-based-on-played-numbers",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I am officiating a FizzBuzz game",
  "keyword": "Given "
});
formatter.match({
  "location": "addtocartsteps.I_am_officiating_a_FizzBuzz_game()"
});
formatter.result({
  "duration": 82995200,
  "status": "passed"
});
formatter.step({
  "line": 5,
  "name": "the number 1 is played",
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 11
    }
  ],
  "location": "addtocartsteps.the_number_is_played(int)"
});
});