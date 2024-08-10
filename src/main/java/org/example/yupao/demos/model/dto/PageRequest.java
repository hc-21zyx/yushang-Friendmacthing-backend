package org.example.yupao.demos.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageRequest implements Serializable {
    /**
     * 每一页的大小
     */

    protected int pageSize = 10;
    /**
     * 当前是第几页
     */
    protected int pageNum = 1;
}
