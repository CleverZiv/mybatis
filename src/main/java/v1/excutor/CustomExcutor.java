package v1.excutor;

/**
 * @Classname CustomExcutor
 * @Date 2019/5/20 15:40
 * @Autor lengzefu
 */
public interface CustomExcutor {
    public <T> T query(String statement, String parameter);

}
