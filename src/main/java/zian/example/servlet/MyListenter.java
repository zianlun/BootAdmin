package zian.example.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
@WebListener
public class MyListenter implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("项目启动{}",sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("项目销毁{}",sce);
    }
}
