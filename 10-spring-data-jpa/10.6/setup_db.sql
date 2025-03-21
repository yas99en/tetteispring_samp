-- データベース
CREATE DATABASE sample10_6;

-- テーブル
CREATE TABLE IF NOT EXISTS  room (
    room_id SERIAL NOT NULL PRIMARY KEY,
    room_name VARCHAR(10),
    capacity INT,
    created_by VARCHAR(128),
    created_date TIMESTAMP,
    created_date2 TIME,
    last_modified_by VARCHAR(128),
    last_modified_date TIME
);

CREATE TABLE IF NOT EXISTS equipment (
    equipment_id INT NOT NULL PRIMARY KEY,
    room_id INT,
    equipment_name VARCHAR(30),
    equipment_count INT,
    equipment_remarks VARCHAR(100),
    foreign key (room_id) references room(room_id)
);

-- データリセット
TRUNCATE room cascade;

-- シーケンスリセット
SELECT SETVAL('room_room_id_seq', 1, false);

-- データ挿入
INSERT INTO room(room_name, capacity, created_date) VALUES ('RoomA', 10, '2024-08-09 13:23:57.118898');
INSERT INTO room(room_name, capacity, created_date) VALUES ('RoomB', 30, '2024-08-09 13:23:57.118898');
INSERT INTO room(room_name, capacity, created_date) VALUES ('RoomC', 100, '2024-08-09 13:23:57.118898');
INSERT INTO room(room_name, capacity, created_date) VALUES ('RoomD', 40, '2024-08-10 13:23:57.118898');
INSERT INTO room(room_name, capacity, created_date) VALUES ('RoomD', 40, '2024-08-11 13:23:57.118898');
INSERT INTO room(room_name, capacity, created_date) VALUES ('RoomD', 25, '2024-08-10 13:23:57.118898');
INSERT INTO room(room_name, capacity, created_date) VALUES ('RoomF', 100, '2024-08-10 13:23:57.118898');
INSERT INTO room(room_name, capacity, created_date) VALUES ('RoomG', 200, '2024-08-10 13:23:57.118898');
INSERT INTO room(room_name, capacity, created_date) VALUES ('RoomH', 300, '2024-08-10 13:23:57.118898');
INSERT INTO room(room_name, capacity, created_date) VALUES ('RoomI', 400, '2024-08-10 13:23:57.118898');
INSERT INTO equipment VALUES ('1','1', 'White Board', 1, null);
INSERT INTO equipment VALUES ('2','1', 'Desk', 1, null);
INSERT INTO equipment VALUES ('3','1', 'Chair', 10, null);
INSERT INTO equipment VALUES ('4','2', 'Computer', 5, null);
INSERT INTO equipment VALUES ('5','2', 'Monitor', 6, null);
INSERT INTO equipment VALUES ('6','3', 'Telephone', 6, null);