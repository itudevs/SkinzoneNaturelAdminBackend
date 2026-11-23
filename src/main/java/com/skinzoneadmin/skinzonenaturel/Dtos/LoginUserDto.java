package com.skinzoneadmin.skinzonenaturel.Dtos;

import jakarta.persistence.Column;

public record LoginUserDto(
         String Email,
         String Name,
         String Surname,
         String ContactNumber
) {

}
