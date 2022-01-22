package com.hashedin.assignment.milestone2.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Titles {
    private String showId;
    private String type;
    private String title;
    private String director;
    private String cast;
    private String country;
    private Date dateAdded;
    private String releaseYear;
    private String rating;
    private String duration;
    private String listedIn;
    private String description;

    public Titles(String showId, String type, String title, String director, String cast, String country,
                  String dateAdded, String releaseYear, String rating, String duration, String listedIn, String description) {
        this.showId = showId;
        this.type = type;
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.country = country;
        if (!dateAdded.isEmpty()) {
            this.dateAdded = evaluateDate(dateAdded);
        }
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.duration = duration;
        this.listedIn = listedIn;
        this.description = description;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getListedIn() {
        return listedIn;
    }

    public void setListedIn(String listedIn) {
        this.listedIn = listedIn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date evaluateDate(String date) {
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yy");
            return format1.parse(date);
        } catch (ParseException e) {
            try {
                date = date.substring(1, date.length() - 1).trim();
                SimpleDateFormat format1 = new SimpleDateFormat("MMMM dd, yyyy");
                return format1.parse(date);
            } catch (ParseException e1) {
                e1.printStackTrace();
                return new Date();
            }
        }
    }
}
