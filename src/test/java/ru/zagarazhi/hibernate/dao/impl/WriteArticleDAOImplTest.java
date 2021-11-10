package ru.zagarazhi.hibernate.dao.impl;

import ru.zagarazhi.hibernate.dao.ArticleDAO;
import ru.zagarazhi.hibernate.dao.AutorDAO;
import ru.zagarazhi.hibernate.model.persistence.Article;
import ru.zagarazhi.hibernate.model.persistence.Autor;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;

public class WriteArticleDAOImplTest {
    private final ArticleDAO dao = new ArticleDAOImpl();
    private final AutorDAO autorDAO = new AutorDAOImpl();
    
    @Test
    public void save() {
        Autor autor = new Autor();
        Article article = new Article();

        autor.setFirstName("new autor firstname");
        autor.setLastName("new autor lastname");
        autor.setBirthday(LocalDate.of(1980, 3, 14));
        autor.setArticles(Arrays.asList(article));

        article.setName("new article");
        article.setDate(LocalDate.of(2000, 4, 25));
        article.setAutor(autor);

        autorDAO.save(autor);
        article = dao.save(article);
        assertFalse(article.getId() == null);
    }

    @Test
    public void incorrectSave() {
        Autor autor = new Autor();
        Article article = new Article();

        autor.setFirstName("new autor firstname");
        autor.setLastName("new autor lastname");
        autor.setBirthday(LocalDate.of(2000, 3, 14));
        autor.setArticles(Arrays.asList(article));

        article.setName("new article");
        article.setDate(LocalDate.of(1980, 4, 25));
        article.setAutor(autor);

        article = dao.save(article);
        assertTrue(article.getId() == null);
    }

    @Test
    public void delete() {
        Long id = 2L;

        dao.deleteById(id);

        Optional<Article> optionalArticle = dao.findById(id);
        assertFalse(optionalArticle.isPresent());
    }
}
