package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String headers(HttpServletRequest request, HttpServletRequest response, HttpMethod httpMethod, Locale locale, @RequestHeader MultiValueMap<String , String > headerMap, @RequestHeader("host")String host, @CookieValue(value="myCookie", required = false) String cookie) {
        log.info("request={}", request);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale); //언어정보
        //locale을 다른걸로 확장하는거..? locale resolver 있으니 찾아볼 것.
        log.info("headerMap={}", headerMap);
        log.info("host={}", host);
        log.info("cookie={}", cookie);

        return "ok";
    }
}
