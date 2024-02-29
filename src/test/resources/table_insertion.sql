DELETE FROM reservations;
DELETE FROM tables;

INSERT INTO tables
	(id, available_seats, busy_at)
VALUES
	(1, 0, null),
	(2, 0, null),
	(3, 0, null),
	(4, 0, null),
	(5, 0, null),
	(6, 0, null),
	(7, 0, null),
	(8, 0, '2024-29-02 12:00:00'),
	(9, 0, '2024-29-02 10:00:00'),
	(10, 0, '2024-29-02 14:29:00'),
	(11, 0, '2024-29-02 9:00:00'),
	(12, 0, '2024-29-02 15:00:00');

INSERT INTO reservations
	(id, reservation_time, table_id)
VALUES
	(1, '2024-01-03 12:00:00', 2),
	(2, '2024-29-02 8:00:00', 3),
	(3, '2024-29-02 16:00:00', 4),
	(4, '2024-29-02 12:00:00', 5),
	(5, '2024-29-02 10:00:00', 6),
	(6, '2024-29-02 14:00:00', 7);
