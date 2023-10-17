package org.launchcode.artgallery.models;

import java.util.Objects;

public class Artwork {

    private static int nextID = 1;

    private final int id;
    private String title;
    private String artist;

    public Artwork(String title, String artist) {
        this.id = nextID;
        this.title = title;
        this.artist = artist;
        nextID++;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return title + " (" + artist + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artwork artwork)) return false;
        return getId() == artwork.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
