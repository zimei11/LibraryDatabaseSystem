# 图书馆数据库系统📚

## 概要

在线的图书馆数据库系统，不仅可以方便管理员随时随地的查看维护场馆数据，并且为用户提供了解场馆信息，反馈问题提供了途径。

本系统的开发工具主要使用了IntelliJ IDEA Ultimate，采用的开发语言为Java。系统体系架构采用的是三层架构，为Java原生Web项目，用MySQL作为后台支持的数据库，采用Mybatis作为持久层框架，中间层选用Servlet，表现层选用Thymeleaf 。

本系统包括图书管理员端、用户服务端两个登录口，分别提供图书馆管理与读者交互功能。

## 特色

1. 灵活运用视图、触发器、索引、事务、约束、统计等
2. 部署在Linux云服务器上，可以通过公网访问
3. 前端网页界面优美，且界面自动适配手机访问
4. 借助过滤器控制用户的登陆验证，借助 Mybatis 防止SQL注入攻击

## 部署方式

在根目录下找到**book_manage.sql**文件，将数据库导入到MySQL 8.0.24及以上版本中（数据库使用了CHECK约束，低版本下将失效）

IntelliJ IDEA Ultimate导入项目，系统使用Maven进行项目管理，tomcat为9+版本。

应用程序上下文改为/book_manager，对应URL http://localhost:8083/book_manager/auth-login

mybatis-config.xml 在目录src/main/resources/ 下，请按需自行修改。

管理员登录
账号:admin@qq.com
密码123456

读者登录
账号:123@qq.com
密码123456

## 需求分析

1. 后台维护子系统

- 用户信息管理

- 图书信息管理

- 借阅信息管理

- 留言信息管理

- 公告信息管理

2. 用户交互子系统

- 信息查看

- 联系场馆

3. 子系统公共部分

- 用户登陆

- 检索系统

- 活跃读者

- 图书畅读榜

## 架构设计

开发过程中使用了分层架构模式（Layered），将系统分为表现层（UI）、业务逻辑层（BLL）以及数据访问层（DAL），三层架构模式。

![image-20220621213224922](http://img.zimei.fun/202206212132046.png)

## DB概念设计

如下图所示为图书馆数据系统的全局E-R图。每一本书即使书号相同，但是图书编号一定不同。 而一个读者可以在不同时间反复借阅同一本书，因此读者编号与书籍编号并不能唯一标识每一次借阅，需要增加借阅编号属性来做主键。

![img](http://img.zimei.fun/202206212140805.png)

## 技术栈

### java 后端技术栈

- Servlet 服务连接器

- Mybatis ORM框架

- Thymeleaf 渲染 XML/XHTML/HTML5 内容的模板引擎

- Lombok 实体类加强工具

  

### 前端技术栈

- HTML5 文本界面  
- CSS3 界面样式表
- JavaScript 界面小脚本

### 部署技术

- 单机部署
- Linux服务器部署tomcat服务

## 运行效果截图

![image-20220621214219419](http://img.zimei.fun/202206212142481.png)

<img src="http://img.zimei.fun/202206212141485.png" alt="img" style="zoom:80%;" />

<img src="http://img.zimei.fun/202206212141649.png" alt="img" style="zoom:80%;" />

<img src="http://img.zimei.fun/202206212142538.png" alt="img" style="zoom:80%;" />

## 总结

本项目为数据库实习项目。本系统基本完成各种业务需求，达到预定目标。较难的多关键字模糊查询未能实现，日期转换功能传入假数据未能实现，分页查询暂未实现，管理员业务逻辑非常简陋、之后会进一步学习这方面的知识，搭建出一个更为完善的系统。

## 致谢

感谢B站UP主**青空の霞光**系列教学视屏对本人的帮助！[青空の霞光的个人空间_哔哩哔哩_bilibili](https://space.bilibili.com/37737161)

感谢**周老师**对数据库设计方面的指导与论文审查！