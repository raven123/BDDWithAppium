#Author: Ravikumar.Rai
Feature: Search Cars
  As a logged in User
  I want to search for available cars at my location 
  In order to purchase one of my choice

  @tag1
  Scenario Outline: Search available cars at my location
    Given I have logged in to the application
    And I have selected my location
    When I input the "<car_model>" into the search bar
    Then I should get search results list for the same

    Examples: 
      | car_model |
      | Mercedes  |
      | BMW       |
      | Ferari    |
