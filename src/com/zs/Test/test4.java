package com.zs.Test;

import com.zs.Entity.StuInfoEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class test4 {
    public static void main(String[] args) {
        try {

            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(in);

            SqlSession sqlSession =sqlSessionFactory.openSession();

            StuInfoEntity stu=new StuInfoEntity();
            stu.setStuid(1);
            stu.setStuname("李四");
            stu.setStusex("男");
            stu.setStuage(19);

            int count= sqlSession.update("com.zs.mapping.StuInfoMapper.upt", stu);

            sqlSession.commit();

            sqlSession.close();


            System.out.println("受影响行数:"+count);


        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
