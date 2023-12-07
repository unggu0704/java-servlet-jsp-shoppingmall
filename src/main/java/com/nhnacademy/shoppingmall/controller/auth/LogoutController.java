package com.nhnacademy.shoppingmall.controller.auth;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.repository.impl.UserRepositoryImpl;
import com.nhnacademy.shoppingmall.user.service.UserService;
import com.nhnacademy.shoppingmall.user.service.impl.UserServiceImpl;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping(method = RequestMapping.Method.POST,value = "/logout.do")
public class LogoutController implements BaseController{
    //todo#13-3 로그아웃 구현
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        //todo#13-3 로그아웃 구현
        HttpSession session = req.getSession(false); // 세션이 없으면 새로 생성하지 않음

        if (session != null) {
            session.invalidate(); // 세션 무효화
        }

        // 로그아웃 후 로그인 페이지로 리다이렉트
        return "redirect:/login.do";
    }
}
