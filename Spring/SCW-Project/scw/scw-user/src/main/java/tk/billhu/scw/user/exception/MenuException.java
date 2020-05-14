package tk.billhu.scw.user.exception;

public class MenuException extends RuntimeException {
    public MenuException(MenuExceptionEnum menuExceptionEnum){
        super(menuExceptionEnum.getMsg());
    }
}
