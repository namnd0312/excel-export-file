package com.namnd.exportexcel.services.impl;

import com.namnd.exportexcel.dtos.UserDto;
import com.namnd.exportexcel.mapper.UserMapper;
import com.namnd.exportexcel.models.User;
import com.namnd.exportexcel.repositories.UserRepository;
import com.namnd.exportexcel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author nam.nd
 * @created 28/02/2021 - 7:38 PM
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userRepository.save(user);

    }

    @Override
    public List<UserDto> getList() {
        return this.userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }
}
