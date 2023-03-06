package de.controller;

import de.configuration.Message;
import de.model.Article;
import de.model.Distributor;
import de.model.Price;
import de.payload.request.PriceRequest;
import de.repository.ArticleRepository;
import de.repository.DistributorRepository;
import de.repository.PriceRepository;
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
@RequestMapping("/price")
public class PriceController {
    private PriceRepository priceRepository;
    private ArticleRepository articleRepository;
    private DistributorRepository distributorRepository;
    private Message message;

    public PriceController(PriceRepository priceRepository, ArticleRepository articleRepository, DistributorRepository distributorRepository, Message message) {
        this.priceRepository = priceRepository;
        this.articleRepository = articleRepository;
        this.distributorRepository = distributorRepository;
        this.message = message;
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody PriceRequest priceRequest) {

        Optional<Article> article = this.articleRepository.findById(priceRequest.getArticleId());
        Optional<Distributor> distributor = this.distributorRepository.findById(priceRequest.getDistributorId());


        if (article.isPresent() && distributor.isPresent()) {
            Price price = Price.builder()
                    .article(article.get())
                    .distributor(distributor.get())
                    .price(priceRequest.getPrice())
                    .build();

            this.priceRepository.save(price);
            return new ResponseEntity<>(this.message.success(), HttpStatus.OK);
        }
        return new ResponseEntity<>(this.message.error(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@RequestBody PriceRequest priceRequest) {

        Optional<Price> price = this.priceRepository.findById(priceRequest.getPriceId());
        Optional<Article> article = this.articleRepository.findById(priceRequest.getArticleId());
        Optional<Distributor> distributor = this.distributorRepository.findById(priceRequest.getDistributorId());


        if (price.isPresent() && article.isPresent() && distributor.isPresent()) {
            price.get().setArticle(article.get());
            price.get().setDistributor(distributor.get());
            price.get().setPrice(priceRequest.getPrice());
            this.priceRepository.save(price.get());
            return new ResponseEntity<>(this.message.success(), HttpStatus.OK);
        }
        return new ResponseEntity<>(this.message.error(), HttpStatus.BAD_REQUEST);
    }
}
