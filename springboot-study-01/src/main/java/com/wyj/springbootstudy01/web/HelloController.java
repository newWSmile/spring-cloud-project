package com.wyj.springbootstudy01.web;

import com.wyj.springbootstudy01.bean.BlogProperties;
import com.wyj.springbootstudy01.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @RequestMapping(value = "/")
    public String index(ModelMap map ){
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host","http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
    //注意 这里/error不行 因为springboot默认提供了一个/error的  映射 如果这里还是这样写会报There is already '******' bean method
    @RequestMapping(value = "/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }


    @RequestMapping(value = "/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @RequestMapping("/security")
    public String security() {
        return "security";
    }
    @RequestMapping("/security2")
    public String security2() {
        return "security2";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
