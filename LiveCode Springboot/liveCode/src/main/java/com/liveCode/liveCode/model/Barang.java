package com.liveCode.liveCode.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "barang")
public class Barang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "barang_id")
    @NotNull
    private Long barangId;

    @Column(name = "nama_barang")
    private String namaBarang;

    @NotNull
    @Column(name = "harga_barang")
    private BigDecimal harga;
}
