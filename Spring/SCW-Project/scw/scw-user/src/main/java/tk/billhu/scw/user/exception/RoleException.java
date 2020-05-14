package tk.billhu.scw.user.exception;

public class RoleException extends RuntimeException {
    public RoleException(RoleExceptionEnum roleExceptionEnum){
        super(roleExceptionEnum.getMsg());
    }
}
