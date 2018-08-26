package cn.e3mall.controller;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 25/08/2018
 * Time: 19:16
 * To change this template use File | Settings | File Templates.
 * Description:
 */

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;


    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) {

        TbItem item = itemService.getItemById(itemId);
        System.out.println(item);
        return item;
    }


}