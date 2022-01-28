package cn.egret.entity;

import java.util.List;

public class Page<T> {
    private int curPage; // 当前页
    private int pageSize; // 每页的数据量
    private int pageCount; // 总页数
    private long dataCount; // 总数据量
    private List<T> data; // 当前的数据

    public Page() {

    }

    public Page(int curPage, int pageSize, long dataCount, List<T> data) {
        this.curPage = curPage;
        this.pageSize = pageSize;
        this.dataCount = dataCount;
        this.data = data;
        this.pageCount = (int) (this.dataCount % this.pageSize == 0 ? this.dataCount / this.pageSize : this.dataCount / this.pageSize + 1);
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public long getDataCount() {
        return dataCount;
    }

    public void setDataCount(long dataCount) {
        this.dataCount = dataCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Page{" +
                "curPage=" + curPage +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", dataCount=" + dataCount +
                ", data=" + data +
                '}';
    }
}
