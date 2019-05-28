package com.yubotao.rdstest2.POJO;

public class Banner {
    private String id;

    private String pictureUrl;

    private Integer sort;

    private String title;

    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", sort=" + sort +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}