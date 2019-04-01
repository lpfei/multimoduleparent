package com.multi.webuser.vote.entity;

import java.io.Serializable;
import java.util.Date;

public class VVoteLog implements Serializable {
    private Integer id;

    private String openId;

    private Date createTime;

    private Integer joinUserId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getJoinUserId() {
        return joinUserId;
    }

    public void setJoinUserId(Integer joinUserId) {
        this.joinUserId = joinUserId;
    }
}