# Spring

### **스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술**

#### 1-1 프로젝트 생성

.idea : 인텔리제이가 사용하는 설정파일

src : main과 test로 나눠져있음(test 코드도 중요함)

build.gradle : 중요

- Settings  $\to$ Build, Execution, Deployment $\to$ Gradle

  $\to$ Build and run using, Run tests using = IntelliJ IDEA 로 변경(gradle을 통하지 않고 바로 실행해서 더 빠르게 실행됨)

#### 1-2 라이브러리 살펴보기

External Libraries : 받아온 라이브러리들

실무에서는 System.out.println 안쓰고 logging을 씀(slf4j, logback)

테스트 라이브러리 junit, mockito, assertj, spring-test

#### 1-3 View 환경설정

spring.io $\to$ Projects $\to$ Spring Boot $\to$ LEARN $\to$ 맞는 버전의 Reference Doc. 에서 필요한거 검색

컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버(viewResolver)가 화면을 찾아서 처리한다.

#### 1-4 빌드하고 실행하기

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

#### 2-1 정적 컨텐츠

웹개발 종류

1. 정적 컨텐츠
2. MVC와 템플릿 엔진
3. API

정적 컨텐츠

- static 폴더에 html 생성
- localhost:8080/파일명.html

#### 2-2 MVC와 템플릿 엔진

MVC와 템플릿 엔진

- @RequestParam("") : 요청 변수 매핑
- model에 담아서 html에서 사용

#### 2-3 API

API

- @ResponseBody : http body에 담아서 반환(Json으로 반환하는게 기본)
- viewResolver 대신에 HttpMessageConverter가 동작(문자는 그대로, 객체는 Json으로 변환함)

#### 3-1 비즈니스 요구사항 정리

#### 3-2 회원 도메인과 리포지토리 만들기

Optional<class> : Java 8에서 생긴 기능, NullPointerException 처리하려고 Optional로 감싸서 반환

실무에서는 동시성 문제때문에 공유되는 변수는 ConcurrentHashMap 사용

람다식, 함수형 인터페이스, stream 도 쓰임

#### 3-3 회원 리포지토리 테스트 케이스 작성

테스트 매우 중요

TDD : 테스트를 먼저 작성하고 개발하는 방식

Assertions로 검증

@Test : 테스트 메소드에 붙임

@AfterEach : 각각의 메소드가 끝날때마다 실행됨

#### 3-4 회원 서비스 개발

Repository 메소드는 기능적으로, Service 메소드는 비즈니스적으로 이름짓기

#### 3-5 회원 서비스 테스트

테스트는 //given, //when, //then 으로 구분해서 작성하는게 좋음

#### 4-1 컴포넌트 스캔과 자동 의존관계 설정

빈 등록

- @Component

  - @Controller

  - @Service

  - @Repository

빈 연결

- @Autowired

컴포넌트 스캔은 기본으로 생성되는 Application과 같거나 하위 패키지만 스캔함

#### 4-2 자바 코드로 직접 스프링 빈 등록하기

DI에는

1. 필드 주입
2. setter 주입
3. 생성자 주입(권장)

이 있다.

#### 5-1 회원 웹 기능 - 홈 화면 추가

#### 5-2 회원 웹 기능 - 등록

#### 5-3 회원 웹 기능 - 조회

#### 6-1 H2 데이터베이스 설치

#### 6-2 순수 JDBC

스프링의 DI를 사용하면 기존 코드를 전혀 손대지 않고, 설정만으로 구현 클래스를 변경할 수 있다(MemoryMemberRepository $\to$ JdbcMemberRepository)

#### 6-3 스프링 통합 테스트

@SpringBootTest : 스프링 컨테이너와 테스트를 함께 실행한다.

@Transactional : commit 안하고 rollback 함

일반적으로 스프링 통합 테스트말고 단위 테스트가 더 좋은 테스트

#### 6-4 스프링 JdbcTemplate

테스트 잘짜는게 매우 중요하다, 개발시간 : 테스트시간 = 30~40% : 60~70%

#### JPA

jpa는 EntityManager로 동작함

jpa는 데이터를 저장, 변경할때 @Transactional이 있어야함

#### 스프링 데이터 JPA

스프링 데이터 JPA가 편리하기는 하지만 JPA를 알고 써야함

복잡한 동적 쿼리는 Querydsl이라는 라이브러리를 사용하고

이것들로도 해결하기 어려운 쿼리는 네이티브 쿼리로 해결할 수 있음
