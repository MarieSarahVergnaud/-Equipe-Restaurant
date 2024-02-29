DROP TABLE IF EXISTS reservations, tables;

CREATE TABLE tables (
	id					INT			PRIMARY KEY,
	available_seats		INT,
	busy_at				DATETIME
);

CREATE TABLE reservations (
	id					INT			PRIMARY KEY,
	reservation_time	DATETIME,
	table_id			INT,
	FOREIGN KEY (table_id) REFERENCES tables(id)
);

