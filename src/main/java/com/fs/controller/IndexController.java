package com.fs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fs.service.PeopleService;

@Controller

public class IndexController
{
	@Autowired PeopleService ps;
	//接收新增人员请求
	@RequestMapping("/insertPeople.do")
	public String insertPeople(HttpServletRequest request,String iname,String iage,String isex)
	{
		request.setAttribute("result", ps.doInsertPeople(iname, iage, isex));
		return "/showIndex.do";
		
	}
	//接收显示页面请求
	@RequestMapping("/showIndex.do")
	public String showPeople(HttpServletRequest request)
	{
		request.setAttribute("show", ps.getAllPeople());
		return "/index.jsp";
		
	}
	@RequestMapping("/deletePeople.do")
	public String deletePeople(HttpServletRequest request,String peopleId) {
		System.out.println(1);
		request.setAttribute("result", ps.deletePeopleById(peopleId));
		return "/showIndex.do";
	}
	
	//ajax
	@RequestMapping(value="/showByAjax.ajax",produces="text/html; charset=UTF-8")
	public @ResponseBody String showPeopleByAjax() {
		return null;
		
	}
	public PeopleService getPs()
	{
		return ps;
	}

	public void setPs(PeopleService ps)
	{
		this.ps = ps;
	}
	
	
}
