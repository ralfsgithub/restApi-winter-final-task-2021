Feature: user

  @User @Smoke
  Scenario Outline: get_user_profile
    Given the user is authorised
    And user gets profile information
    Then the user gets status code "<statusCode>"
    And the following keys exists in the body
      | id          |
      | node_id     |
      | avatar_url  |
    Examples:
      | statusCode |
      | 200        |