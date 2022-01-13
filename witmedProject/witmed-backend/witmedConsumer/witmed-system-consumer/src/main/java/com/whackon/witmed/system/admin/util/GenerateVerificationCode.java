package com.whackon.witmed.system.admin.util;

import com.whackon.witmed.base.controller.BaseController;
import com.whackon.witmed.base.pojo.vo.ResponseVO;
import com.whackon.witmed.base.util.BaseConstants;
import com.whackon.witmed.base.util.RedisUtil;
import com.whackon.witmed.base.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <b>登录模块-生成验证码工具类</b>
 *
 * @version 1.0.0
 * @Author 张武超
 * @Date 2022/1/9
 * @serial 1.0.0
 */
@RestController("GenerateVerificationCode")
@RequestMapping("/VerificationCode")
public class GenerateVerificationCode extends BaseController {
	@Autowired
	private RedisUtil redisUtil;

	private static final String[] strs=new String[]{"A","B","C","D","E","F","G","H","I","J","K"};

		@GetMapping("/code")
	public void GenerateCode()throws Exception{
		int width=60;
		int height=30;
		//1,生成图片

		BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

		//2,获取画笔
		Graphics g=image.getGraphics();
		//3,设置颜色
		g.setColor(new Color(244,244,244));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("宋体", Font.BOLD,16));
		g.setColor(new Color(255, 0, 0));
		//4，验证码的字符串
		String randStr="";
		Random ran=new Random();
		for (int i = 0; i < 4; i++) {
			int index=ran.nextInt(strs.length);
			randStr += strs[index];
		}
		//5,使用画笔把字符串画到image上
		g.drawString(randStr, 12, 21);

		Map<String,String> map=new HashMap<String,String>();
		map.put("RandCode",randStr);
		String token= TokenUtil.createToken(map, 120L);
		if (redisUtil.saveToRedis(token,randStr,60l)){
			//此时将信息存储在Redis中成功，那么将token返回给客户
			//此时为了将token交给客户进行存储，那么我们可以选择将Token绑定到Http响应对象的消息头的部分Authorization
			response.setHeader("GenerateVerificationCode",token);
		}
		g.dispose();
		OutputStream out = response.getOutputStream();
		//6,使用ImageIO类中的方法把图片写出
		ImageIO.write(image, "JPEG", out);
		out.close();
	}


}
