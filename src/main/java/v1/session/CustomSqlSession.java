package v1.session;

import v1.excutor.CustomExcutor;

/**
 * @Classname CustomSqlSession
 * @Date 2019/5/20 15:38
 * @Autor lengzefu
 */
public class CustomSqlSession {

    /**
     * 持有两个对象，分别对应xml配置文件和操作数据库的执行者
     */
    private CustomConfiguration customConfiguration;
    private CustomExcutor customExcutor;

    /**
     * 用构造器将两个对象形成关系
     * @param customConfiguration
     * @param customExcutor
     */
    public CustomSqlSession(CustomConfiguration customConfiguration, CustomExcutor customExcutor) {
        this.customConfiguration = customConfiguration;
        this.customExcutor = customExcutor;
    }

    public CustomConfiguration getCustomConfiguration() {
        return customConfiguration;
    }

    /**
     * 委派customConfiguration获取mapper
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> clazz) {
        return customConfiguration.getMapper(clazz, this);
    }

    public <T> T selectOne(String statement, String parameter) {
        return customExcutor.query(statement, parameter);
    }
}
