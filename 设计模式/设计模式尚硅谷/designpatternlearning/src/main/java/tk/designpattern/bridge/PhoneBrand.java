package tk.designpattern.bridge;

public enum PhoneBrand implements Brand {
    HUAWEI("HuaWeiPhone"){
        @Override
        public void call() {
            System.out.println(this + " is calling***...");
        }
    },
    XIAOMI("XiaoMiPhone"){
        @Override
        public void call() {
            System.out.println(this + " is calling###...");
        }
    },
    APPLE("IPHONE"){
        @Override
        public void call() {
            System.out.println(this + " is calling@@@...");
        }
    },
    VIVO("VivoPhone"){
        @Override
        public void call() {
            System.out.println(this + " is calling$$$...");
        }
    };

    private String brandName;

    PhoneBrand(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "PhoneBrand{" +
                "brandName='" + brandName + '\'' +
                '}';
    }

    @Override
    public void call() {
        System.out.println(this + " is calling...");
    }

    @Override
    public String getBrandName() {
        return brandName;
    }
}
