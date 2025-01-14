Feature: Verify Demo API
  Description : Verify CRUD operation

  @Demo
  Scenario Outline: Verify demo POST API
    Given I want to create test case "<TestName>"
    When I hit the "<RequestMethod>" method of POST USER API with "<URL>" end point
    Then Validate the status code of POST API is "<StatusCode>"
    Then Validate user details in POST API response

    Examples:
      | TestName      | URL    | RequestMethod | StatusCode |
      | POST Demo API | /users | POST          | 201        |

  @Demo
  Scenario Outline: Verify demo GET API
    Given I want to create test case "<TestName>"
    When I hit the "<RequestMethod>" method of GET USER API with "<URL>" end point
    Then Validate the status code of GET API is "<StatusCode>"
    Then Validate user details in GET API response

    Examples:
      | TestName     | URL      | RequestMethod | StatusCode |
      | GET Demo API | /users/2 | GET           | 200        |


