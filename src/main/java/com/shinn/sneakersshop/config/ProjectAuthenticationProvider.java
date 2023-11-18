package com.shinn.sneakersshop.config;

import com.shinn.sneakersshop.constant.SystemConstant;
import com.shinn.sneakersshop.dto.RoleDto;
import com.shinn.sneakersshop.dto.UsersDto;
import com.shinn.sneakersshop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectAuthenticationProvider implements AuthenticationProvider {

    private final UsersService usersService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ProjectAuthenticationProvider(UsersService usersService, PasswordEncoder passwordEncoder) {
        this.usersService = usersService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UsersDto usersDto = usersService.findByUsername(username);
        if(usersDto.getId() != null) {
            if(passwordEncoder.matches(password, usersDto.getPassword())) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                for(RoleDto role : usersDto.getRoles()) {
                  authorities.add(new SimpleGrantedAuthority(SystemConstant.ROLE_PRE + role.getName().name()));
                }
                return new UsernamePasswordAuthenticationToken(username, password, authorities);
            } else {
                throw new BadCredentialsException("Invalid password");
            }
        } else {
            throw new BadCredentialsException("No user registered with this details");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
