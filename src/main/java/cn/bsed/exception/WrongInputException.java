package cn.bsed.exception;

/**
 * @author SQM
 * @date 2018/1/18
 * @version: 1.0
 */
public class WrongInputException extends ForeException {
    public WrongInputException() {
        super();
    }

    public WrongInputException(String message) {
        super(message);
    }
}
