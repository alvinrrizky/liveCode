package com.liveCode.liveCode.service;

import com.liveCode.liveCode.model.Barang;
import com.liveCode.liveCode.repository.BarangRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PurchaseService {

    @Autowired
    private BarangRepository barangRepository;

    public List<Barang> getAllBarang() {
        log.info("Start Get All Barang");
        try {
            return barangRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    public String buyBarang(BigDecimal uang) {
        log.info("Start Buy Barang");
        List<Barang> semuaBarang = barangRepository.findAll();
        List<Barang> barangTerpilih = new ArrayList<>();
        BigDecimal totalTerbaik = BigDecimal.ZERO;

        // Mencari kombinasi barang dengan total harga terbaik
        for (Barang barang : semuaBarang) {
            if (barang.getHarga().compareTo(uang) <= 0) {
                barangTerpilih.add(barang);
                totalTerbaik = totalTerbaik.add(barang.getHarga());
                uang = uang.subtract(barang.getHarga());
            }
        }

        if (!barangTerpilih.isEmpty()) {
            StringBuilder result = new StringBuilder("Kombinasi terbaik:\n");
            for (Barang barang : barangTerpilih) {
                result.append(barang.getNamaBarang()).append("\n");
            }
            result.append("Total Harga: ").append(totalTerbaik.toString()).append("\n");
            result.append("Sisa Uang: ").append(uang.toString());
            return result.toString();
        } else {
            return "Tidak ada barang yang bisa dibeli dengan jumlah uang ini.";
        }
    }

}
