package com.liveCode.liveCode.contoller;

import com.liveCode.liveCode.dto.AddEggReq;
import com.liveCode.liveCode.dto.GetListAllEgg;
import com.liveCode.liveCode.model.Egg;
import com.liveCode.liveCode.service.EggService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/egg/")
public class EggController {

    @Autowired
    EggService eggService;

    // Endpoint untuk melihat semua telur
    @GetMapping("/all")
    public GetListAllEgg getAllEgg() {
        return eggService.getAllEgg();
    }

    // Endpoint untuk tambah telur
    @PostMapping("/addegg")
    public ResponseEntity<Egg> addEgg(@RequestBody AddEggReq req) {
        return eggService.addEgg(req);
    }
}
