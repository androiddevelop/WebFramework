# web-framework
基于Hibernate与Struts2的开发框架， 方便进行后台程序的开发

使用实例 [WebFrameworkExample](https://github.com/androiddevelop/WebFrameworkExample),  文档[Javadoc](http://doc.codeboy.me/Framework/)

## 1. 使用场景
 
 - 使用hibernate进行数据库操作
 - 使用struts2进行json数据的返回,用于后台
 
 
## 2.数据格式
 
 ```
 {
    code: 0,
    data: {},
    description: string
 }
 ```
 
### **code** - 返回码: 

- success(0) 
- failed(-1) 
- exception(-2) 
- others(-3)
 
### **data** - 数据

操作成功后的数据

### **description** - 描述 

  操作成功, 失败，异常等情况下的描述

## 3.项目引入

	compile 'me.codeboy.common:framework:1.1.1'

## 4.使用说明

- 需要使用连接池以及hibernate配置等，请自行加入，可以参考[WebFrameworkExample](https://github.com/androiddevelop/WebFrameworkExample)
- Struts2返回json的方式有多种，本项目采用的是在return之前将数据输出到客户端

## 5.简单例子

### hibernate操作:

```
CBUser user = new CBHibernateTask<CBUser>() {
            @Override
            public CBUser doTask(Session session) {
                long userId = 1L;
                return (CBUser) session.get(CBUser.class, userId);
            }
        }.execute();
```
 
### 数据处理操作: 

```
    /**
     * standard operation or success operation
     *
     * @return null
     */
    public String operateSuccess() {
        CBResponseController.process(getTestUsers());
        return null;
    }

    /**
     * raw data operation, and not use the wrapper structure
     *
     * @return null
     */
    public String operateRawData() {
        CBResponseController.processRaw("raw data");
        return null;
    }

```