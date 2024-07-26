package com.datawarehourse.clustered_data.Services.Impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.datawarehourse.clustered_data.DTO.DealDTO;
import com.datawarehourse.clustered_data.DTO.DealResponseDTO;
import com.datawarehourse.clustered_data.Models.Deal;
import com.datawarehourse.clustered_data.Repositories.DealRepository;

@ExtendWith(MockitoExtension.class)
public class DealServiceImplTest {
    @Mock
    private DealRepository dealRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private DealServiceImpl dealService;

    private Deal deal;
    private DealDTO dealDTO;
    private DealResponseDTO dealResponseDTO;

    @BeforeEach
    public void init(){
        dealDTO = DealDTO.builder()
                         .id("deal-1")
                         .fromCurrency("mad")
                         .toCurrency("mad")
                         .amount(11).build();
        deal = Deal.builder()
                   .id("deal-1")
                   .fromCurrency("mad")
                   .toCurrency("mad")
                   .amount(11).build();
        dealResponseDTO = DealResponseDTO.builder()
                   .id("deal-id")
                   .fromCurrency("mad")
                   .toCurrency("mad")
                   .amount(11).build();
    }

    @Test
    @DisplayName("testing create method")
    void testCreate() {
        given(dealRepository.existsById("deal-1")).willReturn(false);
        given(modelMapper.map(dealDTO, Deal.class)).willReturn(deal);
        given(dealRepository.save(deal)).willReturn(deal);
        given(modelMapper.map(deal, DealResponseDTO.class)).willReturn(dealResponseDTO);
        dealService.create(dealDTO);
        assertEquals(dealDTO.getId(), deal.getId());
    }

    @Test
    void testCreateBatch() {

    }
}
