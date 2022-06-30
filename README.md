# Questionnaire
### Git使用

1. 先试试添加个人主页到Contribution里面。
2. idea里面自带git插件，可以去看看怎么用。
### 项目启动

<!--nacos都还不怎么熟悉，不知道对不对，反正先这样做，希望是有加分-->

1. 项目启动前需要先本地启动nacos（[Nacos 快速开始](https://nacos.io/zh-cn/docs/quick-start.html)）
2. 目前项目里面有三个子模块，分别是userManage、projectManage和questionnaire。前两个模块是提供用户管理、项目管理服务的生产者服务；后面这个是项目的消费者服务，调用前两个所提供的服务。前端代码和后端的一些公用类都在questionnaire里面。
3. questionnaire的controller是用于给前端调用的，然后再由feign下所定义的相关接口找到注册到nacos的对应服务，远程调用服务模块所提供的服务。
4. 基本只需要在manage模块中编写代码。
5. 可以了解一下nacos和feign的结合。

### 已发现的url

#### /addQuestionnaire

作用简述：添加新问卷

已知的参数：

| 变量名          | 确定信息                                              | 猜测信息                                                     |
| --------------- | ----------------------------------------------------- | ------------------------------------------------------------ |
| questionName    | /namedQuestionnaire.html下的调查名称                  | 问卷名称                                                     |
| questionContent | /namedQuestionnaire.html下的调查说明                  | 对问卷的说明                                                 |
| startTime       | /namedQuestionnaire.html下的起止时间的前半部分        | 问卷的开始时间                                               |
| endTime         | /namedQuestionnaire.html下的起止时间的后半部分        | 问卷的结束时间                                               |
| questionStop    | 在/namedQuestionnaire.html下创建新问卷时，默认传入‘5’ |                                                              |
| dataId          | 来自于cookie:'dataId'                                 | 根据createQuestionnaire.js里的function changeType()猜测，dataId表示的是调查类型 |
| projectId       | 来自于cookie:'TProjectId'                             | 合理猜测，这个代表的应该是项目ID，但是cookie:'TProjectId'好像没赋过值 |

信息来源：

1，namedQuestionnaire.js下的 function quickCreate() 函数

2，createQuestionnaire.js里的function changeType()函数

#### /modifyQuestionnaireInfo

作用简述：修改问卷

已知参数：

| 变量名          | 确定信息 | 猜测信息     |
| --------------- | -------- | ------------ |
| id              | 问卷的ID | 问卷的ID     |
| questionName    |          | 问卷名称     |
| questionContent |          | 问卷说明     |
| dataId          |          | 问卷类型     |
| startTime       |          | 问卷开始时间 |
| endTime         |          | 问卷结束时间 |

