package de.controller;

import de.configuration.Message;
import de.model.Article;
import de.model.Entrance;
import de.payload.request.EntranceRequest;
import de.repository.ArticleRepository;
import de.repository.EntranceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/entrance")
public class EntranceController {
  private EntranceRepository entranceRepository;
  private ArticleRepository articleRepository;
  private Message message;

  public EntranceController(EntranceRepository entranceRepository, ArticleRepository articleRepository, Message message) {
    this.entranceRepository = entranceRepository;
    this.articleRepository = articleRepository;
    this.message = message;
  }

  @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> save(@RequestBody EntranceRequest entranceRequest) {
    Optional<Article> article = this.articleRepository.findById(entranceRequest.getArticleId());
    if (article.isPresent()) {

      Entrance entrance = Entrance.builder()
        .article(article.get())
        .quantity(entranceRequest.getQuantity())
        .notice(entranceRequest.getNotice())
        .build();

      this.entranceRepository.save(entrance);
      return new ResponseEntity<>(this.message.success(), HttpStatus.OK);
    }
    return new ResponseEntity<>(this.message.error(), HttpStatus.BAD_REQUEST);
  }
}
