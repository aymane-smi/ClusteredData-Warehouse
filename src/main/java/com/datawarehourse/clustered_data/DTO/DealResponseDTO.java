package com.datawarehourse.clustered_data.DTO;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DealResponseDTO{
    protected String id;
    @NotBlank(message = "from currency is required")
    @Size(min = 3, max=3, message = "fromCurrency must contain 3 characters")
    private String fromCurrency;
    @NotBlank(message = "to currency is required")
    @Size(min = 3, max = 3, message = "toCurrency must contain 3 characters")
    private String toCurrency;
    @Min(value = 10, message = "the amount can't be less then 10")
    private long amount;
    private LocalDateTime dealTime;
}
