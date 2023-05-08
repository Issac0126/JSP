
UPDATE my_user
SET user_pw = 'aaa1111'
WHERE user_id = 'abc1234';

CREATE TABLE my_board (
    board_id NUMBER PRIMARY KEY,
    writer VARCHAR2(30) NOT NULL,
    title VARCHAR2(100) NOT NULL,
    content VARCHAR2(2000),
    reg_date DATE DEFAULT sysdate,
    hit NUMBER DEFAULT 0
);

CREATE SEQUENCE board_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 1000
    NOCYCLE
    NOCACHE;



