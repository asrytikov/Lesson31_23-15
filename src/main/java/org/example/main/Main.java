package org.example.main;

import org.example.config.ProjectConfig;
import org.example.model.Comment;
import org.example.proxies.EmailCommentNotificationProxy;
import org.example.repositories.DbCommentRepository;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        /*var commentRepository = new DbCommentRepository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();
        var commentService = new CommentService(commentRepository, commentNotificationProxy);*/
        var commentService = context.getBean(CommentService.class);
        var comment = new Comment();
        comment.setAuthor("Alex");
        comment.setText("Test comment");

        commentService.publishComment(comment);
    }
}