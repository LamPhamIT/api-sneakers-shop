package com.shinn.sneakersshop.service.impl;

import com.shinn.sneakersshop.converter.Converter;
import com.shinn.sneakersshop.dto.UsersDto;
import com.shinn.sneakersshop.exception.InvalidDataSentException;
import com.shinn.sneakersshop.exception.ResourceNotFoundException;
import com.shinn.sneakersshop.model.Role;
import com.shinn.sneakersshop.model.Users;
import com.shinn.sneakersshop.repository.RoleRepository;
import com.shinn.sneakersshop.repository.UsersRepository;
import com.shinn.sneakersshop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private final Converter<Users, UsersDto> converter;
    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;

    @Autowired
    private UsersServiceImpl(@Qualifier("usersConverter") Converter<Users, UsersDto> converter, UsersRepository usersRepository, RoleRepository roleRepository) {
        this.converter = converter;
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UsersDto findByUsername(String username) {
        Optional<Users> users = usersRepository.findByUsername(username);
        if (!users.isEmpty()) throw new ResourceNotFoundException("User", "username", username);
        return converter.toDto(users.get());
    }

    @Override
    public UsersDto save(UsersDto usersDto) {
        Users saveUser = converter.toEntity(usersDto);
        List<Role> roles = new ArrayList<>();
        for(Role role : saveUser.getRoles()) {
            Optional<Role> fullFieldRole = roleRepository.findByCodeOrName(role.getCode(), role.getName());
            if(!fullFieldRole.isPresent()) throw new InvalidDataSentException("code, name");
            roles.add(fullFieldRole.get());
        }
        saveUser.setRoles(roles);
        saveUser = usersRepository.save(saveUser);
        if (saveUser.getId() > 0) {
            return converter.toDto(saveUser);
        } else {
            throw new RuntimeException("Server side error!");
        }

    }
}
