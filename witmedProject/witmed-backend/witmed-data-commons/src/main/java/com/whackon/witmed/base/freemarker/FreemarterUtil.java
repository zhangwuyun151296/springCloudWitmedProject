package com.whackon.witmed.base.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.util.ResourceUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>智慧医疗信息平台-</b>
 *
 * @version 1.0.0
 * @Author 张武超
 * @Date 2022/1/5
 * @serial 1.0.0
 */
public class FreemarterUtil {
	public static boolean createFile(String tempName,Entity entity){
		//创建Freemarker configurationd对象
		Configuration configuration=new Configuration(Configuration.VERSION_2_3_21);
		try {
			// 获得位于 resources 路径下的 freemarker 文件
			String freemarkerPath = ResourceUtils.getURL("classpath:").getPath() + "freemarker";
			System.out.println(freemarkerPath);
			// 设置所使用的 Freemarker 的模板所在的路径位置
			configuration.setDirectoryForTemplateLoading(new File(freemarkerPath));
			// 生成目标文件的编码格式
			configuration.setDefaultEncoding("UTF-8");
			// 设定所需要生成目标文件的 freemarker 目标是哪个
			Template template = configuration.getTemplate( tempName+".ftl");
			// 设定目标文件生成路径
			// 获得位于 resources 路径下的 freemarker 文件
			String targetPath = ResourceUtils.getURL("classpath:").getPath();
			// 将获得的路径切换到 src 下
			targetPath = targetPath.substring(0, targetPath.indexOf("target/classes/"));
			// 形成目标文件所在文件夹路径
			targetPath = targetPath + "src/main/java/";
			// 将对应的包结构变为文件夹结构，连接到目标文件夹路径下
			targetPath = targetPath + entity.getPackageName().replace(".", "/") + "/";
			// 根据路径和生成文件创建对应的 File 对象
			File targetFile = new File(targetPath + entity.getClassName() + ".java");
			// 根据 File 创建 BufferedWriter 对象
			BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile));
			// 使用 Freemarker 生成对应的文件
			template.process(entity, bw);
			bw.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	/*public static void main(String[] args) throws Exception {
		//创建Freemarker configurationd对象
		Configuration configuration=new Configuration(Configuration.VERSION_2_3_21);
		//获得位于resources路径下的freemarker文件夹
		String freemarkerPath= ResourceUtils.getURL("classpath:").getPath()+"freemarker";
		//设置所使用的freemarker的模板所在路径位置
		configuration.setDirectoryForTemplateLoading(new File(freemarkerPath));
		//设置生成目标文件的编码格式
		configuration.setDefaultEncoding("UTF-8");
		//设置所需要生成的目标文件的freemarker目标是哪个
		Template template=configuration.getTemplate("helloWord.ftl");
		//为了能够得到对应的输出文件，那么需要谁用输出流将生成的文件传输到硬盘上
		//创建字符输出流
		BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(new File("HelloWord.java")));
		//由于freemarker模板中含有参数，那么需要创建Map集合来设定对应的参数值
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("javaName","HelloWord");
		map.put("message", "我的第一个模板ss");
		//使用template生成目标文件
		template.process(map, bufferedWriter);
		//关闭输出流
		bufferedWriter.close();
	}*/
}
