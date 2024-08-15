package com.mbg.generator;



import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过 Java API 的方式运行 MyBatis Generator
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        // 存储运行 MBG 时的警告信息
        List<String> warnings = new ArrayList<>();

        // 生成的代码重复时，覆盖原代码
        boolean overwrite = true;

        // 读取 MBG 配置文件 generatorConfig.xml
        InputStream inputStream = Generator.class.getResourceAsStream("/mybatis-generator.xml");

        // 传入警告信息创建配置解析器（用于解析 generatorConfig.xml 配置文件）
        ConfigurationParser cp = new ConfigurationParser(warnings);

        // 解析配置文件
        Configuration config = cp.parseConfiguration(inputStream);

        // 关闭输入流
        assert inputStream != null;
        inputStream.close();

        // 创建 DefaultShellCallback 对象，用于解决重复文件覆盖问题
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);

        // 创建 MyBatisGenerator 对象，执行生成代码
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);

        // 执行生成代码
        myBatisGenerator.generate(null);

        // 输出警告信息
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}

