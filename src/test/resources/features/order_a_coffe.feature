Feature: Order a coffe

  In order to save time when I pick up my morning coffee
  As a coffe lover
  I want to be able to order a coffee in advance

  Scenario: Buyer orders a coffee when they are close to de coffee shop
    Given Kathy is 100 meters from the coffee shop
    When Kathy orders a large cappuccino
    Then Barry should receive the order
    And Barry should know that the coffee is Urgent