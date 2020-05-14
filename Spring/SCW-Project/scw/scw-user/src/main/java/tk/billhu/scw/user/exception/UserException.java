package tk.billhu.scw.user.exception;

import tk.billhu.scw.enums.UserExceptionEnum;

public class UserException extends RuntimeException {
    public UserException(UserExceptionEnum userExceptionEnum){
        super(userExceptionEnum.getMsg());
    }
}
