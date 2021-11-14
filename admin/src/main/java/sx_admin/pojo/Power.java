package sx_admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Power {

    @TableId(type = IdType.AUTO)
    private long id;

    private  String name ;

    private String path;

    private  String description;
}
