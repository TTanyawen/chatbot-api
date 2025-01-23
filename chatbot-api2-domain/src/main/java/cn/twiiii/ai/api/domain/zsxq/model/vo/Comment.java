package cn.twiiii.ai.api.domain.zsxq.model.vo;

public class Comment {
    public String comment_id ;

    public String create_time ;

    public Owner owner ;

    public String text ;

    public int likes_count ;

    public boolean group_owner_liked ;

    public boolean topic_owner_liked ;

    public int rewards_count ;

    public boolean sticky ;

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public boolean isGroup_owner_liked() {
        return group_owner_liked;
    }

    public void setGroup_owner_liked(boolean group_owner_liked) {
        this.group_owner_liked = group_owner_liked;
    }

    public boolean isTopic_owner_liked() {
        return topic_owner_liked;
    }

    public void setTopic_owner_liked(boolean topic_owner_liked) {
        this.topic_owner_liked = topic_owner_liked;
    }

    public int getRewards_count() {
        return rewards_count;
    }

    public void setRewards_count(int rewards_count) {
        this.rewards_count = rewards_count;
    }

    public boolean isSticky() {
        return sticky;
    }

    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }
}
