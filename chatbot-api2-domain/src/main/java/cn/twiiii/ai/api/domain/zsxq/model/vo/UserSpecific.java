package cn.twiiii.ai.api.domain.zsxq.model.vo;

import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description
 * @github https://github.com/fuzhengwei
 * @copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class UserSpecific {

    public boolean liked;

    public List<String> liked_emojis;

    public boolean subscribed;

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public List<String> getLiked_emojis() {
        return liked_emojis;
    }

    public void setLiked_emojis(List<String> liked_emojis) {
        this.liked_emojis = liked_emojis;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }
}
