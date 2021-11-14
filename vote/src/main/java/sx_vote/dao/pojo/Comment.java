package sx_vote.dao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int id;
    private String content;
    private int createDate;
    private int articleId;
    private int authorId;
    private int parentId;
    private int toUid;
    private int level;
}
