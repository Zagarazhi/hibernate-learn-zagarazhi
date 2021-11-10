package ru.zagarazhi;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.BeforeClass;
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

    public static final Article ARTICLE_1 = new Article();
    public static final Article ARTICLE_2 = new Article();
    public static final Article ARTICLE_3 = new Article();
    public static final Article ARTICLE_4 = new Article();
    public static final Article ARTICLE_5 = new Article();
    public static final Article ARTICLE_6 = new Article();
    public static final Article ARTICLE_7 = new Article();
    public static final Article ARTICLE_8 = new Article();
    public static final Article ARTICLE_9 = new Article();
    public static final Article ARTICLE_10 = new Article();
    public static final Article ARTICLE_11 = new Article();

    public static final Autor AUTOR_1 = new Autor();
    public static final Autor AUTOR_2 = new Autor();

    public static final Reader READER_1 = new Reader();
    public static final Reader READER_2 = new Reader();

    @BeforeClass
    public static void onStart() {
        deleteData();
        loadData();
    }

    @AfterClass
    public static void onEnd() {
        deleteData();
    }

    public static void deleteData() {
        ARTICLE_DAO
                .findAll()
                .forEach(article -> ARTICLE_DAO.deleteById(article.getId()));
        AUTOR_DAO
                .findAll()
                .forEach(autor -> AUTOR_DAO.deleteById(autor.getId()));
        READER_DAO
                .findAll()
                .forEach(reader -> READER_DAO.deleteById(reader.getId()));
    }

    public static void loadData() {
        ARTICLE_1.setName("Test Article Name 1");
        ARTICLE_1.setDate(LocalDate.of(1999, 1, 1));
        ARTICLE_1.setAutor(AUTOR_1);

        ARTICLE_2.setName("Test Article Name 2");
        ARTICLE_2.setDate(LocalDate.of(1999, 2, 1));
        ARTICLE_2.setAutor(AUTOR_1);

        ARTICLE_3.setName("Test Article Name 3");
        ARTICLE_3.setDate(LocalDate.of(1999, 3, 1));
        ARTICLE_3.setAutor(AUTOR_1);

        ARTICLE_4.setName("Test Article Name 4");
        ARTICLE_4.setDate(LocalDate.of(1999, 4, 1));
        ARTICLE_4.setAutor(AUTOR_1);

        ARTICLE_5.setName("Test Article Name 5");
        ARTICLE_5.setDate(LocalDate.of(1999, 5, 1));
        ARTICLE_5.setAutor(AUTOR_1);

        ARTICLE_6.setName("Test Article Name 6");
        ARTICLE_6.setDate(LocalDate.of(1999, 6, 1));
        ARTICLE_6.setAutor(AUTOR_1);

        ARTICLE_7.setName("Test Article Name 7");
        ARTICLE_7.setDate(LocalDate.of(1999, 7, 1));
        ARTICLE_7.setAutor(AUTOR_1);

        ARTICLE_8.setName("Test Article Name 8");
        ARTICLE_8.setDate(LocalDate.of(1999, 8, 1));
        ARTICLE_8.setAutor(AUTOR_1);

        ARTICLE_9.setName("Test Article Name 9");
        ARTICLE_9.setDate(LocalDate.of(1999, 9, 1));
        ARTICLE_9.setAutor(AUTOR_1);

        ARTICLE_10.setName("Test Article Name 10");
        ARTICLE_10.setDate(LocalDate.of(1999, 10, 1));
        ARTICLE_10.setAutor(AUTOR_2);

        ARTICLE_11.setName("Test Article Name 11");
        ARTICLE_11.setDate(LocalDate.of(1999, 11, 1));
        ARTICLE_11.setAutor(AUTOR_2);


        AUTOR_1.setFirstName("Test Autor FirstName 1");
        AUTOR_1.setLastName("Start Test Autor LastName 1");
        AUTOR_1.setBirthday(LocalDate.of(1970, 1, 10));
        AUTOR_1.setArticles(Arrays.asList(ARTICLE_1, ARTICLE_2, ARTICLE_3,
                                            ARTICLE_4, ARTICLE_5, ARTICLE_6,
                                            ARTICLE_7, ARTICLE_8, ARTICLE_9));
        
        AUTOR_2.setFirstName("Test Autor FirstName 2");
        AUTOR_2.setLastName("Test Autor LastName 2");
        AUTOR_2.setBirthday(LocalDate.of(1972, 2, 20));
        AUTOR_2.setArticles(Arrays.asList(ARTICLE_10, ARTICLE_11));


        READER_1.setFirstName("Test Reader FirstName 1");
        READER_1.setLastName("Test Reader LastName 1");
        READER_1.setMail("testmail1@mail.ru");
        READER_1.setArticles(Arrays.asList(ARTICLE_1, ARTICLE_2, ARTICLE_3,
                                            ARTICLE_4, ARTICLE_5, ARTICLE_6,
                                            ARTICLE_7, ARTICLE_8, ARTICLE_10));
        
        READER_2.setFirstName("Test Reader FirstName 2");
        READER_2.setLastName("Test Reader LastName 2");
        READER_2.setMail("testmail2@mail.ru");
        READER_2.setArticles(Arrays.asList(ARTICLE_9, ARTICLE_11));


        ARTICLE_DAO.save(ARTICLE_1);
        ARTICLE_DAO.save(ARTICLE_2);
        ARTICLE_DAO.save(ARTICLE_3);
        ARTICLE_DAO.save(ARTICLE_4);
        ARTICLE_DAO.save(ARTICLE_5);
        ARTICLE_DAO.save(ARTICLE_6);
        ARTICLE_DAO.save(ARTICLE_7);
        ARTICLE_DAO.save(ARTICLE_8);
        ARTICLE_DAO.save(ARTICLE_9);
        ARTICLE_DAO.save(ARTICLE_10);
        ARTICLE_DAO.save(ARTICLE_11);

        AUTOR_DAO.save(AUTOR_1);
        AUTOR_DAO.save(AUTOR_2);

        READER_DAO.save(READER_1);
        READER_DAO.save(READER_2);
    }
}
