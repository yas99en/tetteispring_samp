-- 13.3.2. Spring Data JPA, 13.3.3. MyBatis で使用します

-- データベース
CREATE DATABASE sample13_3;
\c sample13_3

-- テーブル
CREATE TABLE IF NOT EXISTS messages (
    id SERIAL PRIMARY KEY,
    text VARCHAR(255)
);

-- データリセット
TRUNCATE messages;
SELECT SETVAL('messages_id_seq', 1, false);

-- データ挿入
INSERT INTO messages(text) VALUES ('hello world');
INSERT INTO messages(text) VALUES ('hogehoge');
