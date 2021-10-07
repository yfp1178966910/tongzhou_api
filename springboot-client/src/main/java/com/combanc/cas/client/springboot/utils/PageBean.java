package com.combanc.cas.client.springboot.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Three
 *
 * @param <T>
 */
public class PageBean<T> {
	
	 /** 行实体类 */
    private List<T> rows = new ArrayList<T>();
    
    /** 总条数 */
    private int total;

    public PageBean() {
        super();
    }

    public PageBean(List<T> list, int total){
        this.rows =list;
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
