package web;
import org.junit.Test;
import util.WebContext;

public class WebAppTest {
    @Test
    public void testGetServletFromUrl() {
        WebContext webContext = WebApp.parseText("web.xml");
        webContext.getClz("/login");
    }
}
