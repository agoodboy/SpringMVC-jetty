package cn.czqiang.mvc;

import cn.czqiang.entity.User;
import cn.czqiang.exception.UserException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: 陈志强
 * Date: 13-10-16
 * Time: 下午1:53
 */
@Controller
@RequestMapping(value = "/user")
@SessionAttributes(value = "loginUser")
public class UserController {
    public static final Map<String, User> users = new HashMap<String, User>();

    public UserController() {
        users.put("ldh", new User("ldh", "刘德华", "ldh", "ldh@163.com"));
        users.put("zxy", new User("zxy", "张学友", "zxy", "zxy@163.com"));
        users.put("lm", new User("lm", "黎明", "lm", "lm@163.com"));
        users.put("gfc", new User("gfc", "郭富城", "gfc", "gfc@163.com"));
    }

    @RequestMapping({"/", "/users"})
    public String list(Model model) {
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new User());
        System.out.println("add用户页面");
        return "user/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/add";
        }
        users.put(user.getName(), user);
        System.out.println("add用户");
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/user/users";
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String show(@PathVariable String name, Model model) {
        System.out.println(name);
        model.addAttribute(users.get(name));
        return "user/show";
    }

    @RequestMapping(value = "{name}/update")
    public String update(@PathVariable String name, Model model) {
        model.addAttribute(users.get(name));
        System.out.println("update页面");
        return "user/update";
    }

    @RequestMapping(value = "{name}/update", method = RequestMethod.POST)
    public String update(@PathVariable String name, @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "user/update";
        }
        users.put(name, user);
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/user/users";
    }

    @RequestMapping(value = "{name}/delete")
    public String delete(@PathVariable String name) {
        users.remove(name);
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/user/users";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        System.out.println("login页面");
        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String name, String password,Model model) {
        if (!users.containsKey(name)) {
            throw new UserException("姓名不存在！");
        }
        if (!password.equals(users.get(name).getPassword())) {
            throw new UserException("密码不正确！");
        }
        model.addAttribute("loginUser", users.get(name));
        return "redirect:/user/users";
    }

    @RequestMapping(value = "logout")
    public String logout(){
        return "redirect:/user/users";

    }

    @ExceptionHandler(value = {UserException.class})
    public String handlerException(Exception ex, HttpServletRequest request) {
        request.setAttribute("ex", ex);
        return "error";
    }

    @RequestMapping(value = "redir")
    public String redir(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("redir", "直接传值");
//        redirectAttributes.addAttribute("redir", "直接传值");
        //model.addAttribute("redir", "直接传值");
        return "redirect:/user/users";
    }
}
