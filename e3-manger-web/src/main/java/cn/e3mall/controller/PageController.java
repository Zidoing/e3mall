package cn.e3mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 26/08/2018
 * Time: 10:31
 * To change this template use File | Settings | File Templates.
 * Description:
 */

@Controller
public class PageController {

    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }


    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }

}