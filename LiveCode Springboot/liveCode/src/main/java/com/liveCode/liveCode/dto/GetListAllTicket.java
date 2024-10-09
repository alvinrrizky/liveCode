package com.liveCode.liveCode.dto;

import com.liveCode.liveCode.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetListAllTicket {

    private List<Ticket> listTicket;
    private BigDecimal totalPenjualan;
}
