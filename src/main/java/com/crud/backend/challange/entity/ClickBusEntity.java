package com.crud.backend.challange.entity;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.crud.backend.challange.domain.DataRegisterClickBus;
import com.crud.backend.challange.domain.DataUpdateClickBus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "ClickBus")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "crud_click_bus")
public class ClickBusEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String slug;

	private String city;

	private String state;

	@Column(name = "updated_at")
	@UpdateTimestamp
	private Instant updatedAt;

	@Column(name = "created_at")
	@CreationTimestamp
	private Instant createdAt;

	public ClickBusEntity(DataRegisterClickBus data) {
		this.name = data.name();
		this.slug = data.slug();
		this.city = data.city();
		this.state = data.state();
	}

	public void updateInfo(@Valid DataUpdateClickBus data) {
		if (data.slug() != null) {
			this.slug = data.slug();
		}
		if (data.state() != null) {
			this.state = data.state();
		}
		if (data.city() != null) {
			this.city = data.city();
		}
	}

}
