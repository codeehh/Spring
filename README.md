# Spring

### **스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술**

#### 1-1

.idea : 인텔리제이가 사용하는 설정파일

src : main과 test로 나눠져있음(test 코드도 중요함)

build.gradle : 중요

- Settings  $\to$ Build, Execution, Deployment $\to$ Gradle

  $\to$ Build and run using, Run tests using = IntelliJ IDEA 로 변경(gradle을 통하지 않고 바로 실행해서 더 빠르게 실행됨)

#### 1-2

External Libraries : 받아온 라이브러리들

실무에서는 System.out.println 안쓰고 logging을 씀(slf4j, logback)

테스트 라이브러리 junit, mockito, assertj, spring-test

#### 1-3

spring.io $\to$ Projects $\to$ Spring Boot $\to$ LEARN $\to$ 맞는 버전의 Reference Doc. 에서 필요한거 검색

컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버(viewResolver)가 화면을 찾아서 처리한다.

#### 1-4

프로젝트 빌드 명령어

```
# build
./gradlew build
cd build/libs
java -jar <jar 파일명>

# build 폴더 지우기
./gradlew clean
or
./gradlew clean build
```

#### 2-1

웹개발 종류

1. 정적 컨텐츠
2. MVC와 템플릿 엔진
3. API

정적 컨텐츠

- static 폴더에 html 생성
- localhost:8080/파일명.html

#### 2-2

MVC와 템플릿 엔진

- @RequestParam("") : 요청 변수 매핑
- model에 담아서 html에서 사용

#### 2-3

API

- @ResponseBody : http body에 담아서 반환(Json으로 반환하는게 기본)
- viewResolver 대신에 HttpMessageConverter가 동작(문자는 그대로, 객체는 Json으로 변환함)

