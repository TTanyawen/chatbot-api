# chatbot-api
ChatGPT 问答助手
### 介绍
- ChatGPT问答助手项目的功能是定时检测知识星球网页内的某个话题是否有新发的帖子，如果有，则获取话题的内容信息，对接Openai的Api，发送Post请求拿到Gpt的回答，再通过Post请求将回答自动提交到帖子下的评论区
- 项目采用ddd架构，多模块maven
- 项目的主要技术栈有
	- 爬虫
	- Springboot
	- Job
	- docker
- 最终在本地的虚拟机进行了docker打包部署

### 收获
- 1. 学会了如何根据网页的请求信息去模拟发送get和post请求，把参数或者响应信息打包到java实体类中
- 2. 初步认识了ddd结构
- 3. 多模块的maven的pom文件配置
- 4. openai的api使用
- 5. docker打包操作
- 6. git的使用，多分支方便开发
- 7. java定时任务
- 8. 获得了很多实操性的经验
 
### 结果展示
![image](https://github.com/user-attachments/assets/92ea783d-9d90-4c01-beb8-f11c725a0152)
