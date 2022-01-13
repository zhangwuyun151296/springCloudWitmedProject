package com.whackon.witmed.service;

import com.whackon.witmed.pojo.vo.GeneratorVO;

import java.sql.Connection;

/**
 * <b></b>
 *
 * @author 张武超
 * @date 2022/1/12
 * @since
 */
public interface GeneratorService {
	/**
	 * <b>根据连接对象生成代码</b>
	 * @param generatorVO
	 * @param connection
	 * @return
	 * @throws Exception
	 */
	boolean generateCode(GeneratorVO generatorVO, Connection connection) throws Exception;
}
