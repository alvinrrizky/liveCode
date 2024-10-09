package com.liveCode.liveCode.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddEggReq {

    private int jumlahTelur;
    private BigDecimal pendapatan;
}
