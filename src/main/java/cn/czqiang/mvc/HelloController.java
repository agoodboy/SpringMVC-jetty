package cn.czqiang.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: 陈志强
 * Date: 13-10-16
 * Time: 上午10:38
 */
@Controller
public class HelloController {

    @RequestMapping(value = {"/", "/hellomvc"})
    public String hello(Map<String, Object> map) {
//        System.out.println(id);
        System.out.println("hellomvc");
        System.out.println("map = [" + map + "]");
        map.put("hello", "world");
        return "hellomvc";
    }
}
