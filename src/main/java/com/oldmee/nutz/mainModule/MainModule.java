package com.oldmee.nutz.mainModule;

import org.nutz.mvc.annotation.*;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

/**
 * @Author: R.oldmee
 * @Description:
 * @Date: Create in 12:53 2019/1/18
 */
//@Modules(scanPackage = true) //1.r.58开始默认就是true
@SetupBy(value=MainSetup.class)
@Modules(scanPackage=true)
@IocBy(type= ComboIocProvider.class, args={"*js", "src/",
        // 这个package下所有带@IocBean注解的类,都会登记上
        "*anno", "com.oldmee.nutz.mainModule", // *anno 是AnnotationIocLoader,负责处理注解式Ioc, 例如@IocBean
        "*tx", // 事务拦截 aop
        "*async"}) // 异步执行aop
public class MainModule {

}
