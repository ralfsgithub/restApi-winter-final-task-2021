Feature: project

  @Project @Smoke
  Scenario Outline: create_project
    Given the user is authorised
    When the user creates a project with name "<name>"
    Then the user gets status code "201"
    And the user saves response key "id" as session variable with name "projectId"
    Then the user gets created project
    When the user gets status code "200"
    And the user removes created project
    Then the user gets status code "204"
    Examples:
      | name |
      | test |

  @Project @Smoke
  Scenario Outline: delete_not_existing_project
    Given the user is authorised
    When the user removes project with id "<id>"
    And the user gets status code "404"
    Then the value of path "message" is "Not Found"
    Examples:
      | id   |
      | 6364 |

  @Project @Smoke
  Scenario Outline: get_not_existing_project
    Given the user is authorised
    When the user gets project with id "<id>"
    And the user gets status code "404"
    Then the value of path "message" is "Not Found"
    Examples:
      | id   |
      | 6364 |
