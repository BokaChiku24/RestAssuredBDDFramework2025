Feature: Validating Place API's

  Scenario: Verifying if place is being successfully added using AddPlaceAPI
    Given add place payload
    When user calls "AddPlaceAPI" with POST http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"