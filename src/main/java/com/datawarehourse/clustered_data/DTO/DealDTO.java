package com.datawarehourse.clustered_data.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class DealDTO {
    //the client can send request with or without the id
    //if the id existe in the payload then the handling will be changed in the service layer
    private String id = "";
    @NotBlank(message = "from currency is required")
    @Size(min = 3, max=3, message = "fromCurrency must contain 3 characters")
    protected String fromCurrency;
    @NotBlank(message = "to currency is required")
    @Size(min = 3, max = 3, message = "fromCurrency must contain 3 characters")
    protected String toCurrency;
    @NotBlank(message = "amount is required")
    @Min(value = 10, message = "the amount can't be less then 10")
    protected long amount;
}
