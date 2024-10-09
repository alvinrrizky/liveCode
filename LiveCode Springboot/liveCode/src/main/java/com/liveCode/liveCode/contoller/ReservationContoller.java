package com.liveCode.liveCode.contoller;

import com.liveCode.liveCode.dto.BuyTicketReq;
import com.liveCode.liveCode.dto.GetListAllEgg;
import com.liveCode.liveCode.model.Reservation;
import com.liveCode.liveCode.model.Ticket;
import com.liveCode.liveCode.service.ReservationService;
import com.liveCode.liveCode.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/reservation/")
public class ReservationContoller {

    @Autowired
    ReservationService reservationService;

    // Endpoint untuk melihat semua reservasi
    @GetMapping("/all")
    public List<Reservation> getAllReservation() {
        return reservationService.getAllReservation();
    }

    // Endpoint untuk Menambah reservasi
    @PostMapping("/addreservation")
    public ResponseEntity<Reservation> addReservation( @RequestParam String customerName ) throws Exception {
        return reservationService.addReservation(customerName);
    }


}
