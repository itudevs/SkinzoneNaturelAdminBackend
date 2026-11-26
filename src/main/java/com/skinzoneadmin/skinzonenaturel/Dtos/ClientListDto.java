package com.skinzoneadmin.skinzonenaturel.Dtos;

public record ClientListDto(
        Integer id,
        String name,
        String surname,
        String email,
        String contactNumber,
        String address
) {
}
