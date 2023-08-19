package com.crud.backend.challange.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataUpdateClickBus(@NotNull Long id, @NotBlank String slug, String city, String state) {

}
