package de.controller;

import de.model.Article;
import de.configuration.Message;
import de.model.Depot;
import de.payload.request.ArticleRequest;
import de.payload.response.ArticleDTO;
import de.payload.response.ArticleInfoDTO;
import de.payload.response.ArticleResultInt;
import de.repository.ArticleRepository;
import de.repository.DepotRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {
  private ArticleRepository articleRepository;
  private DepotRepository depotRepository;
  private Message message;


  public ArticleController(ArticleRepository articleRepository, DepotRepository depotRepository, Message message) {
    this.articleRepository = articleRepository;
    this.depotRepository = depotRepository;
    this.message = message;
  }

  @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> save(@RequestBody ArticleRequest articleRequest) {

    Optional<Depot> depot = this.depotRepository.findById(articleRequest.getDepotId());


    if (depot.isPresent()) {
      de.model.Article article = Article.builder()
        .depot(depot.get())
        .name(articleRequest.getName())
        .backup(articleRequest.isBackup())
        .price(articleRequest.getPrice())
        .ean(articleRequest.getEan())
        .notice(articleRequest.getNotice())
        .build();

      this.articleRepository.save(article);
      return new ResponseEntity<>(this.message.success(), HttpStatus.OK);
    }
    return new ResponseEntity<>(this.message.error(), HttpStatus.BAD_REQUEST);
  }

  @GetMapping("/{id}")
  public Article getArticleById(@PathVariable("id") Long id) {
    return this.articleRepository.findById(id).get();

  }

  @GetMapping(value = "/all")
  public List<Article> getAll() {
    return this.articleRepository.findAll();
  }

  @GetMapping("/name/{name}")
  public ArticleDTO getArticleByName(@PathVariable("name") String name) {
    return this.articleRepository.findByName(name).get();
  }

  @GetMapping("/info/{name}")
  public ArticleResultInt getArticleInfo(@RequestParam("name") String name) {
    return this.articleRepository.findByNaming(name);
  }

  @GetMapping("/info/all")
  public List<ArticleInfoDTO> getArticlesInformation() {
    return this.articleRepository.findArticlesInfo();
  }

}
