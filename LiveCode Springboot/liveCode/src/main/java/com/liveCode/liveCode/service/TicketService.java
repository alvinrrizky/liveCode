package com.liveCode.liveCode.service;

import com.liveCode.liveCode.dto.BuyTicketReq;
import com.liveCode.liveCode.dto.GetListAllTicket;
import com.liveCode.liveCode.model.Ticket;
import com.liveCode.liveCode.repository.TicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public GetListAllTicket getAllTicket() {
        log.info("Start Get All Ticket");
        try {

            BigDecimal totalHarga = BigDecimal.ZERO;
            List<Ticket> ticketList = ticketRepository.findAll();

            for (Ticket res : ticketList) {
                // Menambahkan harga tiket ke totalHarga
                totalHarga = totalHarga.add(res.getHarga());
            }

            return GetListAllTicket.builder()
                    .listTicket(ticketList)
                    .totalPenjualan(totalHarga).build();
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<Ticket> buyTicket (BuyTicketReq req) {
        log.info("Start Buy Ticket");
        try {
            Date currentDate = new Date();

            Ticket reqTicket = new Ticket();
            reqTicket.setTanggalPembelian(currentDate);
            reqTicket.setJenisTicket(req.getJenisTicket());
            reqTicket.setHarga(req.getHarga());

            Ticket savedTicket =  ticketRepository.save(reqTicket);

            return ResponseEntity.ok(savedTicket);

        } catch (Exception e) {
            throw e;
        }
    }
}
