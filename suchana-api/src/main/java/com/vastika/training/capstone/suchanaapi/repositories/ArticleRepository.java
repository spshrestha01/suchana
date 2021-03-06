package com.vastika.training.capstone.suchanaapi.repositories;

import com.vastika.training.capstone.suchanaapi.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    // Native SQL version
    // @Query(value = "select * from article a where a.author_id=?1", nativeQuery = true)
    // List<Article> findAllByAuthor(Integer authorId);

    //HQL version
    @Query("from Article a where a.user.id=?1")
    List<Article> findAllByAuthor(Integer userId);

    @Query("from Article a where a.category.name=?1")
    List<Article> findAllByCategory(String category);

    @Query(value = "select * from Article where id in (select article_id from article_tag where tag_id =" +
            " (select id from tag where name = ?1))", nativeQuery = true)
    List<Article> findAllByTag(String Tag);

    Article findByTitle(String title);

    Article findById(int id);
}
