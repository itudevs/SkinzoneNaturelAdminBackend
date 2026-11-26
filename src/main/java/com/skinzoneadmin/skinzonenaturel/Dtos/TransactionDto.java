package com.skinzoneadmin.skinzonenaturel.Dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record TransactionDto(
        LocalDate date,
        LocalTime time,
        List<TreatmentUndetailedDto> treatments,
        List<ProductUndetailedDto> products

) {
}
