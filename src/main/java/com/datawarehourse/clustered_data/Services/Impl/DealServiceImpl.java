package com.datawarehourse.clustered_data.Services.Impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.datawarehourse.clustered_data.Services.DealService;
import com.datawarehourse.clustered_data.DTO.DealDTO;
import com.datawarehourse.clustered_data.DTO.DealResponseDTO;
import com.datawarehourse.clustered_data.Exceptions.AlreadyExistsException;
import com.datawarehourse.clustered_data.Models.Deal;
import com.datawarehourse.clustered_data.Repositories.DealRepository;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DealServiceImpl implements DealService{
    private final DealRepository dealRepository;
    private final ModelMapper modelMapper;

    @Override
    public DealResponseDTO create(DealDTO dealDTO) {
        if(!dealDTO.getId().isEmpty() && dealRepository.existsById(dealDTO.getId()))
            throw new AlreadyExistsException("deal already exist");
        Deal deal = modelMapper.map(dealDTO, Deal.class);
        deal.setDealTime(LocalDateTime.now());
        deal = dealRepository.save(deal);
        return modelMapper.map(deal, DealResponseDTO.class);
    }

    @Override
    public ArrayList<DealResponseDTO> createBatch(ArrayList<DealDTO> dealsDTO) {
        List<DealResponseDTO> result = new ArrayList<>();
        dealsDTO.forEach(deal -> {
            try{
                result.add(create(deal));
            }catch(AlreadyExistsException e){
                System.out.println("duplicated");
            }
        });
        return (ArrayList<DealResponseDTO>) result;
    }

    
}