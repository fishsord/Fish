package com.fs.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.mapper.PeopleMapper;
import com.fs.pojo.People;
import com.fs.service.PeopleService;
import com.google.gson.Gson;
@Service
public class PeopleServiceImpl implements PeopleService
{
	private static final  String SUCCESS="SUCCESS";
	private static final  String ERROR="ERROR";
	@Autowired PeopleMapper pm;
	@Autowired Gson g;
	
	//自动注入映射文件
	@Override
	public String doInsertPeople(String iname, String iage, String isex)
	{
		People people = new People();
		people.setPeopleId(UUID.randomUUID().toString());
		people.setPeopleName(iname);
		people.setPeopleAge(iage);
		people.setPeopleSex(isex);
		try {
			
			return pm.insert(people)>0?SUCCESS:ERROR;
		}catch (Exception e) {
			return ERROR;
		}
			
	}
	public PeopleMapper getPm()
	{
		return pm;
	}
	public void setPm(PeopleMapper pm)
	{
		this.pm = pm;
	}
	public Gson getG()
	{
		return g;
	}
	public void setG(Gson g)
	{
		this.g = g;
	}
	@Override
	public List<People> getAllPeople()
	{
		
		return pm.selectAllPeople();
	}
	@Override
	public String deletePeopleById(String peopleId)
	{
		try {
		return pm.deleteByPrimaryKey(peopleId)>0?SUCCESS:ERROR;
	}catch (Exception e) {
		return ERROR;
	}
	}
}
