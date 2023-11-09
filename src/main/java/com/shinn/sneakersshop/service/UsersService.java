package com.shinn.sneakersshop.service;

import com.shinn.sneakersshop.dto.UsersDto;

public interface UsersService {
    public UsersDto findByUsername(String username);
}
