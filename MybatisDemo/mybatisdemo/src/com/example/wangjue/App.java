package com.example.wangjue;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mapper.DogMapper;

public class App {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = null;

        try {
            inputStream = Resources.getResourceAsStream("resource/mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();      
        
        // --insert into--
        // Dog dog = new Dog();
        // dog.setName("Haha");
        // dog.setAge(6);
        // sqlSession.insert("dog.insertDog", dog);

        // HashMap<String, Object>  mapdog = new HashMap<>();
        // mapdog.put("name", "hehe");
        // mapdog.put("age", 4);
        // sqlSession.insert("dog.insertDog", mapdog);

        // --update--
        // HashMap<String, Integer> mapage = new HashMap<>();
        // mapage.put("age", 10);
        // sqlSession.update("dog.updateDog", 11);

        // --delete--
        // sqlSession.delete("dog.deleteDog", 2);

        // sqlSession.commit();

        // query
        DogMapper mapper = sqlSession.getMapper(DogMapper.class);
        //List<Object> objects = sqlSession.selectList("dog.selectDog");
        List<Dog> objects = mapper.selectDog();

        for (Dog ob : objects) {
            System.out.println(ob);
        }

        System.out.println();
        //List<Dog> dogs = sqlSession.selectList("dog.selectByName", "Haha");
        List<Dog> dogs = mapper.selectByName("Haha");
        for (Dog d : dogs) {
            System.out.println(d);
        }
        
        sqlSession.close();
    }
}
