package com.liveCode.liveCode.repository;

import com.liveCode.liveCode.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {


}
