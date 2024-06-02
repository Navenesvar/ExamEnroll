package com.naven.examregister.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.naven.examregister.domain.Login1;
import com.naven.examregister.repository.LoginRepo;

@SpringBootTest
public class LoginServiceTest {

    private LoginService loginService;
    private LoginRepo loginRepoMock;

    @BeforeEach
    public void setUp() {
        // Mock the LoginRepo dependency
        loginRepoMock = mock(LoginRepo.class);
        loginService = new LoginService();
        loginService.setRep(loginRepoMock);
    }

    @Test
    public void testLogin() {
        // Prepare test data
        String username = "testuser";
        String password = "testpassword";
        Login1 expectedLogin = new Login1(username, password);

        // Mock the behavior of the LoginRepo.findByUsernameAndPassword() method
        when(loginRepoMock.findByUsernameAndPassword(username, password)).thenReturn(expectedLogin);

        // Call the login method of the LoginService
        Login1 actualLogin = loginService.log(username, password);

        // Verify that the login method returns the expected login object
        assertEquals(expectedLogin, actualLogin);
    }

    // Add more test cases as needed

    // Don't forget to test the save method as well
}
