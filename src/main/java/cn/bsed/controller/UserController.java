package cn.bsed.controller;

import cn.bsed.pojo.User;
import cn.bsed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author SQM
 * @date 2018/1/17
 * @version: 1.0
 */
@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * login
     * <p>   后台登录
     *
     * @param user  要登陆的用户数据
     * @return java.lang.String  登陆成功则转发到后台管理主页，失败则退回登陆页
     */
    @RequestMapping(value = "/admin_user_login", method = RequestMethod.POST)
    public String login(User user, HttpSession session, HttpServletRequest request) {
        if (userService.login(user)) {
            User userInDataBase = userService.getByUsername(user.getUsername());
            session.setAttribute("user", userInDataBase);
            return "admin/home";
        } else {
            request.setAttribute("message", "用户名或密码错误");
            return "admin/loginPage";
        }
    }

    @RequestMapping(value = "/admin_user_edit_page", method = RequestMethod.GET)
    public String editPage() {
        return "admin/editUser";
    }

    @RequestMapping(value = "admin_user_edit", method = RequestMethod.POST)
    public String edit(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("ensure") String ensure,HttpServletRequest request) {
        String nothing = "";
        if (password != null && !password.equals(nothing) && ensure != null && !ensure.equals(nothing)) {
            if (password.equals(ensure)) {
                User user = userService.getByUsername(username);
                user.setPassword(password);
                userService.update(user);
                return "admin/home";
            } else {
                request.setAttribute("message", "修改失败");

                return "admin/editUser";
            }
        } else {
            request.setAttribute("message", "密码不能为空");
            return "admin/editUser";
        }
    }
}
