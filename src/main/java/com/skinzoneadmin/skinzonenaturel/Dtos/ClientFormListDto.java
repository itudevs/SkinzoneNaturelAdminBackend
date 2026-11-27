package com.skinzoneadmin.skinzonenaturel.Dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public record ClientFormListDto(
        Integer id,
        LocalDate date,
        LocalTime time
) {
}
