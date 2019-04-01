package com.multi.webcommon.model;

import java.io.Serializable;
import java.util.Collection;

public class PageModel implements Serializable {
    private static final long serialVersionUID = 1L;

    //总数
    private int rowsCount;
    //当前页码
    private int pageNum;
    //页面大小
    private int pageSize;
    //数据
    private Collection dataSource;
    private int rowStart;
    private int rowEnd;
    private int pageCount;

    public int getRowEnd() {
        return rowEnd;
    }

    public void setRowEnd(int rowEnd) {
        this.rowEnd = rowEnd;
    }

    public PageModel() {
        this.pageSize = 10;
        this.pageNum = 1;
        this.rowStart = (this.pageNum - 1) * this.pageSize;
    }

    public PageModel(int pageNum, int pageSize) {
        if (pageSize <= 0) {
            this.pageSize = 10;
        } else {
            this.pageSize = pageSize;
        }
        if (pageNum <= 0) {
            this.pageNum = 1;
        } else {
            this.pageNum = pageNum;
        }
        this.rowStart = (this.pageNum - 1) * this.pageSize;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        if (rowsCount % pageSize == 0) {
            this.pageCount = rowsCount / pageSize;
        } else {
            this.pageCount = rowsCount / pageSize + 1;
        }
        return pageCount;
    }

    public int getRowsCount() {
        return rowsCount;
    }

    public void setRowsCount(int rowsCount) {
        this.rowsCount = rowsCount;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Collection getDataSource() {
        return dataSource;
    }

    public void setDataSource(Collection dataSource) {
        this.dataSource = dataSource;
    }

    public int getRowStart() {
        return rowStart;
    }

    public void setRowStart(int rowStart) {
        this.rowStart = rowStart;
    }

}
