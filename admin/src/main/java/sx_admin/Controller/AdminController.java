package sx_admin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sx_admin.Service.PowerService;
import sx_admin.model.params.PageParam;
import sx_admin.pojo.Power;
import sx_admin.vo.Result;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private PowerService powerService;
    @PostMapping("/permission/permissionList")
    public Result listPermission(@RequestBody PageParam pageParam){

        return  powerService.listPower(pageParam);
    }

    @PostMapping("permission/add")
    public Result add(@RequestBody Power power) {

        return powerService.add(power);
    }

    @PostMapping("permission/update")
    public Result update(@RequestBody Power power) {

        return powerService.update(power);
    }

    @GetMapping("permission/delete/{id}")
    public Result delete(@PathVariable("id") Long id) {
        return powerService.delete(id);
    }

}
