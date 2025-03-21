-- データベース
CREATE DATABASE sample10_4;

-- テーブル
CREATE TABLE IF NOT EXISTS room (
    room_id SERIAL NOT NULL PRIMARY KEY,
    room_name VARCHAR(10),
    capacity INT,
    version INT
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
INSERT INTO room(room_name, capacity, version) VALUES ('RoomA', 10, 1);
INSERT INTO room(room_name, capacity, version) VALUES ('RoomB', 30, 1);
INSERT INTO room(room_name, capacity, version) VALUES ('RoomC', 100, 1);
INSERT INTO equipment VALUES ('1','1', 'White Board', 1, null);
INSERT INTO equipment VALUES ('2','1', 'Desk', 1, null);
INSERT INTO equipment VALUES ('3','1', 'Chair', 10, null);
INSERT INTO equipment VALUES ('4','2', 'Computer', 5, null);
INSERT INTO equipment VALUES ('5','2', 'Monitor', 6, null);
INSERT INTO equipment VALUES ('6','3', 'Telephone', 6, null);