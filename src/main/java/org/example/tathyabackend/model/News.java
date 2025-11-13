package org.example.tathyabackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Document(collection = "news")
public class News {

    @Id
    private String id;

    private String url;

    private String title;

    private String category;

    private String lead;

    private String description;

    private LocalDate postedAt;

    private String imageUrl;

    private String language;

    private String newsPortal;

    private Metrics metrics;

    private String summary;


    public News() {
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getLead() {
        return lead;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getPostedAt() {
        return postedAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getLanguage() {
        return language;
    }

    public String getNewsPortal() {
        return newsPortal;
    }

    public Metrics getMetrics() {
        return metrics;
    }

    public String getSummary() {
        return summary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPostedAt(LocalDate postedAt) {
        this.postedAt = postedAt;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setNewsPortal(String newsPortal) {
        this.newsPortal = newsPortal;
    }

    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}