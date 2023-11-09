package com.shinn.sneakersshop.converter;

import com.shinn.sneakersshop.dto.RoleDto;
import com.shinn.sneakersshop.dto.UsersDto;
import com.shinn.sneakersshop.model.Role;
import com.shinn.sneakersshop.model.Users;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersConverter implements Converter<Users, UsersDto>{

    private final Converter<Role, RoleDto> converter;

    @Autowired
    public UsersConverter(@Qualifier("roleConverter") Converter<Role, RoleDto> converter) {
        this.converter = converter;
    }
    @Override
    public Users toEntity(UsersDto dtoObject) {
        Users users = new Users();
        BeanUtils.copyProperties(dtoObject, users);
        if(dtoObject.getRoles() != null) {
            List<Role> roles =  new ArrayList<>();
            for(RoleDto roleDto : dtoObject.getRoles()) {
                Role role = converter.toEntity(roleDto);
                roles.add(role);
            }
            users.setRoles(roles);
        }
        return users;
    }

    @Override
    public UsersDto toDto(Users entity) {
        UsersDto usersDto = new UsersDto();
        BeanUtils.copyProperties(entity, usersDto);
        if(entity.getRoles() != null) {
            List<RoleDto> roles = new ArrayList<>();
            for(Role role: entity.getRoles()) {
                RoleDto roleDto = converter.toDto(role);
                roles.add(roleDto);
            }
            usersDto.setRoles(roles);
        }
        return usersDto;
    }
}
