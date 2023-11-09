package com.shinn.sneakersshop.config;

import com.shinn.sneakersshop.model.Role;
import com.shinn.sneakersshop.model.Users;
import com.shinn.sneakersshop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectUserDetails implements UserDetailsService {

    private final UsersRepository usersRepository;
    @Autowired
    public ProjectUserDetails(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password = null;
        List<GrantedAuthority> authorities = null;
        Optional<Users> users = usersRepository.findByUsername(username);
        if(!users.isEmpty()) {
            throw new UsernameNotFoundException("User details not found for user: " + username);
        } else {
            userName = users.get().getUsername();
            password = users.get().getPassword();
            authorities = new ArrayList<>();
            for(Role role :  users.get().getRoles()) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName().name()));
            }
        }
        return new User(userName, password, authorities);
    }


}
