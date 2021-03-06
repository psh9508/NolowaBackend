package com.example.Nolowa.search;

import com.example.Nolowa.dataModels.Images.ProfileImage;
import com.example.Nolowa.dataModels.PostDTO;
import com.example.Nolowa.dataModels.SearchHistory;
import com.example.Nolowa.dataModels.User;
import com.example.Nolowa.user.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SearchService {
    private final int MAX_SEARCH_COUNT = 5;

    private final SearchRepository searchRepository;
    private final UserRepository userRepository;

    public SearchService(SearchRepository searchRepository, UserRepository userRepository) {
        this.searchRepository = searchRepository;
        this.userRepository = userRepository;
    }

    public List<User> getSearchedList(Long userId) {
        var searchedUserList = searchRepository.findAllBySearchUser(userId);

        return searchedUserList;
    }

    @Transactional
    public List<String> getSearchedKeywords(Long userId) {
        // 5개 이상이면 시간순으로 기존 것 지움
        int searchedCount = searchRepository.findSearchedCount(userId);

        if(searchedCount > MAX_SEARCH_COUNT)
        {
            //DELETE
        }

        var searchedKeywords = searchRepository.findAllKeywords(userId);

        return searchedKeywords;
    }

    @Transactional
    public List<PostDTO> search(Long userIdWhoSearches, String keyword) {
        var maybeLoginUser = userRepository.findById(userIdWhoSearches);

        if(maybeLoginUser.isPresent() == false)
            throw new UsernameNotFoundException("사용중인 User가 없습니다.");

        var loginUser = maybeLoginUser.get();

        // DB에 같은 검색어 있으면 지운다
        var searchResult = searchRepository.findBySearchUserAndKeyword(loginUser, keyword);
        searchResult.ifPresent(searchRepository::delete);

        // DB에 검색어 저장
        searchRepository.save(SearchHistory.builder()
                .searchUser(loginUser)
                .keyword(keyword)
                .build());

        // 검색된 Post 리턴
        return null;
    }

    public List<User> searchUser(String username) {
        var searchedUserList = userRepository.findAllByNameContainingIgnoreCase(username);

        for(var user : searchedUserList) {
            // 프로필 이미지가 없는 유저는 기본 값을 채워서 응답한다.
            if(user.getProfileImage() == null)
                user.setProfileImage(new ProfileImage());
        }

        return searchedUserList;
    }

    @Transactional
    public void deleteKeyword(String userId) {
        var maybeLoginUser = userRepository.findById(Long.parseLong(userId));

        if(maybeLoginUser.isPresent() == false)
            throw new UsernameNotFoundException("사용중인 User가 없습니다.");

        searchRepository.deleteAllBySearchUser(maybeLoginUser.get());
    }
}
