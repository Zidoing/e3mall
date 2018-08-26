package cn.e3mall.service;

import cn.e3mall.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 26/08/2018
 * Time: 13:03
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public interface ItemCatService {

    List <EasyUITreeNode> getItemCatList(long parentId);

}