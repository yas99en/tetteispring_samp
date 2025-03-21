-- 8.3.1. テスト用のデータソースの設定 classpath:schema.sqlの定義例
DROP TABLE IF EXISTS account;

CREATE TABLE account (
	id CHAR(3) PRIMARY KEY,
	name VARCHAR(128)
);