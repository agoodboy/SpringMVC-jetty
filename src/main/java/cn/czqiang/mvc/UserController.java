package cn.czqiang.mvc;

import cn.czqiang.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
