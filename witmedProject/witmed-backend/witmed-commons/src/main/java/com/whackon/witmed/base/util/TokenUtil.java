package com.whackon.witmed.base.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.tomcat.jni.Mmap;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <b>基础信息功能-Token工具类</b>
 * <p>
 *     为了能够实现Token机制，选择借助于JWT(JSON WEB Token)来实现
 *     通过JWT能够实现一个唯一经过加密的Token
 * </p>
 * @Author 张武超
 * @Date 2022/1/6
 * @version 1.0.0
 * @serial 1.0.0
 */
public class TokenUtil {
	//设定系统加密算法
	private static final Algorithm algorithm= Algorithm.HMAC256(BaseConstants.SECRET_KEY);

	/**
	 * 根据用户所给定的信息生成Token
	 * @param claimmMap
	 * @param expireSec
	 * @return
	 */
	public static String createToken(Map<String,String> claimmMap,Long expireSec) {
		//创建生成JWt Token对象
		JWTCreator.Builder builder= JWT.create();
		//创建map集合，用于设定生成Tokend的头部消息
		Map<String ,Object> headerMap=new HashMap<String,Object>();
		//设定token的生成方式是使用了jwt
		headerMap.put("typ","jwt");
		//设定整体的token的加密算法
		headerMap.put("alg", "HS256");
		//设定头部信息
		builder.withHeader(headerMap);
		//-----------------------------
		//设定token的有效载荷部分,共有三种方法
		//第一种当时直接放claimmMap进去
		//builder.withClaim("message", claimmMap);
		//第二种取出所给定的map集合中的每一个key-value组合，逐一的添加到载荷中
		//循环map集合
		//Set<String> keySet=claimmMap.keySet();
		//for (String key : keySet) {
			//Object value=claimmMap.get(key);
			//builder.withClaim(key, String.valueOf(value));
		//}
		//第三种方式是使用JDK8所提供的foreach(),能够快速的实现对map的循环
		claimmMap.forEach((k, v)->{
			builder.withClaim(k, v);
		});
		//设定token的有效时间，需要获得Token到期的时间Date,未来过期的时间
		builder.withExpiresAt(new Date(System.currentTimeMillis()+expireSec*1000));
		//进行token签名获得最后的Token信息
		return builder.sign(algorithm);
	}

	/**
	 * <b>校验 Token 信息，获得该 Token 中的有效载荷数据</b>
	 * @param token
	 * @return
	 */
	public static Map<String, String> verifyToken(String token) {
		// 校验此时所给定的 Token 是符合相关形式的
		if (token != null && !"".equals(token.trim())) {
			// 此时 Token 格式有效
			// 获得 Token 校验对象 JWTVerifier
			JWTVerifier verifier = JWT.require(algorithm).build();
			// 对于该 Token 进行校验
			DecodedJWT decodedJWT = verifier.verify(token);
			// 如果能够获得 DecodedJWT 则说明通过秘钥能够将加密 Token 进行解密
			// 提取绑定在 Token 中的有效载荷信息
			Map<String, String> resultMap = new HashMap<String, String>();
			decodedJWT.getClaims().forEach((key, value) -> {
				resultMap.put(key, value.asString());
			});
			return resultMap;
		}
		return null;
	}

	public static void main(String[] args) {
	/*	Map<String,String>map=new HashMap<>();
		map.put("name","張三");
		System.out.println(createToken(map,  1800L));*/
		Map<String, String> map=verifyToken("eyJ0eXAiOiJqd3QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoi5by15LiJIiwiZXhwIjoxNjQxNDc3NzE4fQ.G7I9ScaC2Tiu7nhgmwauRThvMnv7dZjbFahmaerFu6s");
		map.forEach((k,v)->{
			System.out.println("key："+k+"\tvalue："+v);
		});

	}
}
