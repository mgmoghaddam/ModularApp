package ir.pishrosoft.modularapp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Type1Data {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("dscp")
    @Expose
    private String dscp;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("photos")
    @Expose
    private List<String> photos = null;
    @SerializedName("projectStatus")
    @Expose
    private Object projectStatus;
    @SerializedName("projectEmployer")
    @Expose
    private Object projectEmployer;
    @SerializedName("projectStartDate")
    @Expose
    private Object projectStartDate;
    @SerializedName("projectEndDate")
    @Expose
    private Object projectEndDate;
    @SerializedName("contentType")
    @Expose
    private Object contentType;
    @SerializedName("mediaType")
    @Expose
    private Object mediaType;

    /**
     * No args constructor for use in serialization
     *
     */
    public Type1Data() {
    }

    /**
     *
     * @param imageUrl
     * @param contentType
     * @param date
     * @param mediaType
     * @param url
     * @param id
     * @param photos
     * @param author
     * @param projectStatus
     * @param title
     * @param projectStartDate
     * @param dscp
     * @param projectEmployer
     * @param projectEndDate
     */
    public Type1Data(Integer id, String title, String date, String author, String dscp, String imageUrl, String url, List<String> photos, Object projectStatus, Object projectEmployer, Object projectStartDate, Object projectEndDate, Object contentType, Object mediaType) {
        super();
        this.id = id;
        this.title = title;
        this.date = date;
        this.author = author;
        this.dscp = dscp;
        this.imageUrl = imageUrl;
        this.url = url;
        this.photos = photos;
        this.projectStatus = projectStatus;
        this.projectEmployer = projectEmployer;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
        this.contentType = contentType;
        this.mediaType = mediaType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDscp() {
        return dscp;
    }

    public void setDscp(String dscp) {
        this.dscp = dscp;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public Object getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Object projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Object getProjectEmployer() {
        return projectEmployer;
    }

    public void setProjectEmployer(Object projectEmployer) {
        this.projectEmployer = projectEmployer;
    }

    public Object getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(Object projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public Object getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(Object projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public Object getContentType() {
        return contentType;
    }

    public void setContentType(Object contentType) {
        this.contentType = contentType;
    }

    public Object getMediaType() {
        return mediaType;
    }

    public void setMediaType(Object mediaType) {
        this.mediaType = mediaType;
    }

}