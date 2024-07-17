package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorData(
        @JsonAlias("first_Name") String firstName,
        @JsonAlias("last_name") String lastName,
        @JsonAlias("birth_date") LocalDateTime birthDate) {
}
