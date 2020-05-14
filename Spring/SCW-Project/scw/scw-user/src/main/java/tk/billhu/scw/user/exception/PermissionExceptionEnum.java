package tk.billhu.scw.user.exception;

public enum PermissionExceptionEnum {
    NAME_EXIST(1,"权限已经存在"),
    SAVE_ERROR(2,"权限保存失败");

    private int code;
    private String msg;


    private PermissionExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
