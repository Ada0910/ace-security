# cloud-platform 分布式微服务
## ace-auth 服务鉴权中心模块
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
