package com.likelion.study.dto;

import com.likelion.study.domain.User;
import lombok.Builder;

public class UserRes {
	private Long id;
	private String name;
	private String email;

	@Builder
	private UserRes(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public static UserRes of(Long id, String name, String email) {
		return UserRes.builder()
				.id(id)
				.name(name)
				.email(email)
				.build();
	}

	public static UserRes fromEntity(User user) {
		return UserRes.builder()
				.id(user.getId())
				.name(user.getName())
				.email(user.getEmail())
				.build();
	}

	@Override public String toString() {
		return "UserRes{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}