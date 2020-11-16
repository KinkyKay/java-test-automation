Feature: Get all the airplanes

  Scenario: client makes call to GET /airplanes
    Given We have the following airplanes in the database
      | 1 | AH345 | BM77 | Boeing 777 |
      | 2 | AH220 | A3X0 | Airbus A380 |
    When the client calls /airplanes
    Then the client receives status code of 200
    And the number of airplanes is 2

  Scenario: client makes call to POST /airplanes a new aircraft is in the database
    Given We have the following airplanes in the database
      | 1 | AH345 | BM77 | Boeing 777 |
      | 2 | AH220 | A3X0 | Airbus A380 |
      | 3 | AH900 | BM67 | Boeing 767 |
    When the client calls POST /airplanes with code AH200 model A3X0 and description 'Airbus A365'
    When the client calls /airplanes
    Then the client receives status code of 200
    And the number of airplanes is 4