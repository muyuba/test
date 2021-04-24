package com.lixun.bookman;

        import com.baomidou.mybatisplus.generator.AutoGenerator;
        import com.baomidou.mybatisplus.generator.InjectionConfig;
        import com.baomidou.mybatisplus.generator.config.*;
        import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGen {
    public static void main(String[] args) {
        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        globalConfig.setAuthor("lixun"); globalConfig.setOpen(false);
        //链接到数据库
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/xcxy?useUnicode=true&useSSL=false&characterEncoding=utf8&server Timezone=UTC");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        //修改为你的 mysql 数据库密码
        // 自定义代码模板
        TemplateConfig templateConfig=new TemplateConfig();
        //自定义属性注入
        InjectionConfig injectionConfig=new InjectionConfig() {
            @Override public void initMap() { }
        };//配置包
        PackageConfig packageConfig=new PackageConfig();
        packageConfig.setParent("com.lixun.bookman");
        //生成策略
        StrategyConfig strategyConfig=new StrategyConfig();
        strategyConfig.setTablePrefix("t");
        //告诉表明前缀
        // 这里把数据库中表名 t_user_role 转为驼峰命名法
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //告诉类命名策略是什么
        AutoGenerator generator = new AutoGenerator();
        generator.setGlobalConfig(globalConfig);
        generator.setDataSource(dataSourceConfig);
        generator.setTemplate(templateConfig);
        generator.setCfg(injectionConfig);
        generator.setPackageInfo(packageConfig);
        generator.setStrategy(strategyConfig);
        generator.execute();
        //test
    }
}