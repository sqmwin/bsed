package cn.bsed.controller;

import cn.bsed.exception.user.ChangePasswordException;
import cn.bsed.exception.user.WrongUserInformationException;
import cn.bsed.pojo.User;
import cn.bsed.service.UserService;
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
     * @param user 要登陆的用户数据
     * @return java.lang.String  登陆成功则转发到后台管理主页，失败则退回登陆页
     */
    @RequestMapping(value = "/admin_user_login", method = RequestMethod.POST)
    public String login(HttpSession session,User user, Model model) {
        try {
            userService.login(user);
        } catch (WrongUserInformationException e) {
            model.addAttribute("message", e.getMessage());
            return "fore/loginPage";
        }
        User userInDataBase = userService.getByUsername(user.getUsername());
        session.setAttribute("user", userInDataBase);
        return "admin/home";
    }

    /**
     *loginPageAgain
     *<p>二次进入登陆页面
     *@param session    user信息
     *@param model  传递的信息
     *@return java.lang.String
     */
    @RequestMapping(value = "/admin_user_login_again", method = RequestMethod.GET)
    public String loginPageAgain(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return "admin/home";
        } else {
            model.addAttribute("message", "请重新登陆");
            return "fore/loginPage";
        }
    }

    @RequestMapping(value = "/admin_user_logout", method = RequestMethod.GET)
    public String logout(HttpSession session, Model model) {
        model.addAttribute("message", "已退出");
        session.invalidate();
        return "fore/loginPage";
    }

    @RequestMapping(value = "/admin_user_edit_page", method = RequestMethod.GET)
    public String editPage() {
        return "admin/editUser";
    }

    @RequestMapping(value = "admin_user_edit", method = RequestMethod.POST)
    public String edit(HttpSession session, @RequestParam("password") String password, @RequestParam("ensure") String ensure, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            try {
                userService.updatePassword(user.getId(), password, ensure);
                model.addAttribute("passwordMessage", "修改成功");
            } catch (ChangePasswordException e) {
                model.addAttribute("passwordMessage", e.getMessage());
            }
        }
        return "admin/editUser";
    }
}
