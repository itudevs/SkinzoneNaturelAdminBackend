package com.skinzoneadmin.skinzonenaturel.Dtos;

import jakarta.persistence.Column;

public record ClientDto(

        String name,

       String surname,

       String phone,


        String email,


        String address
) {
}
