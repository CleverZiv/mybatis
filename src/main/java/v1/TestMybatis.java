package v1;

import v1.excutor.CustomDefaultExecutor;
import v1.mapper.UserMapper;
import v1.session.CustomConfiguration;
import v1.session.CustomSqlSession;

/**
 * @Classname TestMybatis
 * @Date 2019/5/20 16:15
 * @Autor lengzefu
 */
public class TestMybatis {
    public static void main(String[] args) {
        CustomSqlSession sqlSession = new CustomSqlSession(
                new CustomConfiguration(), new CustomDefaultExecutor());
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.selectByPrimaryKey(2));

    }
}
