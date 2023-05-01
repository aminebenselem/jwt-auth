package auth;

import com.example.demo.entity.Forum;
import com.example.demo.entity.Reply;

import java.util.List;

public class ForumReply {
    public Forum forum;

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    public List<Reply> replyList;

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }





}
