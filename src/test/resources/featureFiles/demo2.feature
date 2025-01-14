Feature: Verify Demo API
  Description : Verify CRUD operation

  @Demo
  Scenario Outline: Verify demo PUT API
    Given I want to create test case "<TestName>"
    When I hit the "<RequestMethod>" method of PUT USER API with "<URL>" end point
    Then Validate the status code is "<StatusCode>"
    Then Validate user details in PUT API response

    Examples:
      | TestName     | URL      | RequestMethod | StatusCode |
      | PUT Demo API | /users/2 | PUT           | 200        |

  @Demo
  Scenario Outline: Verify demo DELETE API
    Given I want to create test case "<TestName>"
    When I hit the "<RequestMethod>" method of DELETE USER API with "<URL>" end point
    Then Validate the status code is "<StatusCode>"
    Then Validate user details in DELETE API response

    Examples:
      | TestName        | URL      | RequestMethod | StatusCode |
      | DELETE Demo API | /users/2 | DELETE        | 204        |



