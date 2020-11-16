INSERT INTO AIRPLANES (code, model, description) VALUES
  ('AH101', 'A338', 'Airbus A330-800neo'),
  ('AH202', 'A339', 'Airbus A330-900neo'),
  ('AH103', 'A342', 'Airbus A340-200'),
  ('AH104', 'A343', 'Airbus A340-300'),
  ('AH105', 'A345', 'Airbus A340-500'),
  ('AH106', 'A346', 'Airbus A340-600'),
  ('AH107', 'A359', 'Airbus A350-900'),
  ('AH108', 'A388', 'Airbus A380-800'),
  ('AH109', 'B37M', 'Boeing 737 MAX 7'),
  ('AH110', 'B38M', 'Boeing 737 MAX 8'),
  ('AH111', 'B39M', 'Boeing 737 MAX 9'),
  ('AH112', 'B3XM', 'Boeing 737 MAX 10');


INSERT INTO FLIGHTS (type, origin, destination, departure_date, arrival_date, airplane_id) VALUES
  ('Medium-Haull', 'Paris', 'Amsterdam', '2020-11-12 12:08:17.320053-03', '2020-11-12 13:08:17.320053-03', 1),
  ('Medium-Haull', 'Amsterdam', 'Paris', '2020-11-12 14:08:17.320053-03', '2020-11-12 15:08:17.320053-03', 1),
  ('Medium-Haull', 'Paris', 'Amsterdam', '2020-11-12 16:08:17.320053-03', '2020-11-12 17:08:17.320053-03', 2),
  ('Medium-Haull', 'Amsterdam', 'Paris', '2020-11-12 16:08:17.320053-03', '2020-11-12 17:08:17.320053-03', 3),
   ('Long-Haull', 'Brussels', 'New-York', '2020-11-12 19:08:17.320053-03', '2020-11-13 01:08:17.320053-03', 11);