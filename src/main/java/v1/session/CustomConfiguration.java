package v1.session;

import v1.binding.MapperRegistory;
import v1.mapper.UserMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname CustomConfiguration
 * @Date 2019/5/20 15:40
 * @Autor lengzefu
 */
public class CustomConfiguration {

    public final MapperRegistory mapperRegistory = new MapperRegistory();

    public static final Map<String, String> mappedStatements = new HashMap<>();

    public CustomConfiguration() {
        mapperRegistory.addMapper(UserMapper.class);
        mappedStatements.put("v1.mapper.UserMapper.selectByPrimaryKey"
                , "select * from user where id = %d");
    }

    //MapperProxy根据statementName查找是否有对应SQL
    public boolean hasStatement(String statementName) {
        return mappedStatements.containsKey(statementName);
    }

    //MapperProxy根据statementID获取SQL
    public String getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    public <T> T getMapper(Class<T> clazz, CustomSqlSession customSqlSession) {
        return mapperRegistory.getMapper(clazz, customSqlSession);
    }
}
