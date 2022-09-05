package com.pavel.SoulCollect.services;

import com.pavel.SoulCollect.models.Comment;
import com.pavel.SoulCollect.models.Item;
import com.pavel.SoulCollect.models.User;
import com.pavel.SoulCollect.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepo commentRepo;

    public Iterable<Comment> getCommentsByItem(Item item) {
        return commentRepo.findAllByItem(item);
    }

    public void addComment(String comment, User author, Item item) {
        Comment comm = new Comment(comment, author, item);
        commentRepo.save(comm);
    }
}
