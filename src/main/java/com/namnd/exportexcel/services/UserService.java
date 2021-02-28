package com.namnd.exportexcel.services;

import com.namnd.exportexcel.dtos.UserDto;
import com.namnd.exportexcel.models.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author nam.nd
 * @created 28/02/2021 - 7:38 PM
 */
public interface UserService {

    void saveUser(UserDto userDto);

    List<UserDto> getList();

    List<User> getAll();

    void save(MultipartFile file);
}
