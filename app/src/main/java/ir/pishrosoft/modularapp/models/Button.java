package ir.pishrosoft.modularapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Button {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("apiUrl")
    @Expose
    private String apiUrl;

    /**
     * No args constructor for use in serialization
     *
     */
    public Button() {
    }

    /**
     *
     * @param icon
     * @param title
     * @param apiUrl
     * @param type
     */
    public Button(String type, String title, String icon, String apiUrl) {
        super();
        this.type = type;
        this.title = title;
        this.icon = icon;
        this.apiUrl = apiUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

}