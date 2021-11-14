package sx_vote.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sx_user")
public class User {
    //基本信息
    @TableId(type = IdType.AUTO)
    private int autoid; //自增ID
    private LocalDateTime createtime; //创建时间
    private LocalDateTime lastlogin; //上次登录时间
    private String username; //用户名
    private String password; //密码
    private Integer role; //角色暂时用枚举（可考虑换成RBAC设计)
    //拓展信息
    private Integer age; //年龄
    private Integer sex; //性别枚举
    private String email; //邮箱
    private String phone; //手机号
    private String classes; //班级信息
}
