package com.hu.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author allnas
 * @since 2018-07-27
 */
@TableName("operation_log")
public class OperationLog extends Model<OperationLog> {

    private static final long serialVersionUID = 1L;
    @TableId(value="id", type= IdType.AUTO)
    private Integer id;
    /**
     * 系统模块
     */
    @TableField("oper_moudel")
    private String operMoudel;
    /**
     * 操作类型1-新增2-编辑3-删除
     */
    @TableField("oper_type")
    private String  operType;
    /**
     * 操作的表
     */
    @TableField("oper_table")
    private String operTable;
    /**
     * 操作内容
     */
    @TableField("oper_content")
    private String operContent;
    /**
     * 操作时间
     */
    @TableField("oper_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime operTime;
    /**
     * 操作人
     */
    @TableField("oper_id")
    private Integer operId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperMoudel() {
        return operMoudel;
    }

    public void setOperMoudel(String operMoudel) {
        this.operMoudel = operMoudel;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getOperTable() {
        return operTable;
    }

    public void setOperTable(String operTable) {
        this.operTable = operTable;
    }

    public String getOperContent() {
        return operContent;
    }

    public void setOperContent(String operContent) {
        this.operContent = operContent;
    }

    public LocalDateTime getOperTime() {
        return operTime;
    }

    public void setOperTime(LocalDateTime operTime) {
        this.operTime = operTime;
    }

    public Integer getOperId() {
        return operId;
    }

    public void setOperId(Integer operId) {
        this.operId = operId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "OperationLog{" +
        ", id=" + id +
        ", operMoudel=" + operMoudel +
        ", operType=" + operType +
        ", operTable=" + operTable +
        ", operContent=" + operContent +
        ", operTime=" + operTime +
        ", operId=" + operId +
        "}";
    }
}
