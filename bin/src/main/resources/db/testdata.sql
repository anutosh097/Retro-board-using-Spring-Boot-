DROP TABLE IF EXISTS rb_comment CASCADE;
DROP TABLE IF EXISTS rb_user CASCADE;

DROP SEQUENCE IF EXISTS hibernate_sequence;
CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE rb_comment (
    id bigint NOT NULL,
    comment VARCHAR(255),
    created_by VARCHAR(255),
    created_date TIMESTAMP,
    type VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE rb_user (
     id bigint NOT NULL,
     password VARCHAR(255),
     role VARCHAR(255),
     username VARCHAR(255),
     PRIMARY KEY (id)
);

INSERT INTO rb_user (id, username, password, role) VALUES (1, 'Anutosh123', 'XXXXXX', 'USER');
INSERT INTO rb_user (id, username, password, role) VALUES (2, 'Anutosh122', 'XXXXXX2', 'USER2');