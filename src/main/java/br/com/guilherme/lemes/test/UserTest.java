package br.com.guilherme.lemes.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.guilherme.lemes.core.domain.bean.User;
import br.com.guilherme.lemes.rest.controller.impl.UserControllerImpl;
import br.com.guilherme.lemes.rest.domain.dto.UserDto;

public class UserTest {

	@Test
	public void testById() throws Exception {
		UserControllerImpl userControllerImpl = new UserControllerImpl();
		User user = new User();
		user.setId(1l);
		UserDto userDto = new UserDto();
		userDto.setId(1l);
		assertEquals(userControllerImpl.getUser(user.getId()), userDto);
	}

}
