-- データベース
CREATE DATABASE sample9_6;
\c sample9_6

-- ロール
CREATE TABLE roles(
  id INTEGER PRIMARY KEY,   -- ロールのID
  name VARCHAR(32) NOT NULL  -- ロールの名前 
);

-- ユーザー 
CREATE TABLE login_user( 
  id VARCHAR(128) NOT NULL PRIMARY KEY, -- ユーザーID
  name VARCHAR(128) NOT NULL, -- ユーザー名
  password VARCHAR(128) NOT NULL -- ハッシュ化済みのパスワード 
);

-- 権限管理
CREATE TABLE user_role( 
  user_id VARCHAR(128) NOT NULL, -- ユーザー名 (ユーザーID)
  role_id INTEGER, -- ロールのID 
  CONSTRAINT pk_user_role PRIMARY KEY (user_id, role_id), 
  CONSTRAINT fk_user_role_user_id FOREIGN KEY (user_id) REFERENCES login_user(id), 
  CONSTRAINT fk_user_role_role_id FOREIGN KEY (role_id) REFERENCES roles(id) 
);



INSERT INTO roles(id, name) VALUES(1, 'ROLE_GENERAL'); 
INSERT INTO roles(id, name) VALUES(2, 'ROLE_ADMIN'); 

-- password = "general" 
INSERT INTO login_user(id, name, password) VALUES('general', '一般ユーザー','$2a$10$6fPXYK.C9rCWUBifuqBIB.GRNU.nQtBpdzkkKis8ETaKVKxNo/ltO'); 
-- password = "admin" 
INSERT INTO login_user(id, name, password) VALUES('admin', '管理者ユーザー','$2a$10$SJTWvNl16fCU7DaXtWC0DeN/A8IOakpCkWWNZ/FKRV2CHvWElQwMS'); 

INSERT INTO user_role(user_id, role_id) VALUES('general', 1); 
INSERT INTO user_role(user_id, role_id) VALUES('admin', 1); 
INSERT INTO user_role(user_id, role_id) VALUES('admin', 2);
