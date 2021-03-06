/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


/**
 *
 * @author ASUS
 */
public class News {
    
    private String news_id;      
    private String news_title;
    private String news_description;
    private String news_img  ;      
    private String news_type ;

    public News() {
    }

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_description() {
        return news_description;
    }

    public void setNews_description(String news_description) {
        this.news_description = news_description;
    }

    public String getNews_img() {
        return news_img;
    }

    public void setNews_img(String news_img) {
        this.news_img = news_img;
    }

    public String getNews_type() {
        return news_type;
    }

    public void setNews_type(String news_type) {
        this.news_type = news_type;
    }

    @Override
    public String toString() {
        return "News{" + "news_id=" + news_id + ", news_title=" + news_title + ", news_description=" + news_description + ", news_img=" + news_img + ", news_type=" + news_type + '}';
    }
    
    
    
    
}

