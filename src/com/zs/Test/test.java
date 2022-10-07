package com.zs.Test;

import com.zs.Entity.StuInfoEntity;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    public static void main(String[] args) {
        try {
            //1.加载mybatis核心配置文件(mybatis-config.xml)
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            //2.创建会话工厂
            SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(in);
            //3.创建会话对象
            SqlSession sqlSession =sqlSessionFactory.openSession();
            //4.执行SQL语句（查询）-- 返回一个泛型集合（注意参数：mapper映射文件（namespace+id值））
            List<StuInfoEntity> stuList=sqlSession.selectList("com.zs.mapping.StuInfoMapper.all");
            //5.提交
            sqlSession.commit();
            //6.关闭
            sqlSession.close();

            //循环遍历集合
            for (StuInfoEntity stu:stuList){
                System.out.println(stu.getStuid()+" "+stu.getStuname()+" "+stu.getStusex()+" "+stu.getStuage());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
