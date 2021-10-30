package com.example.Nolowa.account;

import com.example.Nolowa.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService {
    private final UserRepository userRepository;

    public AccountService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var account = userRepository.findByEmail(username);
        var user = account.orElseThrow(() -> new UsernameNotFoundException(username));

        return Account.builder()
                    .id(user.getId())
                    .email(user.getEmail())
//                    .password(user.getPassword())
                    .build();
    }
}