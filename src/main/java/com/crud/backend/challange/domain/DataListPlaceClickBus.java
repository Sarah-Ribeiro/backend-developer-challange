package com.crud.backend.challange.domain;

import java.time.Instant;

import com.crud.backend.challange.entity.ClickBusEntity;

public record DataListPlaceClickBus(Long id, String name, String slug, String state, String city, Instant updatedAt,
		Instant createdAt) {

	public DataListPlaceClickBus(ClickBusEntity clickBus) {
		this(clickBus.getId(), clickBus.getName(), clickBus.getSlug(), clickBus.getState(), clickBus.getCity(),
				clickBus.getUpdatedAt(), clickBus.getCreatedAt());
	}

}
