package cn.czqiang.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: 陈志强
 * Date: 13-10-16
 * Time: 上午9:17
 */
@WebServlet(name = "HelloServlet")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("gbk");
        System.out.println("HelloServlet.doGet");
        System.out.println("真的实现热部署了嘛");
        System.out.println("\"希望我的分享能帮到前端开发的朋友们\"");
        System.out.println("测试JRebel Debug");
        PrintWriter writer = response.getWriter();
        writer.print("hello");
        writer.print("真的实现热部署了，非常开心");
        writer.println();
        writer.println("希望我的分享能帮到前端开发的朋友们");
        writer.println();
        writer.println("测试JRebel Debug");
    }
}
