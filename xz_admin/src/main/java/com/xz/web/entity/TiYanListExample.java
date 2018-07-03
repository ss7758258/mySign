package com.xz.web.entity;

import java.util.ArrayList;
import java.util.List;

public class TiYanListExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ti_yan_list
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ti_yan_list
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ti_yan_list
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_yan_list
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    public TiYanListExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_yan_list
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_yan_list
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_yan_list
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_yan_list
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_yan_list
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_yan_list
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_yan_list
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_yan_list
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_yan_list
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_yan_list
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ti_yan_list
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andConstellationIdIsNull() {
            addCriterion("constellation_id is null");
            return (Criteria) this;
        }

        public Criteria andConstellationIdIsNotNull() {
            addCriterion("constellation_id is not null");
            return (Criteria) this;
        }

        public Criteria andConstellationIdEqualTo(Long value) {
            addCriterion("constellation_id =", value, "constellationId");
            return (Criteria) this;
        }

        public Criteria andConstellationIdNotEqualTo(Long value) {
            addCriterion("constellation_id <>", value, "constellationId");
            return (Criteria) this;
        }

        public Criteria andConstellationIdGreaterThan(Long value) {
            addCriterion("constellation_id >", value, "constellationId");
            return (Criteria) this;
        }

        public Criteria andConstellationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("constellation_id >=", value, "constellationId");
            return (Criteria) this;
        }

        public Criteria andConstellationIdLessThan(Long value) {
            addCriterion("constellation_id <", value, "constellationId");
            return (Criteria) this;
        }

        public Criteria andConstellationIdLessThanOrEqualTo(Long value) {
            addCriterion("constellation_id <=", value, "constellationId");
            return (Criteria) this;
        }

        public Criteria andConstellationIdIn(List<Long> values) {
            addCriterion("constellation_id in", values, "constellationId");
            return (Criteria) this;
        }

        public Criteria andConstellationIdNotIn(List<Long> values) {
            addCriterion("constellation_id not in", values, "constellationId");
            return (Criteria) this;
        }

        public Criteria andConstellationIdBetween(Long value1, Long value2) {
            addCriterion("constellation_id between", value1, value2, "constellationId");
            return (Criteria) this;
        }

        public Criteria andConstellationIdNotBetween(Long value1, Long value2) {
            addCriterion("constellation_id not between", value1, value2, "constellationId");
            return (Criteria) this;
        }

        public Criteria andPrevPicIsNull() {
            addCriterion("prev_pic is null");
            return (Criteria) this;
        }

        public Criteria andPrevPicIsNotNull() {
            addCriterion("prev_pic is not null");
            return (Criteria) this;
        }

        public Criteria andPrevPicEqualTo(String value) {
            addCriterion("prev_pic =", value, "prevPic");
            return (Criteria) this;
        }

        public Criteria andPrevPicNotEqualTo(String value) {
            addCriterion("prev_pic <>", value, "prevPic");
            return (Criteria) this;
        }

        public Criteria andPrevPicGreaterThan(String value) {
            addCriterion("prev_pic >", value, "prevPic");
            return (Criteria) this;
        }

        public Criteria andPrevPicGreaterThanOrEqualTo(String value) {
            addCriterion("prev_pic >=", value, "prevPic");
            return (Criteria) this;
        }

        public Criteria andPrevPicLessThan(String value) {
            addCriterion("prev_pic <", value, "prevPic");
            return (Criteria) this;
        }

        public Criteria andPrevPicLessThanOrEqualTo(String value) {
            addCriterion("prev_pic <=", value, "prevPic");
            return (Criteria) this;
        }

        public Criteria andPrevPicLike(String value) {
            addCriterion("prev_pic like", value, "prevPic");
            return (Criteria) this;
        }

        public Criteria andPrevPicNotLike(String value) {
            addCriterion("prev_pic not like", value, "prevPic");
            return (Criteria) this;
        }

        public Criteria andPrevPicIn(List<String> values) {
            addCriterion("prev_pic in", values, "prevPic");
            return (Criteria) this;
        }

        public Criteria andPrevPicNotIn(List<String> values) {
            addCriterion("prev_pic not in", values, "prevPic");
            return (Criteria) this;
        }

        public Criteria andPrevPicBetween(String value1, String value2) {
            addCriterion("prev_pic between", value1, value2, "prevPic");
            return (Criteria) this;
        }

        public Criteria andPrevPicNotBetween(String value1, String value2) {
            addCriterion("prev_pic not between", value1, value2, "prevPic");
            return (Criteria) this;
        }

        public Criteria andSpeechIsNull() {
            addCriterion("speech is null");
            return (Criteria) this;
        }

        public Criteria andSpeechIsNotNull() {
            addCriterion("speech is not null");
            return (Criteria) this;
        }

        public Criteria andSpeechEqualTo(String value) {
            addCriterion("speech =", value, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechNotEqualTo(String value) {
            addCriterion("speech <>", value, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechGreaterThan(String value) {
            addCriterion("speech >", value, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechGreaterThanOrEqualTo(String value) {
            addCriterion("speech >=", value, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechLessThan(String value) {
            addCriterion("speech <", value, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechLessThanOrEqualTo(String value) {
            addCriterion("speech <=", value, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechLike(String value) {
            addCriterion("speech like", value, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechNotLike(String value) {
            addCriterion("speech not like", value, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechIn(List<String> values) {
            addCriterion("speech in", values, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechNotIn(List<String> values) {
            addCriterion("speech not in", values, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechBetween(String value1, String value2) {
            addCriterion("speech between", value1, value2, "speech");
            return (Criteria) this;
        }

        public Criteria andSpeechNotBetween(String value1, String value2) {
            addCriterion("speech not between", value1, value2, "speech");
            return (Criteria) this;
        }

        public Criteria andPublishPersonIsNull() {
            addCriterion("publish_person is null");
            return (Criteria) this;
        }

        public Criteria andPublishPersonIsNotNull() {
            addCriterion("publish_person is not null");
            return (Criteria) this;
        }

        public Criteria andPublishPersonEqualTo(String value) {
            addCriterion("publish_person =", value, "publishPerson");
            return (Criteria) this;
        }

        public Criteria andPublishPersonNotEqualTo(String value) {
            addCriterion("publish_person <>", value, "publishPerson");
            return (Criteria) this;
        }

        public Criteria andPublishPersonGreaterThan(String value) {
            addCriterion("publish_person >", value, "publishPerson");
            return (Criteria) this;
        }

        public Criteria andPublishPersonGreaterThanOrEqualTo(String value) {
            addCriterion("publish_person >=", value, "publishPerson");
            return (Criteria) this;
        }

        public Criteria andPublishPersonLessThan(String value) {
            addCriterion("publish_person <", value, "publishPerson");
            return (Criteria) this;
        }

        public Criteria andPublishPersonLessThanOrEqualTo(String value) {
            addCriterion("publish_person <=", value, "publishPerson");
            return (Criteria) this;
        }

        public Criteria andPublishPersonLike(String value) {
            addCriterion("publish_person like", value, "publishPerson");
            return (Criteria) this;
        }

        public Criteria andPublishPersonNotLike(String value) {
            addCriterion("publish_person not like", value, "publishPerson");
            return (Criteria) this;
        }

        public Criteria andPublishPersonIn(List<String> values) {
            addCriterion("publish_person in", values, "publishPerson");
            return (Criteria) this;
        }

        public Criteria andPublishPersonNotIn(List<String> values) {
            addCriterion("publish_person not in", values, "publishPerson");
            return (Criteria) this;
        }

        public Criteria andPublishPersonBetween(String value1, String value2) {
            addCriterion("publish_person between", value1, value2, "publishPerson");
            return (Criteria) this;
        }

        public Criteria andPublishPersonNotBetween(String value1, String value2) {
            addCriterion("publish_person not between", value1, value2, "publishPerson");
            return (Criteria) this;
        }

        public Criteria andPublishStatusIsNull() {
            addCriterion("publish_status is null");
            return (Criteria) this;
        }

        public Criteria andPublishStatusIsNotNull() {
            addCriterion("publish_status is not null");
            return (Criteria) this;
        }

        public Criteria andPublishStatusEqualTo(String value) {
            addCriterion("publish_status =", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusNotEqualTo(String value) {
            addCriterion("publish_status <>", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusGreaterThan(String value) {
            addCriterion("publish_status >", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusGreaterThanOrEqualTo(String value) {
            addCriterion("publish_status >=", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusLessThan(String value) {
            addCriterion("publish_status <", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusLessThanOrEqualTo(String value) {
            addCriterion("publish_status <=", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusLike(String value) {
            addCriterion("publish_status like", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusNotLike(String value) {
            addCriterion("publish_status not like", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusIn(List<String> values) {
            addCriterion("publish_status in", values, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusNotIn(List<String> values) {
            addCriterion("publish_status not in", values, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusBetween(String value1, String value2) {
            addCriterion("publish_status between", value1, value2, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusNotBetween(String value1, String value2) {
            addCriterion("publish_status not between", value1, value2, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(String value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(String value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(String value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(String value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(String value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(String value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLike(String value) {
            addCriterion("publish_time like", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotLike(String value) {
            addCriterion("publish_time not like", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<String> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<String> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(String value1, String value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(String value1, String value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampIsNull() {
            addCriterion("create_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampIsNotNull() {
            addCriterion("create_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampEqualTo(String value) {
            addCriterion("create_timestamp =", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampNotEqualTo(String value) {
            addCriterion("create_timestamp <>", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampGreaterThan(String value) {
            addCriterion("create_timestamp >", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampGreaterThanOrEqualTo(String value) {
            addCriterion("create_timestamp >=", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampLessThan(String value) {
            addCriterion("create_timestamp <", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampLessThanOrEqualTo(String value) {
            addCriterion("create_timestamp <=", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampLike(String value) {
            addCriterion("create_timestamp like", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampNotLike(String value) {
            addCriterion("create_timestamp not like", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampIn(List<String> values) {
            addCriterion("create_timestamp in", values, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampNotIn(List<String> values) {
            addCriterion("create_timestamp not in", values, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampBetween(String value1, String value2) {
            addCriterion("create_timestamp between", value1, value2, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampNotBetween(String value1, String value2) {
            addCriterion("create_timestamp not between", value1, value2, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andUpdateTimestampIsNull() {
            addCriterion("update_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimestampIsNotNull() {
            addCriterion("update_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimestampEqualTo(String value) {
            addCriterion("update_timestamp =", value, "updateTimestamp");
            return (Criteria) this;
        }

        public Criteria andUpdateTimestampNotEqualTo(String value) {
            addCriterion("update_timestamp <>", value, "updateTimestamp");
            return (Criteria) this;
        }

        public Criteria andUpdateTimestampGreaterThan(String value) {
            addCriterion("update_timestamp >", value, "updateTimestamp");
            return (Criteria) this;
        }

        public Criteria andUpdateTimestampGreaterThanOrEqualTo(String value) {
            addCriterion("update_timestamp >=", value, "updateTimestamp");
            return (Criteria) this;
        }

        public Criteria andUpdateTimestampLessThan(String value) {
            addCriterion("update_timestamp <", value, "updateTimestamp");
            return (Criteria) this;
        }

        public Criteria andUpdateTimestampLessThanOrEqualTo(String value) {
            addCriterion("update_timestamp <=", value, "updateTimestamp");
            return (Criteria) this;
        }

        public Criteria andUpdateTimestampLike(String value) {
            addCriterion("update_timestamp like", value, "updateTimestamp");
            return (Criteria) this;
        }

        public Criteria andUpdateTimestampNotLike(String value) {
            addCriterion("update_timestamp not like", value, "updateTimestamp");
            return (Criteria) this;
        }

        public Criteria andUpdateTimestampIn(List<String> values) {
            addCriterion("update_timestamp in", values, "updateTimestamp");
            return (Criteria) this;
        }

        public Criteria andUpdateTimestampNotIn(List<String> values) {
            addCriterion("update_timestamp not in", values, "updateTimestamp");
            return (Criteria) this;
        }

        public Criteria andUpdateTimestampBetween(String value1, String value2) {
            addCriterion("update_timestamp between", value1, value2, "updateTimestamp");
            return (Criteria) this;
        }

        public Criteria andUpdateTimestampNotBetween(String value1, String value2) {
            addCriterion("update_timestamp not between", value1, value2, "updateTimestamp");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ti_yan_list
     *
     * @mbggenerated do_not_delete_during_merge Sun May 13 16:14:16 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ti_yan_list
     *
     * @mbggenerated Sun May 13 16:14:16 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}