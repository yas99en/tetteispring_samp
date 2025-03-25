CREATE DATABASE sample3_2;
\c sample3_2

CREATE TABLE usr (
    user_id VARCHAR(10) NOT NULL PRIMARY KEY,
    user_name VARCHAR(30) NOT NULL
);
CREATE TABLE room (
    room_id VARCHAR(10) NOT NULL PRIMARY KEY,
    room_name VARCHAR(30) NOT NULL,
    capacity INT NOT NULL
);
CREATE TABLE equipment (
    equipment_id VARCHAR(10) NOT NULL PRIMARY KEY,
    room_id VARCHAR(10) NOT NULL,
    equipment_name VARCHAR(30) NOT NULL,
    equipment_count INT NOT NULL,
    equipment_remarks VARCHAR(100),
    foreign key (room_id) references room(room_id)
);

TRUNCATE equipment;
TRUNCATE room cascade;
TRUNCATE usr;

INSERT INTO usr VALUES ('U0001','taro yamada');

INSERT INTO room VALUES ('A001','幹部用会議室', 10);
INSERT INTO room VALUES ('C001001','セミナールーム', 30);
INSERT INTO room VALUES ('X9999','カンファレンスルーム', 100);

INSERT INTO equipment VALUES ('10-1','A001', 'テレビ会議システム', 1, null);
INSERT INTO equipment VALUES ('20-1','A001', 'プロジェクタ', 1, '部屋据え付けです');
INSERT INTO equipment VALUES ('40-500','C001001', 'シンクライアント', 10, null);
INSERT INTO equipment VALUES ('20-2','C001001', 'プロジェクタ', 5, '移動可能です');
INSERT INTO equipment VALUES ('30-1','C001001', 'ホワイトボード', 6, '移動可能です');
