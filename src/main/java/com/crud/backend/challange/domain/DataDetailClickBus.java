package com.crud.backend.challange.domain;

import java.time.Instant;

import com.crud.backend.challange.entity.ClickBusEntity;

public record DataDetailClickBus(Long id, String name, String slug, String city, String state, Instant updatedAt,
		Instant createdAt) {

	public DataDetailClickBus(ClickBusEntity clickBus) {
		this(clickBus.getId(), clickBus.getName(), clickBus.getSlug(), clickBus.getCity(), clickBus.getState(),
				clickBus.getUpdatedAt(), clickBus.getCreatedAt());
	}

}
