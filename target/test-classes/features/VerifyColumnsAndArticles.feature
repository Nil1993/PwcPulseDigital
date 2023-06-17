Feature: Verifying Digital Pulse webPage

	@Smoke
	Scenario Outline: Verfication of number of columns and articles
		Given I navigate to the PwC Digital Pulse website
    When I am viewing the <NameOfPage> page
    Then I am presented with <NumberOfColumn> columns of articles
    And The Left <LeftCol> column is displaying <LeftColumnArticles> articles
    And the Middle <MiddleCol> column is displaying <MiddleColumnArticles> articles
    And The Right <RightCol> is displaying <RightColumnArticles> articles
    Examples:
    | NameOfPage | NumberOfColumn | LeftCol		| MiddleCol 		| RightCol 		|LeftColumnArticles | MiddleColumnArticles | RightColumnArticles |
    | "Home"     	 | "3"     					| "2"      	| "1"       | "3"       | "2"     						| "1"        						 | "4"                   |
    
  @Regression
  Scenario Outline: Subsribe Page Fields Verification
   Given I navigate to the PwC Digital Pulse website
   And I am viewing the <NameOfPage> page
   When I click on the Subscribe navigation link
   Then I am taken to the Subscribe page
   And I am presented with the below fields
   | Field | Required | Type |
   | First Name  |true |text  |
   |Last Name    |true | text |
   |Organisation |true | text |
   |Job Title    |true | dropdown |
   |Business Email Address| true | text |
   |State                 | true  | dropdown |
   |Countries or regions               |true   | dropdown |
   And I will need to complete Google reCAPTCHA before I can complete my request
   Examples:
        | NameOfPage |
        | "Home"     |

   @Sanity
   Scenario Outline: verification of Number of Search Results
   	Given I navigate to the PwC Digital Pulse website
    When I click on the Magnifying glass icon to perform a search
    And I enter the text <TextToEnter>
    And I submit the search
    Then I am taken to the search results page
    And I am presented with at least <MinimumNumberOfResults> search result
    Examples:
      | TextToEnter | MinimumNumberOfResults |
      | "Single page applications"     | "1" |