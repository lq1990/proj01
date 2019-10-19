package com.wendao.test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 	通过第三方lib，配置generatorConfig.xml后，自动生成项目所需 实体类，mapper
 * @author china
 *
 */
public class GeneratorSqlmap {
	public void generator() throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		
		// 指定逆向工程配置文件
		File configFile = new File(".\\src\\generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator gen = new MyBatisGenerator(config, callback, warnings);
		gen.generate(null);
		
		
	}
	
	
	
	public static void main(String[] args) {
		try {
			GeneratorSqlmap map = new GeneratorSqlmap();
			map.generator();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}












