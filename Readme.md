# cloud-platform 分布式微服务
## 模块
## 项目结构
# 技术选型
- 基础环境
win10+IDEA+JDK1.8
- 前端
- 后台

# 使用指南
# 运行效果
# 注意事项
# 鸣谢
https://gitee.com/geek_qi/cloud-platform/wikis/Home 附上我学习的链接
# 规范
## pom文件规范
引入的标签顺序为：
```
  <!--1.父坐标-->
  
        <parent></parent>
        
  <!--2.本身坐标-->
        <groupId>com.awm</groupId>
        <artifactId>cloud-platform</artifactId>
        <version>1.0-SNAPSHOT</version>
   
  <!--3.打包方式-->
        <packaging>pom</packaging>
    
  <!--4.子模块-->
        <modules>
            <module>ace-auth</module>
        </modules>
        
  <!--5.配置-->
         <properties></properties>
        
  <!--6.依赖-->
        <dependencies>
                <dependency>
                    <groupId>org.projectlombok</groupId>
                    <artifactId>lombok</artifactId>
                </dependency>      
        </dependencies>
        
  <!--7.构建-->     
      <build>
          <plugins>
              <plugin>
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-maven-plugin</artifactId>
              </plugin>
          </plugins>
      </build> 
        <!--1.父坐标-->
        <!--2.本身坐标-->   
        <!--3.打包方式-->       
        <!--4.子模块-->      
        <!--5.配置-->       
        <!--6.依赖-->          
        <!--7.构建-->        
```
