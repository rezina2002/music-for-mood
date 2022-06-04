package ru.mirea.ikb.mood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.ikb.mood.dto.Playlist;
import ru.mirea.ikb.mood.repository.MoodRepository;

import java.util.Collection;
import java.util.Collections;

/**
 * Определяет мапирование входящих запросов на методы поиска плейлистов в репозитории
 */
@RestController
public class PlaylistController {

    /**
     * Сыылка на репозиторий с настроениями и соответствующими плейлистами
     */
    @Autowired
    private MoodRepository moodRepository;

    /**
     * Метод ищет список плейлистов по настроению
     * @param moodName название настроения
     * @return возвращает список плейлистов или пустую коллекцию
     */
    @GetMapping("/mood/{moodName}")
    public Collection<Playlist> playlists(@PathVariable String moodName) {
        return moodRepository.playlists(moodName).orElse(Collections.emptyList());
    }
}
