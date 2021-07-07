# Spring-Boot-Test


## 스프링 부트 [메모용] 프로젝트

https://start.spring.io/   

## Project Select   
IDE: Intellij   
Build Tool: Gradle   
Spring Boot: 2.5.2   
Language: Java   
Packaging: Jar   
Java: 11   

Dependencies: Spring Web, Thymeleaf, devtools   
   
## Project Metadata   
groupId: hello (모든 프로젝트 중에서 당신의 프로젝트를 식별하게 해주는 식별자, Java의 패키지 이름 규칙:도메인 이름의 반대로 시작)  
artifactId: hello-spring (버전 없는 jar파일의 이름, 특수문자x,소문자로만 작성)   
version: (배포를 하려면 숫자와 점으로 구성된 일반적인 버전, SNAPSHOT: 아직 배포되기 전 임시로 만들어 놓은 버전, 개발 중이라는 의미)
   
## 추가 설치한 플로그인 정리
.ignore, Atom Material Icons, Awesome Console, GitToolBox, Grep Console, Key Promoter X, Rainbow Brackets, Sticky Selection, Translator
    
## MEMO   
etc memo:    
JUnit, Assertj, concurrent.*, Optional<T>, Anonymous Object, lambda, Method Reference     
   
#### IntelliJ Gradle 대신에 자바 직접 실행  
 최근 IntelliJ 버전은 Gradle을 통해서 실행 하는 것이 기본 설정이다. 이렇게 하면 실행속도가 느리다.   
다음과 같이 변경하면 자바로 바로 실행해서 실행속도가 더 빠르다.   
File -> Setting -> Build, Execution, Deployment -> Build Tools ->Gradle   
Build and run using: Gradle IntelliJ IDEA   
Run tests using: Gradle IntelliJ IDEA   
     
      
초기에 셋팅 할 것   
Keymap, Java Compiler:javac, 테마,   
UTF-8 인코딩 설정 할 것(Help->Edit Custom VM Options, File->Setting->Editor->File Encdoing->3개 설정)   

Intellij    
프로젝트 JDK 설정 : Windows: File Project Structure(Ctrl+Alt+Shift+S) -> Java 11   
gradle JDK 설정 : Windows: File Settings(Ctrl+Alt+S) -> Java 11   
   
## 라이브러리 설명
스프링 부트 라이브러리   
spring-boot-starter-web   
spring-boot-starter-tomcat: 톰캣 (웹서버)   
spring-webmvc: 스프링 웹 MVC   
     
spring-boot-starter-thymeleaf: 타임리프 템플릿 엔진(View)   
      
spring-boot-starter(공통): 스프링 부트 + 스프링 코어 + 로깅   
spring-boot   
spring-core   
spring-boot-starter-logging   
logback, slf4j   
      
테스트 라이브러리   
spring-boot-starter-test   
junit: 테스트 프레임워크, mockito: 목 라이브러리, ssertj: 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리, spring-test: 스프링 통합 테스트 지원   

   
## @ResponseBody 원리   
@ResponseBody 를 사용   
HTTP의 BODY에 문자 내용을 직접 반환   
viewResolver 대신에 HttpMessageConverter 가 동작   
기본 문자처리: StringHttpMessageConverter   
기본 객체처리: MappingJackson2HttpMessageConverter    
byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음   
    
## 단위 테스트 ( GIVEN -> WHEN -> THEN )   
단위 테스트(Unit Test)는 하나의 모듈을 기준으로 독립적으로 진행되는 가장 작은 단위의 테스트이다.   
테스팅에 대한 시간과 비용을 절감할 수 있다.   
새로운 기능 추가 시에 수시로 빠르게 테스트 할 수 있다.   
리팩토링 시에 안정성을 확보할 수 있다.   
stub: 다른 객체 대신에 가짜 객체(Mock Object)를 주입하여 어떤 결과를 반환하라고 정해진 답변을 준비하는 것.
예를 들어 데이터베이스에 새로운 데이터를 추가하는 코드를 테스트한다고 하면, 가짜 데이터베이스(Mock Database)를 주입하여 insert 처리 시에 반드시에 1을 반환하도록 해주는 것이 stub이다.   

