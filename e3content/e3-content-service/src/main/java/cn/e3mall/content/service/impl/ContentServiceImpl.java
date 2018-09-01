package cn.e3mall.content.service.impl;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.mapper.TbContentMapper;
import cn.e3mall.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 01/09/2018
 * Time: 13:46
 * To change this template use File | Settings | File Templates.
 * Description:
 */

@Service
public class ContentServiceImpl implements ContentService {


    @Autowired
    private TbContentMapper contentMapper;


    @Override
    public E3Result addContent(TbContent content) {

        content.setCreated(new Date());
        content.setUpdated(new Date());


        int insert = contentMapper.insert(content);


        return E3Result.ok(content);
    }
}