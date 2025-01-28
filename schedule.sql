CREATE TABLE schedule (
                           schedule_id BIGINT AUTO_INCREMENT PRIMARY KEY,     -- Schedule ID, 자동으로 증가하는 기본 키
                           user_id BIGINT AUTO_INCREMENT NOT NULL,      -- 자동으로 증가하는 키,
                           todo VARCHAR NOT NULL,         -- 할 일, NULL을 허용하지 않음
                           password VARCHAR NOT NULL,          -- 비밀번호, NULL을 허용하지 않음
                           inti_date TIMESTAMP,                      -- 작성일
                           mod_date TIMESTAMP                -- 입사일
);

Show table;