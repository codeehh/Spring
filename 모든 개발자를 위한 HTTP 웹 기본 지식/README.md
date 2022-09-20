# 모든 개발자를 위한 HTTP 웹 기본 지식

### 1. 인터넷 네트워크

#### 1-1 인터넷 통신

#### 1-2 IP(인터넷 프로토콜)

IP 프로토콜의 한계

- 비연결성
  - 패킷을 받을 대상이 없거나 서비스 불능 상태여도 패킷 전송(TCP 3 way handshake)
- 비신뢰성
  - 중간에 패킷이 사라지면?
  - 패킷이 순서대로 안오면?
- 프로그램 구분
  - 같은 IP를 사용하는 서버에서 통신하는 애플리케이션이 둘 이상이면?(PORT로 구분)

$\to$ TCP로 해결

#### 1-3 TCP, UDP

<img src="assets/image-20220919115742318.png" alt="image-20220919115742318" style="zoom:50%;" />

IP 패킷 정보 : 출발지 IP, 목적지 IP, 기타...

TCP 패킷 정보 : 출발지 PORT, 목적지 PORT, 전송 제어, 순서, 검증 정보...

UDP : 기능은 별로 없지만 단순하고 빠름

#### 1-4 PORT

PORT - 같은 IP 내에서 프로세스 구분

0 ~ 65535 할당 가능

0 ~ 1023 : 잘 알려진 포트, 사용하지 않는 것이 좋음

#### 1-5 DNS

<img src="assets/image-20220919115642439.png" alt="image-20220919115642439" style="zoom:50%;" />

#### 2. URI와 웹 브라우저 요청 흐름

#### 2-1 URI

<img src="assets/image-20220919120714594.png" alt="image-20220919120714594" style="zoom:50%;" />

URN은 거의 안쓰이고 URL과 URI는 거의 같은 의미로 쓰임

<img src="assets/image-20220919120801196.png" alt="image-20220919120801196" style="zoom:50%;" />

#### 2-2 웹 브라우저 요청 흐름

1. URL 요청

2. DNS 조회(IP, PORT)

3. HTTP 요청 메세지 생성

   <img src="assets/image-20220919121757622.png" alt="image-20220919121757622" style="zoom:50%;" />

4. SOCKET 라이브러리를 통해 OS로 전달

5. TCP/IP 패킷 생성(HTTP 메세지 포함)

6. 서버로 요청 패킷 전달

7. 서버에서 HTTP 메세지 파싱

8. HTTP 응답 메세지 생성

   <img src="assets/image-20220919122111996.png" alt="image-20220919122111996" style="zoom:50%;" />

9. 클라이언트로 응답 패킷 전달

10. 클라이언트에서 HTTP 응답 메세지 파싱

11. 웹 브라우저 HTML 렌더링

### 3. HTTP 기본

#### 3-1 모든 것이 HTTP

HTTP(HyperText Transfer Protocol) : HTML, TEXT 뿐만 아니라 IMAGE, 음성, 영상, 파일, JSON, XML 등 거의 모든 형태의 데이터 전송 가능

HTTP/1.1 : 가장 많이 사용, 우리에게 가장 중요한 버전

HTTP/2 : 성능 개선

HTTP/3 진행중 : TCP 대신 UDP 사용, 성능 개선

#### 3-2 클라이언트 서버 구조

#### 3-3 Stateful, Stateless

최대한 stateless로 설계하고 어쩔수없는 부분(로그인 등)만 stateful로 설계

#### 3-4 비 연결성(connectionless)

#### 3-5 HTTP 메시지

<img src="assets/image-20220919144848093.png" alt="image-20220919144848093" style="zoom:50%;" />

### 4. HTTP 메서드

#### 4-1 HTTP API를 만들어보자

#### 4-2 HTTP 메서드 - GET, POST

GET 요청은 캐싱을 해서 조회는 웬만하면 GET으로

POST

- 새 리소스 생성(등록)
- 요청 데이터 처리
- 다른 메서드로 처리하기 애매한 경우

#### 4-3 HTTP 메서드 - PUT, PATCH, DELETE

PUT : 리소스가 있으면 대체, 없으면 생성

PATCH : 리소스 부분 변경(PUT은 완전히 대체해버림 부분변경 x)

DELETE : 리소스 삭제

#### 4-4 HTTP 메서드의 속성

안전(Safe) : 호출해도 리소스를 변경하지 않는다

멱등(Idempotent) : 한 번 호출하든 두 번 호출하든 몇 번 호출하든 결과가 똑같다

- GET (o)
- PUT (o)
- DELETE (o)
- POST (x)
- 서버에서 응답이 없을 때 같은 요청을 다시 보내도 되는지에 대한 판단의 근거

캐시가능(Cacheable)

- 응답 결과 리소스를 캐시해서 사용해도 되는가?

- GET, HEAD, POST, PATCH 캐시가능
- 실제로는 GET, HEAD 정도만 캐시로 사용
- POST, PATCH는 본문 내용까지 캐시 키로 고려해야 하는데, 구현이 쉽지않음

### 5. HTTP 메서드 활용

#### 5-1 클라이언트에서 서버로 데이터 전송

#### 5-2 HTTP API 설계 예시

컬렉션 vs 스토어

컬렉션

- POST 기반 등록(서버가 새로 등록된 리소스 URI를 생성해준다)

  ex) POST /members

스토어

- PUT 기반 등록(클라이언트가 직접 리소스의 URI를 지정한다)

  ex) PUT /files/star.jpg

컬렉션을 많이 사용함

API 설계는 리소스와 메서드로 최대한 해결하고 안되면 컨트롤 URI를 씀

### 6. HTTP 상태코드

#### 6-1 HTTP 상태코드 소개

- 1xx (Informational): 요청이 수신되어 처리중
- 2xx (Successful): 요청 정상 처리
- 3xx (Redirection): 요청을 완료하려면 추가 행동이 필요
- 4xx (Client Error): 클라이언트 오류, 잘못된 문법등으로 서버가 요청을 수행할 수 없음
- 5xx (Server Error): 서버 오류, 서버가 정상 요청을 처리하지 못함

#### 6-2 2xx - 성공

#### 6-3 3xx - 리다이렉션1

#### 6-4 3xx - 리다이렉션2

#### 6-5 4xx - 클라이언트 오류, 5xx - 서버 오류



