package sx_admin.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sx_admin.mapper.PowerMapper;
import sx_admin.model.params.PageParam;
import sx_admin.pojo.Power;
import sx_admin.vo.PageResult;
import sx_admin.vo.Result;

@Service
public class PowerService {
    @Autowired
    private PowerMapper powerMapper;

    public Result listPower(PageParam pageParam){
        /**
          *  返回的是 power 表中的 所有数据字段 Power 对象
          *@Author 刘海
          *@Data 10:45 2021/10/26
          *@Param
          *@return
          */
        Page<Power> page = new Page<>(pageParam.getCurrentPage(),pageParam.getPageSize());
        LambdaQueryWrapper<Power> queryWrapper =new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(pageParam.getQueryString())){
            queryWrapper.eq(Power::getName,pageParam.getQueryString());
        }
        Page<Power> powerPage= powerMapper.selectPage(page,queryWrapper);
        PageResult<Power> pageResult =new PageResult<>();
        pageResult.setList(powerPage.getRecords());
        pageResult.setTotal(powerPage.getTotal());
        return Result.success(pageResult);
    }

    public Result add(Power power) {
        this.powerMapper.insert(power);
        return  Result.success(null);
    }

    public Result update(Power power) {
        this.powerMapper.updateById(power);
        return  Result.success(null);
    }

    public Result delete(Long id) {
        this.powerMapper.deleteById(id);
        return  Result.success(null);
    }
}
