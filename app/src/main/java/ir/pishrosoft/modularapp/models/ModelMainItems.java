package ir.pishrosoft.modularapp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ir.pishrosoft.modularapp.models.Button;

public class ModelMainItems {

    @SerializedName("appTitle")
    @Expose
    private String appTitle;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("logoUrl")
    @Expose
    private String logoUrl;
    @SerializedName("baseUrl")
    @Expose
    private String baseUrl;
    @SerializedName("buttons")
    @Expose
    private List<Button> buttons = null;

    public String getAppTitle() {
        return appTitle;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

}