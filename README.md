# MVN_SPRG_MVC_BRD
Example Of Maven Spring MVC Pattern Board.  
Maven으로 Build한 Java Spring Project의 MVC 패턴 게시판 예제.  
  
## 개발 환경
- Language :
  - JDK 1.8
- IDE :
  - VSCODE
  - STS 3.9.8  
    - https://spring.io/tools3/sts/legacy
- Database : MariaDB 10.4.6  
- Spring : 4.3.6.RELEASE
- WAS : Apache Tomcat 9.0
  
## Repository 생성
- Github에 원격 저장소 생성
- local에 clone
- README 작성
- project 폴더 생성
- STS 3에서 Spring Legacy Project 생성

## 프로젝트 생성
1. New -> Spring Legacy Project
2.  
  - Name : Board
  - Template : Spring MVC Project
3. com.study.brd


## 작업 내역
### 20.01.27
- index.jsp redirect to board/list
- jsp CSS 적용

### 20.01.26
- log4jdbc.log4j.properties 수정 -> Driver 안잡아 줘서 main src에서 DB를 못잡음.
- VO DAO Controller Service class 생성
- 게시글 목록 조회 jsp 생성
- 게시글 목록 조회 기능 개발
- 게시글 상세 조회 기능
- 게시글 조회수 수정 기능
- 게시물 삭제 기능

  
### 20.01.25
- MariaDB Connection TEST
- 설정 변경
- Welcome File 생성
- logger library logback으로 변경
- JDBC Logger 설정
- HandlerInterceptorAdapter를 상속받은 LoggerInterceptor 생성
  - Controller로 요청이 들어 올 때, 대상 URI와 Request Parameter를 출력하는데 사용할 수 있다.
- Spring MyBatis 연동, TEST
- Mapper 및 JSON 설정 - 이걸 근데 지금 왜?
  
### 20.01.20
- 프로젝트 생성
- log4j 버전 수정
- jsp 한글 깨짐 수정
  
## 참고할 포스팅
- https://tychejin.tistory.com/10?category=765216