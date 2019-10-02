package org.leyi.gmall.mbg.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
public abstract class BaseController<E, ID extends Serializable> {

    @Autowired
    public abstract IService<E> getService();

    @GetMapping("/get/{id}")
    public R get(@PathVariable ID id) {
        return R.ok(getService().getById(id));
    }

    @GetMapping("/get")
    public R getAll() {
        return R.ok(getService().list());
    }

    @GetMapping("/page")
    public R getByPage(@RequestBody BaseParameter<E> param) {
        return R.ok(getService().page(param.getPage(), new QueryWrapper<E>(param.getE())));
    }

    @PostMapping("/save")
    public R save(@RequestBody E entity){
        return R.ok(getService().save(entity));
    }

    @PutMapping("/update")
    public R update(@RequestBody E entity){
        return R.ok(getService().updateById(entity));
    }

    @DeleteMapping("/delete/{idList}")
    public R deleteBatch(@PathVariable List<ID> idList){
        return R.ok(getService().removeByIds(idList));
    }

}
