CREATE TABLE IF NOT EXISTS tweets
(
  id bigserial NOT NULL ,
  user_name character varying(20) NOT NULL,
  tweet TEXT NULL DEFAULT NULL,
  PRIMARY KEY (id)
);