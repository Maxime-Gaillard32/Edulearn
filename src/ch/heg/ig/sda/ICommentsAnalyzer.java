package ch.heg.ig.sda;

import ch.heg.ig.sda.business.Comment;

import java.util.List;

public interface ICommentsAnalyzer {

    void loadComments(String filepath);

    List<Comment> getComments();

}
