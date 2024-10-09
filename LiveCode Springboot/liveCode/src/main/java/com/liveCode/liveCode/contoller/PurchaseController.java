package com.liveCode.liveCode.contoller;

import com.liveCode.liveCode.dto.BuyTicketReq;
import com.liveCode.liveCode.dto.GetListAllTicket;
import com.liveCode.liveCode.model.Barang;
import com.liveCode.liveCode.model.Ticket;
import com.liveCode.liveCode.service.PurchaseService;
import com.liveCode.liveCode.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/purchase/")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    // Endpoint untuk melihat semua barang
    @GetMapping("/all")
    public List<Barang> getAllBarang() {
        return purchaseService.getAllBarang();
    }

    // Endpoint untuk beli barang
    @PostMapping("/buybarang")
    public String buyBarang(@RequestParam BigDecimal harga) {
        return purchaseService.buyBarang(harga);
    }
}
