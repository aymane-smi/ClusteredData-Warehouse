package com.datawarehourse.clustered_data.Services;

import com.datawarehourse.clustered_data.DTO.DealDTO;
import com.datawarehourse.clustered_data.DTO.DealResponseDTO;

public interface DealService{
    public DealResponseDTO create(DealDTO dealDTO);
}