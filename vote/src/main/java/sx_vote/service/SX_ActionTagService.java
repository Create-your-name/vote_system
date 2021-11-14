package sx_vote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sx_vote.dao.mapper.SX_TagMapper;
import sx_vote.dao.pojo.Comment;
import sx_vote.dao.pojo.Tag;

import java.util.List;
@Service
public class SX_ActionTagService {

    @Autowired
    private SX_TagMapper sx_tagMapper;

    public List<Tag> findall() // 查整个表
    {
        return sx_tagMapper.findall();
    }
}
