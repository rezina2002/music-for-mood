package ru.mirea.ikb.mood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mirea.ikb.mood.repository.MoodRepository;

import java.util.Collection;

/**
 * Web контроллер который перенаправлет все запросы на index.jsp и заполняет атрибут moods у модели (Model)
 * со списком настроений
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
     * Получение списка настроений из репозитория и сохранения его в атрибут moods у модели
     * @param model Ссылка на модель, которая будет передана для отображения
     * @return возвращает имя представления (View)
     */
    @GetMapping("/*")
    public String main(Model model) {
        Collection<String> moodNames = moodRepository.findAllMoods();
        model.addAttribute("moods", moodNames);
        return "index";
    }
}
