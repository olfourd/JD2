package by.itacademy.dao;

import by.itacademy.dao.common.BaseDaoImpl;
import by.itacademy.entity.ForumPost;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ForumPostDaoIml extends BaseDaoImpl<ForumPost> implements ForumPostDao{
    @Override
    public ForumPost changeText(ForumPost post, String text) {
        post.setText(text);
        return update(post);
    }
}
