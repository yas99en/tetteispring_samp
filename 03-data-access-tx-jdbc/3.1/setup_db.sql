-- データベース
CREATE DATABASE sample3_1;

-- テーブル
CREATE TABLE IF NOT EXISTS room (
    room_id VARCHAR(5) NOT NULL PRIMARY KEY,
    room_name VARCHAR(10),
    capacity INT
);

-- データリセット
TRUNCATE room cascade;

-- データ挿入
INSERT INTO room VALUES ('1','RoomA', 10);
INSERT INTO room VALUES ('2','RoomB', 30);
INSERT INTO room VALUES ('3','RoomC', 100);
