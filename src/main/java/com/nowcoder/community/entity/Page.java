package com.nowcoder.community.entity;

/**
 * 封装分页相关的信息.
 */
public class Page {

    // 当前页码，默认为1
    private int current = 1;
    // 显示上限，默认为10
    private int limit = 10;
    // 数据总数(用于计算总页数)
    private int rows;
    // 查询路径(用于复用分页链接)
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) {//设置当前页，如果大于等于1才设置即检验有效性
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {//如果当前每页限制显示的数量在100以内才设置
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows >= 0) {//设置总页码，检验参数
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始行
     *
     * @return
     */
    public int getOffset() {
        // current * limit - limit
        //每页显示的数量减去当前页显示的数量即为首行
        return (current - 1) * limit;
    }

    /**
     * 获取总页数
     *
     * @return
     */
    public int getTotal() {
        // rows / limit [+1]
        if (rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }

    /**
     * 获取起始页码
     *
     * @return
     */
    public int getFrom() {
        //显示三页，所以起始页为当前页减去2
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    /**
     * 获取结束页码
     *
     * @return
     */
    public int getTo() {
        //显示三页，所以末尾页为当前页加2
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }

}
