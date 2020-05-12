package tk.billhu.scw.user.exception;

public enum RoleExceptionEnum {
    NAME_EXIST(1,"角色名已经存在"),
    SAVE_ERROR(2,"角色保存失败");

    private int code;
    private String msg;


    private RoleExceptionEnum(int code, String msg) {
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
