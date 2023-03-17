package de.repository;

import de.model.Article;
import de.payload.response.ArticleDTO;
import de.payload.response.ArticleInfoDTO;
import de.payload.response.ArticleResultInt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {

  @Query(value = "SELECT new de.payload.response.ArticleDTO(a.id, a.name, a.price, d.name)  FROM Article a  INNER JOIN a.depot d WHERE a.name=?1")
  Optional<ArticleDTO> findByName(String name);

  @Query(value = "SELECT a.id, a.name, a.price, a.backup,d.notice, Sum(e.quantity) As quantity FROM article a " +
    "INNER JOIN entrance e ON e.article_id = a.id " +
    "INNER JOIN depot d ON d.id = a.depot_id WHERE a.name= ?1  GROUP BY a.id,d.notice  ", nativeQuery = true)
  ArticleResultInt findByNaming(String name);

  @Query(value = "SELECT new de.payload.response.ArticleInfoDTO(e.article.id, e.article.name, e.article.price, e.article.backup,e.article.depot.name, Sum(e.quantity) As quantity) FROM Entrance e " +
    "INNER JOIN  e.article as art " +
    "INNER JOIN  art.depot d WHERE art.name= ?1  GROUP BY art.id, e.article.depot.name, e.article.id  ")
  List<ArticleInfoDTO> findByNamingJPQL(String name);

  @Query(value = "SELECT new de.payload.response.ArticleInfoDTO(e.article.id, e.article.name, e.article.price, e.article.backup,e.article.depot.name, Sum(e.quantity) As quantity)" +
    " FROM Entrance e GROUP BY  e.article.depot.name, e.article.id,e.article.name , e.article.price, e.article.backup")
  List<ArticleInfoDTO> findArticlesInfo();

}


