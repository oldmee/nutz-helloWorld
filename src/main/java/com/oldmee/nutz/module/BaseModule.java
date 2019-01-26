package com.oldmee.nutz.module;

import com.oldmee.nutz.service.EmailService;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.lang.random.R;
import org.nutz.lang.util.NutMap;

import java.util.List;

/**
 * @Author: R.oldmee
 * @Description:
 * @Date: Create in 13:17 2019/1/21
 */
public abstract class BaseModule {

    /**
     * 注入与属性同名的一个ioc对象
     */
    @Inject
    protected Dao dao;

    @Inject
    protected EmailService emailService;

    protected QueryResult query(Class<?> klass, Condition cnd, Pager pager, String regex) {
        if (pager != null && pager.getPageNumber() < 1) {
            pager.setPageNumber(1);
        }
        List<?> roles = dao.query(klass, cnd, pager);
        dao.fetchLinks(roles, null);
        pager.setRecordCount(dao.count(klass, cnd));
        return new QueryResult(roles, pager);
    }

    protected NutMap ajaxOk(Object data) {
        return new NutMap().setv("ok", true).setv("data", data);
    }

    protected NutMap ajaxFail(String msg) {
        return new NutMap().setv("ok", false).setv("msg", msg);
    }
}
