package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class LogTestController {

    //패키지가 slf4j인 걸로 가져올 것.
    //내 클래스를 지정하는 것.
    //이걸 매번 적기 귀찮잖아 ? -> Lombok의 기능 @slf4j 사용
//    private final Logger log = LoggerFactory.getLogger(getClass());

    //위 코드 대신 아래 방법도 가능
//    private final Logger log = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        //{}안에 뒤에 붙은 String이 치환되어 들어감
        //이 로그가 어떤 상태의 레벨인가
        log.trace("trace log={}", name);  //
        log.debug("debug log={}", name); //debug할 때 보는 것. 개발서버 같은 곳
        //실행하면 위 두개는 안나옴

        //application.properties 에서 레벨 설정하면 그 레벨까지 로그 출력됨
        //코드를 건드리지 않고 설정만으로 로그 출력 조절 가능


        //info는 운영서버에서 돌릴 때 info까지만 설정
        //System.out.println과 출력형태가 다르게 됨 이건 무조건 출력됨. 그래서 이걸 쓰면 안돼. 운영서버에 이 로거를 다 남기면 안됨.

        log.info("info log={}", name); //비즈니스 정보(중요정보)
        log.warn("warn log={}, name"); //위험한거야
        log.error("error log={}", name); //에러니까 빨리 확인해야 함.


        //로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 이런 방식으로 사용하면 안됨
//        log.debug("String concat log="+ name);


        //@RestController로 하고 String을 return하면 String이 그냥 반환됨 http 메시지 바디에 return값을 넣음
        //view 이름이 아님.
        return "ok";
    }
}
