package com.shinn.sneakersshop.repository;

import com.shinn.sneakersshop.model.ERole;
import com.shinn.sneakersshop.model.Role;
import com.shinn.sneakersshop.model.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@DataJpaTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2) // Fix
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UsersRepositoryTest {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RoleRepository roleRepository;
    private List<Role> roles = new ArrayList<>();
    private List<Users> users = new ArrayList<>();
    @BeforeEach
    void setUpAll() {
        Role admin = new Role(null,
                new Date(System.currentTimeMillis()),
                "LamPham",
                null,
                null,
                "admin", ERole.ADMIN,
                null);
        Role userRole= new Role(null,
                new Date(System.currentTimeMillis()),
                "LamPham",
                null,
                null,
                "admin", ERole.USER,
                null);
        Role seller = new Role(null,
                new Date(System.currentTimeMillis()),
                "LamPham",
                null,
                null,
                "admin", ERole.SELLER,
                null
        );
        roles.add(admin);
        Users user = new Users(null,
                null,
                null,
                null,
                null,
                "genzdoit",
                "lamdz2k4",
                "phamtanlam@gmail.com",
                "pham tan lam",
                roles
        );
        roles.add(userRole);
        roles.add(seller);
        users.add(user);
    }
    @DisplayName("Find An Object given an username")
    @Test
    public void shouldReturnAnObject() {
        roleRepository.saveAll(roles);
        usersRepository.save(users.get(0));
        Optional<Users> user = usersRepository.findByUsername("genzdoit");
        Assertions.assertSame(users.get(0), user.get());
    }

}
