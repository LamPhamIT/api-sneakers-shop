package com.shinn.sneakersshop.service.impl;

import com.shinn.sneakersshop.SneakersShopApiApplication;
import com.shinn.sneakersshop.converter.Converter;
import com.shinn.sneakersshop.dto.RoleDto;
import com.shinn.sneakersshop.dto.UsersDto;
import com.shinn.sneakersshop.model.Role;
import com.shinn.sneakersshop.model.Users;
import com.shinn.sneakersshop.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsersServiceImplTest {

//    @MockBean
    @Mock
    private UsersRepository usersRepository;

//   @MockBean
    @Mock
    private Converter<Users, UsersDto> converter;

//    @MockBean
    @Mock
    private PasswordEncoder passwordEncoder;

//    @Autowired
    @InjectMocks
    private UsersServiceImpl usersService;


    private UsersDto usersDto;
    private Users users;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        List<RoleDto> listRolesDto = new ArrayList<>();
        List<Role> listRoles = new ArrayList<>();
        usersDto = new UsersDto(1L,
                new Date(System.currentTimeMillis()),
                "lampham",
                null,
                null,
                "lamphamit",
                "lamdz2k4",
                "lamtkhtk2004@gmail.com",
                "Pham Tan Lam",
                listRolesDto
        );
        users = new Users(1L,
                new Date(System.currentTimeMillis()),
                "lampham",
                null,
                null,
                "lamphamit",
                "lamdz2k4",
                "lamtkhtk2004@gmail.com",
                "Pham Tan Lam",
                listRoles
        );
    }

    @DisplayName("Save an user with valid information")
    @Test
    public void shouldReturnAnUserObject() {
        when(converter.toEntity(usersDto)).thenReturn(users);
        when(converter.toDto(users)).thenReturn(usersDto);
        when(usersRepository.save(users)).thenReturn(users);
        assertNotNull(usersService.save(usersDto));
//        verify(converter, times(1)).toDto(users);
    }


    @DisplayName("Find user by email with valid email")
    @Test
    public void shoudReturnNotNull() {
        when(converter.toDto(users)).thenReturn(usersDto);
        when(usersRepository.findByUsername(users.getUsername())).thenReturn(Optional.of(users));
        assertNotNull(usersService.findByUsername(usersDto.getUsername()));
    }

}