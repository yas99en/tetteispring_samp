-- データベース（sample11_4が存在しない場合のみ実行）
CREATE DATABASE sample11_4;
\c sample11_4

-- テーブル
CREATE TABLE IF NOT EXISTS meeting_room (
    room_id VARCHAR(10) NOT NULL PRIMARY KEY,
    room_name VARCHAR(20),
    capacity INT
);
CREATE TABLE IF NOT EXISTS reservable_room (
  reserved_date DATE NOT NULL,
  room_id VARCHAR(10) NOT NULL,
  PRIMARY KEY (reserved_date, room_id)
);
CREATE TABLE IF NOT EXISTS usr (
  user_id VARCHAR(10) NOT NULL,
  first_name VARCHAR(20) NOT NULL,
  last_name VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  role_name VARCHAR(10) NOT NULL,
  PRIMARY KEY (user_id)
);
CREATE TABLE IF NOT EXISTS reservation (
  reservation_id VARCHAR(10) NOT NULL,
  end_time       TIME NOT NULL,
  start_time     TIME NOT NULL,
  reserved_date  DATE NOT NULL,
  room_id        VARCHAR(10) NOT NULL,
  user_id        VARCHAR(10) NOT NULL,
  PRIMARY KEY (reservation_id)
);

-- データリセット
TRUNCATE meeting_room CASCADE;
TRUNCATE reservable_room CASCADE;
TRUNCATE usr CASCADE;
TRUNCATE reservation CASCADE;

ALTER TABLE reservable_room DROP CONSTRAINT IF EXISTS FK_f4wnx2qj0d59s9tl1q5800fw7;
ALTER TABLE reservation DROP CONSTRAINT IF EXISTS FK_p1k4iriqd4eo1cpnv79uvni9g;
ALTER TABLE reservation DROP CONSTRAINT IF EXISTS FK_recqnfjcp370rygd9hjjxjtg;
ALTER TABLE reservable_room ADD CONSTRAINT FK_f4wnx2qj0d59s9tl1q5800fw7 FOREIGN KEY (room_id) REFERENCES meeting_room;
ALTER TABLE reservation ADD CONSTRAINT FK_p1k4iriqd4eo1cpnv79uvni9g FOREIGN KEY (reserved_date, room_id) REFERENCES reservable_room;
ALTER TABLE reservation ADD CONSTRAINT FK_recqnfjcp370rygd9hjjxjtg FOREIGN KEY (user_id) REFERENCES usr;

-- データ挿入
INSERT INTO meeting_room VALUES ('1','RoomA', 10);
INSERT INTO meeting_room VALUES ('2','RoomA_2', 20);
INSERT INTO meeting_room VALUES ('3','RoomA_3', 30);
INSERT INTO meeting_room VALUES ('4','RoomB', 40);
INSERT INTO meeting_room VALUES ('5','RoomB_2', 50);
INSERT INTO meeting_room VALUES ('6','RoomB_3', 60);
INSERT INTO meeting_room VALUES ('7','RoomB_4', 70);
INSERT INTO meeting_room VALUES ('8','RoomC', 80);
INSERT INTO meeting_room VALUES ('9','RoomC_2', 90);
INSERT INTO meeting_room VALUES ('10','RoomC_3', 100);
INSERT INTO meeting_room VALUES ('11','RoomD', 110);
INSERT INTO meeting_room VALUES ('12','RoomD_1', 120);
INSERT INTO meeting_room VALUES ('13','RoomD_2', 130);

INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, '1');
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE + 1, '2');
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE - 1, '3');
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE + 2, '1');
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE + 2, '2');
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE + 2, '3');

INSERT INTO usr VALUES ('1','山田','太郎','pass', 'USER');
INSERT INTO usr VALUES ('2','山田','花子','pass', 'USER');
INSERT INTO usr VALUES ('3','田中','一郎','pass', 'USER');
INSERT INTO reservation VALUES ('1',CURRENT_TIME,CURRENT_TIME,CURRENT_DATE,'1','1');
INSERT INTO reservation VALUES ('2',CURRENT_TIME,CURRENT_TIME,CURRENT_DATE + 1,'2','2');
INSERT INTO reservation VALUES ('3',CURRENT_TIME,CURRENT_TIME,CURRENT_DATE - 1,'3','3');
INSERT INTO reservation VALUES ('4',CURRENT_TIME,CURRENT_TIME,CURRENT_DATE + 2,'1','1');
INSERT INTO reservation VALUES ('5',CURRENT_TIME,CURRENT_TIME,CURRENT_DATE + 2,'2','2');
INSERT INTO reservation VALUES ('6',CURRENT_TIME,CURRENT_TIME,CURRENT_DATE + 2,'3','3');
