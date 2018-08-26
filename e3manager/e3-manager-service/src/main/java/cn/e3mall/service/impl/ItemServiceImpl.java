package cn.e3mall.service.impl;

import cn.e3mall.common.pojo.EasyUIDataGripResult;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 25/08/2018
 * Time: 19:07
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getItemById(long itemId) {

//        TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();

        criteria.andIdEqualTo(itemId);


        List <TbItem> list = itemMapper.selectByExample(example);


        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;

    }

    @Override
    public EasyUIDataGripResult getItemList(int page, int rows) {
        PageHelper.startPage(page, rows);

        TbItemExample example = new TbItemExample();


        List <TbItem> list = itemMapper.selectByExample(example);

        EasyUIDataGripResult result = new EasyUIDataGripResult();

        result.setRows(list);

        System.out.println("已经查询");

        PageInfo <TbItem> pageInfo = new PageInfo <>(list);


        result.setTotal(pageInfo.getTotal());

        return result;
    }
}