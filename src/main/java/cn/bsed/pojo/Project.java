package cn.bsed.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Project implements Serializable {
    private Integer id;

    private Integer categoryId;

    private String categoryType;

    private String title;

    private String description;

    private Date createDate;

    private String name;

    private String owner;

    private String location;

    private String area;

    @DateTimeFormat(pattern = "yyyy")
    private Date time;

    private String projectPageUrl;

    private String imageUrl;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getProjectPageUrl() {
        return projectPageUrl;
    }

    public void setProjectPageUrl(String projectPageUrl) {
        this.projectPageUrl = projectPageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Project other = (Project) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getCategoryType() == null ? other.getCategoryType() == null : this.getCategoryType().equals(other.getCategoryType()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getOwner() == null ? other.getOwner() == null : this.getOwner().equals(other.getOwner()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getProjectPageUrl() == null ? other.getProjectPageUrl() == null : this.getProjectPageUrl().equals(other.getProjectPageUrl()))
            && (this.getImageUrl() == null ? other.getImageUrl() == null : this.getImageUrl().equals(other.getImageUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getCategoryType() == null) ? 0 : getCategoryType().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getOwner() == null) ? 0 : getOwner().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getProjectPageUrl() == null) ? 0 : getProjectPageUrl().hashCode());
        result = prime * result + ((getImageUrl() == null) ? 0 : getImageUrl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categoryType=").append(categoryType);
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", createDate=").append(createDate);
        sb.append(", name=").append(name);
        sb.append(", owner=").append(owner);
        sb.append(", location=").append(location);
        sb.append(", area=").append(area);
        sb.append(", time=").append(time);
        sb.append(", projectPageUrl=").append(projectPageUrl);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}