#### 좋은 단위 테스트의 특징   
1개의 테스트 함수에 대해 assert를 최소화하라   
1개의 테스트 함수는 1가지 개념 만을 테스트하라   

좋고 깨끗한 테스트 코드는 FIRST라는 5가지 규칙을 따라야 한다.   
Fast: 테스트는 빠르게 동작하여 자주 돌릴 수 있어야 한다.   
Independent: 각각의 테스트는 독립적이며 서로 의존해서는 안된다.   
Repeatable: 어느 환경에서도 반복 가능해야 한다.   
Self-Validating: 테스트는 성공 또는 실패로 bool 값으로 결과를 내어 자체적으로 검증되어야 한다.   
Timely: 테스트는 적시에 즉, 테스트하려는 실제 코드를 구현하기 직전에 구현해야 한다.   

@Before: 초기화 (테스트 전 실행할 코드 정의)    
@After: 해제 (테스트 후 실행할 코드를 정의)    
@Test: 테스트 메소드     
@Test(timeout=5000) : 테스트 메소드 수행시간 제한(mili second)    
@Test(expected=RuntimeException.class) : 테스트 메소드가 선언된 exception을 발생시켜야 테스트가 성공     
   
@AfterEach : @AfterEach 를 사용하면 각 테스트가
종료될 때 마다 이 기능을 실행한다. 여기서는 메모리 DB에 저장된 데이터를 삭제한다.
테스트는 각각 독립적으로 실행되어야 한다. 테스트 순서에 의존관계가 있는 것은 좋은 테스트가 아니다.
      
JUint:   
import org.junit.jupiter.api.Assertions;   
Assertions.assertEquals(member, result); // assertEquals(expected, actual)   
     
Assertj: (가독성 좋음)     
import static org.assertj.core.api.Assertions.assertThat;   
assertThat(result).isEqualTo(member); // assertThat(acture).isEqualTo(expected)    
assertThat("The Lord of the Rings").isNotNull().startsWith("The").contains("Lord").endsWith("Rings");      
assertThat(frodo.getAge()).as("check %s's age", frodo.getName()).isEqualTo(100);  //// as를 assertion 이전에 넣어라.      
assertThat(list).filteredOn(human -> human.getName().contains("a")) .containsOnly(park, jack);     
assertThat(list).filteredOn("age", notIn(22)).containsOnly(park, lee);      
assertThat(list).extracting("name", "age") .contains(tuple("Kim", 22), tuple("Park", 25), tuple("Lee", 25), tuple("Amy", 22), tuple("Jack",22));      
assertThatThrownBy(() -> { throw new Exception("boom!"); }).isInstanceOf(Exception.class) .hasMessageContaining("boom");     
assertThatIOException().isThrownBy(() -> { throw new IOException("boom!"); }) .withMessage("%s!", "boom") .withMessageContaining("boom") .withNoCause();     
  
## 트랜잭션(Transaction)
데이터베이스의 상태를 변경시키는 작업 또는 한번에 수행되어야하는 연산들을 의미한다.
트랜잭션 작업이 끝나면 Commit 또는 Rollback 되어야한다.
원자성(Atomicity)    
한 트랜잭션 내에서 실행한 작업들은 하나의 단위로 처리합니다 즉, 모두 성공 또는 모두 실패   
일관성(Consistency)   
트랜잭션은 일관성 있는 데이터베이스 상태를 유지한다.   
격리성(Isolation)   
동시에 실행되는 트랜잭션들이 서로 영향을 미치지 않도록 격리해야한다.   
영속성(Durability)    
트랜잭션을 성공적으로 처리되면 결과가 항상 저장되어야한다.   
   
@Transactional   
스프링에서 지원하는 선언적 트랜잭션이다   
//@Transactional(propagation = , isolation = ,noRollbackFor = ,readOnly = ,rollbackFor = ,timeout = )   

