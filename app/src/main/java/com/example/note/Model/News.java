package com.example.note.Model;

public class News {
    private int newsID;
    private String newsTitle;
    private String newsContent;

    public News(){

    }

    public News(int newsID, String newsTitle, String newsContent) {
        this.newsID = newsID;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
    }

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }
}
