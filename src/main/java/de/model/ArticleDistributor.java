package de.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDistributor {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @OneToOne
  @JoinColumn(name = "article_id")
  private Article article;
  @OneToOne
  @JoinColumn(name = "distributor_id")
  private Distributor distributor;

  private float price;
  private float tax;
}
