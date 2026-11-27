package com.skinzoneadmin.skinzonenaturel.Dtos;

import com.skinzoneadmin.skinzonenaturel.Entities.Client;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public record ClientFormDto(
        LocalDate date,

         String todayTreatmentGoal,

          Map<String,Object> answers,

           ClientDto client
) {
}
