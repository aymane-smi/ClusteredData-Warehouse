package com.datawarehourse.clustered_data.Services.Impl;
import org.springframework.stereotype.Service;

import com.datawarehourse.clustered_data.Services.DealService;
import com.datawarehourse.clustered_data.DTO.DealDTO;
import com.datawarehourse.clustered_data.DTO.DealResponseDTO;
import com.datawarehourse.clustered_data.Repositories.DealRepository;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class DealServiceImpl implements DealService{
    private DealRepository DealRepository;

    @Override
    public DealResponseDTO create(DealDTO dealDTO) {
        return null;
    }

    
}