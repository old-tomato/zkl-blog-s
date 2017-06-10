CREATE TABLE IF NOT EXISTS user_info (
  id int unsigned NOT NULL AUTO_INCREMENT,
  uid int unsigned NOT NULL,
  username VARCHAR(16) NOT NULL ,
  password VARCHAR(128) NOT NULL ,
  mail_address VARCHAR(128) NOT NULL,
  create_time DATETIME NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY (uid),
  UNIQUE KEY (username)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS user_cookie(
  uid INT UNSIGNED NOT NULL ,
  cookie VARCHAR(128) NOT NULL,
  create_time DATETIME NOT NULL,
  available_time DATETIME NOT NULL,
  KEY (cookie)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS uid_queue(
  uid_queue INT UNSIGNED NOT NULL DEFAULT 1
)ENGINE=InnoDB;

# 初始化队列
INSERT uid_queue VALUE (100000);