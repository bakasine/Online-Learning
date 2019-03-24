package com.uerax.learning.domain;

import java.util.List;

/**
 * @author uerax
 * @date 2018/12/29 16:55
 */
public class Message<E> {

    // 0为执行失败
    private Integer status = 1;
    private String msg = "";
    private List<E> list;
    // 0为Admin
    private Integer isAdmin = 1;

    public Integer getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Integer admin) {
        isAdmin = admin;
    }

    public Integer getStatus() {
        return status;
    }

    public void falseStatus() {
        setStatus(0);
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }
}
