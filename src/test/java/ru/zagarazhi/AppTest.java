package ru.zagarazhi;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ru.zagarazhi.hibernate.dao.ArticleDAO;
import ru.zagarazhi.hibernate.dao.AutorDAO;
import ru.zagarazhi.hibernate.dao.ReaderDAO;
import ru.zagarazhi.hibernate.dao.impl.ArticleDAOImpl;
import ru.zagarazhi.hibernate.dao.impl.AutorDAOImpl;
import ru.zagarazhi.hibernate.dao.impl.ReadArticleDAOImplTest;
import ru.zagarazhi.hibernate.dao.impl.ReaderDAOImpl;
import ru.zagarazhi.hibernate.dao.impl.WriteArticleDAOImplTest;
import ru.zagarazhi.hibernate.model.persistence.Article;
import ru.zagarazhi.hibernate.model.persistence.Autor;
import ru.zagarazhi.hibernate.model.persistence.Reader;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ReadArticleDAOImplTest.class,
    WriteArticleDAOImplTest.class
})
public class AppTest {
    private static final ArticleDAO ARTICLE_DAO = new ArticleDAOImpl();
    private static final AutorDAO AUTOR_DAO = new AutorDAOImpl();
    private static final ReaderDAO READER_DAO = new ReaderDAOImpl();

    private static final Article ARTICLE_1 = new Article();
    private static final Article ARTICLE_2 = new Article();

    private static final Autor AUTOR_1 = new Autor();
    private static final Autor AUTOR_2 = new Autor();

    private static final Reader READER_1 = new Reader();
    private static final Reader READER_2 = new Reader();

    public static void loadData() {
        
    }
}
