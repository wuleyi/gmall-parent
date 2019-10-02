package org.leyi.gmall.mbg.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
class BaseParameter<E> {

    private Page<E> page;
    private E e;

}
