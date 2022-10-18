package com.example.demo;

public class GroupServiceImpl implements GroupService {

	@Override
	public String findByNo(String number) {
		//リポジトリから社員を選択
		GroupRepository groupRepository = new GroupRepositoryImpl();
		String name = groupRepository.selectByNo(number);
		return name;
	}

}
