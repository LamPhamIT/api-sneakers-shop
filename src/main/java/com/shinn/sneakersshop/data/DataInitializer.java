//package com.shinn.sneakersshop.data;
//
//import com.shinn.sneakersshop.model.ERole;
//import com.shinn.sneakersshop.model.Role;
//import com.shinn.sneakersshop.model.Users;
//import com.shinn.sneakersshop.repository.RoleRepository;
//import com.shinn.sneakersshop.repository.UsersRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//    private final RoleRepository roleRepository;
//    private final UsersRepository usersRepository;
//
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public DataInitializer(RoleRepository roleRepository, UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
//        this.roleRepository = roleRepository;
//        this.usersRepository = usersRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        Role admin = new Role(
//                null,
//                new Date(System.currentTimeMillis()),
//                "Lam Pham",
//                null,
//                null,
//                "admin",
//                ERole.ADMIN,
//                null
//                );
//        Role user= new Role(
//                null,
//                new Date(System.currentTimeMillis()),
//                "Lam Pham",
//                null,
//                null,
//                "user",
//                ERole.USER,
//                null
//        );
//        Role seller = new Role(
//                null,
//                new Date(System.currentTimeMillis()),
//                "Lam Pham",
//                null,
//                null,
//                "seller",
//                ERole.SELLER,
//                null
//        );
//        roleRepository.save(admin);
//        roleRepository.save(user);
//        roleRepository.save(seller);
//        List<Role> roles = new ArrayList<>();
//        roles.add(user);
//        Users users = new Users(
//                null,
//                new Date(System.currentTimeMillis()),
//                "Lam Pham",
//                null,
//                null,
//                "lamphamit",
//                passwordEncoder.encode("lamdz2k4"),
//                "phamtanlambe@gmail.com",
//                "Pham Tan Lam",
//                roles
//        );
//        usersRepository.save(users);
//    }
//}
