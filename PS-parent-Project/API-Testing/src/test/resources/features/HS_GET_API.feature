Feature: Testing GET API

  Scenario Outline: Testing GET request with different schema files
  Given the API endpoint is "<endpoint>"
    When  I send a GET HTTP request with the Accept header
    Then the response status code is <expected_status_code>
    And the response matches the schema "<schema_file>"

    Examples: 
      | endpoint         | schema_file   | expected_status_code |
      | /substances/find | HS_Get_Data.json |                  200 |

  Scenario Outline: Verify successful retrieval of substances with updated resource status
  	Given the API endpoint is "<endpoint>" and the parameter "<key>" has the value "<value>"
  	When I send a GET HTTP request with the Accept header
    Then the response status code is <expected_status_code>
    And the response matches the schema "<schema_file>"

    Examples: 
      | endpoint         | key           | value   | expected_status_code | schema_file   |
      | /substances/find | resourceStatus| UPDATED |                  200 | HS_Updated_Status.json |

Scenario Outline: Verify successful retrieval of substances with created resource status
  	Given the API endpoint is "<endpoint>" and the parameter "<key>" has the value "<value>"
  	When I send a GET HTTP request with the Accept header
    Then the response status code is <expected_status_code>
    And the response matches the schema "<schema_file>"

    Examples: 
      | endpoint         | key           | value   | expected_status_code | schema_file   |
      | /substances/find | resourceStatus| CREATED |                  200 | HS_Created_Status.json |