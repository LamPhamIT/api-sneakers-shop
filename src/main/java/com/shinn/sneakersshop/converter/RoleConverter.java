package com.shinn.sneakersshop.converter;

import com.shinn.sneakersshop.dto.RoleDto;
import com.shinn.sneakersshop.model.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements Converter<Role, RoleDto>{

    @Override
    public Role toEntity(RoleDto dtoObject) {
        Role role = new Role();
        BeanUtils.copyProperties(dtoObject, role);
        return role;
    }

    @Override
    public RoleDto toDto(Role entity) {
        RoleDto roleDto =
                new RoleDto();
        BeanUtils.copyProperties(entity, roleDto);
        return roleDto;
    }
}
