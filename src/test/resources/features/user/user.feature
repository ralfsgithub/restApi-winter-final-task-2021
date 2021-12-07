Feature: Create User profile and delete it

  @user @smoke
  Scenario Outline: create_user
    Given the user is authorised
    When user creates profile with "<name>","<email>","<gender>" and "<status>"
    Then the user gets status code "201"
    And the following values are present in the body
      |  data.name | <name> |
      |  data.email | <email> |
      |  data.gender | <gender> |
      |  data.status | <status> |
    And the following keys exists in the body
      | data.id |
    And the user saves response key "data.id" as session variable with name "userId"
    Then the user deletes profile
    And the user gets status code "204"

    Examples:
      | name      | email              | gender | status |
      | TestUser1 |TestEmail1@judo.com | female | active |


  @user @smoke
  Scenario Outline: update_user_name
    Given the user is authorised
    When user creates profile with "<name>","<email>","<gender>" and "<status>"
    Then the user gets status code "201"
    And the user saves response key "data.id" as session variable with name "userId"
    When user updates profile name with "<newName>"
    Then the user gets status code "200"
    And the following values are present in the body
      |  data.name | <newName> |
      |  data.email | <email> |
      |  data.gender | <gender> |
      |  data.status | <status> |

    And the user deletes profile
    And the user gets status code "204"


    Examples:
      | name       |       email       | gender | status |  newName          |
      | TestUser2  |TestUer2@judo.com  | female | active |  UpdatedUserNAme  |


  @user @smoke
  Scenario Outline: create_user_with_already_existing_email
    Given the user is authorised
    When user creates profile with "<name>","<email>","<gender>" and "<status>"
    Then the user gets status code "201"
    When user creates new profile with "<newName>", already used "<email>","<newGender>" and "<newStatus>"
    Then the user gets status code "422"
    And the value of path "data.field" is "[email]"
    And the value of path "data.message" is "[has already been taken]"

    Examples:
      | name       |       email       | gender | status |  newName |  newGender | newStatus |
      | TestUser3  |TestUser3@judo.com | female | active |  Rihads  |   male     |  inactive |


  @user @smoke
  Scenario Outline: remove_already_removed_user_profile
    Given the user is authorised
    When user creates profile with "<name>","<email>","<gender>" and "<status>"
    Then the user gets status code "201"
    And the user saves response key "data.id" as session variable with name "userId"
    Then the user deletes profile
    And the user gets status code "204"
    Then the user deletes already deleted profile
    Then the user gets status code "404"
    And the value of path "data.message" is "Resource not found"

    Examples:
      | name      | email             | gender | status |
      | TestUser4 |TestUser4@judo.com | male   | active |