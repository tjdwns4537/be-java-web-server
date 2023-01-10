# Java web server

 ## 집중했던 부분: 

<br/>

 1) socket 통신의 개념적인 이해
 2) 쓰레드 사용
 3) 유지보수 좋은 코드 작성하기

<br/>

 ## 1일차

<br/>

 ### 클래스 역할

<br/>

 - RequestHandler : 클라이언트에서 요청이 들어오면 요청한 파일을 다시 클라이언트로 전달해준다.

<br/>

 ### 학습

<br/>


- 개념 이해
1. DataOutputStream <br/>

: FileReader는 데이터를 읽어서 숫자 데이터로 변환해줘야하지만,DataOutputStream은 데이터 변환까지 해줘서 파일을 읽고 쓰는 클래스 (즉, 프리미티브 타입의 데이터를 읽을 수 잇음)
 
  > write() : 데이터를 파일에 쓰기<br/>

  > flush() <br/>

  : 현재 버퍼에 저장되 있는 내용을 클라이언트에 전송하고 버퍼를 비운다.<br/>

  즉, 강제로 버퍼의 내용을 전송함으로써 데드락 상태를 해제한다.<br/>

  <br/>
<br/>

2. 프록시<br/>

: 클라이언트와 서버 사이에 존재하며 캐싱, 필터링, 로드 밸런싱, 인증, 로깅 등의 다양한 기능을 수행한다.<br/>

<br/>

<br/>

3. 브라우저 동작 방식<br/>

> 최초에는 HTML 을 가져온다.<br/>

> HTML에서 CSS, js, 이미지에 대한 링크 정보를 추출한다.<br/>

> 추출한 정보의 URL을 이용 새로운 요청을 보낸다.<br/>

> 모든 웹 자원을 받아와서 렌더링을 시작한다.<br/>

> 1.1 은 파이프라인, 2.0은 병렬처리로 성능을 개선하였다.<br/>

<br/>

<br/>


4. MIME 타입이란? <br/>

> 클라이언트에게 전송된 문서의 다양성을 알려주기 위한 메커니즘 <br/>

> 브라우저들은 리소스를 내려받았을 때 해야 할 기본 동작이 무엇인지를 결정하기 위해 MIME 타입 사용 <br/>

<br/>

<br/>

5. 수업 노트
 - 리퀘스트 핸들러를 왜 쓰레드로 생성했는가?<br/>

    - runnable의 run : 스레드를 실행<br/>

    - thread 의 start: 스레드를 생성<br/>

 <br/>

<br/>

- 왜 멀티스레드로 생성하나?<br/>

    - 많은 사람들이 사용하게 하기 위함<br/>

    - thread.start 안에 runnable 하지 않는다면 싱글 스레드로 한명만   실행 가능<br/>
      <br/>

<br/>

- 쓰레드를 만들고 없애는 비용은 엄청 크다.
   <br/>

    - 쓰레드를 계속 생성하고 삭제하는게 아님
    - 쓰레드 풀에 미리 쓰레드를 만들어 놓고 하나씩 빼내서 쓰는게 좋다.<br/>
   
<br/>

<br/>

- 풀 리퀘스트를 웬만하면 해라<br/>

    - PR 을 하면 revert가 가능
    - reset 으로 커밋을 돌리면 작업했던 내용이 다 날라감
    - PR을 하면 돌리기 전 작업 내역도 남아 있음







