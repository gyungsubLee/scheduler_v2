-- 유저
CREATE TABLE User (
                      Id INT AUTO_INCREMENT PRIMARY KEY,      -- 유저의 고유 ID, 자동 증가
                      Username VARCHAR(50) NOT NULL,          -- 유저명, 최대 50자
                      Email VARCHAR(100) NOT NULL UNIQUE,     -- 이메일, 최대 100자, 중복 불가
                      Password VARCHAR(255) NOT NULL,         -- 비밀번호, 해시된 값 저장
                      CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 작성일, 기본값은 현재 시간
                      UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  -- 수정일, 업데이트 시 자동 갱신
);



-- 일정
CREATE TABLE Schedule (
                          Id INT AUTO_INCREMENT PRIMARY KEY,               -- 일정의 고유 ID, 자동 증가
                          UserId INT NOT NULL,                             -- 유저 ID, 외래 키로 설정
                          Title VARCHAR(100) NOT NULL,                     -- 할일 제목, 최대 100자
                          Description TEXT,                                -- 할일 내용, 길이에 제한이 없는 텍스트
                          CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,   -- 작성일, 기본값은 현재 시간
                          UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  -- 수정일, 업데이트 시 자동 갱신
                          FOREIGN KEY (UserId) REFERENCES User(Id)         -- User 테이블의 Id를 참조하는 외래 키
);



-- 댓글
CREATE TABLE Comment (
                         Id INT AUTO_INCREMENT PRIMARY KEY,               -- 댓글의 고유 ID, 자동 증가
                         UserId INT NOT NULL,                             -- 유저 ID, 외래 키로 설정
                         ScheduleId INT NOT NULL,                         -- 일정 ID, 외래 키로 설정
                         Content TEXT NOT NULL,                           -- 댓글 내용, 길이에 제한이 없는 텍스트
                         CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,   -- 작성일, 기본값은 현재 시간
                         UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  -- 수정일, 업데이트 시 자동 갱신
                         FOREIGN KEY (UserId) REFERENCES User(Id),        -- User 테이블의 Id를 참조하는 외래 키
                         FOREIGN KEY (ScheduleId) REFERENCES Schedule(Id) -- Schedule 테이블의 Id를 참조하는 외래 키
);