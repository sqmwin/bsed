package cn.bsed.controller;

import cn.bsed.exception.CorrectInputException;
import cn.bsed.exception.ForeException;
import cn.bsed.exception.WrongInputException;
import cn.bsed.handler.MyExceptionResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author SQM
 * @date 2018/1/18
 * @version: 1.0
 */
@Controller
@RequestMapping("/test")
public class TestController extends MyExceptionResolver {
    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String notFound() {
        return "error/404";
    }

    @RequestMapping(value = "/exception_test_page", method = RequestMethod.GET)
    public String exceptionTestPage() {

        return "test/exception";
    }

    @RequestMapping(value = "/exception_test", method = RequestMethod.GET)
    public String exceptionTest(@RequestParam("test") String text) throws ForeException {
        String result = "yes";
        if (!text.equals(result)) {
            throw new WrongInputException("输入错误");
        } else {
            throw new CorrectInputException("输入正确");
        }
    }

}
