package cn.e3mall.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 29/08/2018
 * Time: 21:48
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Controller
public class IndexControll {

    @RequestMapping("/index")
    public String showIndex() {
        return "index";
    }
}