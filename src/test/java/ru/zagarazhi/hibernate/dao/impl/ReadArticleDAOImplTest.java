package ru.zagarazhi.hibernate.dao.impl;

import ru.zagarazhi.hibernate.dao.ArticleDAO;
import ru.zagarazhi.hibernate.model.persistence.Article;

import static org.junit.Assert.*;
import static ru.zagarazhi.AppTest.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

public class ReadArticleDAOImplTest {
    private final ArticleDAO dao = new ArticleDAOImpl();

    @Test
    public void findArticleByID(){
        Article expected = ARTICLE_1;
        Optional<Article> actual = dao.findById(1L);

        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

    @Test
    public void findAll(){
        List<Article> expected = Arrays.asList(ARTICLE_1, ARTICLE_2, ARTICLE_3,
                                                ARTICLE_4, ARTICLE_5, ARTICLE_6,
                                                ARTICLE_7, ARTICLE_8, ARTICLE_9,
                                                ARTICLE_10, ARTICLE_11);
        List<Article> actual = dao.findAll();

        assertFalse(expected.isEmpty());
        assertTrue(actual.size() == expected.size());
        for(int i = 0; i < actual.size(); i++){
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void findByStartsAutorLastName() {
        String startsName = "Start";

        List<Article> articles = dao.findByStartsAutorLastName(startsName);

        assertFalse(articles.isEmpty());

        for (Article article : articles) {
            assertTrue(article.getAutor().getLastName().startsWith(startsName));
        }
    }
}
