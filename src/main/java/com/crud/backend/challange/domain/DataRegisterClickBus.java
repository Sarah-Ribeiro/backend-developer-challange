package com.crud.backend.challange.domain;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;

public record DataRegisterClickBus(@NotBlank String name, @NotBlank String slug, @NotBlank String city,
		@NotBlank String state,

		Date updatedAt, Date createdAt) {

}
