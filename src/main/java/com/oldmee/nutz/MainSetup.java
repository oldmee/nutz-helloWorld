package com.oldmee.nutz;

import com.oldmee.nutz.bean.User;
import com.oldmee.nutz.service.AuthorityService;
import com.oldmee.nutz.service.UserService;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.integration.quartz.NutQuartzCronJobFactory;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

/**
 * @Author: R.oldmee
 * @Description:
 * @Date: Create in 12:43 2019/1/19
 */
public class MainSetup implements Setup {

    // 特别留意一下,是init方法,不是destroy方法!!!!!
    public void init(NutConfig nc) {
        Ioc ioc = nc.getIoc();
        Dao dao = ioc.get(Dao.class);
        // 如果没有createTablesInPackage,请检查nutz版本
        Daos.createTablesInPackage(dao, "com.oldmee.nutz.mainModule", false);

        Daos.migration(dao, User.class, true, false, false);

        // 初始化默认根用户
        if (dao.count(User.class) == 0) {
            UserService us = ioc.get(UserService.class);
            us.add("admin", "123456");
        }
        // 获取NutQuartzCronJobFactory从而触发计划任务的初始化与启动
        ioc.get(NutQuartzCronJobFactory.class);

        AuthorityService as = ioc.get(AuthorityService.class);
        as.initFormPackage("com.oldmee.nutz");
        as.checkBasicRoles(dao.fetch(User.class, "admin"));

    }

    public void destroy(NutConfig nc) {
        // webapp销毁之前执行的逻辑
        // 这个时候依然可以从nc取出ioc, 然后取出需要的ioc 对象进行操作
    }

}
