@phase3
Feature: Compare city temperature between UI and API

	@Temperature
  @web
  @api
  @functional
  Scenario: Find temperature of Ahmedabad city on both UI and API and check if the difference is more than the threshold
    Given On the ndtv landing page
    And Open submenu
    And Click on the weather button
    And Select Ahmedabad city in the pin your city section 
    And Verify that Ahmedabad city shows up on the map
    And Open the Ahmedabad city weather pop up and get the temperature and store
    And Get the city temperature of Ahmedabad in celsius and store
    Then Check if the difference is more than a threshold