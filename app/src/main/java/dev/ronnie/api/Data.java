package dev.ronnie.api;

import java.util.List;

public class Data {

    public List<TeamList> data;

    public Data(List<TeamList> data) {
        this.data = data;
    }

    public Data() {
    }

    public List<TeamList> getData() {
        return data;
    }

    public void setData(List<TeamList> data) {
        this.data = data;
    }
}
