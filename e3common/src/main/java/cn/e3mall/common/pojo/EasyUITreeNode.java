package cn.e3mall.common.pojo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 26/08/2018
 * Time: 13:01
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class EasyUITreeNode implements Serializable {


    private long id;
    private String text;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private String state;


}