## IntelliJ 단축키 정리(Win)   
Ctrl+P: 메서드의 매개변수 조회(커서가 위치한)     
Ctrl+E, Ctrl+Shift+E : 최근 연 파일 목록 검색   
Shift+F6: 이름변경   
Shift+Shift: Search Everywhere   
Alt+Insert: Generate (Lombok 사용해도 됨)   
Alt+Enter: Quick-fixes   
Ctrl+Shift+Space: 적합한 코드 자동완성을 추천(Smart Code Completion)   
   
#### 디버깅(Alt+Shift+F9)   
Ctrl+F2: Stop   
F7 : Step Into   
F8 : Step Over   
Shift+F8 : Step Out
F9 : Resume programe   
Shift+F8 / Shift + F7 : smart step into / smart step out   
Ctrl+F8 : Toggle breakpoint   
Ctrl+Shift+F8: View breakpoints   
   
#### Search     
Shift+Shift: Search Everywhere   
Ctrl+F: 파일 내 검색   
F3 / Shift+F3: 다음 검색 항목 / 이전 검색 항목   
Ctrl+R: 대체(Replace)   
Ctrl+Shift+F: Find in path   
   
#### Editing   
Ctrl+Space: 기본 코드 자동 완성(Basic code completion)   
Ctrl+Shift+Space: 적합한 자동완성 추천(Smart code completion)   
Ctrl+Shift+Enter: 문장 완성(Complete statement)   
Ctrl+P: 매개변수 정보 조회(within method call arguments)   
Ctlr+/: 한줄 주석 생성/제거   
Ctrl+Shift+/: 블록 주석 생성/제거    
Ctrl+Alt+L: 코드 정리(Reformat code)   
Ctrl+Alt+O: import 정리(Optimize imports)   
Shift+Enter: Start new line   
Ctrl+Shift+]/[: Select till code block end/start   
Ctrl+Numpad+/-: Expand/Collapse   
Ctrl+Alt+Shift+T: 사용 가능한 리팩토링 옵션 표시(rename)   
Ctrl+Y: 캐럿의 라인 삭제   
Ctrl+D:선택된 블럭을 복제   
Ctrl+Alt+V: Extract Variable   
Ctrl+Alt+M: Extract Method   
Alt+Enter: Static import   
      
#### Navigation (이동 관련)   
Ctrl+N: Class로 이동   
Ctrl+Shift+N: 파일로 이동   
Ctrl+Alt+Shift+N: Go to symbol   
Ctrl+Alt+Left/Right: Navigate back/forward   
Ctrl+Shift+Backspace: Navigate to last edit location   
Ctrl+B/Ctrl+Click: Go to declaration   
Ctrl+Alt+B: Go to implementations   
Ctrl+Shift+I: Open quick definition lookup   
Ctrl+Shift+B: Go to type declaration   
Ctrl+U: Go to super-method/super-class   
Ctrl+]/[: Move to code block end/start   
Ctrl+F12: File structure popup   
Ctrl+Shift+H: Method hiearchy   
F4/Ctrl+Enter: Edit source/View source   
F11: Toggle bookmark   
Shift+F11: Show bookmarks    
   
#### Compile and Run ( 컴파일 및 실행 관련 )   
Ctrl+F9: 프로젝트 빌드   
Ctrl+Shift+F9: 선탁한 파일, 패키지 혹은 모듈 컴파일   
Alt+Shift+F10/F9: configuration 선택 후 실행/디버깅   
Shift+F10/F9: 프로젝트 실행/디버깅   
Ctrl+Shift+F10: Run context configuration from editor   
   
#### Usage Search (사용처 검색 관련 )   
Alt+F7/Ctrl+F7: 사용처 탐색/파일 내 사용처 탐색   
Ctrl+Shift+F7: 파일 내 사용처 하이라이트   
Ctrl+Alt+F7: 사용처 조회(Show usages)   

## 단축키 비교 [IntelliJ, VSCode, Eclipse, VS]
   
<table>
<thead>
<tr>
<th><strong>기능</strong></th>
<th><strong>IntelliJ</strong></th>
<th><strong>VSCode</strong></th>
<th><strong>Eclipse</strong></th>
<th><strong>VS</strong></th>
</tr>
</thead>
<tbody><tr>
<td>자동 완성, 인텔리센스</td>
<td>Ctrl + Space</td>
<td></td>
<td>Ctrl + Space</td>
<td>Alt + Right</td>
</tr>
<tr>
<td>SmartType code completion</td>
<td>Ctrl + Shift + Space</td>
<td></td>
<td>-</td>
<td></td>
</tr>
<tr>
<td>Reformat, Code Tidy</td>
<td>Ctrl + Alt + L</td>
<td>Ctrl + Shift + F</td>
<td>Ctrl + Shift + F</td>
<td></td>
</tr>
<tr>
<td>Quick Fix</td>
<td>Alt + Enter</td>
<td></td>
<td>Ctrl + 1</td>
<td></td>
</tr>
<tr>
<td>Navigate | Declaration (Open Declaration)</td>
<td>Ctrl + B</td>
<td></td>
<td>F3</td>
<td></td>
</tr>
<tr>
<td>Go to file(Open Resource)</td>
<td>Ctrl + Shift + N</td>
<td>Ctrl + P</td>
<td>Ctrl + Shift + R</td>
<td></td>
</tr>
<tr>
<td>Find in Path (Search Project)</td>
<td>Ctrl + Shift + F</td>
<td></td>
<td>Ctrl + H</td>
<td></td>
</tr>
<tr>
<td>Rename</td>
<td>Shift + F6</td>
<td>F2</td>
<td>Ctrl + Alt + R</td>
<td>F2 or Ctrl + R, R</td>
</tr>
<tr>
<td>Extract Variable</td>
<td>Ctrl + Alt + V</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Extract Method</td>
<td>Ctrl + Alt + M</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>Quick Documentation</td>
<td>Ctrl + Q</td>
<td></td>
<td>F2</td>
<td></td>
</tr>
<tr>
<td>검색(형 기반의 전역 검색)<br>Go to class</td>
<td>Ctrl + N</td>
<td></td>
<td>Ctrl + Shift + T</td>
<td>Ctrl + ,</td>
</tr>
<tr>
<td>Go to symbol</td>
<td>Ctrl + Alt + Shift + N</td>
<td></td>
<td>-</td>
<td></td>
</tr>
<tr>
<td>이전 작업 위치(이거 짱짱맨)</td>
<td>Ctrl + Alt + ←</td>
<td></td>
<td>Alt + ←</td>
<td>Ctrl + -</td>
</tr>
<tr>
<td>다음 작업 위치(반대)</td>
<td>Ctrl + Alt + →</td>
<td></td>
<td>Alt + →</td>
<td>Shift + Ctrl + -</td>
</tr>
<tr>
<td>코드 한 줄 혹은 선택 영역을 한 줄 위로 이동</td>
<td>Ctrl + Shift + ↑</td>
<td>Alt + ↑</td>
<td>Alt + ↑</td>
<td>Alt + ↑</td>
</tr>
<tr>
<td>코드 한 줄 혹은 선택 영역을 한 줄 아래로 이동</td>
<td>Ctrl + Shift + ↓</td>
<td>Alt + ↓</td>
<td>Alt + ↓</td>
<td>Alt + ↓</td>
</tr>
<tr>
<td>코드 한 줄 혹은 선택 영역 복사</td>
<td>Ctrl + D</td>
<td>Ctrl + C<br>Alt + Shift + ↓</td>
<td>Ctrl + D</td>
<td>Ctrl + C</td>
</tr>
<tr>
<td><strong>기능</strong></td>
<td><strong>IntelliJ</strong></td>
<td><strong>VSCode</strong></td>
<td><strong>Eclipse</strong></td>
<td><strong>VS</strong></td>
</tr>
<tr>
<td>도구(메뉴나 다이얼로그 항목 등) 찾기<br>Search Action (Quick Access)</td>
<td>Ctrl + Shift + A</td>
<td>Ctrl + Shift + P</td>
<td>Ctrl + 3</td>
<td>Ctrl + Q</td>
</tr>
<tr>
<td>Search everywhere (Quick Search Plugin)</td>
<td>Double Shift</td>
<td></td>
<td>Ctrl + Shift + L</td>
<td></td>
</tr>
<tr>
<td>View Hierarchy (Show Hierarchy)</td>
<td>Ctrl + H</td>
<td></td>
<td>Ctrl + T</td>
<td></td>
</tr>
<tr>
<td>Find Usages (Find References)</td>
<td>Alt + F7</td>
<td></td>
<td>Ctrl + Shift + G</td>
<td></td>
</tr>
<tr>
<td>Find</td>
<td>Ctrl + F</td>
<td>Ctrl + F</td>
<td>Ctrl + F</td>
<td></td>
</tr>
<tr>
<td>Find next</td>
<td>F3</td>
<td></td>
<td>Ctrl + K</td>
<td></td>
</tr>
<tr>
<td>Find previous</td>
<td>Shift + F3</td>
<td></td>
<td>Ctrl + Shift + K</td>
<td></td>
</tr>
<tr>
<td>Replace</td>
<td>Ctrl + R</td>
<td></td>
<td>Ctrl + F</td>
<td></td>
</tr>
<tr>
<td>Find in path (Search)</td>
<td>Ctrl + Shift + F</td>
<td></td>
<td>Ctrl + H</td>
<td></td>
</tr>
<tr>
<td>문법 해결(네임스페이스 찾기/ 인터페이스 구현 등)</td>
<td></td>
<td></td>
<td></td>
<td>Shift + Alt + F10</td>
</tr>
<tr>
<td>솔루션 탐색기</td>
<td></td>
<td></td>
<td></td>
<td>Ctrl + W, S</td>
</tr>
<tr>
<td>출력 창</td>
<td></td>
<td>Ctrl + `</td>
<td></td>
<td>Ctrl + W, O</td>
</tr>
<tr>
<td>솔루션 탐색기 검색</td>
<td></td>
<td></td>
<td></td>
<td>Ctrl + ;</td>
</tr>
<tr>
<td>주석 처리</td>
<td>Ctrl + /</td>
<td>Ctrl + /</td>
<td>Ctrl + /</td>
<td>Ctrl + E, C</td>
</tr>
<tr>
<td>주석 제거</td>
<td>Ctrl + /</td>
<td>Ctrl + /</td>
<td>Ctrl + /</td>
<td>Ctrl + E, U</td>
</tr>
<tr>
<td>코드 아웃라인(네임스페이스, 클래스, 메서드 등등) 토글</td>
<td></td>
<td></td>
<td>Ctrl + M, M</td>
<td></td>
</tr>
<tr>
<td>파일 내 전체 코드 아웃라인 토글</td>
<td></td>
<td></td>
<td></td>
<td>Ctrl + M, L</td>
</tr>
<tr>
<td>테스트 탐색기</td>
<td></td>
<td></td>
<td></td>
<td>Alt + S, W, T<br>(메뉴 단축키 경로)</td>
</tr>
<tr>
<td>팀 탐색기</td>
<td></td>
<td></td>
<td></td>
<td>Ctrl + , Ctrl + M</td>
</tr>
<tr>
<td>전체 테스트 실행</td>
<td></td>
<td></td>
<td></td>
<td>Ctrl + R, A</td>
</tr>
<tr>
<td>캐럿 기준 현재 테스트 실행</td>
<td></td>
<td></td>
<td></td>
<td>Ctrl + R, T</td>
</tr>
<tr>
<td>코드 렌즈 테스트 결과 팝업</td>
<td></td>
<td></td>
<td></td>
<td>Alt + 1</td>
</tr>
</tbody></table>
