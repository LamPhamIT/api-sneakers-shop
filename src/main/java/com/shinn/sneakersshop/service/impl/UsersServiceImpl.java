package com.shinn.sneakersshop.service.impl;

import com.shinn.sneakersshop.converter.Converter;
import com.shinn.sneakersshop.dto.UsersDto;
import com.shinn.sneakersshop.exception.ResourceNotFoundException;
import com.shinn.sneakersshop.model.Users;
import com.shinn.sneakersshop.repository.UsersRepository;
import com.shinn.sneakersshop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private final Converter<Users, UsersDto> converter;
    private final UsersRepository usersRepository;
    @Autowired
    private UsersServiceImpl(@Qualifier("usersConverter") Converter<Users, UsersDto> converter, UsersRepository usersRepository) {
        this.converter = converter;
        this.usersRepository = usersRepository;
    }
    @Override
    public UsersDto findByUsername(String username) {
        Optional<Users> users = usersRepository.findByUsername(username);
        if(!users.isPresent()) throw new ResourceNotFoundException("User", "username", username);
        return converter.toDto(users.get());
    }
}
