package com.example.Nolowa.controller;

import com.example.Nolowa.authentication.AuthenticationController;
import com.example.Nolowa.dataModels.Images.ProfileImage;
import com.example.Nolowa.dataModels.Post;
import com.example.Nolowa.dataModels.User;
import com.example.Nolowa.user.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.parser.ParseException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @Before
    public void setUp() {
        var profileImage = new ProfileImage("http://testUrl/Endpoint.com", "testhashcode");

        var testUser = User.builder()
                .email("TestUser")
                .password("TestPassword")
                .profileImage(profileImage)
                .build();

        userRepository.save(testUser);
    }

    @Test
    public void 프로필사진이있는객체에대한올바른프로필생성() {
        try {
            var param = new JSONObject();
            param.put("id", "TestUser");
            param.put("password", "TestPassword");

            var actions = mockMvc.perform(post("/Authentication/Login")
                    .content(param.toString())
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON));

            actions.andDo(print());
        } catch (Exception exception) {
        }

    }
}
