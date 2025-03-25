-- データベース（sample10_5が存在しない場合のみ実行）
CREATE DATABASE sample10_5;
\c sample10_5

-- テーブル
CREATE TABLE IF NOT EXISTS room (
    room_id INT NOT NULL PRIMARY KEY,
    room_name VARCHAR(10),
    capacity INT
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

-- データ挿入
INSERT INTO room VALUES ('1','RoomA', 10);
INSERT INTO room VALUES ('2','RoomB', 30);
INSERT INTO room VALUES ('3','RoomC', 100);
INSERT INTO equipment VALUES ('1','1', 'White Board', 1, null);
INSERT INTO equipment VALUES ('2','1', 'Desk', 1, null);
INSERT INTO equipment VALUES ('3','1', 'Chair', 10, null);
INSERT INTO equipment VALUES ('4','2', 'Computer', 5, null);
INSERT INTO equipment VALUES ('5','2', 'Monitor', 6, null);
INSERT INTO equipment VALUES ('6','3', 'Telephone', 6, null);
