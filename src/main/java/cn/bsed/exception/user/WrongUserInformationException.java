package cn.bsed.exception.user;

/**
 * @author SQM
 * @date 2018/1/19
 * @version: 1.0
 */
public class WrongUserInformationException extends UserException {
    public WrongUserInformationException() {
        super();
    }

    public WrongUserInformationException(String message) {
        super(message);
    }
}
