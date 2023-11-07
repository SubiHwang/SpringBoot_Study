package com.likelion.study.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
//annotation
@Table(name="User")
@Getter //-> 이유가 없다면, 굳이 쓰지 마라.
//@Setter -> 쓰지 마라.
@NoArgsConstructor(access = AccessLevel.PROTECTED)

//필요한 생성자만 쓰겠다.
//@AllArgsConstructor(access = AccessLevel.PUBLIC) -> 웬만하면 직접 작성하는 것을 권고

public class User {
	//primary key 선언은 @를 사용한다.
	//@GeneratedValue(strategy = GenerationType.IDENTITY) : 컬럼 하나가 증가 했을 때 자동적으로 필드를 증가시켜주는
	//'auto increase' 를 사용하겠다는 것을 명시해준다.
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@Column(name = "username"): DB 필드의 값 이름에는 username로 설정하고 싶을 때 사용한다.
	//필드에 null을 허용하지 않고, 길이는 32로 하겠다.
	@Column(nullable = false, length = 32)
	private String name;

	@Column(nullable = false,length = 32)
	private String email;
	private String password;
	private String address;

	@Enumerated(EnumType.STRING)
	private RoleType roleType;

	public User(String name, String email, String password, String address, RoleType roleType) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.roleType = roleType;
	}
}
