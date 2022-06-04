package ru.mirea.ikb.mood.repository.impl;

import ru.mirea.ikb.mood.dto.Playlist;
import ru.mirea.ikb.mood.repository.MoodRepository;

import java.util.*;

/**
 * Реализация интерфейса репозитория с настроениями и плейлистами
 */
public class MoodRepositoryImpl implements MoodRepository {

    /**
     * Map для хранения соответствия настроений и плейлистов
     */
    private final Map<String, Set<Playlist>> storedPlaylists = new HashMap<>();

    /**
     * Возвращает список всех настроений
     * @return коллекция ключей, соответствующая настроениям
     */
    @Override
    public Collection<String> findAllMoods() {
        return storedPlaylists.keySet();
    }

    /**
     * Поиск плейлистов по переданному настроению
     * @param mood название настроения
     * @return возвращает список плейлистов или пустой Optional
     */
    @Override
    public Optional<Collection<Playlist>> playlists(String mood) {
        return Optional.ofNullable(storedPlaylists.get(mood));
    }

    /**
     * Добавляет плейлист к настроению
     * @param mood название настроения
     * @param playlist плейлист для настроения
     */
    @Override
    public void addPlaylist(String mood, Playlist playlist) {
        Set<Playlist> playlists = storedPlaylists.computeIfAbsent(mood, m -> new HashSet<>());
        playlists.add(playlist);
    }
}
