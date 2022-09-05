package com.pavel.SoulCollect.repos;

import com.pavel.SoulCollect.models.Comment;
import com.pavel.SoulCollect.models.Item;
import com.pavel.SoulCollect.models.User;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<Comment, Long> {

    Iterable<Comment> findAllByAuthor(User author);
    Iterable<Comment> findAllByItem(Item item);
}
