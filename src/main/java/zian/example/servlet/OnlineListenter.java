package zian.example.servlet;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.time.LocalDate;
import java.util.Date;

@Slf4j
@WebListener
public class OnlineListenter implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("session创建{}",se);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("session销毁{}",se);
    }
}
