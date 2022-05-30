package ru.mirea.ikb.mood.view;

import ru.mirea.ikb.mood.dto.Playlist;

import java.util.Collection;

/**
 * Model для UI содержащая название настроения и список плейлистов
 */
public class Mood {

    /**
     * Настроение
     */
    private final String name;

    /**
     * Список плейлистов
     */
    private final Collection<Playlist> playlists;

    /**
     * Конструктор
     * @param name настроение
     * @param playlists плейлисты
     */
    public Mood(String name, Collection<Playlist> playlists) {
        this.name = name;
        this.playlists = playlists;
    }

    /**
     * Геттер для настроения
     * @return название настроения
     */
    public String getName() {
        return name;
    }

    /**
     * Геттер для списка плейлистов
     * @return коллекция плейлистов
     */
    public Collection<Playlist> getPlaylists() {
        return playlists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mood mood = (Mood) o;

        if (name != null ? !name.equals(mood.name) : mood.name != null) return false;
        return playlists != null ? playlists.equals(mood.playlists) : mood.playlists == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (playlists != null ? playlists.hashCode() : 0);
        return result;
    }
}
