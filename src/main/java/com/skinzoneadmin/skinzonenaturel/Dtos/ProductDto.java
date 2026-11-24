package com.skinzoneadmin.skinzonenaturel.Dtos;

import java.time.LocalDate;

public record ProductDto(
        Integer id,
        String name,
        String category,
        Integer amountAvailable,
        Float retailPrice,
        Float clinicalPrice,
        LocalDate dateReceived
) {
}
