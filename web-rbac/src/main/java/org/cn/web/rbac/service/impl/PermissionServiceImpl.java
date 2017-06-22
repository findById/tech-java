package org.cn.web.rbac.service.impl;

import org.cn.web.rbac.dao.PermissionDao;
import org.cn.web.rbac.domain.Permission;
import org.cn.web.rbac.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Resource
    PermissionDao permissionDao;

    @Override
    public Permission get(Serializable id) {
        return permissionDao.get(id);
    }

    @Override
    @Transactional
    public Permission save(Permission permission) {
        permissionDao.save(permission);
        return permission;
    }

    @Override
    @Transactional
    public Permission update(Permission permission) {
        permissionDao.update(permission);
        return permission;
    }

    @Override
    @Transactional
    public void delete(Serializable id) {
        permissionDao.delete(id);
    }

    @Override
    public List<Permission> list() {
        List<Permission> list = permissionDao.getResultList("SELECT * FROM permission", null, 0, 0);
        return list;
    }

    @Override
    public List<Permission> findByUserId(Serializable userId) {
        // SELECT * FROM permission AS p,role_permission AS rp,user_role AS ur WHERE p.id=rp.permission_id AND rp.role_id=ur.role_id AND ur.user_id='' AND p.type='menu' AND p.del_flg=0 AND rp.del_flg=0 AND ur.del_flg=0 ORDER BY p.parent_id,p.position
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM permission AS p,role_permission AS rp,user_role AS ur ");
        sql.append("WHERE p.id=rp.permission_id AND rp.role_id=ur.role_id AND ur.user_id=:userId ");
        sql.append("AND p.del_flg=0 AND rp.del_flg=0 AND ur.del_flg=0 ");
        sql.append("ORDER BY p.parent_id,p.position");

        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        List<Permission> list = permissionDao.getResultList(sql.toString(), params, 0, 0);

        return list;
    }

    @Override
    @Transactional
    public void saveAll(List<Permission> permissions) {
        for (Permission perm : permissions) {
            permissionDao.save(perm);
        }
    }

}
