CREATE USER 'studia'@'localhost' IDENTIFIED BY 'studia';

GRANT ALL PRIVILEGES ON * . * TO 'studia'@'localhost';

ALTER USER 'studia'@'localhost' IDENTIFIED WITH mysql_native_password BY 'studia';