package com.example.Nolowa.controller;

import com.example.Nolowa.authentication.AuthenticationController;
import com.example.Nolowa.authentication.AuthenticationService;
import com.example.Nolowa.dataModels.Images.ProfileImage;
import com.example.Nolowa.dataModels.Post;
import com.example.Nolowa.dataModels.User;
import com.example.Nolowa.user.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.parser.ParseException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

    @Mock
    private AuthenticationService authenticationService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void Mock을이용한테스트작성() {
        var mockService = mock(AuthenticationService.class);

        var controller = new AuthenticationController(mockService, null);

        var mockUser = new User();
        mockUser.setEmail("TestUser");
        mockUser.setPassword("TestPassword");
        mockUser.setProfileImage(new ProfileImage("http://mockUrl", "hash"));

        when(mockService.login("TestUser", "TestPassword")).thenReturn(mockUser);

        try {
            Map<String, String> param = new HashMap<String, String>() {
                {
                    put("id", "TestUser");
                    put("password", "TestPassword");
                }
            };

            var loginedUser = controller.Login(param);
        } catch (Exception ex) {

        }
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

            actions.andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("profileImage").exists());
        } catch (Exception exception) {
        }

    }
}
