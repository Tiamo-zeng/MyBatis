package com.zs.Test;

import com.zs.Entity.StuInfoEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class test2 {
    public static void main(String[] args) {
        try {

            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(in);

            SqlSession sqlSession =sqlSessionFactory.openSession();

            int stuid=1;
            String stuName=sqlSession.selectOne("com.zs.mapping.StuInfoMapper.one2", stuid);

            sqlSession.commit();

            sqlSession.close();


            System.out.println("学号："+stuid+" 姓名:"+stuName);


        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
