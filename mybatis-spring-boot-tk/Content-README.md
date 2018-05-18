# 内容注释
## 1：mysql的乐观锁
通过数据库表中添加version字段，查询时获取当前version信息；
update时 update set version = version+1 where version = #{version};
见LockController

## 2: spring Propagation 事物传播机制
