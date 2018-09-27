package com.fs.service;

import java.util.List;

import com.fs.pojo.People;

public interface PeopleService
{
	String doInsertPeople(String iname,String iage,String isex);
	List<People> getAllPeople();
	String deletePeopleById(String peopleId);
}
