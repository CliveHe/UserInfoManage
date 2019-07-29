package cn.cliveh.domain;

import java.util.List;

/**
 * 分页
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/7/27
 */
public class Paging<T> {
    /**
     * 数据库总记录数
     */
    private int totalCount;

    /**
     * 总页码 = 总记录数%每页显示条数 == 0 ? 总记录数/每页显示条数 : 总记录数/每页显示条数+1
     */
    private int totalPage;

    /**
     * 每页的显示的数据
     */
    private List<T> list;

    /**
     * 当前页码
     */
    private int currentPage;

    /**
     * 每页需要显示的结果数量pageSize
     */
    private int rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Paging{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }
}
