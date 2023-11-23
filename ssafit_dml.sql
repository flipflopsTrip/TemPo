insert into user(id, password, name, nickname, email) VALUES ("ssafy","1234","김싸피", "ssafykim", "ssafy@gmail.com");
insert into user VALUES ("hong","1234","홍길동","2001-03-03", "hongking", "hong@gmail.com");
insert into user VALUES ("happy","1234","유재석","1995-11-23", "뚜기", "youu@gmail.com");
insert into user VALUES ("user","1234","김가나","1985-11-23", "가나", "youu@gmail.com");
insert into user VALUES ("java","1234","박다라","1998-06-17", "다라", "jjava@gmail.com");
 
-- video는 클릭해서

INSERT INTO `review` (`userId`, videoId, `title`, `content`, `regDate`)
VALUES
    ('ssafy', 1, '좋은 운동 영상', '이 운동 영상 정말 좋았어요. 강사님은 동기부여가 되고, 운동도 효과적이었습니다.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('hong', 1, '최곱니다', '시간이 부족하다면? 이 영상이 딱입니다. 짧은 운동이지만 달성감을 느낄 수 있어요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('ssafy', 2, '좋은 유산소 세션', '이 영상의 유산소 세션이 놀라워요! 땀을 많이 흘리고 운동 후에 에너지를 느꼈습니다.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('user', 1, '초보자를 위한 루틴', '초보자에게 딱입니다! 강사님은 명확한 지침을 제공하여 따라가기 쉽습니다.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('hong', 2, '도전적이지만 재미있는 운동', '이 운동은 도전적이었지만 정말 재미있었습니다. 운동의 다양성이 흥미로웠어요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('happy', 2, '빠르고 효과적인 운동', '시간이 부족하다면? 이 영상이 딱입니다. 짧은 운동이지만 달성감을 느낄 수 있어요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('happy', 3, '좋아하는 운동 영상', '많은 운동 영상을 시도해봤는데, 이게 내 최고의 영상입니다. 음악, 동작—모두 훌륭해요!', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('user', 4, '칼로리 소모하는 HIIT', '칼로리를 많이 태우고 싶다면 여기를 보세요. 이 HIIT 영상은 강렬하지만 가치가 있어요!', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00'));

INSERT INTO `comment` (`userId`, `reviewId`, `content`)
VALUES
    ('ssafy', 2, '그렇죠! 이 영상 진짜 좋아요.'),
    ('hong', 1, '운동 시작하려면 이 영상이 딱이에요.'),
    ('user', 1, '맞아요! 저도 초보자인데 쉽게 따라갈 수 있어요.'),
    ('happy', 4, '힘들었지만 완주감이 있어 좋았어요.'),
    ('ssafy', 5, '시간이 부족한 날엔 이 영상이 정말 편해요.'),
    ('hong', 3, '음악이 운동에 힘이 됩니다.'),
    ('user', 3, '나도 매일 하고 있어요! 효과가 좋아요.'),
    ('happy', 5, '다음 영상도 기대돼요!'),
    ('ssafy', 9, '운동이 취미가 되다니 멋져요!'),
    ('hong', 10, '이 영상은 정말 재미있어서 계속 하게 돼요.');

UPDATE `video`
SET `level` = FLOOR(RAND() * 5) + 1;

update `video`
set `level` = 0
where videoId = 8;

insert into weight(userId, weight, regDate) 
	values ("hong",54,"2023-11-01"),
			("hong",60,"2023-11-02"),
			("hong",63,"2023-11-03"),
			("hong",59,"2023-11-04"),
            ("hong",56,"2023-11-05");

INSERT INTO `community` (`userId`, `title`, `content`, `regDate`, `category`)
VALUES
    ('ssafy', '운동 추천 좀 해주세요!', '요즘 어떤 운동이 유행이에요? 추천 좀 부탁드려요!', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00'), 'Q&A'),
    ('hong', '운동 중에 듣기 좋은 노래 추천해주세요!', '운동 중에 듣기 좋은 노래가 뭐가 있을까요? 음악 추천 부탁드려요!', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00'), '잡담'),
    ('happy', '식단 관련 정보 공유', '건강한 식단에 대한 정보를 공유해봐요! 여러분의 식단 관리법을 알려주세요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00'), '정보'),
    ('user', '제 헬스클럽 소개합니다!', '제가 다니는 헬스클럽에서 새로운 프로그램이 나왔어요. 함께 참여하실 분 계신가요?', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00'), '홍보'),
    ('ssafy', '운동 중 다친 곳 있어요', '운동 중에 다친 곳이 있어서 고민 중입니다. 조언 부탁드려요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00'), 'Q&A'),
    ('hong', '오늘의 운동 일지', '오늘은 어떤 운동을 했는지 공유해봐요! 같이 운동한 소감도 함께 듣고 싶어요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00'), '잡담'),
    ('happy', '운동 장비 사용법 문의', '특정 운동 장비의 사용법을 잘 몰라서 질문 드립니다. 도와주세요!', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00'), 'Q&A'),
    ('user', '운동 관련 이벤트 소식', '오늘은 운동 관련 이벤트 소식을 알려드릴게요. 함께 참여하실 분 계신가요?', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00'), '홍보'),
    ('ssafy', '다이어트 팁 공유', '다이어트 중인데 효과적인 팁이 있다면 나누어 주세요! 같이 건강하게 다이어트 하자구요!', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00'), '정보'),
    ('hong', '운동 후기', '최근에 시도한 운동 프로그램이나 운동기구에 대한 후기를 듣고 싶어요. 솔직한 후기 부탁드려요!', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00'), '잡담');



select weightId, userId, weight, DATE_FORMAT(regDate, '%y.%m.%d') as regDate from weight where userId = 'hong';

select * from weight where userId = 'hong' and regDate = '2023-11-01';

SELECT ROUND(AVG(level)) AS average_level
FROM levelVote
WHERE videoId = 3
GROUP BY videoId
HAVING COUNT(*) >= 1;

select * from levelVote;
select * from user;
select * from video;
select * from weight;
select * from community;