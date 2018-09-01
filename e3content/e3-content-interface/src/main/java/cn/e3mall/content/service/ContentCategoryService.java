package cn.e3mall.content.service;

import cn.e3mall.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 01/09/2018
 * Time: 10:51
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public interface ContentCategoryService {

    List <EasyUITreeNode> getContentCatList(long parentId);
}