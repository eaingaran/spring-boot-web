package uk.co.jemos.experiments.spring.boot.jackson;

import java.util.*;

/**
 * Created by tedonema on 09/05/2015.
 */
public class Album {

    private String title;

    private String[] links;

    List<String> songs = new ArrayList<String>();

    private Artist artist;

    private Map<String,String> musicians = new HashMap<String, String>();

    public Album() {}

    public Album(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getLinks() {
        return links;
    }

    public void setLinks(String[] links) {
        this.links = links;
    }

    public List<String> getSongs() {
        return Collections.unmodifiableList(songs);
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Map<String, String> getMusicians() {
        return Collections.unmodifiableMap(musicians);
    }
    public void addMusician(String key, String value){
        musicians.put(key, value);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Album{");
        sb.append("title='").append(title).append('\'');
        sb.append(", links=").append(Arrays.toString(links));
        sb.append(", songs=").append(songs);
        sb.append(", artist=").append(artist);
        sb.append(", musicians=").append(musicians);
        sb.append('}');
        return sb.toString();
    }
}
