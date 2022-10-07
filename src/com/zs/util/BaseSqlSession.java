package com.zs.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;

public class BaseSqlSession {
    //定义SqlsessionFactory对象
    private static SqlSessionFactory sqlSessionFactory=null;
    //定义Sqlsession对象
    private static SqlSession sqlSession=null;

    static {
        try {
            InputStream in= Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //1.定义方法获取SQLSession
    public static SqlSession getSession(){
        sqlSession=sqlSessionFactory.openSession();
        return sqlSession;
    }
    //2.定义关闭资源
    public static void closrSession(){
        sqlSession.commit();
        sqlSession.close();
    }
}
