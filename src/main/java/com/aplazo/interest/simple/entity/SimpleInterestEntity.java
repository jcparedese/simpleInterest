package com.aplazo.interest.simple.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "simple_interest")
public class SimpleInterestEntity {

    public SimpleInterestEntity(){
        createdAt = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "terms", nullable = false)
    private Integer terms;

    @Column(name = "rate", nullable = false)
    private Double rate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getTerms() {
        return terms;
    }

    public void setTerms(Integer terms) {
        this.terms = terms;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "SimpleInterestEntity{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", amount=" + amount +
                ", terms=" + terms +
                ", rate=" + rate +
                '}';
    }
}
