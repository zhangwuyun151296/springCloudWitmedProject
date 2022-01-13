package com.whackon.witmed.controller;

import com.whackon.witmed.pojo.vo.GeneratorVO;
import com.whackon.witmed.service.GeneratorService;
import com.whackon.witmed.util.ConnectionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Connection;

/**
 * <b></b>
 *
 * @author 张武超
 * @date 2022/1/12
 * @since
 */
@Controller("generatorController")
public class GeneratorController {
	@Resource(name = "generatorService")
	private GeneratorService generatorService;

	@GetMapping("/generator")
	public String index() throws Exception {
		return "generator_index";
	}

	/**
	 * <b>根据用户所给定的信息生成对应的代码</b>
	 * @param
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/generate")
	@ResponseBody
	public boolean generateCode(String dbIP,String dbPort ,String dbSchema,String dbName,String dbPassword ) throws Exception {
		// 使用所给定的数据库信息创建 Connection 对象
		GeneratorVO generatorVO=new GeneratorVO(dbIP, dbPort, dbSchema, dbName, dbPassword);
		Connection connection = ConnectionUtil.getConnection(
				generatorVO.getDbIP(), generatorVO.getDbPort(), generatorVO.getDbSchema(),
				generatorVO.getDbName(), generatorVO.getDbPassword());
		// 使用 Connection 对象生成代码
		return generatorService.generateCode(generatorVO, connection);
	}
}
