package de.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private float price;
    @ManyToOne
    @JoinColumn(name = "depot_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Depot depot;
    private boolean backup;
    private String ean;
    private String notice;

}
