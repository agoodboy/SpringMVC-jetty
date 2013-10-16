package cn.czqiang.mvc;

import cn.czqiang.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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
public class UserController {
    public static final Map<String, User> users = new HashMap<String, User>();

    public UserController() {
        users.put("ldh", new User("ldh", "刘德华", "ldh", "ldh@163.com"));
        users.put("zxy", new User("zxy", "张学友", "ldh", "zxy@163.com"));
        users.put("lm", new User("lm", "黎明", "ldh", "lm@163.com"));
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
}
