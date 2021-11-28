Feature: user

  @User @Smoke
  Scenario Outline: get_ser_profile
    Given the user is authorised
    And user gets profile information
    Then the user gets status code "<statusCode>"
    And the following keys exists in the body
      | login       |
      | id          |
      | node_id     |
      | plan        |
      | avatar_url  |
    Examples:
      | statusCode |
      | 200        |