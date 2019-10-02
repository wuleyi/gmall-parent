package org.leyi.gmall.admin.config;

import com.baomidou.mybatisplus.extension.api.R;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * Created by leyi on 2019/6/8.
 */
@Slf4j
@Aspect
@Component
public class GlobalParamValidator {

    @Around("execution(* org.leyi.gmall.admin..controller..*.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        log.info("【参数校验切面】开始运作...");

        //前置通知
        for (Object obj : args) { //获取当前所有参数
            if (obj instanceof BindingResult) { //只获取感兴趣的BindingResult
                BindingResult bindingResult = (BindingResult) obj;
                if (bindingResult.hasFieldErrors()) { //判断校验有无错误
                    return R.failed(bindingResult.getFieldErrors().get(0).getDefaultMessage());
                }
            }
        }

        // 方法执行完成  method.invoke();
        Object proceed = proceedingJoinPoint.proceed(args);

        // 后置通知
        return proceed;
    }

}
