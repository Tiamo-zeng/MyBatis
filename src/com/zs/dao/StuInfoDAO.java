package com.zs.dao;

import com.zs.Entity.StuInfoEntity;
import com.zs.util.BaseSqlSession;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StuInfoDAO {
    //获取所有学生信息，返回一个学生集合
    public static List<StuInfoEntity> getAllStuInfo(){
        //执行查询所有学生信息SQL
        List<StuInfoEntity> stuList= BaseSqlSession.getSession().selectList("com.zs.mapping.StuInfoMapper.all");
        //关闭资源
        BaseSqlSession.closrSession();
        //返回学生信息集合
        return stuList;
    }

    //根据学号查询单个学生信息
    public static StuInfoEntity getOneStuInfo(int stuid){
        StuInfoEntity stuInfo = BaseSqlSession.getSession().selectOne("com.zs.mapping.StuInfoMapper.one", stuid);
        BaseSqlSession.closrSession();
        return stuInfo;
    }

    //根据学号修改学生信息
    public static int updateStuInfo(StuInfoEntity stu){
        int count = BaseSqlSession.getSession().update("com.zs.mapping.StuInfoMapper.upt", stu);
        BaseSqlSession.closrSession();
        return count;
    }

    //新增学生信息
    public static int insertStuInfo(StuInfoEntity stu){
            int count=BaseSqlSession.getSession().insert("com.zs.mapping.StuInfoMapper.add", stu);
            BaseSqlSession.closrSession();
            return count;
    }

    public static int deleteStuInfo(int stuid){
        int count = BaseSqlSession.getSession().delete("com.zs.mapping.StuInfoMapper.del",stuid);
        BaseSqlSession.closrSession();
        return count;
    }

}
