package com.datawarehourse.clustered_data.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class DealDTO {
    //the client can send request with or without the id
    //if the id existe in the payload then the handling will be changed in the service layer
    @Builder.Default
    protected String id = "";
    @NotBlank(message = "from currency is required")
    @Size(min = 3, max=3, message = "fromCurrency must contain 3 characters")
    private String fromCurrency;
    @NotBlank(message = "to currency is required")
    @Size(min = 3, max = 3, message = "toCurrency must contain 3 characters")
    private String toCurrency;
    @Min(value = 10, message = "the amount can't be less then 10")
    private long amount;
}
