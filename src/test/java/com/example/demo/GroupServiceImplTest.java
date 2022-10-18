package com.example.demo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class GroupServiceImplTest {

	@MockBean
	private GroupRepository groupRepository;

	@Test
	public void findByNoTest() throws Exception {

		when(groupRepository.selectByNo("10000")).thenReturn("SS1部");
		GroupService groupService = new GroupServiceImpl();
		String employee = groupService.findByNo("10000");
		assertEquals(employee, "SS1部");
	}

}