package com.zs.Servlet;

import com.zs.Entity.StuInfoEntity;
import com.zs.dao.StuInfoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/StuInfoServlet")

public class StuInfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        //获取code值，判断进行何种操作
        int code = Integer.parseInt(request.getParameter("code"));

        if (code == 1) {
            //查询所有学生信息

            //调用查询所有学生信息方法
            List<StuInfoEntity> stuList = StuInfoDAO.getAllStuInfo();

            //跳转页面
            request.setAttribute("stuList", stuList);

            request.getRequestDispatcher("all.jsp").forward(request, response);
        } else if (code == 2) {

            int stuid = Integer.parseInt(request.getParameter("stuid"));
            StuInfoEntity stuInfo = StuInfoDAO.getOneStuInfo(stuid);

            //��ת
            request.setAttribute("stuInfo", stuInfo);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } else if (code == 3) {
            int stuid = Integer.parseInt(request.getParameter("stuid"));
            String stuname = request.getParameter("stuname");
            String stusex = request.getParameter("stusex");
            int stuage = Integer.parseInt(request.getParameter("stuage"));

            StuInfoEntity stu = new StuInfoEntity();
            stu.setStuid(stuid);
            stu.setStuname(stuname);
            stu.setStusex(stusex);
            stu.setStuage(stuage);

            int count = StuInfoDAO.updateStuInfo(stu);

            if (count > 0) {
                request.getRequestDispatcher("StuInfoServlet?code=1").forward(request, response);
            }else{

            }
        } if (code == 4) {
            String stuname = request.getParameter("stuname");
            String stusex = request.getParameter("stusex");
            int stuage = Integer.parseInt(request.getParameter("stuage"));

            StuInfoEntity stu = new StuInfoEntity();
            stu.setStuname(stuname);
            stu.setStusex(stusex);
            stu.setStuage(stuage);
            int count = StuInfoDAO.insertStuInfo(stu);
            if (count > 0) {
                request.getRequestDispatcher("StuInfoServlet?code=1").forward(request, response);
            }
        }if (code==5){
            response.sendRedirect("success.jsp");
        }if (code==6){
            int stuid = Integer.parseInt(request.getParameter("stuid"));
            int count=StuInfoDAO.deleteStuInfo(stuid);
            if (count>0){
                request.getRequestDispatcher("StuInfoServlet?code=1").forward(request,response);
            }

        }
    }
}
