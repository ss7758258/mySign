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

import com.xz.web.entity.TcConstellation;
import com.xz.web.entity.TcConstellationExample.Criteria;
import com.xz.web.entity.TcConstellationExample.Criterion;
import com.xz.web.entity.TcConstellationExample;
import java.util.List;
import java.util.Map;

public class TcConstellationSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tc_constellation
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public String countByExample(TcConstellationExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("tc_constellation");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tc_constellation
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public String deleteByExample(TcConstellationExample example) {
        BEGIN();
        DELETE_FROM("tc_constellation");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tc_constellation
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public String insertSelective(TcConstellation record) {
        BEGIN();
        INSERT_INTO("tc_constellation");
        
        if (record.getConstellationName() != null) {
            VALUES("constellation_name", "#{constellationName,jdbcType=VARCHAR}");
        }
        
        if (record.getStartDate() != null) {
            VALUES("start_date", "#{startDate,jdbcType=VARCHAR}");
        }
        
        if (record.getEndDate() != null) {
            VALUES("end_date", "#{endDate,jdbcType=VARCHAR}");
        }
        
        if (record.getPictureUrl() != null) {
            VALUES("picture_url", "#{pictureUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table tc_constellation
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public String selectByExample(TcConstellationExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("constellation_name");
        SELECT("start_date");
        SELECT("end_date");
        SELECT("picture_url");
        SELECT("remark");
        SELECT("create_timestamp");
        SELECT("update_timestamp");
        FROM("tc_constellation");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tc_constellation
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TcConstellation record = (TcConstellation) parameter.get("record");
        TcConstellationExample example = (TcConstellationExample) parameter.get("example");
        
        BEGIN();
        UPDATE("tc_constellation");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getConstellationName() != null) {
            SET("constellation_name = #{record.constellationName,jdbcType=VARCHAR}");
        }
        
        if (record.getStartDate() != null) {
            SET("start_date = #{record.startDate,jdbcType=VARCHAR}");
        }
        
        if (record.getEndDate() != null) {
            SET("end_date = #{record.endDate,jdbcType=VARCHAR}");
        }
        
        if (record.getPictureUrl() != null) {
            SET("picture_url = #{record.pictureUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table tc_constellation
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("tc_constellation");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("constellation_name = #{record.constellationName,jdbcType=VARCHAR}");
        SET("start_date = #{record.startDate,jdbcType=VARCHAR}");
        SET("end_date = #{record.endDate,jdbcType=VARCHAR}");
        SET("picture_url = #{record.pictureUrl,jdbcType=VARCHAR}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("create_timestamp = #{record.createTimestamp,jdbcType=VARCHAR}");
        SET("update_timestamp = #{record.updateTimestamp,jdbcType=VARCHAR}");
        
        TcConstellationExample example = (TcConstellationExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tc_constellation
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public String updateByPrimaryKeySelective(TcConstellation record) {
        BEGIN();
        UPDATE("tc_constellation");
        
        if (record.getConstellationName() != null) {
            SET("constellation_name = #{constellationName,jdbcType=VARCHAR}");
        }
        
        if (record.getStartDate() != null) {
            SET("start_date = #{startDate,jdbcType=VARCHAR}");
        }
        
        if (record.getEndDate() != null) {
            SET("end_date = #{endDate,jdbcType=VARCHAR}");
        }
        
        if (record.getPictureUrl() != null) {
            SET("picture_url = #{pictureUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table tc_constellation
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    protected void applyWhere(TcConstellationExample example, boolean includeExamplePhrase) {
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