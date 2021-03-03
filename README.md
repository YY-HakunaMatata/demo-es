# ElasticSearch博客示例
***
## 项目介绍：

该实例基于spring boot快速构架ELK中间件，模拟实现blog全文检索功能；对比传统MySQL进行不切实际的全文检索，
性能上有着质的飞跃和提升！

项目提供测试数据库，SQL脚本在db文件夹中。
***
## 集成说明：

- 集成MySQL数据库与ElasticSearch模块；
- ORM层使用spring boot官方推荐的JPA作为数据的CRUD；
- 项目所使用的ELK版本都为7.11.1版本，需自行前往 [Elastic官网](https://www.elastic.co/cn/elastic-stack) 下载;
***
## 实现功能：

- MySQL 模糊查询；
- 数据查询接口，分别统计MySQL模糊查询和ES查询的耗时统计；