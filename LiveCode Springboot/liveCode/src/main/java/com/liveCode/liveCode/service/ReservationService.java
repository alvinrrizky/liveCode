package com.liveCode.liveCode.service;

import com.liveCode.liveCode.dto.GetListAllEgg;
import com.liveCode.liveCode.model.Egg;
import com.liveCode.liveCode.model.Reservation;
import com.liveCode.liveCode.repository.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public ResponseEntity<Reservation> addReservation(String customerName) throws Exception {
        LocalDate reservationDate = LocalDate.now();

        if (reservationDate.getDayOfWeek() == DayOfWeek.WEDNESDAY || reservationDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
            throw new Exception("Hari Rabu dan Jumat tidak tersedia untuk reservasi.");
        }

        List<Reservation> reservationsForDay = reservationRepository.findByReservationDate(reservationDate);
        if (reservationsForDay.size() >= 2) {
            throw new Exception("Sudah ada 2 reservasi untuk hari ini.");
        }

        Reservation reservation = new Reservation(null, customerName, reservationDate);
        Reservation resultReservation = reservationRepository.save(reservation);

        return ResponseEntity.ok(resultReservation);
    }

    public List<Reservation> getAllReservation() {
        log.info("Start Get All Reservation");
        try {
            return reservationRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }
}
