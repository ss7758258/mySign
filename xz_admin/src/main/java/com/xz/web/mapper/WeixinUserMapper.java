package com.xz.web.mapper;

import com.xz.web.entity.WeixinUser;
import com.xz.web.entity.WeixinUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface WeixinUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weixin_user
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    @SelectProvider(type=WeixinUserSqlProvider.class, method="countByExample")
    int countByExample(WeixinUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weixin_user
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    @DeleteProvider(type=WeixinUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(WeixinUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weixin_user
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    @Delete({
        "delete from weixin_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weixin_user
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    @Insert({
        "insert into weixin_user (constellation_id, open_id, ",
        "user_name, nick_name, ",
        "phone_no, is_disabled, ",
        "head_image, gender, ",
        "passwd, address, ",
        "create_timestamp, update_timestamp)",
        "values (#{constellationId,jdbcType=BIGINT}, #{openId,jdbcType=VARCHAR}, ",
        "#{userName,jdbcType=VARCHAR}, #{nickName,jdbcType=VARCHAR}, ",
        "#{phoneNo,jdbcType=VARCHAR}, #{isDisabled,jdbcType=VARCHAR}, ",
        "#{headImage,jdbcType=VARCHAR}, #{gender,jdbcType=VARCHAR}, ",
        "#{passwd,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{createTimestamp,jdbcType=VARCHAR}, #{updateTimestamp,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(WeixinUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weixin_user
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    @InsertProvider(type=WeixinUserSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(WeixinUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weixin_user
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    @SelectProvider(type=WeixinUserSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="constellation_id", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="open_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="user_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="nick_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="phone_no", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="is_disabled", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="head_image", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="gender", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="passwd", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="address", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_timestamp", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="update_timestamp", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<WeixinUser> selectByExample(WeixinUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weixin_user
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    @Select({
        "select",
        "id, constellation_id, open_id, user_name, nick_name, phone_no, is_disabled, ",
        "head_image, gender, passwd, address, create_timestamp, update_timestamp",
        "from weixin_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="constellation_id", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="open_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="user_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="nick_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="phone_no", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="is_disabled", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="head_image", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="gender", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="passwd", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="address", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_timestamp", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="update_timestamp", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    WeixinUser selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weixin_user
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    @UpdateProvider(type=WeixinUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WeixinUser record, @Param("example") WeixinUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weixin_user
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    @UpdateProvider(type=WeixinUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WeixinUser record, @Param("example") WeixinUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weixin_user
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    @UpdateProvider(type=WeixinUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WeixinUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weixin_user
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    @Update({
        "update weixin_user",
        "set constellation_id = #{constellationId,jdbcType=BIGINT},",
          "open_id = #{openId,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "nick_name = #{nickName,jdbcType=VARCHAR},",
          "phone_no = #{phoneNo,jdbcType=VARCHAR},",
          "is_disabled = #{isDisabled,jdbcType=VARCHAR},",
          "head_image = #{headImage,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=VARCHAR},",
          "passwd = #{passwd,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "create_timestamp = #{createTimestamp,jdbcType=VARCHAR},",
          "update_timestamp = #{updateTimestamp,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(WeixinUser record);
}