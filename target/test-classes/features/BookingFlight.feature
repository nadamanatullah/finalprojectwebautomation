Feature: Booking Flight in Agoda

  Scenario: User books a flight from Jakarta to Singapore
    Given user is on the Agoda Flights page
    When user selects departure city as "Jakarta"
    And user selects destination city as "Singapore"
    And user selects tomorrow date
    And user clicks Search
    Then user filters AirAsia flight
    And user selects the cheapest flight
    Then verify selected price matches checkout price
    And verify airline is "Indonesia AirAsia"
    Then user fills contact details
