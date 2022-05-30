package ru.mirea.ikb.mood.repository.impl;

import ru.mirea.ikb.mood.dto.Playlist;
import ru.mirea.ikb.mood.repository.MoodRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class MoodRepositoryImpl implements MoodRepository {

    private final Map<String, Set<Playlist>> storedPlaylists = new HashMap<>();

    @Override
    public Collection<String> findAllMoods() {
        return storedPlaylists.keySet();
    }

    @Override
    public Optional<Collection<Playlist>> playlists(String mood) {
        return Optional.ofNullable(storedPlaylists.get(mood));
    }

    @Override
    public void addPlaylist(String mood, Playlist playlist) {
        Set<Playlist> playlists = storedPlaylists.computeIfAbsent(mood, m -> new HashSet<>());
        playlists.add(playlist);
    }
}
