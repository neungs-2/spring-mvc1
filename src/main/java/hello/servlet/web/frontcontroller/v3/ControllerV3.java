package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    // 서블릿을 사용하지 않아서 코드가 단순해짐
    // 테스트 코드로 테스트가 쉬워짐
    ModelView process(Map<String, String> paramMap);
}
