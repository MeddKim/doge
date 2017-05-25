package com.doge.blog.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Comment implements Serializable {
    private Long id;

    private Long parentId;

    private Long contentId;

    private String contentModule;

    private Integer commentCount;

    private Integer orderNumber;

    private Long userId;

    private String ip;

    private String author;

    private String type;

    private String text;

    private String agent;

    private Date created;

    private String slug;

    private String email;

    private String status;

    private Integer voteUp;

    private Integer voteDown;

    private String flag;

    private BigDecimal lat;

    private BigDecimal lng;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getContentModule() {
        return contentModule;
    }

    public void setContentModule(String contentModule) {
        this.contentModule = contentModule == null ? null : contentModule.trim();
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent == null ? null : agent.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug == null ? null : slug.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getVoteUp() {
        return voteUp;
    }

    public void setVoteUp(Integer voteUp) {
        this.voteUp = voteUp;
    }

    public Integer getVoteDown() {
        return voteDown;
    }

    public void setVoteDown(Integer voteDown) {
        this.voteDown = voteDown;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", contentId=").append(contentId);
        sb.append(", contentModule=").append(contentModule);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", userId=").append(userId);
        sb.append(", ip=").append(ip);
        sb.append(", author=").append(author);
        sb.append(", type=").append(type);
        sb.append(", text=").append(text);
        sb.append(", agent=").append(agent);
        sb.append(", created=").append(created);
        sb.append(", slug=").append(slug);
        sb.append(", email=").append(email);
        sb.append(", status=").append(status);
        sb.append(", voteUp=").append(voteUp);
        sb.append(", voteDown=").append(voteDown);
        sb.append(", flag=").append(flag);
        sb.append(", lat=").append(lat);
        sb.append(", lng=").append(lng);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}