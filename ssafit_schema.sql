DROP DATABASE IF EXISTS ssafit;
CREATE DATABASE ssafit DEFAULT CHARACTER SET utf8mb4;
USE ssafit;
 
CREATE TABLE `user` (
    `id`    varchar(50)    NOT NULL PRIMARY KEY,
    `password`    varchar(50)    NOT NULL,
    `name`    varchar(50)    NOT NULL,
    `birth`    DATE NULL,
    `nickname` varchar(50) not NULL,
    `email`    varchar(100) not NULL
);

CREATE TABLE `video` (
    `videoId`    int    NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `viewCnt` int default 0 NOT NULL,
    `title`    varchar(120) NOT NULL,
    `fitpart`    varchar(50) NOT NULL,
    `youtuber`    varchar(50)    NOT NULL,
    `url`    varchar(300) NOT NULL,
    `regDate`    datetime default now() NULL,
	`level`	int	NOT NULL	DEFAULT 0
);

CREATE TABLE `review` (
    `reviewId`    int    NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `userId`    varchar(50)    NOT NULL,
    `videoId`    int    NOT NULL,
    `title`    varchar(50) NOT NULL,
    `content`    varchar(500) not NULL,
    `regDate` timestamp default now(),
    `viewCnt` int NOT NULL default 0,
     constraint FK_video_tbl_TO_review_tbl_1
        foreign key (videoId)
        references video (videoId)
        on delete cascade
        on update cascade,
    constraint FK_member_tbl_TO_review_tbl_1
        foreign key (userId)
        references user (id)
        on delete cascade
        on update cascade
);

CREATE TABLE `friend` (
	`friendId`	int	NOT NULL	AUTO_INCREMENT PRIMARY KEY,
	`followerId`	varchar(50)	NOT NULL,
	`followId`	varchar(50)	NOT NULL,
	constraint FK_member_tbl_TO_friend_tbl_1
        foreign key (followerId)
        references user (id)
        on delete cascade
        on update cascade,
    constraint FK_member_tbl_TO_friend_tbl_2
        foreign key (followId)
        references user (id)
        on delete cascade
        on update cascade
);

CREATE TABLE `wish` (
	`wishId`	int	NOT NULL	AUTO_INCREMENT PRIMARY KEY,
	`userId`	varchar(50)	NOT NULL,
	`videoId`	int	NOT NULL,
	`regDate`	datetime	NOT NULL	DEFAULT now(),
	constraint FK_video_tbl_TO_wish_tbl_1
        foreign key (videoId)
        references video (videoId)
        on delete cascade
        on update cascade,
    constraint FK_member_tbl_TO_wish_tbl_1
        foreign key (userId)
        references user (id)
        on delete cascade
        on update cascade
);

CREATE TABLE `comment` (
	`commentId`	int	NOT NULL	AUTO_INCREMENT PRIMARY KEY,
	`userId`	varchar(50)	NOT NULL,
	`reviewId`	int	NOT NULL,
	`content`	varchar(100)	NOT NULL,
	`regDate`	timestamp	NULL	DEFAULT now(),
constraint FK_member_tbl_TO_comment_tbl_1
        foreign key (userId)
        references user (id)
        on delete cascade
        on update cascade,
    constraint FK_review_tbl_TO_comment_tbl_1
        foreign key (reviewId)
        references review (reviewId)
        on delete cascade
        on update cascade
);
    
CREATE TABLE `levelVote` (
	`levelVoteId`	int	NOT NULL	AUTO_INCREMENT PRIMARY KEY,
	`userId`	varchar(50)	NOT NULL,
	`videoId`	int	NOT NULL,
	`level`	int	NOT NULL,
constraint FK_user_tbl_TO_levelVote_tbl_1
        foreign key (userId)
        references user (id)
        on delete cascade
        on update cascade,
constraint FK_video_tbl_TO_levelVote_tbl_1
        foreign key (videoId)
        references video (videoId)
        on delete cascade
        on update cascade
);

CREATE TABLE `community` (
	`communityId`	int	NOT NULL	AUTO_INCREMENT PRIMARY KEY,
	`userId`	varchar(50)	NOT NULL,
	`category`	varchar(20)	NOT NULL,
	`title`	varchar(50)	NOT NULL,
	`content`	varchar(500)	NOT NULL,
	`regDate`	datetime	NOT NULL	DEFAULT now(),
        `viewCnt` int not null default 0,
	constraint FK_member_tbl_TO_community_tbl_1
        foreign key (userId)
        references user (id)
        on delete cascade
        on update cascade
);

CREATE TABLE `cReview` (
	`cReviewId`	int	AUTO_INCREMENT PRIMARY KEY,
	`communityId`	int	NOT NULL,
	`userId`	varchar(50)	NOT NULL,
	`content`	varchar(500)	NOT NULL,
	`regDate`	datetime	NOT NULL	DEFAULT now(),
	constraint FK_community_tbl_TO_cReview_tbl_1
        foreign key (communityId)
        references community (communityId)
        on delete cascade
        on update cascade,
	constraint FK_user_tbl_TO_cReview_tbl_1
        foreign key (userId)
        references user (id)
        on delete cascade
        on update cascade
);

CREATE TABLE `diary` (
	`diaryId`	int	NOT NULL	AUTO_INCREMENT PRIMARY KEY,
	`userId`	varchar(50)	NOT NULL,
	`start`	datetime	NOT NULL,
	`end`	datetime	NULL,
	`title`	varchar(50)	NOT NULL,
	`content`	varchar(500)	NOT NULL,
	`allDay`	boolean	NOT NULL,
		constraint FK_user_tbl_TO_diary_tbl_1
        foreign key (userId)
        references user (id)
        on delete cascade
        on update cascade
);

CREATE TABLE `weight` (
	`weightId`	int	NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`userId`	varchar(50)	NOT NULL,
	`weight`	int	NULL,
	`regDate`	DATE	NOT NULL,
	constraint FK_user_tbl_TO_weight_tbl_1
        foreign key (userId)
        references user (id)
        on delete cascade
        on update cascade
);

commit;