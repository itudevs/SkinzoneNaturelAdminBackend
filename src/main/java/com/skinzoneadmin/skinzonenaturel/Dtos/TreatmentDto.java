package com.skinzoneadmin.skinzonenaturel.Dtos;

public record TreatmentDto(
        String name,
        String category,
        Float retailPrice,
        Float discount,
        Integer numberOfPeopleTreated
) {
}
