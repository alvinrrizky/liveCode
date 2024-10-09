package com.liveCode.liveCode.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "egg")
public class Egg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "egg_id")
    @NotNull
    private Long eggId;

    @Column(name = "jumlah_telur")
    private int jumlahTelur;

    @NotNull
    @Column(name = "pendapatan")
    private BigDecimal pendapatan;

    @NotNull
    @Column(name = "tanggal_peletakan")
    private Date tanggalPeletakan;
}
