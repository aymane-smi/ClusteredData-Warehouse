package com.datawarehourse.clustered_data.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DealDTO {
    protected String fromCurrency;
    protected String toCurrency;
    protected long amount;
}
