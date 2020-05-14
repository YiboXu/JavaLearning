package tk.billhu.scw.user.exception;

public class PermissionException extends RuntimeException {
    public PermissionException(PermissionExceptionEnum permissionExceptionEnum){
        super(permissionExceptionEnum.getMsg());
    }
}
