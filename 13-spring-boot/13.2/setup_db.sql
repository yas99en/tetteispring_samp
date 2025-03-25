-- データベース（sample13が存在しない場合のみ実行）
CREATE DATABASE sample13;
\c sample13

-- テーブル
CREATE TABLE IF NOT EXISTS messages (
    id SERIAL PRIMARY KEY,
    text VARCHAR(255)
);

-- データリセット
TRUNCATE messages;

-- データ挿入
INSERT INTO messages(text) VALUES ('hello world');
INSERT INTO messages(text) VALUES ('hogehoge');
