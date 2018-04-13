package com.gmail.vtc.vlado.news;

public class News {

    private String title;
    private String dateAndTime;
    private String section;
    private String author;
    private String webLink;

    public News(String title, String dateAndTime, String section, String author, String webLink) {
        this.title = title;
        this.dateAndTime = dateAndTime;
        this.section = section;
        this.author = author;
        this.webLink = webLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public String getSection() {
        return section;
    }

    public String getAuthor() {
        return author;
    }

    public String getWebLink() {
        return webLink;
    }
}
