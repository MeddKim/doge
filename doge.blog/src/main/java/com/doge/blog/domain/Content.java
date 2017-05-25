package com.doge.blog.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Content implements Serializable {
    private Long id;

    private String title;

    private String text;

    private String summary;

    private String linkTo;

    private Boolean markdownEnable;

    private String thumbnail;

    private String module;

    private String style;

    private Long userId;

    private String author;

    private String userEmail;

    private String userIp;

    private String userAgent;

    private Long parentId;

    private Long objectId;

    private Integer orderNumber;

    private String status;

    private Integer voteUp;

    private Integer voteDown;

    private Integer rate;

    private Integer rateCount;

    private BigDecimal price;

    private String commentStatus;

    private Integer commentCount;

    private Date commentTime;

    private Integer viewCount;

    private Date created;

    private Date modified;

    private String slug;

    private String flag;

    private BigDecimal lng;

    private BigDecimal lat;

    private String metaKeywords;

    private String metaDescription;

    private String remarks;

    private List<Mapping> mappings;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getLinkTo() {
        return linkTo;
    }

    public void setLinkTo(String linkTo) {
        this.linkTo = linkTo == null ? null : linkTo.trim();
    }

    public Boolean getMarkdownEnable() {
        return markdownEnable;
    }

    public void setMarkdownEnable(Boolean markdownEnable) {
        this.markdownEnable = markdownEnable;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail == null ? null : thumbnail.trim();
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getRateCount() {
        return rateCount;
    }

    public void setRateCount(Integer rateCount) {
        this.rateCount = rateCount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus == null ? null : commentStatus.trim();
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug == null ? null : slug.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords == null ? null : metaKeywords.trim();
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription == null ? null : metaDescription.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public List<Mapping> getMappings() {
        return mappings;
    }

    public void setMappings(List<Mapping> mappings) {
        this.mappings = mappings;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", text=").append(text);
        sb.append(", summary=").append(summary);
        sb.append(", linkTo=").append(linkTo);
        sb.append(", markdownEnable=").append(markdownEnable);
        sb.append(", thumbnail=").append(thumbnail);
        sb.append(", module=").append(module);
        sb.append(", style=").append(style);
        sb.append(", userId=").append(userId);
        sb.append(", author=").append(author);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", userIp=").append(userIp);
        sb.append(", userAgent=").append(userAgent);
        sb.append(", parentId=").append(parentId);
        sb.append(", objectId=").append(objectId);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", status=").append(status);
        sb.append(", voteUp=").append(voteUp);
        sb.append(", voteDown=").append(voteDown);
        sb.append(", rate=").append(rate);
        sb.append(", rateCount=").append(rateCount);
        sb.append(", price=").append(price);
        sb.append(", commentStatus=").append(commentStatus);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", commentTime=").append(commentTime);
        sb.append(", viewCount=").append(viewCount);
        sb.append(", created=").append(created);
        sb.append(", modified=").append(modified);
        sb.append(", slug=").append(slug);
        sb.append(", flag=").append(flag);
        sb.append(", lng=").append(lng);
        sb.append(", lat=").append(lat);
        sb.append(", metaKeywords=").append(metaKeywords);
        sb.append(", metaDescription=").append(metaDescription);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}