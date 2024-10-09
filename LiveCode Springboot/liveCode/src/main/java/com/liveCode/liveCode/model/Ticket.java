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
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    @NotNull
    private Long ticketId;

    @Column(name = "jenis_ticket")
    private String jenisTicket;

    @NotNull
    @Column(name = "harga")
    private BigDecimal harga;

    @NotNull
    @Column(name = "tanggal_pembelian")
    private Date tanggalPembelian;
}
