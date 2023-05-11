INSERT
INTO
  restaurants
  (name, cuisine, `description`, city, state, zip_code)
VALUES
  ('Taco Molon', 'Mexican', 'Ricos Tacos!', 'New York', 'New York', '12345'), ('Ichiban Takai', 'Japanese',
  'For that picky 1%', 'Miami', 'Florida', '54321');
  INSERT
INTO
  users
  (name, city, state, zip_code)
VALUES
  ('user1', 'New York', 'New York', '12345'), ('user2', 'Miami ', 'Florida', '54321');
  INSERT
INTO
  users
  (name, city, state, zip_code, interested_in_peanut_allergies)
VALUES
  ('John1', 'New York', 'New York', '12345', 0);

INSERT
INTO
  reviews
  (author_id, restaurant_id, dairy_rating, commentary)
VALUES
  (1, 1, 3, 'Nice!');
INSERT
INTO
  reviews
  (author_id, restaurant_id, peanut_rating, egg_rating, dairy_rating, commentary)
VALUES
  (1, 1, 2, 4, 4, 'Second Comment');
