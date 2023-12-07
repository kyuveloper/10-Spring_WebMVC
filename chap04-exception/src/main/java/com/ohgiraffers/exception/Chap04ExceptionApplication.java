package com.ohgiraffers.exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // (scanBasePackages="com.ohgiraffers.exception") 을 붙이면 작성한 패키지부터 읽음
public class Chap04ExceptionApplication { // 없으면 안돌아감 // 이 파일이 포함된 폴더부터 하위를 읽음

    public static void main(String[] args) {
        SpringApplication.run(Chap04ExceptionApplication.class, args);
    }

}
