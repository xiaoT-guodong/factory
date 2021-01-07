package com.xiaot.factory.entity;

import lombok.Data;

@Data
public class PageQueryEntity {

    /**
     * 页码
     */
    private Integer pageNo = 1;

    /**
     * 条数
     */
    private Integer pageSize = 10;

    /**
     * 排序字段
     */
    private String field;

    /**
     * 排序方式
     */
    private String order;

    public Integer getPageNo() {
        return (pageNo - 1) * pageSize;
    }

    public Integer getPageSize() {
        return pageNo * pageSize;
    }

}
