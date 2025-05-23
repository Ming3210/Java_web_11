create database web_11;
use web_11;

CREATE TABLE movie (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(100) NOT NULL,
                       director VARCHAR(50) NOT NULL,
                       releaseDate DATE,
                       genre VARCHAR(30) NOT NULL,
                       poster TEXT
);

DELIMITER //

CREATE PROCEDURE add_movie(
    IN p_title VARCHAR(100),
    IN p_director VARCHAR(50),
    IN p_releaseDate DATE,
    IN p_genre VARCHAR(30),
    IN p_poster TEXT
)
BEGIN
INSERT INTO movie (title, director, releaseDate, genre, poster)
VALUES (p_title, p_director, p_releaseDate, p_genre, p_poster);
END //

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE getAllMovies()
BEGIN
SELECT id, title, director, releaseDate, genre, poster FROM movie;
END $$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE update_movie(
    IN p_id INT,
    IN p_title VARCHAR(100),
    IN p_director VARCHAR(50),
    IN p_release_date DATE,
    IN p_genre VARCHAR(30),
    IN p_poster TEXT
)
BEGIN
UPDATE movie
SET title = p_title,
    director = p_director,
    releaseDate = p_release_date,
    genre = p_genre,
    poster = p_poster
WHERE id = p_id;
END $$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE get_movie_by_id(IN p_id INT)
BEGIN
SELECT * FROM movie WHERE id = p_id;
END $$

DELIMITER ;


DELIMITER //
CREATE PROCEDURE delete_movie(IN movieId INT)
BEGIN
DELETE FROM movie WHERE id = movieId;
END //
DELIMITER ;



CREATE TABLE category (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          categoryName VARCHAR(50) NOT NULL UNIQUE,
                          status BIT DEFAULT 1
);

DELIMITER $$

CREATE PROCEDURE AddCategoryProc(
    IN p_categoryName VARCHAR(50),
    IN p_status BIT
)
BEGIN
    DECLARE cnt INT;
SELECT COUNT(*) INTO cnt FROM category WHERE categoryName = p_categoryName;
IF cnt > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Category name already exists';
ELSE
        INSERT INTO category(categoryName, status) VALUES (p_categoryName, p_status);
END IF;
END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE ListCategories()
BEGIN
SELECT id, categoryName, status FROM category;
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE UpdateCategoryProc(
    IN p_id INT,
    IN p_categoryName VARCHAR(50),
    IN p_status BIT
)
BEGIN
    DECLARE cnt INT;
SELECT COUNT(*) INTO cnt FROM category WHERE categoryName = p_categoryName AND id <> p_id;
IF cnt > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Category name already exists';
ELSE
UPDATE category SET categoryName = p_categoryName, status = p_status WHERE id = p_id;
END IF;
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE DeleteCategoryProc(
    IN p_id INT
)
BEGIN
DELETE FROM category WHERE id = p_id;
END$$

DELIMITER ;
