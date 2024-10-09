package com.liveCode.liveCode.service;

import com.liveCode.liveCode.dto.AddEggReq;
import com.liveCode.liveCode.dto.BuyTicketReq;
import com.liveCode.liveCode.dto.GetListAllEgg;
import com.liveCode.liveCode.dto.GetListAllTicket;
import com.liveCode.liveCode.model.Egg;
import com.liveCode.liveCode.model.Ticket;
import com.liveCode.liveCode.repository.EggRepository;
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
public class EggService {

    @Autowired
    private EggRepository eggRepository;

    public GetListAllEgg getAllEgg() {
        log.info("Start Get All Egg");
        try {

            BigDecimal totalPendapatan = BigDecimal.ZERO;
            List<Egg> eggList = eggRepository.findAll();

            for (Egg res : eggList) {
                // Menambahkan harga tiket ke totalHarga
                totalPendapatan = totalPendapatan.add(res.getPendapatan());
            }

            return GetListAllEgg.builder()
                    .listEgg(eggList)
                    .totalPendapatan(totalPendapatan).build();
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<Egg> addEgg (AddEggReq req) {
        log.info("Start Add Egg");
        try {
            Date currentDate = new Date();

            Egg reqEgg = new Egg();
            reqEgg.setTanggalPeletakan(currentDate);
            reqEgg.setJumlahTelur(req.getJumlahTelur());
            reqEgg.setPendapatan(req.getPendapatan());

            Egg savedEgg =  eggRepository.save(reqEgg);

            return ResponseEntity.ok(savedEgg);

        } catch (Exception e) {
            throw e;
        }
    }
}
