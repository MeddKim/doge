# 关于URL的规则
## 对单个资源的操作
使用方法类型表表明操作
如对content
- 增加: `/content http`方法为post
- 删除：`/content/{contentId}` http方法为delete
- 查询: `/content/{contentId}` http方法为Get
- 修改: `/content/{contentId}`或`/content`  http方法为PUT

## 对于多条数据
### 不涉及分页
- 无过滤条件 `/contents` http方法为get
- 有过滤条件 `/contents?a=1&b=2&c=3` http方法为get
- 过滤条件复杂 `/contents` http方法为Post，将条件以post的方式提交
### 分页
- 无过滤条件 `/contents/page?pageNum=1&pageSize=10` http方法为get 
- 包含过滤条件`/contents/page?pageNum=1&pageSize=10?a=1&b=2` http方法为get
- 过滤条件复杂`/contents/page?pageNum=1&pageSize=10` http方法为Post，将条件以post的方式提交
    
## 批量操作
- 添加 `contents/add` http方法为post
- 删除`contents/delete` http方法为post
- 查询`contents/get` 方法为post

