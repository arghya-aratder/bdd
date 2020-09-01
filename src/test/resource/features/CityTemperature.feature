
Feature: Find city temperature using NDTV weather app

	@Temperature
  @web
  @functional
  Scenario: Find temperature of Ahmedabad city
    Given On the ndtv landing page
    And Open submenu
    And Click on the weather button
    And Select Ahmedabad city in the pin your city section 
    And Verify that Ahmedabad city shows up on the map
    Then Open the Ahmedabad city weather pop up and get the temperature
    

  