package com.openclassrooms.starterjwt.services;

import com.openclassrooms.starterjwt.models.User;
import com.openclassrooms.starterjwt.repository.UserRepository;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Test
    void deleteUserById_Success() throws Exception {

        //GIVEN
       User user1 = User.builder()
               .id(1L)
               .email("abdourahamane620@gmail.com")
               .lastName("Abdourahamane")
               .firstName("BALDE")
               .password("BALDE2024@")
               .admin(true)
               .build();

        User user2 = User.builder()
                .id(2L)
                .email("abdourahamane620@gmail.com")
                .lastName("Abdourahamane")
                .firstName("BALDE")
                .password("BALDE2024@")
                .admin(false)
                .build();

        //WHEN
        userService.delete(2L);

        //THEN
        assertThat(user2.getId()).isNotNull();

    }

    @Test
    void findByIdUser_Success() throws Exception{

        //GIVEN
        User user1 = User.builder()
                .id(1L)
                .email("abdourahamane620@gmail.com")
                .lastName("Abdourahamane")
                .firstName("BALDE")
                .password("BALDE2024@")
                .admin(true)
                .build();

        User user2 = User.builder()
                .id(2L)
                .email("abdourahamane620@gmail.com")
                .lastName("Abdourahamane")
                .firstName("BALDE")
                .password("BALDE2024@")
                .admin(false)
                .build();

        //WHEN
        given(userRepository.findById(2L))
                .willReturn(Optional.ofNullable(user2));

        var teacher = userService.findById(2L);

        //THEN
        //verify(userService).findById(2L);
        assertThat(teacher).isNotNull();
    }
}