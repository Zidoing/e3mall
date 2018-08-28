package cn.e3mall.service;

import cn.e3mall.common.pojo.EasyUIDataGripResult;
import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbItem;

public interface ItemService {


    TbItem getItemById(long itemId);

    EasyUIDataGripResult getItemList(int page, int rows);

    E3Result addItem(TbItem item, String desc);


}
