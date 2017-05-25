package com.doge.blog.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Taxonomy implements Serializable {
    private Long id;

    private String title;

    private String slug;

    private String type;

    private String icon;

    private String contentModule;

    private Integer contentCount;

    private Integer orderNumber;

    private Long parentId;

    private Long objectId;

    private String flag;

    private BigDecimal lat;

    private BigDecimal lng;

    private String metaKeywords;

    private String metaDescription;

    private Date created;

    private String text;

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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug == null ? null : slug.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getContentModule() {
        return contentModule;
    }

    public void setContentModule(String contentModule) {
        this.contentModule = contentModule == null ? null : contentModule.trim();
    }

    public Integer getContentCount() {
        return contentCount;
    }

    public void setContentCount(Integer contentCount) {
        this.contentCount = contentCount;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", slug=").append(slug);
        sb.append(", type=").append(type);
        sb.append(", icon=").append(icon);
        sb.append(", contentModule=").append(contentModule);
        sb.append(", contentCount=").append(contentCount);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", parentId=").append(parentId);
        sb.append(", objectId=").append(objectId);
        sb.append(", flag=").append(flag);
        sb.append(", lat=").append(lat);
        sb.append(", lng=").append(lng);
        sb.append(", metaKeywords=").append(metaKeywords);
        sb.append(", metaDescription=").append(metaDescription);
        sb.append(", created=").append(created);
        sb.append(", text=").append(text);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}