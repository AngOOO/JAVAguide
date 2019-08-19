package web;


import org.junit.Test;
import server.Servlet;

public class WebAppTest {
    @Test
    public void testGetServletFromUrl() {
        Servlet servlet = WebApp.getServletFromUrl("login");
        System.out.println(servlet);
    }
}
