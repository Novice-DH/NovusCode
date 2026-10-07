package com.manus.novuscode.generator;

import cn.hutool.core.lang.Dict;
import cn.hutool.setting.yaml.YamlUtil;
import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.util.Map;

/**
 * MyBatis Flex 代码生成器
 */
public class MyBatisCodeGenerator {

    // 要生成的表名
    private static final String[] TABLE_NAMES = {"user"};

    public static void main(String[] args) {
        // 获取数据源信息
        Dict dict = YamlUtil.loadByPath("application.yaml");
        Map<String, Object> dataSourceConfig = dict.getByPath("spring.datasource");
        String url = String.valueOf(dataSourceConfig.get("url"));
        String username = String.valueOf(dataSourceConfig.get("username"));
        String password = String.valueOf(dataSourceConfig.get("password"));
        // 配置数据源
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        // 创建配置内容
        GlobalConfig globalConfig = createGlobalConfig();

        // 通过 datasource 和 globalConfig 创建代码生成器
        Generator generator = new Generator(dataSource, globalConfig);

        // 生成代码
        generator.generate();
    }


    // 详细配置见：https://mybatis-flex.com/zh/others/codegen.html
    public static GlobalConfig createGlobalConfig() {
        // 创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        // 设置根包。注意：Java 源码目录与 Mapper XML 目录是两项独立配置，
        // 默认均相对启动时的工作目录（user.dir）拼 /src/main/java、/src/main/resources/mapper，
        // 这里显式指定到 backend 模块下，避免生成到工程根目录
        globalConfig.getPackageConfig()
                .setBasePackage("com.manus.novuscode.genresult")
                .setSourceDir(System.getProperty("user.dir") + "/backend/src/main/java")
                .setMapperXmlPath(System.getProperty("user.dir") + "/backend/src/main/resources/mapper");

        // 设置表前缀和只生成哪些表，setGenerateTable 未配置时，生成所有表
        globalConfig.getStrategyConfig()
                .setGenerateTable(TABLE_NAMES)
                // 设置逻辑删除的默认字段名称
                .setLogicDeleteColumn("isDelete");

        // 设置生成 entity 并启用 Lombok
        globalConfig.enableEntity()
                .setWithLombok(true)
                .setJdkVersion(21);

        // 设置生成 mapper
        globalConfig.enableMapper();
        globalConfig.enableMapperXml();

        // 设置生成 Service
        globalConfig.enableService();
        globalConfig.enableServiceImpl();

        // 设置生成 Controller
        globalConfig.enableController();

        // 设置生成注释，比如生成的时间和作者，避免后续多余的代码改动
        globalConfig.getJavadocConfig()
                .setAuthor("<a href=\"https://github.com/Novice-DH\">Manus-DH</a>")
                .setSince("");
        return globalConfig;
    }
}
