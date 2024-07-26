package com.datawarehourse.clustered_data.Services.Impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.datawarehourse.clustered_data.Services.DealService;
import com.datawarehourse.clustered_data.DTO.DealDTO;
import com.datawarehourse.clustered_data.DTO.DealResponseDTO;
import com.datawarehourse.clustered_data.Exceptions.AlreadyExistsException;
import com.datawarehourse.clustered_data.Exceptions.CurrencyPatternException;
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
        if(!this.RealisticCurrencyValidation(dealDTO.getFromCurrency()))
            throw new CurrencyPatternException("the from currency must contain only 3 letters");
        if(!this.RealisticCurrencyValidation(dealDTO.getToCurrency()))
            throw new CurrencyPatternException("the to currency must contain only 3 letters");
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
            }catch(CurrencyPatternException ex){
                System.out.println("currency error");
            }catch(AlreadyExistsException ex){
                System.out.println("duplicated");
            }
        });
        return (ArrayList<DealResponseDTO>) result;
    }

    private boolean RealisticCurrencyValidation(String currency){
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(currency);
        return matcher.matches() ? true : false;
    }

    
}