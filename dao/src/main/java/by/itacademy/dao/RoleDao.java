package by.itacademy.dao;

import by.itacademy.dao.common.BaseDao;
import by.itacademy.entity.RoleOfUser;

public interface RoleDao extends BaseDao<RoleOfUser> {
    RoleOfUser getAdmin();
    RoleOfUser getUser();
    RoleOfUser getContentMaker();
    RoleOfUser getModerator();



}
