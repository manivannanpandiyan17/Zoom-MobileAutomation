Feature: Zoom meeting Automation
I want to verify the join meeting fuctionality

  Scenario Outline: Verify the Join meeting functionality in zoom app
  Given I launch the zoom mobile app
  When I click on Join meeting button
  And I enter Meeting Id less than nine digits "<Incorrect Meeting Id>"
  And Join button is disabled "<Incorrect Meeting Id>"
  And I enter the correct meeting id "<Correct Meeting Id>"
  And Join button is enabled "<Correct Meeting Id>"
  And I click on Join button
  Then An Invalid Pop up message is displayed "<Error Message>"
  
  Examples:
    | Incorrect Meeting Id  | Correct Meeting Id | Error Message                                    |
    | 94134307              | 941343070          | Invalid meeting ID. Please check and try again.  |