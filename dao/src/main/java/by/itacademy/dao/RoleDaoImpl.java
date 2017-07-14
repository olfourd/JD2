package by.itacademy.dao;

import by.itacademy.dao.common.BaseDaoImpl;
import by.itacademy.entity.QRoleOfUser;
import by.itacademy.entity.RoleOfUser;
import by.itacademy.entity.other.UserRole;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<RoleOfUser> implements RoleDao {

    @Override
    public RoleOfUser getAdmin() {
        QRoleOfUser role = new QRoleOfUser("role");
        JPAQuery<RoleOfUser> query = new JPAQuery<>(getSessionFactory().getCurrentSession());
        return query.select(role).from(role).where(role.role.eq(UserRole.ADMIN)).fetchOne();

    }

    @Override
    public RoleOfUser getUser() {
        QRoleOfUser role = new QRoleOfUser("role");
        JPAQuery<RoleOfUser> query = new JPAQuery<>(getSessionFactory().getCurrentSession());
        return query.select(role).from(role).where(role.role.eq(UserRole.USER)).fetchOne();
    }

    @Override
    public RoleOfUser getContentMaker() {
        QRoleOfUser role = new QRoleOfUser("role");
        JPAQuery<RoleOfUser> query = new JPAQuery<>(getSessionFactory().getCurrentSession());
        return query.select(role).from(role).where(role.role.eq(UserRole.CONTENT_MAKER)).fetchOne();
    }

    @Override
    public RoleOfUser getModerator() {
        QRoleOfUser role = new QRoleOfUser("role");
        JPAQuery<RoleOfUser> query = new JPAQuery<>(getSessionFactory().getCurrentSession());
        return query.select(role).from(role).where(role.role.eq(UserRole.MODERATOR)).fetchOne();
    }
}
