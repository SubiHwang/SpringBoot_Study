package com.likelion.study.controller;

import com.likelion.study.dto.UserReq;
import com.likelion.study.dto.UserRes;
import com.likelion.study.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@controller + @ResponseBody
@RequiredArgsConstructor

//1. 어느 경로로 들어오는지를 매핑해주는 어노테이션
@RequestMapping("api/v1/user") //http://localhost:8080/api/v1/users
@Slf4j
public class UserController {
	private final UserService userService;

	//2. 어떤 요청으로 받을 건데?
	@PostMapping("")
	public ResponseEntity<?> signUp(@RequestBody UserReq requset){ //3. 요청을 어떻게 받을 건데?
		//패킷의 바디에 유저 요청을 넣겠다.

		//3. 응답하기 위한 데이터 어떻게 가져올 건데?
		UserRes response = userService.save(requset);
		log.info("User signUp success:{}",response);

		//성공하면 200
		return ResponseEntity.ok(response);
	}
}
