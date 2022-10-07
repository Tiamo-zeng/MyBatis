package com.zs.Test;

import com.zs.Entity.StuInfoEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class test3 {
    public static void main(String[] args) {
        try {

            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(in);

            SqlSession sqlSession =sqlSessionFactory.openSession();

            StuInfoEntity stu=new StuInfoEntity();
            stu.setStuname("张三");
            stu.setStusex("女");
            stu.setStuage(20);

            int count= sqlSession.insert("com.zs.mapping.StuInfoMapper.add", stu);

            sqlSession.commit();

            sqlSession.close();


            System.out.println("受影响行数:"+count);


        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
