package cn.czqiang.exception;

/**
 * Created with IntelliJ IDEA.
 * User: 陈志强
 * Date: 13-10-16
 * Time: 下午9:09
 */
public class UserException extends RuntimeException {
    public UserException() {
        super();    //To change body of overridden methods use File | Settings | File Templates.
    }

    public UserException(String message) {
        super(message);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public UserException(Throwable cause) {
        super(cause);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
