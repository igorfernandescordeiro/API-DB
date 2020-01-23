Feature: API automation test
  testing the api

  Scenario: Wants to see if the call is success
    When calls /movies
    Then receives response status value "200 OK"


  Scenario: Wants to see if the call return value by ID
    When calls /id with "2"
    Then receives response with first_name key value "Ravi"

