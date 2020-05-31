package tk.billhu.gulimall.common.constant;

public class Product {
    public enum AttrEnum{
        BASE_ATTR(1,"基本属性"),SALES_ATTR(0,"销售属性"),BASE_SALES_ATTR(2,"同时属于基本和销售属性");
        private int code;
        private String msg;

        AttrEnum(int code, String msg){
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
