package com.xiaot.factory.entity;

import lombok.Data;

@Data
public class QueryEntity {

    /**
     * 页码
     */
    private Integer pageNo;

    /**
     * 条数
     */
    private Integer pageSize;

    /**
     * 排序字段
     */
    private String field;

    /**
     * 排序方式
     */
    private String order;

    public Integer getPageNo() {
        return pageNo == null ? 0 : (pageNo - 1) * pageSize;
    }

    public Integer getPageSize() {
        return pageSize == null ? 10 : pageNo * pageSize;
    }

}
