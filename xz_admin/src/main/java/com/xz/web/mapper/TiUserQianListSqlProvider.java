package com.xz.web.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.xz.web.entity.TiUserQianList;
import com.xz.web.entity.TiUserQianListExample.Criteria;
import com.xz.web.entity.TiUserQianListExample.Criterion;
import com.xz.web.entity.TiUserQianListExample;
import java.util.List;
import java.util.Map;

public class TiUserQianListSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_user_qian_list
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    public String countByExample(TiUserQianListExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("ti_user_qian_list");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_user_qian_list
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    public String deleteByExample(TiUserQianListExample example) {
        BEGIN();
        DELETE_FROM("ti_user_qian_list");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_user_qian_list
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    public String insertSelective(TiUserQianList record) {
        BEGIN();
        INSERT_INTO("ti_user_qian_list");
        
        if (record.getQianDate() != null) {
            VALUES("qian_date", "#{qianDate,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getQianName() != null) {
            VALUES("qian_name", "#{qianName,jdbcType=VARCHAR}");
        }
        
        if (record.getQianContent() != null) {
            VALUES("qian_content", "#{qianContent,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getFriendOpenId1() != null) {
            VALUES("friend_open_id1", "#{friendOpenId1,jdbcType=VARCHAR}");
        }
        
        if (record.getFriendOpenId2() != null) {
            VALUES("friend_open_id2", "#{friendOpenId2,jdbcType=VARCHAR}");
        }
        
        if (record.getFriendOpenId3() != null) {
            VALUES("friend_open_id3", "#{friendOpenId3,jdbcType=VARCHAR}");
        }
        
        if (record.getFriendOpenId4() != null) {
            VALUES("friend_open_id4", "#{friendOpenId4,jdbcType=VARCHAR}");
        }
        
        if (record.getFriendOpenId5() != null) {
            VALUES("friend_open_id5", "#{friendOpenId5,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTimestamp() != null) {
            VALUES("create_timestamp", "#{createTimestamp,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTimestamp() != null) {
            VALUES("update_timestamp", "#{updateTimestamp,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_user_qian_list
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    public String selectByExample(TiUserQianListExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("qian_date");
        SELECT("status");
        SELECT("qian_name");
        SELECT("qian_content");
        SELECT("user_id");
        SELECT("friend_open_id1");
        SELECT("friend_open_id2");
        SELECT("friend_open_id3");
        SELECT("friend_open_id4");
        SELECT("friend_open_id5");
        SELECT("create_timestamp");
        SELECT("update_timestamp");
        FROM("ti_user_qian_list");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_user_qian_list
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TiUserQianList record = (TiUserQianList) parameter.get("record");
        TiUserQianListExample example = (TiUserQianListExample) parameter.get("example");
        
        BEGIN();
        UPDATE("ti_user_qian_list");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getQianDate() != null) {
            SET("qian_date = #{record.qianDate,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getQianName() != null) {
            SET("qian_name = #{record.qianName,jdbcType=VARCHAR}");
        }
        
        if (record.getQianContent() != null) {
            SET("qian_content = #{record.qianContent,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getFriendOpenId1() != null) {
            SET("friend_open_id1 = #{record.friendOpenId1,jdbcType=VARCHAR}");
        }
        
        if (record.getFriendOpenId2() != null) {
            SET("friend_open_id2 = #{record.friendOpenId2,jdbcType=VARCHAR}");
        }
        
        if (record.getFriendOpenId3() != null) {
            SET("friend_open_id3 = #{record.friendOpenId3,jdbcType=VARCHAR}");
        }
        
        if (record.getFriendOpenId4() != null) {
            SET("friend_open_id4 = #{record.friendOpenId4,jdbcType=VARCHAR}");
        }
        
        if (record.getFriendOpenId5() != null) {
            SET("friend_open_id5 = #{record.friendOpenId5,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTimestamp() != null) {
            SET("create_timestamp = #{record.createTimestamp,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTimestamp() != null) {
            SET("update_timestamp = #{record.updateTimestamp,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_user_qian_list
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("ti_user_qian_list");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("qian_date = #{record.qianDate,jdbcType=VARCHAR}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("qian_name = #{record.qianName,jdbcType=VARCHAR}");
        SET("qian_content = #{record.qianContent,jdbcType=VARCHAR}");
        SET("user_id = #{record.userId,jdbcType=BIGINT}");
        SET("friend_open_id1 = #{record.friendOpenId1,jdbcType=VARCHAR}");
        SET("friend_open_id2 = #{record.friendOpenId2,jdbcType=VARCHAR}");
        SET("friend_open_id3 = #{record.friendOpenId3,jdbcType=VARCHAR}");
        SET("friend_open_id4 = #{record.friendOpenId4,jdbcType=VARCHAR}");
        SET("friend_open_id5 = #{record.friendOpenId5,jdbcType=VARCHAR}");
        SET("create_timestamp = #{record.createTimestamp,jdbcType=VARCHAR}");
        SET("update_timestamp = #{record.updateTimestamp,jdbcType=VARCHAR}");
        
        TiUserQianListExample example = (TiUserQianListExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_user_qian_list
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    public String updateByPrimaryKeySelective(TiUserQianList record) {
        BEGIN();
        UPDATE("ti_user_qian_list");
        
        if (record.getQianDate() != null) {
            SET("qian_date = #{qianDate,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getQianName() != null) {
            SET("qian_name = #{qianName,jdbcType=VARCHAR}");
        }
        
        if (record.getQianContent() != null) {
            SET("qian_content = #{qianContent,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getFriendOpenId1() != null) {
            SET("friend_open_id1 = #{friendOpenId1,jdbcType=VARCHAR}");
        }
        
        if (record.getFriendOpenId2() != null) {
            SET("friend_open_id2 = #{friendOpenId2,jdbcType=VARCHAR}");
        }
        
        if (record.getFriendOpenId3() != null) {
            SET("friend_open_id3 = #{friendOpenId3,jdbcType=VARCHAR}");
        }
        
        if (record.getFriendOpenId4() != null) {
            SET("friend_open_id4 = #{friendOpenId4,jdbcType=VARCHAR}");
        }
        
        if (record.getFriendOpenId5() != null) {
            SET("friend_open_id5 = #{friendOpenId5,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTimestamp() != null) {
            SET("create_timestamp = #{createTimestamp,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTimestamp() != null) {
            SET("update_timestamp = #{updateTimestamp,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_user_qian_list
     *
     * @mbggenerated Sat May 12 22:20:50 CST 2018
     */
    protected void applyWhere(TiUserQianListExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}