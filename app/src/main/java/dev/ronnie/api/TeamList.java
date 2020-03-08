package dev.ronnie.api;

public class TeamList {

    public String key;
    public Boolean active;
    public String group;
    public String title;
    public String details;


    public TeamList(String key, Boolean active, String group, String title, String details) {
        this.key = key;
        this.active = active;
        this.group = group;
        this.title = title;
        this.details = details;
    }

    public TeamList() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
