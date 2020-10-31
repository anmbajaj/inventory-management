CREATE TABLE IF NOT EXISTS Item(
	id int AUTO_INCREMENT PRIMARY KEY,
	name varchar(250) NOT NULL,
	description varchar(250) NOT NULL,
	quantity number NOT NULL,
	price number NOT NULL
);