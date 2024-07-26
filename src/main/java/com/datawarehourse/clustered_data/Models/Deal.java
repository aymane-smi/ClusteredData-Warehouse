package com.datawarehourse.clustered_data.Models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "from_currency", nullable = false)
    private String fromCurrency;
    @Column(name = "to_currency", nullable = false)
    private String toCurrency;
    @Column(name = "deal_timestamp", nullable = false)
    private LocalDateTime dealTime;
    @Column(name = "deal_amount", nullable = false)
    private long amount;

}