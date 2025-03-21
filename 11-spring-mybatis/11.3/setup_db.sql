-- データベース（sample11が存在しない場合のみ実行）
CREATE DATABASE sample11;

-- Postgresでget_random_uuid関数を使用するための設定
CREATE EXTENSION pgcrypto;

-- テーブル
CREATE TABLE IF NOT EXISTS meeting_room (
    room_id VARCHAR(50) NOT NULL PRIMARY KEY,
    room_name VARCHAR(10),
    capacity INT
);
INSERT INTO meeting_room VALUES ('1','RoomA', 10);
INSERT INTO meeting_room VALUES ('2','RoomB', 30);
INSERT INTO meeting_room VALUES ('3','RoomC', 100);


-- ID列の自動採番確認用(11.3.6のみ実行)
CREATE TABLE IF NOT EXISTS meeting_room_2 (
    room_id SERIAL NOT NULL PRIMARY KEY,
    room_name VARCHAR(10),
    capacity INT
);
INSERT INTO meeting_room_2(room_name, capacity) VALUES ('RoomA', 10);
INSERT INTO meeting_room_2(room_name, capacity) VALUES ('RoomB', 30);
INSERT INTO meeting_room_2(room_name, capacity) VALUES ('RoomC', 100);