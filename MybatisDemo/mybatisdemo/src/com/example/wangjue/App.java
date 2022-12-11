package com.example.wangjue;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mapper.CatMapper;
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
        SqlSession sqlSession1 = build.openSession();        
        SqlSession sqlSession2 = build.openSession();
        
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

        // 不同SqlSession对象多次查询，需要打开二级缓存 <setting name="cacheEnabled" value="true" />
        DogMapper mapper1 = sqlSession1.getMapper(DogMapper.class);
        Dog dog1 = mapper1.selectOneDog();

        DogMapper mapper2 = sqlSession2.getMapper(DogMapper.class);
        // DML操作清空二级缓存  
        // mapper2.updateDog(40);
        // sqlSession2.commit();
        Dog dog2 = mapper2.selectOneDog();

        // 跨命名空间操作，不清除缓存，造成脏数据
        // CatMapper mapper3 = sqlSession2.getMapper(CatMapper.class);
        // mapper3.updateDog();
        // sqlSession2.commit();
        // Dog dog2 = mapper1.selectOneDog();

        System.out.println(dog1);
        System.out.println(dog2);
        //List<Object> objects = sqlSession.selectList("dog.selectDog");
        // List<Dog> objects = mapper.selectDog();

        // for (Dog ob : objects) {
        //     System.out.println(ob);
        // }

        // System.out.println();
        // //List<Dog> dogs = sqlSession.selectList("dog.selectByName", "Haha");
        // List<Dog> dogs = mapper.selectByName("Haha");
        // for (Dog d : dogs) {
        //     System.out.println(d);
        // }
        
        sqlSession1.close();
        sqlSession2.close();
    }
}
