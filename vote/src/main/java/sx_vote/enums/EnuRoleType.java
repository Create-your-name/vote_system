package sx_vote.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public enum EnuRoleType {
    ADMIN(0,"管理员"),
    USER(1,"用户");
    private Integer code;
    private String text;

    public static String valueOf(Integer code){
        switch (code){
            case 0:
                return ADMIN.name();
            case 1:
                return USER.name();
            default:
                return "";
        }
    }
    EnuRoleType(Integer code, String text) {
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
