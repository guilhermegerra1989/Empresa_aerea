package br.com.guilherme.lemes.rest.domain.mapper;

import br.com.guilherme.lemes.common.util.CommonUtil;
import br.com.guilherme.lemes.core.domain.bean.User;
import br.com.guilherme.lemes.core.domain.enumeration.UserGroup;
import br.com.guilherme.lemes.core.service.UserService;
import br.com.guilherme.lemes.rest.domain.dto.PaginatedListDto;
import br.com.guilherme.lemes.rest.domain.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    @Autowired
    private UserService userService;

    public User toEntity(UserDto userDto) {
        User user = null;

        if (userDto.getId() != null) {
            user = userService.getById(userDto.getId());
        } else {
            user = new User();
        }

        user.setGroup(UserGroup.valueOf(userDto.getGroup()));

        List<String> ignoredFields = new ArrayList<>();
        ignoredFields.add("group");

        if (CommonUtil.isNotNullOrNotEmpty(userDto.getPassword())) {
            ignoredFields.add("password");
        }

        BeanUtils.copyProperties(userDto, user, ignoredFields.toArray(new String[0]));
        return user;
    }

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setGroup(user.getGroup().name());

        BeanUtils.copyProperties(user, userDto, new String[] { "password", "group" });
        return userDto;
    }

    public PaginatedListDto<UserDto> toDto(PaginatedListDto<User> usersList) {
        List<UserDto> userDtoList = new ArrayList<>();

        for (User user : usersList.getItems()) {
            userDtoList.add(toDto(user));
        }

        return new PaginatedListDto<UserDto>(usersList.getCurrentPage(), usersList.getItemsPerPage(),
                usersList.getTotalItems(), userDtoList);
    }

    public List<UserDto> toDto(List<User> usersList) {
        List<UserDto> userDtoList = new ArrayList<>();

        for (User user : usersList) {
            userDtoList.add(toDto(user));
        }

        return userDtoList;
    }
}
