package cn.bsed.controller;

import cn.bsed.pojo.User;
import cn.bsed.service.UserService;
import cn.bsed.util.security.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author SQM
 * @date 2018/1/17
 * @version: 1.0
 */
@Controller
@RequestMapping("/admin")
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
    public String login(User user, HttpSession session, Model model) {
        if (userService.login(user)) {
            User userInDataBase = userService.getByUsername(user.getUsername());
            session.setAttribute("user", userInDataBase);
            return "admin/home";
        } else {
            model.addAttribute("message", "用户名或密码错误");
            return "admin/loginPage";
        }
    }

    //二次进入登陆页面
    @RequestMapping(value = "/admin_user_login_again", method = RequestMethod.GET)
    public String loginPageAgain(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return "admin/home";
        } else {
            model.addAttribute("message", "请重新登陆");
            return "admin/loginPage";
        }
    }

    @RequestMapping(value = "/admin_user_logout", method = RequestMethod.GET)
    public String logout(HttpSession session, Model model) {

        model.addAttribute("message", "已退出");
        session.invalidate();
        return "admin/loginPage";
    }

    @RequestMapping(value = "/admin_user_edit_page", method = RequestMethod.GET)
    public String editPage() {
        return "admin/editUser";
    }

    @RequestMapping(value = "admin_user_edit", method = RequestMethod.POST)
    public String edit(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("ensure") String ensure,Model model) {
        //判断密码是否为空
        String nothing = "";
        if (password != null && !password.equals(nothing) && ensure != null && !ensure.equals(nothing)) {
            //判断密码长度是否小于等于5
            int minLength = 5;
            if (password.length() >= minLength) {
                //判断两次密码是否相同
                if (password.equals(ensure)) {
                    //判断密码是否与旧密码相同
                    User user = userService.getByUsername(username);
                    String newPassword = MD5Util.getMD5(password);
                    String oldPassword = user.getPassword();
                    if (newPassword != null && oldPassword != null && !newPassword.equals(oldPassword)) {
                        user.setPassword(password);
                        userService.update(user);
                        model.addAttribute("passwordMessage", "修改成功");
                        return "admin/editUser";
                    } else {
                        model.addAttribute("passwordMessage", "新密码不能与旧密码相同");
                        return "admin/editUser";
                    }
                } else {
                    model.addAttribute("passwordMessage", "两次密码不同");
                    return "admin/editUser";
                }
            } else {
                model.addAttribute("passwordMessage", "密码太短，至少5位");
                return "admin/editUser";
            }
        } else {
            model.addAttribute("passwordMessage", "密码不能为空");
            return "admin/editUser";
        }
    }
}
