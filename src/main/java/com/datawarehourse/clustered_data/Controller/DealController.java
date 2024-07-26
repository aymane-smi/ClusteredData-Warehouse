package com.datawarehourse.clustered_data.Controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datawarehourse.clustered_data.DTO.DealDTO;
import com.datawarehourse.clustered_data.DTO.DealResponseDTO;
import com.datawarehourse.clustered_data.Services.DealService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/deal")
public class DealController {
    public DealService dealService;

    @PostMapping
    public ResponseEntity<DealResponseDTO> createDeal(@RequestBody DealDTO dealDTO) {
        return new ResponseEntity<>(dealService.create(dealDTO), HttpStatus.CREATED);
    }

    @PostMapping("/batchSave")
    public ResponseEntity<ArrayList<DealResponseDTO>>batchDealCreation(@RequestBody ArrayList<DealDTO> dealsDTO) {
        return new ResponseEntity<>(dealService.createBatch(dealsDTO), HttpStatus.CREATED);
    }
    
}
