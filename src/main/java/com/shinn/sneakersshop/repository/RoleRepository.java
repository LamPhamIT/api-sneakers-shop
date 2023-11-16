package com.shinn.sneakersshop.repository;

import com.shinn.sneakersshop.model.ERole;
import com.shinn.sneakersshop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Optional<Role> findByCodeOrName(String code, ERole name);
}
