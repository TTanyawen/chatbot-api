package cn.twiiii.ai.api.domain.zsxq.model.vo;

import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description
 * @github https://github.com/fuzhengwei
 * @copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class Topics {


    public String topic_id;
    public Group group;

    public String type;

    public Talk talk;

    public List<Latest_likes> latest_likes;

    public List<ShowComments> show_comments;

    public int likes_count;

    public int tourist_likes_count;

    public LikesDetail likes_detail;

    public int rewards_count  ;
    public int comments_count   ;

    public int read;

    public int readers_count ;

    public boolean digested ;

    public boolean sticky ;

    public String create_time ;

    public UserSpecific user_specific ;

    public String title ;

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Talk getTalk() {
        return talk;
    }

    public void setTalk(Talk talk) {
        this.talk = talk;
    }

    public List<Latest_likes> getLatest_likes() {
        return latest_likes;
    }

    public void setLatest_likes(List<Latest_likes> latest_likes) {
        this.latest_likes = latest_likes;
    }

    public List<ShowComments> getShow_comments() {
        return show_comments;
    }

    public void setShow_comments(List<ShowComments> show_comments) {
        this.show_comments = show_comments;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public int getTourist_likes_count() {
        return tourist_likes_count;
    }

    public void setTourist_likes_count(int tourist_likes_count) {
        this.tourist_likes_count = tourist_likes_count;
    }

    public LikesDetail getLikes_detail() {
        return likes_detail;
    }

    public void setLikes_detail(LikesDetail likes_detail) {
        this.likes_detail = likes_detail;
    }

    public int getRewards_count() {
        return rewards_count;
    }

    public void setRewards_count(int rewards_count) {
        this.rewards_count = rewards_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public int getReaders_count() {
        return readers_count;
    }

    public void setReaders_count(int readers_count) {
        this.readers_count = readers_count;
    }

    public boolean isDigested() {
        return digested;
    }

    public void setDigested(boolean digested) {
        this.digested = digested;
    }

    public boolean isSticky() {
        return sticky;
    }

    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public UserSpecific getUser_specific() {
        return user_specific;
    }

    public void setUser_specific(UserSpecific user_specific) {
        this.user_specific = user_specific;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
