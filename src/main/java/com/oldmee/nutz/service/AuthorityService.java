package com.oldmee.nutz.service;

import com.oldmee.nutz.bean.Role;
import com.oldmee.nutz.bean.User;

/**
 * @Author: R.oldmee
 * @Description:
 * @Date: Create in 16:07 2019/1/26
 */
public interface AuthorityService {

    /**
     * 扫描RequiresPermissions和RequiresRoles注解
     *
     * @param pkg
     *            需要扫描的package
     */
    void initFormPackage(String pkg);

    /**
     * 检查最基础的权限,确保admin用户-admin角色-(用户增删改查-权限增删改查)这一基础权限设置
     *
     * @param admin
     */
    void checkBasicRoles(User admin);

    /**
     * 添加一个权限
     */
    void addPermission(String permission);

    /**
     * 添加一个角色
     */
    Role addRole(String role);
}
