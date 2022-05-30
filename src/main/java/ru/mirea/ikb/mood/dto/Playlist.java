package ru.mirea.ikb.mood.dto;

public class Playlist {

    private final String name;
    private final String url;

    public Playlist(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Playlist playlist = (Playlist) o;

        if (name != null ? !name.equals(playlist.name) : playlist.name != null) return false;
        return url != null ? url.equals(playlist.url) : playlist.url == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
