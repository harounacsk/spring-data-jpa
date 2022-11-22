package de.controller;

import de.configuration.Message;
import de.model.Article;
import de.model.ArticleDistributor;
import de.model.Distributor;
import de.payload.request.ArticleDistributorRequest;
import de.payload.response.ArticlePriceResponse;
import de.repository.ArticleDistributorRepository;
import de.repository.ArticleRepository;
import de.repository.DistributorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/article/distributor")
public class ArticleDistributorController {
  private ArticleRepository articleRepository;
  private DistributorRepository distributorRepository;
  private ArticleDistributorRepository articleDistributorRepository;
  private Message message;

  public ArticleDistributorController(ArticleRepository articleRepository, DistributorRepository distributorRepository, ArticleDistributorRepository articleDistributorRepository, Message message) {
    this.articleRepository = articleRepository;
    this.distributorRepository = distributorRepository;
    this.articleDistributorRepository = articleDistributorRepository;
    this.message = message;
  }


  @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> save(@RequestBody ArticleDistributorRequest articleDistributorRequest) {

    Optional<Article> article = this.articleRepository.findById(articleDistributorRequest.getArticleId());
    Optional<Distributor> distributor = this.distributorRepository.findById(articleDistributorRequest.getDistributorId());

    if (article.isPresent() && distributor.isPresent()) {
      ArticleDistributor articleDistributor = ArticleDistributor.builder()
        .article(article.get())
        .distributor(distributor.get())
        .price(articleDistributorRequest.getPrice())
        .tax(articleDistributorRequest.getTax())
        .build();

      this.articleDistributorRepository.save(articleDistributor);
      return new ResponseEntity<>(message.getSuccess(), HttpStatus.CREATED);
    }
    return new ResponseEntity<>("Article-id und Distributor-Id müssen beide vorhanden sein.", HttpStatus.BAD_REQUEST);
  }

  @GetMapping("/price")
  public List<ArticlePriceResponse> getPrice(@RequestParam("name") String name) {
    return this.articleDistributorRepository.findPriceByArticleName(name);
  }
}
