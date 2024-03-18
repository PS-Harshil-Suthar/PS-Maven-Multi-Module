Feature: Testing POST API

  Scenario Outline: Search for substances by keys
    Given the API is available
    When I send a POST request to "<endpoint>" endpoint with the following request body:
      """
      <request_body>
      """
    Then the API should return the expected data
    And the response status code should be <expected_status_code>
    And the response should match the schema "<schemaFile>"

    Examples: 
      | endpoint               | request_body                                                                             | expected_status_code | schemaFile              |
      | /substances/findByKeys | ["VSK-00000000-0000-0000-0000-000000000006", "VSK-00000000-0000-0000-0000-000000000003"] |                  200 | HS_Post_substances.json |

  Scenario Outline: Verify invalid or missing request body
    Given the API is available
    When I send a POST request to "<endpoint>" endpoint with the following request body:
      """
      <request_body>
      """
    Then the API should return an empty response
    And the response status code should be <expected_status_code>
    And the response should match the schema "<schemaFile>"

    Examples: 
      | endpoint               | request_body | expected_status_code | schemaFile          |
      | /substances/findByKeys | []           |                  200 | HS_emptySchema.json |

  Scenario Outline: Verify empty result for non-existent keys
    Given the API is available
    When I send a POST request to "<endpoint>" endpoint with the following request body:
      """
      <request_body>
      """
    Then the API should return an empty response
    And the response status code should be <expected_status_code>
    And the response should match the schema "<schemaFile>"

    Examples: 
      | endpoint               | request_body                                 | expected_status_code | schemaFile          |
      | /substances/findByKeys | ["VSK-00000000-0000-0000-0000-000000000001"] |                  200 | HS_emptySchema.json |

  Scenario Outline: Send a POST request with an invalid format for the request body
    Given the API is available
    When I send a POST request to "<endpoint>" endpoint with the following request body:
      """
      <invalid_request_body>
      """
    Then the API should return an empty response
    And the response status code should be <expected_status_code>
    And the response should match the schema "<schemaFile>"

    Examples: 
      | endpoint               | invalid_request_body                     | expected_status_code | schemaFile          |
      | /substances/findByKeys | ["00000000-0000-0000-0000-000000000006"] |                  200 | HS_emptySchema.json |



  Scenario Outline: Verify that the Content-Type header in the POST request is set to "application/json"
    Given the API is available
    When I send a POST request to <endpoint> endpoint with the following request body in text format <request_body>
    Then the API should return an error message indicating error message
    And the response status code should be <expected_status_code>

    Examples: 
      | endpoint                 | request_body                                 | expected_status_code |
      | "/substances/findByKeys" | "VSK-00000000-0000-0000-0000-000000000001"   | 415                  |
  
  
  
  
  
  #Scenario Outline: Verify successful retrieval of substances with updated resource status
    #Given the API is available
    #When I send a POST request to the endpoint "<endpoint>" with query parameter "<key>" set to "<value>"
    #Then the response body should contain a list of substances with updated resource status
    #And the response status code should be <expected_status_code>
    #And the response should match the schema "<schemaFile>"
#
    #Examples: 
      #| endpoint         | key            | value   | expected_status_code | schemaFile          |
      #| /substances/find | resourceStatus | UPDATED | 400                  | HS_Error_Message.json |
