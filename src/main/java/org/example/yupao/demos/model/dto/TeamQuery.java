package org.example.yupao.demos.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class TeamQuery implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 队伍名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 最大人数
     */
    private Integer maxNum;

    /**
     * 每一页的大小
     */

    protected int pageSize = 10;
    /**
     * 当前是第几页
     */
    protected int pageNum = 1;
}
