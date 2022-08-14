@regression_Test
Feature: Find user details
  Find user details with username
  All email addreses should have valid email format
@User
  Scenario Outline: Search for the user with username
    Given I search for User "<userName>"
    When Verify if user "<userName>" exists "<exist_Status>"
    Examples:
      | userName | exist_Status |
      | Delphine | Exist        |
      | Delphin# | NotExist     |
@Post
  Scenario Outline: Find user details such as Post & Email with username
    Given I have userId for "<userName>"
    Then Verify userId <userId> for "<userName>"
    When I query  posts for specific user with userid parameter
    Then Verify the count of Post <post_Count> for user with <userId>
    Then Verify user should get <email_Count> emails
    Examples:
      | userName | userId | post_Count | email_Count |
      | Delphine | 9      | 10         | 50          |

@Email
  Scenario: I should verify all email addresses are valid
    When I check all email addresses
    Then I should have all email addreses in valid format