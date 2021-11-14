package sx_vote.enums;


public enum EnuSexType {
    MALE(0,"男"),
    FEMALE(1,"女"),
    OTHER(2,"其他");
    private Integer code;
    private String text;

    public static String valueOf(Integer code){
        switch (code){
            case 0:
                return MALE.name();
            case 1:
                return FEMALE.name();
            default:
                return OTHER.name();
        }
    }
    EnuSexType(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    public Integer getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
}
