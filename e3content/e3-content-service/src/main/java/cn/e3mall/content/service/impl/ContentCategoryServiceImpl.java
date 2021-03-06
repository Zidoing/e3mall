package cn.e3mall.content.service.impl;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentCategoryService;
import cn.e3mall.mapper.TbContentCategoryMapper;
import cn.e3mall.pojo.TbContentCategory;
import cn.e3mall.pojo.TbContentCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 01/09/2018
 * Time: 10:53
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {


    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;

    @Override
    public List <EasyUITreeNode> getContentCatList(long parentId) {

        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List <TbContentCategory> categoryList = contentCategoryMapper.selectByExample(example);
        ArrayList <EasyUITreeNode> nodelist = new ArrayList <>();
        for (TbContentCategory tbContentCategory : categoryList) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent() ? "closed" : "open");
            nodelist.add(node);
        }
        System.out.println(nodelist);
        return nodelist;
    }

    @Override
    public E3Result addContentCategory(long parentId, String name) {
        TbContentCategory contentCategory = new TbContentCategory();

        contentCategory.setParentId(parentId);
        contentCategory.setName(name);
        contentCategory.setStatus(1);
        contentCategory.setSortOrder(1);
        contentCategory.setIsParent(false);
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(new Date());

        int insert = contentCategoryMapper.insert(contentCategory);

        TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);

        if (!parent.getIsParent()) {
            parent.setIsParent(true);
            contentCategoryMapper.updateByPrimaryKey(parent);
        }

        return E3Result.ok(contentCategory);

    }
}