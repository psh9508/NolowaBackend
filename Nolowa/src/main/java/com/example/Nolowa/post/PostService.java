package com.example.Nolowa.post;

import com.example.Nolowa.dataModels.Post;
import com.example.Nolowa.dataModels.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostService {

    private static List<Post> posts = new ArrayList<>();

    static {
        posts.add(new Post(1L, "병아리감별사", "@_golden_gate_", "안녕하세요 팬여러분들!! 방탄소년단의 팬앤스타 초이스 상 수상을 위해 여러분의 도움이 필요합니다.", LocalDateTime.of(2021, 9, 21, 15, 23, 32)));
        posts.add(new Post(1L, "병아리감별사", "@_golden_gate_", "[에릭]", LocalDateTime.of(2018, 12, 11, 16, 23, 32)));
        posts.add(new Post(1L, "병아리감별사", "@_golden_gate_", "NCT 127 美 '제임스 코든쇼' 출연 화제! 신곡 'Sticker' 무대 최초 공개, 글로벌 팬열광!", LocalDateTime.now()));
        posts.add(new Post(2L, "xaxxxx", "@Majj_manuel", "테스트 스트링입니다.", LocalDateTime.of(2017, 12, 11, 15, 23, 32)));
        posts.add(new Post(2L, "xaxxxx", "@Majj_manuel",  "We ard too far away with our 50K gap goal.", LocalDateTime.of(2018, 10, 11, 15, 23, 32)));
        posts.add(new Post(3L, "BTS_OFFICIAL", "@WE_T", "Stream의 요소들이 특정한 조건을 충족하는지 검사하고 싶은 경우에는 match 함수를 이용할 수 있다.", LocalDateTime.of(2018, 12, 11, 15, 23, 0)));
        posts.add(new Post(3L, "BTS_OFFICIAL", "@WE_T", "예를 들어 요소들을 출력하기를 원할 때 다.", LocalDateTime.of(2018, 12, 11, 15, 22, 30)));
        posts.add(new Post(4L, "BIGBANG_OFFICIAL", "@Anti", "redicate를 받아 Boolean을 Key값으로 partitioning한다", LocalDateTime.of(2021, 9, 15, 15, 23, 32)));
        posts.add(new Post(5L, "bbnannn99", "@banana", "하지만 만약 1개의 Stream으로부터 갯수, 합계, 평균, 최댓값, 최솟값을 한번에 얻고 싶은 경우에는 어떻게 할 수 있을까?", LocalDateTime.of(2021, 9, 11, 15, 23, 32)));
        posts.add(new Post(6L, "ninn211", "@best_programmer", "Stream에서 작업한 결과를 1개의 String으로 이어붙이기를 원하는 경우에 Collectors.joining()을 이용할 수 있다", LocalDateTime.of(2021, 8, 11, 15, 23, 55)));
    }

    public List<Post> getFollowerPosts(User user) {
        return getFollowerPosts(user.getFollowIds());
    }

    private List<Post> getFollowerPosts(List<Long> followerIds) {

        var followerPosts = new ArrayList<Post>();

        for (var follower : followerIds) {

            var followerPost = posts.stream().filter(x -> x.getId().equals(follower))
                                                       .collect(Collectors.toList());

            if(followerPost.size() > 0) {
                followerPosts.addAll(followerPost);
            }
        }

        followerPosts.sort(Comparator.comparing(Post::getUploadedDate));

        return followerPosts;
    }

}

