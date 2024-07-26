package com.datawarehourse.clustered_data.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DealResponseDTO extends DealDTO{
    private long id;
    private LocalDateTime dealTime;
}
