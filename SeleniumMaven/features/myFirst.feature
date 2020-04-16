Feature: Application Login with different cucumber options

  @SC01
  Scenario: Hardcoded Login
    Given User opens the Guru99.com website
    When User enters the username and password
    Then User is able to view the landing page
    Then Application should be closed

  @SC02
  Scenario: Parameterized Login
    Given User opens the Guru99.com website
    When User enters the "mngr252543" and "saqysUq"
    Then User is able to view the landing page
    Then Application should be closed

  @SC03
  Scenario Outline: Login with Examples keyword
    Given User opens the Guru99.com website
    When User enters the "<uname>" and "<pwd>"
    Then User is able to view the landing page
    Then Application should be closed

    Examples: 
      | uname      | pwd       |
      | viren1     | password1 |
      | mngr252543 | saqysUq   |
	
  @SC04
  Scenario: Application Login through Page Object Model
    Given User opens the Guru99.com website
    When User enters the credentials and click on Login button
    Then User is able to view the welcome page
    Then Application should be closed
	