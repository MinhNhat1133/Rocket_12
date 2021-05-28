package com.vti.demo;

import java.util.List;

import com.vti.entity.Group;
import com.vti.repository.GroupRepository;

public class Program {
	public static void main(String[] args) {
		GroupRepository groupRepository = new GroupRepository();
		System.out.println("************LIST GROUP*************");
		List<Group> Groups = groupRepository.getAllGroups();
		for (Group group : Groups) {
			System.out.println(group);
		}
		System.out.println("\n\n***********GET GROUP BY ID***********");
		Group groupById = groupRepository.getGroupByID((int) 2);
		System.out.println(groupById);
		
		System.out.println("\n\n***********GET GROUP BY NAME***********");
		Group groupByName = groupRepository.getGroupByName("Developement");
		System.out.println(groupByName);

		System.out.println("\n\n***********CREATE GROUP***********");
		Group departmentCreate = new Group();
		departmentCreate.setGroupName("waiting");
		groupRepository.createGroup(departmentCreate);

		System.out.println("\n\n***********UPDATE GROUP 1***********");

		groupRepository.updateGroup((int) 3, "Security");

//		System.out.println("\n\n***********UPDATE DEPARTMENT 2***********");
//
//		Group departmentUpdate = new Group();
//		departmentUpdate.setId((int) 2);
//		departmentUpdate.setGroupName("Security2");
//		groupRepository.updateGroup(departmentUpdate);

		System.out.println("\n\n***********DELETE GROUP***********");
		groupRepository.deleteGroup((int) 2);

		System.out.println("***********CHECK GROUP EXISTS BY ID***********");
		System.out.println(groupRepository.isGroupExistsByID((int) 1));

		System.out.println("***********CHECK GROUP EXISTS BY NAME***********");
		System.out.println(groupRepository.isGroupExistsByName("Security"));

	}
}
