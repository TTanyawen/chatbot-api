package cn.twiiii.ai.api.domain.zsxq.model.res;


import cn.twiiii.ai.api.domain.zsxq.model.vo.Comment;
import cn.twiiii.ai.api.domain.zsxq.model.vo.Topics;

import java.util.List;


public class RespData {

    public List<Topics> topics;

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }
}
