insert into profile_image values(1L, '844b2e56483db6f6f75611e891a84e9c38c727d02655f3d211a837f0aadfa31c', 'http://djsajinkwan.com/wp-content/uploads/2015/06/%E1%84%8C%E1%85%B3%E1%86%BC%E1%84%86%E1%85%A7%E1%86%BC%E1%84%89%E1%85%A2%E1%86%B7%E1%84%91%E1%85%B3%E1%86%AF1.jpg');
insert into profile_image values(2L, 'hash1', 'https://file.mk.co.kr/meet/neds/2021/06/image_readtop_2021_530955_16225970114666915.jpg');
insert into profile_image values(5L, '이승국', 'https://www.topdaily.kr/news/photo/202102/92556_61830_012.jpg');

insert into user values(1L, '@_golden_gate_', '11',  sysdate(), '병아리감별사', '1', 1L);
insert into user values(2L, '@Majj_manuel', 'Alice@gmail.com', sysdate(), 'xaxxxx', 'a', 2L);
insert into user values(3, '@WE_T', 'Elena@gmail.com', sysdate(), 'BTS_OFFICIAL', 'a', null);
insert into user values(4,  '@Anti', 'Masuri@naver.com', sysdate(), 'Anitisitce', 'a', null);
insert into user values(5L, '@banana',  'aa', sysdate(), 'bbnannn99', 'a', 5L);

insert into follower values(1L, 2L, 1L);
insert into follower values(2L, 1L, 5L);
insert into follower values(3L, 2L, 5L);
insert into follower values(4L, 3L, 5L);
insert into follower values(5L, 4L, 5L);
--insert into follower values(6L, 5L, 5L);
--insert into follower values(7L, 1L, 1L);

insert into post values(1L, '안녕하세요 팬여러분들!! 방탄소년단의 팬앤스타 초이스 상 수상을 위해 여러분의 도움이 필요합니다.', sysdate(), 1L);
insert into post values(2L, '[에릭]', '2019-10-04', 1L);
insert into post values(3L, 'NCT 127 美 ''제임스 코든쇼'' 출연 화제! 신곡 ''Sticker'' 무대 최초 공개, 글로벌 팬열광!', '2020-02-01 13:00:00', 1L);
insert into post values(4L, '테스트 스트링입니다.', '2020-02-01 13:01:00', 2L);
insert into post values(5L, 'We ard too far away with our 50K gap goal.', sysdate(), 2L);
insert into post values(6L, 'Stream의 요소들이 특정한 조건을 충족하는지 검사하고 싶은 경우에는 match 함수를 이용할 수 있다.', sysdate(), 3L);
insert into post values(7L, '예를 들어 요소들을 출력하기를 원할 때 다.', sysdate(), 3L);
insert into post values(8L, 'Hello, there!? What is the anger means in your mind? I think it''s the thing that gives me power that makes me achieve what I want. Let''s show him I''m greater than they think I am.', sysdate(), 4L);
insert into post values(9L, '하지만 만약 1개의 Stream으로부터 갯수, 합계, 평균, 최댓값, 최솟값을 한번에 얻고 싶은 경우에는 어떻게 할 수 있을까?', sysdate(), 5L);