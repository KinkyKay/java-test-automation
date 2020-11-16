Feature: Tests for /flights endpoint

  Scenario: client makes call to GET /flights
    Given We have the following airplanes in the database
      | 1 | AH345 | BM77 | Boeing 777 |
      | 2 | AH220 | A3X0 | Airbus A380 |
    And We have the following flights in the database
      |1|Medium-Haull|Paris|Amsterdam|2020-11-12 12:08:17.320053-03|2020-11-12 13:08:17.320053-03|AH345|
      |2|Medium-Haull|Amsterdam|Paris|2020-11-12 14:08:17.320053-03|2020-11-12 15:08:17.320053-03|AH345|
      |3|Medium-Haull|Paris|Amsterdam|2020-11-12 16:08:17.320053-03|2020-11-12 17:08:17.320053-03|AH345|
      |4|Medium-Haull|Amsterdam|Paris|2020-11-12 18:08:17.320053-03|2020-11-12 19:08:17.320053-03|AH345|
      |5|Medium-Haull|Paris|Amsterdam|2020-11-12 20:08:17.320053-03|2020-11-12 21:08:17.320053-03|AH345|
      |6|Long-Haull|Brussels|New-York|2020-11-12 16:08:17.320053-03|2020-11-13 00:08:17.320053-03|AH220|
    When the client calls /flights
    Then the client receives status code of 200

  Scenario: client makes call to GET /flights
    Given We have the following airplanes in the database
      | 1 | AH345 | BM77 | Boeing 777 |
      | 2 | AH220 | A3X0 | Airbus A380 |
    And We have the following flights in the database
      |1|Medium-Haull|Paris|Amsterdam|2020-11-12 12:08:17.320053-03|2020-11-12 13:08:17.320053-03|AH345|
      |2|Medium-Haull|Amsterdam|Paris|2020-11-12 14:08:17.320053-03|2020-11-12 15:08:17.320053-03|AH345|
      |3|Medium-Haull|Paris|Amsterdam|2020-11-12 16:08:17.320053-03|2020-11-12 17:08:17.320053-03|AH345|
      |4|Medium-Haull|Amsterdam|Paris|2020-11-12 18:08:17.320053-03|2020-11-12 19:08:17.320053-03|AH345|
      |5|Medium-Haull|Paris|Amsterdam|2020-11-12 20:08:17.320053-03|2020-11-12 21:08:17.320053-03|AH345|
      |6|Long-Haull|Brussels|New-York|2020-11-12 16:08:17.320053-03|2020-11-13 00:08:17.320053-03|AH220|
    When the client calls /flights
    Then the client take the first flight and the destination is Amsterdam

  Scenario: client makes call to GET /flights
    Given We have the following airplanes in the database
      | 1 | AH345 | BM77 | Boeing 777 |
      | 2 | AH220 | A3X0 | Airbus A380 |
    And We have the following flights in the database
      |1|Medium-Haull|Paris|Amsterdam|2020-11-12 12:08:17.320053-03|2020-11-12 13:08:17.320053-03|AH345|
      |2|Medium-Haull|Amsterdam|Paris|2020-11-12 14:08:17.320053-03|2020-11-12 15:08:17.320053-03|AH345|
      |3|Medium-Haull|Paris|Amsterdam|2020-11-12 16:08:17.320053-03|2020-11-12 17:08:17.320053-03|AH345|
      |4|Medium-Haull|Amsterdam|Paris|2020-11-12 18:08:17.320053-03|2020-11-12 19:08:17.320053-03|AH345|
      |5|Medium-Haull|Paris|Amsterdam|2020-11-12 20:08:17.320053-03|2020-11-12 21:08:17.320053-03|AH345|
      |6|Long-Haull|Brussels|New-York|2020-11-12 16:08:17.320053-03|2020-11-13 00:08:17.320053-03|AH220|
    When the client calls /flights
    Then the client take the first flight and the origin is Paris

  Scenario: client makes call to GET /flights/origin/Paris
    Given We have the following airplanes in the database
      | 1 | AH345 | BM77 | Boeing 777 |
      | 2 | AH220 | A3X0 | Airbus A380 |
    And We have the following flights in the database
      |1|Medium-Haull|Paris|Amsterdam|2020-11-12 12:08:17.320053-03|2020-11-12 13:08:17.320053-03|AH345|
      |2|Medium-Haull|Amsterdam|Paris|2020-11-12 14:08:17.320053-03|2020-11-12 15:08:17.320053-03|AH345|
      |3|Medium-Haull|Paris|Amsterdam|2020-11-12 16:08:17.320053-03|2020-11-12 17:08:17.320053-03|AH345|
      |4|Medium-Haull|Amsterdam|Paris|2020-11-12 18:08:17.320053-03|2020-11-12 19:08:17.320053-03|AH345|
      |5|Medium-Haull|Paris|Amsterdam|2020-11-12 20:08:17.320053-03|2020-11-12 21:08:17.320053-03|AH345|
      |6|Long-Haull|Brussels|New-York|2020-11-12 16:08:17.320053-03|2020-11-13 00:08:17.320053-03|AH220|
    When the client calls /flights/origin/Paris
    Then all the flights origin is Paris

  Scenario: client makes call to GET /flights/origin/Amsterdam
    Given We have the following airplanes in the database
      | 1 | AH345 | BM77 | Boeing 777 |
      | 2 | AH220 | A3X0 | Airbus A380 |
    And We have the following flights in the database
      |1|Medium-Haull|Paris|Amsterdam|2020-11-12 12:08:17.320053-03|2020-11-12 13:08:17.320053-03|AH345|
      |2|Medium-Haull|Amsterdam|Paris|2020-11-12 14:08:17.320053-03|2020-11-12 15:08:17.320053-03|AH345|
      |3|Medium-Haull|Paris|Amsterdam|2020-11-12 16:08:17.320053-03|2020-11-12 17:08:17.320053-03|AH345|
      |4|Medium-Haull|Amsterdam|Paris|2020-11-12 18:08:17.320053-03|2020-11-12 19:08:17.320053-03|AH345|
      |5|Medium-Haull|Paris|Amsterdam|2020-11-12 20:08:17.320053-03|2020-11-12 21:08:17.320053-03|AH345|
      |6|Long-Haull|Brussels|New-York|2020-11-12 16:08:17.320053-03|2020-11-13 00:08:17.320053-03|AH220|
    When the client calls /flights/origin/Amsterdam
    Then all the flights origin is Amsterdam

  Scenario: client makes call to GET /flights/destination/Paris
    Given We have the following airplanes in the database
      | 1 | AH345 | BM77 | Boeing 777 |
      | 2 | AH220 | A3X0 | Airbus A380 |
    And We have the following flights in the database
      |1|Medium-Haull|Paris|Amsterdam|2020-11-12 12:08:17.320053-03|2020-11-12 13:08:17.320053-03|AH345|
      |2|Medium-Haull|Amsterdam|Paris|2020-11-12 14:08:17.320053-03|2020-11-12 15:08:17.320053-03|AH345|
      |3|Medium-Haull|Paris|Amsterdam|2020-11-12 16:08:17.320053-03|2020-11-12 17:08:17.320053-03|AH345|
      |4|Medium-Haull|Amsterdam|Paris|2020-11-12 18:08:17.320053-03|2020-11-12 19:08:17.320053-03|AH345|
      |5|Medium-Haull|Paris|Amsterdam|2020-11-12 20:08:17.320053-03|2020-11-12 21:08:17.320053-03|AH345|
      |6|Long-Haull|Brussels|New-York|2020-11-12 16:08:17.320053-03|2020-11-13 00:08:17.320053-03|AH220|
    When the client calls /flights/destination/Paris
    Then all the flights destination is Paris

  Scenario: client makes call to GET /flights/destination/Amsterdam
    Given We have the following airplanes in the database
      | 1 | AH345 | BM77 | Boeing 777 |
      | 2 | AH220 | A3X0 | Airbus A380 |
    And We have the following flights in the database
      |1|Medium-Haull|Paris|Amsterdam|2020-11-12 12:08:17.320053-03|2020-11-12 13:08:17.320053-03|AH345|
      |2|Medium-Haull|Amsterdam|Paris|2020-11-12 14:08:17.320053-03|2020-11-12 15:08:17.320053-03|AH345|
      |3|Medium-Haull|Paris|Amsterdam|2020-11-12 16:08:17.320053-03|2020-11-12 17:08:17.320053-03|AH345|
      |4|Medium-Haull|Amsterdam|Paris|2020-11-12 18:08:17.320053-03|2020-11-12 19:08:17.320053-03|AH345|
      |5|Medium-Haull|Paris|Amsterdam|2020-11-12 20:08:17.320053-03|2020-11-12 21:08:17.320053-03|AH345|
      |6|Long-Haull|Brussels|New-York|2020-11-12 16:08:17.320053-03|2020-11-13 00:08:17.320053-03|AH220|
    When the client calls /flights/destination/Amsterdam
    Then all the flights destination is Amsterdam

  Scenario: client makes call to GET /flights/destination/London
    Given We have the following airplanes in the database
      | 1 | AH345 | BM77 | Boeing 777 |
      | 2 | AH220 | A3X0 | Airbus A380 |
    And We have the following flights in the database
      |1|Medium-Haull|Paris|Amsterdam|2020-11-12 12:08:17.320053-03|2020-11-12 13:08:17.320053-03|AH345|
      |2|Medium-Haull|Amsterdam|Paris|2020-11-12 14:08:17.320053-03|2020-11-12 15:08:17.320053-03|AH345|
      |3|Medium-Haull|Paris|Amsterdam|2020-11-12 16:08:17.320053-03|2020-11-12 17:08:17.320053-03|AH345|
      |4|Medium-Haull|Amsterdam|Paris|2020-11-12 18:08:17.320053-03|2020-11-12 19:08:17.320053-03|AH345|
      |5|Medium-Haull|Paris|Amsterdam|2020-11-12 20:08:17.320053-03|2020-11-12 21:08:17.320053-03|AH345|
      |6|Long-Haull|Brussels|New-York|2020-11-12 16:08:17.320053-03|2020-11-13 00:08:17.320053-03|AH220|
    When the client calls /flights/destination/London
    Then there is no flight for this destination
    Then the client add a destination to 'London'
    When the client calls /flights/destination/London
    Then we have one flight