package com.nhnacademy.shoppingmall.common.listener;

import com.nhnacademy.shoppingmall.common.mvc.transaction.DbConnectionThreadLocal;
import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.repository.impl.UserRepositoryImpl;
import com.nhnacademy.shoppingmall.user.service.UserService;
import com.nhnacademy.shoppingmall.user.service.impl.UserServiceImpl;
import java.time.LocalDateTime;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Slf4j
@WebListener
public class ApplicationListener implements ServletContextListener {
    private final UserService userService = new UserServiceImpl(new UserRepositoryImpl());
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DbConnectionThreadLocal.initialize();
        //todo#12 application 시작시 테스트 계정인 admin,user 등록합니다. 만약 존재하면 등록하지 않습니다.
        if (userService.getUser("admin") == null) {
            User admin = new User("admin", "Admin User", "12345", "19900101", User.Auth.ROLE_ADMIN, 1000000, LocalDateTime.now(), null);
            userService.saveUser(admin);
            log.info("admin 유저 저장");
        }

        if (userService.getUser("user") == null) {
            User user = new User("user", "Regular User", "12345", "19910101", User.Auth.ROLE_USER, 1000000, LocalDateTime.now(), null);
            userService.saveUser(user);
            log.info("user 유저 저장");
        }
        log.info("리스너 처리 완료");
        DbConnectionThreadLocal.reset();
    }
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        //todo#12 application 종료시 테스트 계정인 admin,user 삭제합니다.
//        // Check if admin and user exist
//        if (userService.getUser("admin") != null) {
//            userService.deleteUser("admin");
//            log.info("admin 유저 삭제");
//        }
//
//        if (userService.getUser("user") != null) {
//            userService.deleteUser("user");
//            log.info("user 유저 삭제");
//        }
//    }
}
