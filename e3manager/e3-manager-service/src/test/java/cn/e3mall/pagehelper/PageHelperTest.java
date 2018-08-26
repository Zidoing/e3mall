package cn.e3mall.pagehelper;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 26/08/2018
 * Time: 12:19
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class PageHelperTest {


    @Test
    public void testPageHelper() {

        // 初始化spring 容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");

        //从容器树中获取mapper对象
        TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
        // 执行sql 语句之前设置分页信息使用pagehelper 的startpage方法

        PageHelper.startPage(1, 10);

        // 执行查询
        TbItemExample example = new TbItemExample();


        List <TbItem> tbItems = itemMapper.selectByExample(example);

        // 去分页信息 pageinfo  总记录数 总页数 当钱页码

        PageInfo <TbItem> pa = new PageInfo <>(tbItems);


        System.out.println(pa.getTotal());

        System.out.println(pa.getPages());


        System.out.println(pa.getEndRow());

    }
}