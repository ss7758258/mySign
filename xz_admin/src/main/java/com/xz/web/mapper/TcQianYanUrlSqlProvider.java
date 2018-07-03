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

import com.xz.web.entity.TcQianYanUrl;
import com.xz.web.entity.TcQianYanUrlExample.Criteria;
import com.xz.web.entity.TcQianYanUrlExample.Criterion;
import com.xz.web.entity.TcQianYanUrlExample;
import java.util.List;
import java.util.Map;

public class TcQianYanUrlSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tc_qian_yan_url
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    public String countByExample(TcQianYanUrlExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("tc_qian_yan_url");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tc_qian_yan_url
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    public String deleteByExample(TcQianYanUrlExample example) {
        BEGIN();
        DELETE_FROM("tc_qian_yan_url");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tc_qian_yan_url
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    public String insertSelective(TcQianYanUrl record) {
        BEGIN();
        INSERT_INTO("tc_qian_yan_url");
        
        if (record.getYanUrl() != null) {
            VALUES("yan_url", "#{yanUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getQianUrl() != null) {
            VALUES("qian_url", "#{qianUrl,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table tc_qian_yan_url
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    public String selectByExample(TcQianYanUrlExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("yan_url");
        SELECT("qian_url");
        SELECT("create_timestamp");
        SELECT("update_timestamp");
        FROM("tc_qian_yan_url");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tc_qian_yan_url
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TcQianYanUrl record = (TcQianYanUrl) parameter.get("record");
        TcQianYanUrlExample example = (TcQianYanUrlExample) parameter.get("example");
        
        BEGIN();
        UPDATE("tc_qian_yan_url");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getYanUrl() != null) {
            SET("yan_url = #{record.yanUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getQianUrl() != null) {
            SET("qian_url = #{record.qianUrl,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table tc_qian_yan_url
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("tc_qian_yan_url");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("yan_url = #{record.yanUrl,jdbcType=VARCHAR}");
        SET("qian_url = #{record.qianUrl,jdbcType=VARCHAR}");
        SET("create_timestamp = #{record.createTimestamp,jdbcType=VARCHAR}");
        SET("update_timestamp = #{record.updateTimestamp,jdbcType=VARCHAR}");
        
        TcQianYanUrlExample example = (TcQianYanUrlExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tc_qian_yan_url
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    public String updateByPrimaryKeySelective(TcQianYanUrl record) {
        BEGIN();
        UPDATE("tc_qian_yan_url");
        
        if (record.getYanUrl() != null) {
            SET("yan_url = #{yanUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getQianUrl() != null) {
            SET("qian_url = #{qianUrl,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table tc_qian_yan_url
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    protected void applyWhere(TcQianYanUrlExample example, boolean includeExamplePhrase) {
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