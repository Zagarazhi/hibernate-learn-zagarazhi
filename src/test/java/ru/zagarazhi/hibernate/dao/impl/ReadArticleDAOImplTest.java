package ru.zagarazhi.hibernate.dao.impl;

import ru.zagarazhi.hibernate.dao.ArticleDAO;
import ru.zagarazhi.hibernate.dao.impl.ArticleDAOImpl;
import ru.zagarazhi.hibernate.model.persistence.Article;

import static org.junit.Assert.*;
import static ru.zagarazhi.AppTest.*;

import org.junit.Test;


public class ReadArticleDAOImplTest {
    private final ArticleDAO dao = new ArticleDAOImpl();

    @Test
    public void findArticleByID(){
        //Article expected = 
    }
}
