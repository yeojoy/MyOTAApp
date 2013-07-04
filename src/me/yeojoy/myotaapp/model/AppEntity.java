package me.yeojoy.myotaapp.model;

public class AppEntity {
    public String appTitle;
    public String appDesc;
    public String appPackageName;
    
    public int versionCode = -1;
    
    public int iconResouceId = -1;
    
    public AppEntity() {}
    
    public AppEntity(int iconResourceId, String appTitle, String appDesc) {
        this.iconResouceId = iconResourceId;
        this.appTitle = appTitle;
        this.appDesc = appDesc;
    }
}
