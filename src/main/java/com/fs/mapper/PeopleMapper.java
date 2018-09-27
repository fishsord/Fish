package com.fs.mapper;

import java.util.List;

import com.fs.pojo.People;

public interface PeopleMapper {
    int deleteByPrimaryKey(String peopleId);

    int insert(People record);

    int insertSelective(People record);

    People selectByPrimaryKey(String peopleId);

    int updateByPrimaryKeySelective(People record);

    int updateByPrimaryKey(People record);
    
    List<People> selectAllPeople();
    
}