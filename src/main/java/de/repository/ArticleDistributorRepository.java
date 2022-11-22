package de.repository;

import de.model.ArticleDistributor;
import de.payload.response.ArticlePriceResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleDistributorRepository extends JpaRepository<ArticleDistributor, Long> {
  @Query(value = "SELECT new de.payload.response.ArticlePriceResponse(a.id, a.article.name,a.distributor.name, (a.price * (1 + a.tax)) as price) FROM ArticleDistributor a WHERE a.article.name =?1")
  List<ArticlePriceResponse> findPriceByArticleName(String name);
}
