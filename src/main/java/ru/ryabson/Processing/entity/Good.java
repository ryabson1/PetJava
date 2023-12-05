package ru.ryabson.Processing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;

@Entity
@Data
@Table(name = "pc_good")
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String goodName;

    @Column(name = "price")
    private BigDecimal goodPrice;

    @Column(name = "active")
    private boolean goodActive;

    @ManyToOne
    @JoinColumn(name = "good_type_id")
    private GoodType goodType;




}
