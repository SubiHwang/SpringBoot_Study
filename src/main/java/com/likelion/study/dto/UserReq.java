package com.likelion.study.dto;

import com.likelion.study.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserReq {
	private String name;
	private String email;
	private String password;
	private String address;

	@Builder
	private UserReq(String name, String email, String password, String address) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public User toEntity() {
		return User.builder()
				.name(name)
				.email(email)
				.password(password)
				.address(address)
				.build();
	}

	@Override public String toString() {
		return "UserReq{" +
				"name='" + name + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}