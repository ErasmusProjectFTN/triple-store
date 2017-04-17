package com.ErasmusProject.model;

/**
 *
 * @author Nina
 */
public class CourseSearch {
    
    private String id;
    private String title;
    private String type;
    private String unitLevel;
    private Integer yearOfStudy;
    private Double credits;
    private String language;
    private String termPattern;
    private Double duration;
    private Double cost;
    
    public CourseSearch(){
        this.id = "";
        this.title = "";
        this.type = "";
        this.unitLevel = "";
        this.yearOfStudy = -1;
        this.credits = -1.0;
        this.language = "";
        this.termPattern = "";
        this.duration = -1.0;
        this.cost = -1.0;
    }

    public CourseSearch(String id, String title, String type, String unitLevel, Integer yearOfStudy, Double credits, String language, String termPattern, Double duration, Double cost) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.unitLevel = unitLevel;
        this.yearOfStudy = yearOfStudy;
        this.credits = credits;
        this.language = language;
        this.termPattern = termPattern;
        this.duration = duration;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getUnitLevel() {
        return unitLevel;
    }

    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    public Double getCredits() {
        return credits;
    }

    public String getLanguage() {
        return language;
    }

    public String getTermPattern() {
        return termPattern;
    }

    public Double getDuration() {
        return duration;
    }

    public Double getCost() {
        return cost;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUnitLevel(String unitLevel) {
        this.unitLevel = unitLevel;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setTermPattern(String termPattern) {
        this.termPattern = termPattern;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "CourseSearch{" + "id=" + id + ", title=" + title + ", type=" + type + ", unitLevel=" + unitLevel + ", yearOfStudy=" + yearOfStudy + ", credits=" + credits + ", language=" + language + ", termPattern=" + termPattern + ", duration=" + duration + ", cost=" + cost + '}';
    }
    
}
