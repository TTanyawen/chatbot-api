package cn.twiiii.ai.api.application.ext;



import cn.bugstack.chatbot.api.common.PropertyUtil;
import cn.twiiii.ai.api.application.job.ChatbotTask;
import cn.twiiii.ai.api.domain.ai.IOpenAI;
import cn.twiiii.ai.api.domain.zsxq.IZsxqApi;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Configuration
@EnableScheduling
public class TaskRegistrarAutoConfig implements EnvironmentAware, SchedulingConfigurer {

    private Logger logger = LoggerFactory.getLogger(TaskRegistrarAutoConfig.class);

    /**
     * 任务配置组
     */
    private Map<String, Map<String, Object>> taskGroupMap = new HashMap<>();

    @Resource
    private IZsxqApi zsxqApi;
    @Resource
    private IOpenAI openAI;

    @Override
    public void setEnvironment(Environment environment) {

        String prefix = "chatbot-api2.";
        String launchListStr = environment.getProperty(prefix + "launchList");
        if (StringUtils.isEmpty(launchListStr)) return;
        for (String groupKey : launchListStr.split(",")) {
            Map<String, Object> taskGroupProps = PropertyUtil.handle(environment, prefix + groupKey, Map.class);
            taskGroupMap.put(groupKey, taskGroupProps);
        }
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        System.out.println("configureTasks");
        Set<String> taskGroups = taskGroupMap.keySet();
        for (String groupKey : taskGroups) {
            Map<String, Object> taskGroup = taskGroupMap.get(groupKey);
            String groupName = taskGroup.get("groupName").toString();
            String groupId = taskGroup.get("groupId").toString();
            String cookie = taskGroup.get("cookie").toString();
            String openAiKey = taskGroup.get("openAiKey").toString();
//            String cronExpressionBase64 = taskGroup.get("cronExpression").toString();
//            String cronExpression = new String(Base64.getDecoder().decode(cronExpressionBase64), StandardCharsets.UTF_8);
            String cronExpression = taskGroup.get("cronExpression").toString();
//            boolean silenced = Boolean.parseBoolean(taskGroup.get("silenced").toString());
            boolean silenced=true;
            logger.info("创建任务 groupName：{} groupId：{} cronExpression：{}", groupName, groupId, cronExpression);
            // 添加任务
            taskRegistrar.addCronTask(new ChatbotTask(groupName, groupId, cookie, openAiKey, zsxqApi, openAI, silenced), cronExpression);
        }
    }

}
