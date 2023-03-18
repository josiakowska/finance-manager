package org.manager.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
public class Outgoing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private BigDecimal amount;
    private LocalDate createDate;
    private String comment;

    @ManyToMany(mappedBy = "outgoings", fetch = FetchType.EAGER)
    private List<Incoming> incomings;

}