package sx_vote.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import sx_vote.dao.pojo.Comment;
import sx_vote.dao.pojo.Tag;

import java.util.List;
@Repository
public interface SX_TagMapper extends BaseMapper<Tag> {
    List<Tag> findall();
}
