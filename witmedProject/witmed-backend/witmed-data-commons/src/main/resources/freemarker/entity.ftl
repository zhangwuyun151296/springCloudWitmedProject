package ${packageName};

import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>系统功能 - 系统用户实体信息</b>
 * @author 张武超
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
*/
@Data
public class ${className} extends BaseEntity{
    <#list propertyList as property>
        private ${property.type} ${property.name};                  //${property.comment}
    </#list>
}