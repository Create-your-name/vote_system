package sx_vote.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import sx_vote.dao.pojo.Comment;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Action {
    @TableId(type = IdType.AUTO)
    private  int id;

    private  int powerCounts;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime cdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  LocalDateTime edate;

    private String summary;

    private String title;

    private  int authorid;
/*    @TableId(type = IdType.AUTO)*/
    private  int articleid;
/*    //关联对象
    private Comment comment;*/

    private  String img;
}
