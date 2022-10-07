package com.zs.Test;

import com.zs.Entity.StuInfoEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class test5 {
    public static void main(String[] args) {
        try {

            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(in);

            SqlSession sqlSession =sqlSessionFactory.openSession();

            int stuid=4;

            int count= sqlSession.update("com.zs.mapping.StuInfoMapper.del", stuid);

            sqlSession.commit();

            sqlSession.close();

            System.out.println("受影响行数:"+count);


        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
