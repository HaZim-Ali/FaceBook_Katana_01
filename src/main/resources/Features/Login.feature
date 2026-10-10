#@Monkey🐒
Feature: To Login Functionality

  Scenario: Login with Valid Credentials
    When clint enters mobile number
    And clint fill passwords
    And clint click on login button

#  @Monkey🐒
Scenario Outline: Verify To Login With Invalid Credentials

  When clint enters "<Invalidmobilenumber>"
  And clint fill "<Invalidpasswords>"
  And clint click on login button

  Examples:
    | Invalidmobilenumber | Invalidpasswords |
    |     971501234567    |  hhhhhhhhhhhh    |
    |     5040506020      |  AAAAAAAAAAA     |
    |     789160123456    |  ZZZZZZZZZZZZ    |
    |     0221234567      |  MMMMMMMMMMM     |

