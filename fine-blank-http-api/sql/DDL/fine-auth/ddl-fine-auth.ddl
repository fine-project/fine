-- -----------------------------------------------------
-- account
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS account (
  account_id INTEGER NOT NULL,
  user_id VARCHAR(15) NOT NULL,
  first_name VARCHAR(15) NOT NULL,
  last_name VARCHAR(15) NOT NULL,
  mail_address VARCHAR(254) NOT NULL,
  password VARCHAR(100) NOT NULL,
  login_failure_count INT NOT NULL,
  last_login_failure_date_time TIMESTAMP(0) NULL,
  is_locked VARCHAR(1) NOT NULL,
  last_login_date_time TIMESTAMP(0) NULL,
  created_user_date_time TIMESTAMP(0) NOT NULL,
  created_user_id VARCHAR(15) NOT NULL,
  updated_user_date_time TIMESTAMP(0) NULL,
  updated_user_id VARCHAR(15) NULL,
  PRIMARY KEY (account_id))
;


-- -----------------------------------------------------
-- account_role
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS account_role (
  account_id INTEGER NOT NULL,
  role_id INTEGER NOT NULL,
  created_user_date_time TIMESTAMP(0) NOT NULL,
  created_user_id VARCHAR(15) NOT NULL,
  updated_user_date_time TIMESTAMP(0) NULL,
  updated_user_id VARCHAR(15) NULL,
  PRIMARY KEY (account_id, role_id)
);


-- -----------------------------------------------------
-- role
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS role (
  role_id INT NOT NULL,
  role_code VARCHAR(15) NOT NULL,
  role_name VARCHAR(45) NOT NULL,
  created_user_date_time TIMESTAMP(0) NOT NULL,
  created_user_id VARCHAR(15) NOT NULL,
  updated_user_date_time TIMESTAMP(0) NULL,
  updated_user_id VARCHAR(15) NULL,
  PRIMARY KEY (role_id)
);

-- -----------------------------------------------------
-- role_permission
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS role_permission (
  role_id INT NOT NULL,
  permission VARCHAR(15) NOT NULL,
  created_user_date_time TIMESTAMP(0) NOT NULL,
  created_user_id VARCHAR(15) NOT NULL,
  updated_user_date_time TIMESTAMP(0) NULL,
  updated_user_id VARCHAR(15) NULL,
  PRIMARY KEY (role_id, permission)
);


-- -----------------------------------------------------
-- user_session
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS user_session (
  access_token VARCHAR(64) NOT NULL,
  account_id INT NOT NULL,
--  user_group VARCHAR(45) NULL,
--  role_id VARCHAR(10) NULL,
--  permission(10) NULL,
-- staff_type VARCHAR(45) NULL,
-- admin_role VARCHAR(3) NULL,
  created_user_date_time TIMESTAMP(0) NOT NULL,
  created_user_id VARCHAR(15) NOT NULL,
  updated_user_date_time TIMESTAMP(0) NULL,
  updated_user_id VARCHAR(15) NULL,
  PRIMARY KEY (access_token)
);


