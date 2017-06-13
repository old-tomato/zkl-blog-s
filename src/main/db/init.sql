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

CREATE TABLE IF NOT EXISTS file_info(
  id int unsigned NOT NULL AUTO_INCREMENT,
  uid int unsigned NOT NULL,
  file_name VARCHAR(32) NOT NULL ,
  file_desc VARCHAR(32) ,
  content LONGTEXT,
  create_time DATETIME NOT NULL,
  update_time DATETIME NOT NULL,
  PRIMARY KEY (id)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS ip_address_log(
  id int unsigned NOT NULL AUTO_INCREMENT,
  ip VARCHAR(64) NOT NULL,
  create_time DATETIME NOT NULL,
  PRIMARY KEY (id)
)ENGINE=InnoDB;

# 初始化队列
INSERT uid_queue VALUE (100000);