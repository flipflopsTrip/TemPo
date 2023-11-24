insert into user(id, password, name, nickname, email) VALUES ("ssafy","1234","김싸피", "ssafykim", "ssafy@gmail.com");
insert into user VALUES ("hong","1234","홍길동","2001-03-03", "hongking", "hong@gmail.com");
insert into user VALUES ("happy","1234","유재석","1995-11-23", "뚜기", "youu@gmail.com");
insert into user VALUES ("user","1234","김가나","1985-11-23", "가나", "youu@gmail.com");
insert into user VALUES ("java","1234","박다라","1998-06-17", "다라", "jjava@gmail.com");

INSERT INTO `video` (`viewCnt`, `title`, `fitpart`, `youtuber`, `url`, `regDate`, `level`)
VALUES
    (0, '[운동자극]피곤하고 귀찮을때 보는 동기부여영상', '전체', 'MEN 힘센남자', 'H-AcDBLqxi4', '2017-09-24 09:57:03', 0),
    (0, '일단 보면 운동하고 싶어지는 영상 - 신나는 음악, 운동자극, 헬스장 음악', '전체', '운동 음악[Workout Music]', '9Bcp9K_1paM', '2023-05-16 08:00:10', 0),
    (0, '균형잡힌 탄탄한 상체와 멋진 자세를 위한 덤벨 상체 운동 홈트 22분', '상체', '빅씨스 Bigsis', 'U7IH4wyVMBU', '2022-03-23 08:00:08', 0),
    (0, '상체 다이어트 운동 BEST [팔뚝살/겨드랑이살/가슴어깨/등살]', '상체', 'Thankyou BUBU', 'C3TqpGgnIoI', '2017-11-13 13:58:02', 0),
    (0, '하체운동 딱&#39;3가지&#39;만 하면 허벅지 쫙쫙 갈라집니다!!! (하체 필수 운동루틴)', '하체', '헬린이 탈출을 위한 운동정보', '9_AiWMlH87U', '2023-03-03 09:00:05', 0),
    (0, '🏅요일별운동🏅 금요일 하체집중 근력운동 15분 루틴!', '하체', '힙으뜸', 'pDFuLG0xrsU', '2020-12-18 10:00:15', 0),
    (0, '거북목, 굽은 등 해결! 하루 5분 교정 운동', '교정', '피지오스튜디오 PHYSIOSTUDIO', 'aDbqk7JbpEs', '2022-01-26 08:00:00', 0),
    (0, '[ENG] 운동 전 최고의 스트레칭! 10분만 따라해도 운동효과 대박!', '스트레칭', '힙으뜸', 'yyjOhsNEqtE', '2019-03-12 10:39:48', 0),
    (0, '오늘부터 이거 들으면서 10kg 뺀다🎵 운동할때 듣는 음악, 운동자극', '전체', '운동 음악[Workout Music]', 'D9_hVxuhl7Q', '2023-06-15 08:00:04', 0),
    (0, '운동할 시간이 없다는 사람에게 보여주세요... 제발', '전체', '김종국 GYM JONG KOOK', 'Hx8Lc_0hUaI', '2021-11-04 09:00:09', 0),
    (0, '상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]', '상체', 'Thankyou BUBU', '54tTYO-vU2E', '2019-11-10 08:50:45', 0),
    (0, '전세계 3위와 하체 운동.avi', '하체', 'Allright24_박재훈', 'tC50_pRR2Y8', '2023-11-22 13:16:16', 0),
    (0, '[ENG] 딱 20분🔥 하루 운동 끝장내는 전신 &amp; 아랫배 &amp; 타바타 올인원 루틴', '전신', '힙으뜸', 'zruKSHfD7b4', '2023-05-09 10:15:02', 0);

