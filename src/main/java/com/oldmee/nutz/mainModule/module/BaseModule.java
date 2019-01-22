package com.oldmee.nutz.mainModule.module;

import com.oldmee.nutz.mainModule.service.EmailService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.lang.random.R;

/**
 * @Author: R.oldmee
 * @Description:
 * @Date: Create in 13:17 2019/1/21
 */
public abstract class BaseModule {

    /**
     * 注入同名的一个ioc对象
     */
    @Inject
    protected Dao dao;

    @Inject
    protected EmailService emailService;

    protected byte[] emailKEY = R.sg(24).next().getBytes();

}
