package ru.mirea.ikb.mood.repository;

import ru.mirea.ikb.mood.dto.Playlist;

import java.util.Collection;
import java.util.Optional;

/**
 * Интерфейс для репозитория который хранит плейлисты по настроениями
 */
public interface MoodRepository {

    /**
     * Возвращает названия всех настроений для поиск связанных плейлистов
     * @return коллекцию названий настроений
     */
    Collection<String> findAllMoods();

    /**
     * Коллекция плейлистов для переданного настроения
     * @param mood название настроения
     * @return Optional коллекции плейлистов
     */
    Optional<Collection<Playlist>> playlists(String mood);

    /**
     * Добавляет плейлист к настроению
     * @param mood название настроения
     * @param playlist плейлист для настроения
     */
    void addPlaylist(String mood, Playlist playlist);
}
