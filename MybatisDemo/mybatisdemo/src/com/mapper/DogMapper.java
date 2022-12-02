package com.mapper;

import java.util.List;

import com.example.wangjue.*;

public interface DogMapper {
    List<Dog> selectDog();

    int insertDog(Dog dog);
    
    int updateDog(int age);

    int deleteDog(int id);

    List<Dog> selectByName(String name);
}
