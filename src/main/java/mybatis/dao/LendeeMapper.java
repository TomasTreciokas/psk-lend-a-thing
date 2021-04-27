package mybatis.dao;

import java.util.List;
import mybatis.model.Lendee;
import org.mybatis.cdi.Mapper;

@Mapper
public interface LendeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.LENDEE
     *
     * @mbg.generated Sun Apr 11 10:19:35 EEST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.LENDEE
     *
     * @mbg.generated Sun Apr 11 10:19:35 EEST 2021
     */
    int insert(Lendee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.LENDEE
     *
     * @mbg.generated Sun Apr 11 10:19:35 EEST 2021
     */
    Lendee selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.LENDEE
     *
     * @mbg.generated Sun Apr 11 10:19:35 EEST 2021
     */
    List<Lendee> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.LENDEE
     *
     * @mbg.generated Sun Apr 11 10:19:35 EEST 2021
     */
    int updateByPrimaryKey(Lendee record);
}