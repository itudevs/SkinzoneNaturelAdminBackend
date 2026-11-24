package com.skinzoneadmin.skinzonenaturel.Dtos;

import java.time.LocalDate;

public record ProductDto(
        Integer productId,
        String productName,
        String productCategory,
        Integer productQuantity,
        Float retailPrice,
        Float clinicalPrice,
        LocalDate dateReceived
) {
}
