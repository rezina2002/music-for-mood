package ru.mirea.ikb.mood.repository.impl;

import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;
import ru.mirea.ikb.mood.dto.Playlist;

import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MoodRepositoryImplTest {

    private final MoodRepositoryImpl moodRepository = new MoodRepositoryImpl();

    @Test
    void testAddAndFind() {
        assertTrue(moodRepository.findAllMoods().isEmpty());
        Playlist pl1 = new Playlist("pl1", "url1");
        Playlist pl2 = new Playlist("pl2", "url2");
        Playlist pl3 = new Playlist("pl3", "url3");
        Playlist pl4 = new Playlist("pl4", "url4");
        moodRepository.addPlaylist("mood1", pl1);
        moodRepository.addPlaylist("mood1", pl2);
        moodRepository.addPlaylist("mood1", pl3);
        moodRepository.addPlaylist("mood2", pl1);
        moodRepository.addPlaylist("mood2", pl4);

        assertEquals(Sets.newSet("mood1", "mood2"), moodRepository.findAllMoods());
        Optional<Collection<Playlist>> mood1 = moodRepository.playlists("mood1");
        assertTrue(mood1.isPresent());
        assertEquals(Sets.newSet(pl1, pl2, pl3), mood1.get());

        Optional<Collection<Playlist>> mood2 = moodRepository.playlists("mood2");
        assertTrue(mood2.isPresent());
        assertEquals(Sets.newSet(pl1, pl4), mood2.get());

        assertFalse(moodRepository.playlists("notFound").isPresent());
    }
}