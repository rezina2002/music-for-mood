package ru.mirea.ikb.mood;

import org.h2.tools.Csv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import ru.mirea.ikb.mood.dto.Playlist;
import ru.mirea.ikb.mood.repository.impl.MoodRepositoryImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Конфигурация создания бинов для контекста spring
 */
@Configuration
public class ApplicationConfiguration {

    /**
     * Создание репозитория связывающего настрояния с плейлистами. С помощью утилиты CSV вычитывается файл
     * и полученный ResultSet содержит 3 колонки: настроение, название плейлиста и ссылка на плейлист
     * @return заполненный репозиторий в котором плейлисты привязаны к соотв. настроению
     * @param playlistFileName название csv файла со списком плейлистов
     * @throws SQLException в случае ошибки чтения данных из csv
     * @throws IOException в случае отсутствия файла или прав на чтение
     */
    @Bean
    MoodRepositoryImpl moodRepository(@Value("${playlist.csv.file:sql/playlists.csv}") String playlistFileName
    ) throws SQLException, IOException {
        MoodRepositoryImpl moodRepository = new MoodRepositoryImpl();
        InputStream inputStream = new ClassPathResource(playlistFileName).getInputStream();
        ResultSet rs = new Csv().read(new InputStreamReader(inputStream, StandardCharsets.UTF_8), null);
        while (rs.next()) {
            moodRepository.addPlaylist(
                    rs.getString(1),
                    new Playlist(rs.getString(2), rs.getString(3))
            );
        }
        rs.close();
        return moodRepository;
    }
}
