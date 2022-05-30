package ru.mirea.ikb.mood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mirea.ikb.mood.repository.MoodRepository;
import ru.mirea.ikb.mood.view.Mood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Web контроллер который перенаправлет все запросы на index.jsp и заполняет атрибут moods у модели (Model)
 * со список плейлистов.
 */
@Controller
@RequestMapping
public class MoodController {

    /**
     * Сыылка на репозиторий с настроениями и соответствующими плейлистами
     */
    @Autowired
    private MoodRepository moodRepository;

    /**
     * Получение списка плейлистов из репозитория для каждого настроения и создаёт объект Mood содержащий
     * список всех плейлистов для каждого настроения
     * @param model Ссылка на модель, которая будет передана для отображения
     * @return возвращает имя представления (View)
     */
    @GetMapping("/*")
    public String main(Model model) {
        Collection<String> moodNames = moodRepository.findAllMoods();
        List<Mood> moods = new ArrayList<>();
        for (String moodName : moodNames) {
            moodRepository.playlists(moodName).ifPresent(playlists -> moods.add(new Mood(moodName, playlists)));
        }
        model.addAttribute("moods", moods);
        return "index";
    }
}
