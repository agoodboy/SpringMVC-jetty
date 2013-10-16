package cn.czqiang.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: 陈志强
 * Date: 13-10-16
 * Time: 上午10:38
 */
@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(value = {"/hellomvc"})
    public String hello(Map<String, Object> map) {
        //        System.out.println(id);
        System.out.println("hellomvc");
        System.out.println("map = [" + map + "]");
        map.put("hello", "world");
        map.put("jrebel", "jrebel测试");
        return "hellomvc";
    }

    @RequestMapping(value = "/say")
    public String say(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("ok");
        model.addAttribute("hello", "value");
        System.out.println(id);
        return "hellomvc";
    }
}