INSERT INTO `review` (`userId`, `videoId`, `title`, `content`, `regDate`)
VALUES
    ('ssafy', 1, '좋은 운동 영상', '이 운동 영상 정말 좋았어요. 강사님은 동기부여가 되고, 운동도 효과적이었습니다.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('hong', 1, '최곱니다', '시간이 부족하다면? 이 영상이 딱입니다. 짧은 운동이지만 달성감을 느낄 수 있어요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('ssafy', 2, '좋은 유산소 세션', '이 영상의 유산소 세션이 놀라워요! 땀을 많이 흘리고 운동 후에 에너지를 느꼈습니다.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('user', 1, '초보자를 위한 루틴', '초보자에게 딱입니다! 강사님은 명확한 지침을 제공하여 따라가기 쉽습니다.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('hong', 2, '도전적이지만 재미있는 운동', '이 운동은 도전적이었지만 정말 재미있었습니다. 운동의 다양성이 흥미로웠어요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('happy', 2, '빠르고 효과적인 운동', '시간이 부족하다면? 이 영상이 딱입니다. 짧은 운동이지만 달성감을 느낄 수 있어요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('happy', 3, '좋아하는 운동 영상', '많은 운동 영상을 시도해봤는데, 이게 내 최고의 영상입니다. 음악, 동작—모두 훌륭해요!', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('user', 4, '칼로리 소모하는 HIIT', '칼로리를 많이 태우고 싶다면 여기를 보세요. 이 HIIT 영상은 강렬하지만 가치가 있어요!', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00'));

INSERT INTO `review` (`userId`, `videoId`, `title`, `content`, `regDate`)
VALUES
    ('java', 1, '좋은 운동 영상', '이 운동 영상 정말 좋았어요. 강사님은 동기부여가 되고, 운동도 효과적이었습니다.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('user', 1, '힘들지만 좋아요', '운동은 힘들지만 이 음악이 함께라면 할 수 있어요. 정말 좋은 선택이었습니다.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('user', 2, '상체 운동 홈트 최고!', '이 영상은 상체에 집중하는데 정말 효과적이에요. 22분이라는 짧은 시간에 효과를 볼 수 있어 좋아요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('java', 2, '다양한 운동이 있어 좋아요', '이 채널은 다양한 상체 운동을 소개하고 있어서 매번 새로운 운동을 시도할 수 있어 좋아요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('happy', 1, '하체 운동 루틴 강추!', '허벅지를 갈라지게 하는데 정말 효과적인 루틴이에요. 매일 꾸준히 하고 있습니다.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('java', 1, '금요일 하체운동 최고', '금요일에 이 루틴을 따라하면 주말에 기분 좋게 시작할 수 있어 좋아요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('happy', 2, '5분 교정 운동 좋아요', '이 영상 덕분에 자세 교정에 도움이 되고 있어서 매일 하고 있어요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('happy', 3, '스트레칭이 필수죠!', '이 스트레칭 영상은 정말 효과적이에요. 운동 전에 꼭 따라하고 있습니다.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('happy', 4, '음악이 운동을 더 즐겁게', '이 음악은 정말 운동을 더 즐겁게 만들어줍니다. 추천합니다!', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('user', 4, '시간이 없어도 가능한 운동', '이 영상은 짧은 시간에도 효과적인 운동이 가능해서 시간이 없는 사람에게 딱이에요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('user', 4, '김종국의 운동은 최고', '김종국 강사님의 운동 영상은 항상 힘이 나서 좋아요. 매일 꾸준히 따라하고 있습니다.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('user', 5, '상체 다이어트 운동 최고', 'Thankyou BUBU 채널의 상체 다이어트 운동은 정말 최고에요. 강추합니다!', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('user', 5, '하체 운동 대박!', 'Allright24 박재훈 강사님의 하체 운동 영상은 정말 대박이에요. 매우 만족합니다.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00'));

INSERT INTO `review` (`userId`, `videoId`, `title`, `content`, `regDate`)
VALUES
    ('java', 6, '좋은 운동 영상', '이 운동 영상 정말 좋았어요. 강사님은 동기부여가 되고, 운동도 효과적이었습니다.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('user', 6, '힘들지만 좋아요', '운동은 힘들지만 이 음악이 함께라면 할 수 있어요. 정말 좋은 선택이었습니다.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('user', 6, '상체 운동 홈트 최고!', '이 영상은 상체에 집중하는데 정말 효과적이에요. 22분이라는 짧은 시간에 효과를 볼 수 있어 좋아요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('java', 7, '다양한 운동이 있어 좋아요', '이 채널은 다양한 상체 운동을 소개하고 있어서 매번 새로운 운동을 시도할 수 있어 좋아요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('happy', 8, '하체 운동 루틴 강추!', '허벅지를 갈라지게 하는데 정말 효과적인 루틴이에요. 매일 꾸준히 하고 있습니다.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('java', 8, '금요일 하체운동 최고', '금요일에 이 루틴을 따라하면 주말에 기분 좋게 시작할 수 있어 좋아요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('happy', 9, '5분 교정 운동 좋아요', '이 영상 덕분에 자세 교정에 도움이 되고 있어서 매일 하고 있어요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('happy', 9, '스트레칭이 필수죠!', '이 스트레칭 영상은 정말 효과적이에요. 운동 전에 꼭 따라하고 있습니다.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('happy', 9, '음악이 운동을 더 즐겁게', '이 음악은 정말 운동을 더 즐겁게 만들어줍니다. 추천합니다!', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00')),
    ('user', 9, '시간이 없어도 가능한 운동', '이 영상은 짧은 시간에도 효과적인 운동이 가능해서 시간이 없는 사람에게 딱이에요.', TIMESTAMPADD(SECOND, FLOOR(RAND() * 1728000) + 1604198400, '1970-01-01 00:00:00'));

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
    ('ssafy', 6, '운동이 취미가 되다니 멋져요!'),
    ('hong', 6, '이 영상은 정말 재미있어서 계속 하게 돼요.');

-- UPDATE `video`
-- SET `level` = FLOOR(RAND() * 5) + 1;

-- update `video`
-- set `level` = 1
-- where videoId = 3;

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

INSERT INTO `cReview` (`communityId`, `userId`, `content`, `regDate`)
VALUES
    (1, 'happy', '오늘은 하체 운동을 했는데 정말 기분이 좋아졌어요!', NOW()),
    (1, 'hong', '이번 주에는 상체 운동에 도전했는데 힘들었지만 뿌듯해요.', NOW()),
    (1, 'user', '운동은 꾸준함이 중요하다고 생각해요. 매일 조금씩이라도 하려고 노력 중입니다.', NOW()),
    (2, 'happy', '금요일에 하체집중 루틴을 따라하고 기분이 최고에요!', NOW()),
    (2, 'hong', '스트레칭을 하면 몸이 가볍고 상쾌해져서 좋아요.', NOW());

insert into levelVote(userId, videoId, level) 
values 
	('happy', 1, 5),
    ('happy', 2, 2),
    ('happy', 3, 4);

select weightId, userId, weight, DATE_FORMAT(regDate, '%y.%m.%d') as regDate from weight where userId = 'hong';

select * from weight where userId = 'hong' and regDate = '2023-11-01';

SELECT ROUND(AVG(level)) AS average_level
FROM levelVote
WHERE videoId = 11
GROUP BY videoId
HAVING COUNT(*) >= 1;

select * from levelVote;
select * from user;
select * from video;
select * from weight;
select * from community;