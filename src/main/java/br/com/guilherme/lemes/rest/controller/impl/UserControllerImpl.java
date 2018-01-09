package br.com.guilherme.lemes.rest.controller.impl;


import br.com.guilherme.lemes.common.util.CommonUtil;
import br.com.guilherme.lemes.core.domain.bean.User;
import br.com.guilherme.lemes.core.domain.enumeration.UserGroup;
import br.com.guilherme.lemes.core.service.UserService;
import br.com.guilherme.lemes.rest.domain.dto.PaginatedListDto;
import br.com.guilherme.lemes.rest.domain.dto.UserDto;
import br.com.guilherme.lemes.rest.domain.mapper.UserMapper;
import br.com.guilherme.lemes.security.service.AuthenticationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/users")
public class UserControllerImpl {

    private Logger logger = Logger.getLogger(UserControllerImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public PaginatedListDto<UserDto> getUsersPaginated(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer itemsPerPage, @RequestParam(required = false) UserGroup group) throws Exception {
        if (group != null) {
            List<User> users = userService.getAllEnabledByGroup(group);
            PaginatedListDto<User> usersList = new PaginatedListDto<>(page, itemsPerPage, new Long(users.size()), users);
            return userMapper.toDto(usersList);
        } else {
            PaginatedListDto<User> usersList = userService.getAllPaginated(page, itemsPerPage);
            return userMapper.toDto(usersList);
        }
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/current-user", method = RequestMethod.GET)
    public UserDto getUser(Principal principal) {
        User user = userService.getByUsername(principal.getName());
        return userMapper.toDto(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    UserDto getUser(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);

        if (!CommonUtil.isNullOrEmpty(userDto.getPassword())) {
            String encoded = authenticationService.encodePassword(userDto.getPassword());
            user.setPassword(encoded);
        }

        userService.save(user);

        return userMapper.toDto(user);
    }





    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public UserDto updateUser(@RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);

        if (!CommonUtil.isNullOrEmpty(userDto.getPassword())) {
            String encoded = authenticationService.encodePassword(userDto.getPassword());
            user.setPassword(encoded);
        }

        userService.update(user);

        return userMapper.toDto(user);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }






}
