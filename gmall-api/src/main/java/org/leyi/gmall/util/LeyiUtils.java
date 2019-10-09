package org.leyi.gmall.util;

import com.baomidou.mybatisplus.core.toolkit.ClassUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanMap;

import java.util.Map;

public class LeyiUtils {

    public static <S,T> T copyProperties(S source, T target){
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static Object mapToBean(Map<String,Object> t, Class<?> clazz ){
        Object bean = ClassUtils.newInstance(clazz);
        BeanMap.create(bean).putAll(t);
        return bean;
    }

}
