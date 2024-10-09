package com.liveCode.liveCode.contoller;

import com.liveCode.liveCode.dto.BuyTicketReq;
import com.liveCode.liveCode.dto.GetListAllTicket;
import com.liveCode.liveCode.model.Ticket;
import com.liveCode.liveCode.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/tickets/")
public class TicketController {

    @Autowired
    TicketService ticketService;

    // Endpoint untuk melihat semua tiket yang terjual
    @GetMapping("/all")
    public GetListAllTicket getAllTicket() {
        return ticketService.getAllTicket();
    }

    // Endpoint untuk beli ticket
    @PostMapping("/buyticket")
    public ResponseEntity<Ticket> buyTicket(@RequestBody BuyTicketReq req) {
        return ticketService.buyTicket(req);
    }
}
