package com.netflix.app.utlis;

public class SliderData {
    private String Id;
    private String Thumbnail;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        Thumbnail = thumbnail;
    }



    public SliderData(String id, String thumbnail) {
        Id = id;
        Thumbnail = thumbnail;
    }



}
