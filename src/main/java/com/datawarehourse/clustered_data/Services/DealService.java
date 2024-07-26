package com.datawarehourse.clustered_data.Services;

import java.util.ArrayList;

import com.datawarehourse.clustered_data.DTO.DealDTO;
import com.datawarehourse.clustered_data.DTO.DealResponseDTO;

public interface DealService{
    public DealResponseDTO create(DealDTO dealDTO);
    public ArrayList<DealResponseDTO> createBatch(ArrayList<DealDTO> dealsDTO);
}