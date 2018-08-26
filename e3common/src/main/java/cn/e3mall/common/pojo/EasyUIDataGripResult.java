package cn.e3mall.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 26/08/2018
 * Time: 12:27
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class EasyUIDataGripResult implements Serializable {


    private long total;
    private List rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}