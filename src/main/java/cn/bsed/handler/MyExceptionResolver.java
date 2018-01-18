package cn.bsed.handler;

import cn.bsed.exception.CorrectInputException;
import cn.bsed.exception.WrongInputException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author SQM
 * @date 2018/1/18
 * @version: 1.0
 */
@Controller
public class MyExceptionResolver {
    //WrongInputException处理
    @ExceptionHandler(WrongInputException.class)
    public String handleWrongInputException(Exception e, Model model) {
        model.addAttribute("ex", e);
        return "error/wrongInputException";
    }

    //CorrectInputException处理
    @ExceptionHandler(CorrectInputException.class)
    public String handleCorrectInputException(Exception e, Model model) {
        model.addAttribute("ex", e);
        return "error/correctInputException";
    }

    //其他异常处理
    @ExceptionHandler
    public String handleOtherException(Exception e, Model model) {
        model.addAttribute("ex", e);
        return "error/defaultError";
    }
}
