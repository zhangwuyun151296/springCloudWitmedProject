import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>${comment}</b>
 *
 * @author 张武超
 * @date 2022/1/12
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@TableName("${tableName}")
public class ${entityName} extends BaseEntity {
	private static final long serialVersionUID = 1L;
<#list propertyList as property>
<#if (property_index == 0)>
	@TableId(type = IdType.NONE)
	private ${property.type} ${property.name};                        // ${property.comment}
</#if>
	@TableField(value = "${property.name}")
	private ${property.type} ${property.name};                        // ${property.comment}
</#list>
}