package com.namnd.exportexcel.mapper;

import com.namnd.exportexcel.dtos.UserDto;
import com.namnd.exportexcel.models.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author nam.nd
 * @created 28/02/2021 - 7:49 PM
 */

@Component
public class UserMapper {

    public User toEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }
        User temporary = new User();
        BeanUtils.copyProperties(dto, temporary);
        return temporary;
    }

    public UserDto toDto(User entity) {
        if (entity == null) {
            return null;
        }
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
