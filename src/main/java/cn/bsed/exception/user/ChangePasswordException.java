package cn.bsed.exception.user;

/**
 * @author SQM
 * @date 2018/1/19
 * @version: 1.0
 */
public class ChangePasswordException extends UserException {
    public ChangePasswordException() {
        super();
    }

    public ChangePasswordException(String message) {
        super(message);
    }
}
