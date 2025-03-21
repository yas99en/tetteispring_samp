-- データベース
CREATE DATABASE sample3_4;

-- テーブル
CREATE TABLE IF NOT EXISTS room (
    room_id VARCHAR(10) NOT NULL PRIMARY KEY,
    room_name VARCHAR(10),
    capacity INT
);

-- データリセット
TRUNCATE room cascade;

-- データ挿入
INSERT INTO room VALUES ('ExistId','ExistRoom', 200);
