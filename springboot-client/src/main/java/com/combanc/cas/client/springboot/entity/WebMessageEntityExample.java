package com.combanc.cas.client.springboot.entity;

import java.util.ArrayList;
import java.util.List;

public class WebMessageEntityExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WebMessageEntityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }
    /**
     * 偏移量
     */
    private Integer offset;

    /**
     * 分页数
     */
    private Integer limit;
    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMessageTitleIsNull() {
            addCriterion("message_title is null");
            return (Criteria) this;
        }

        public Criteria andMessageTitleIsNotNull() {
            addCriterion("message_title is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTitleEqualTo(String value) {
            addCriterion("message_title =", value, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleNotEqualTo(String value) {
            addCriterion("message_title <>", value, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleGreaterThan(String value) {
            addCriterion("message_title >", value, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleGreaterThanOrEqualTo(String value) {
            addCriterion("message_title >=", value, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleLessThan(String value) {
            addCriterion("message_title <", value, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleLessThanOrEqualTo(String value) {
            addCriterion("message_title <=", value, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleLike(String value) {
            addCriterion("message_title like", value, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleNotLike(String value) {
            addCriterion("message_title not like", value, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleIn(List<String> values) {
            addCriterion("message_title in", values, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleNotIn(List<String> values) {
            addCriterion("message_title not in", values, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleBetween(String value1, String value2) {
            addCriterion("message_title between", value1, value2, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleNotBetween(String value1, String value2) {
            addCriterion("message_title not between", value1, value2, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentPartIsNull() {
            addCriterion("department_part is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentPartIsNotNull() {
            addCriterion("department_part is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentPartEqualTo(String value) {
            addCriterion("department_part =", value, "departmentPart");
            return (Criteria) this;
        }

        public Criteria andDepartmentPartNotEqualTo(String value) {
            addCriterion("department_part <>", value, "departmentPart");
            return (Criteria) this;
        }

        public Criteria andDepartmentPartGreaterThan(String value) {
            addCriterion("department_part >", value, "departmentPart");
            return (Criteria) this;
        }

        public Criteria andDepartmentPartGreaterThanOrEqualTo(String value) {
            addCriterion("department_part >=", value, "departmentPart");
            return (Criteria) this;
        }

        public Criteria andDepartmentPartLessThan(String value) {
            addCriterion("department_part <", value, "departmentPart");
            return (Criteria) this;
        }

        public Criteria andDepartmentPartLessThanOrEqualTo(String value) {
            addCriterion("department_part <=", value, "departmentPart");
            return (Criteria) this;
        }

        public Criteria andDepartmentPartLike(String value) {
            addCriterion("department_part like", value, "departmentPart");
            return (Criteria) this;
        }

        public Criteria andDepartmentPartNotLike(String value) {
            addCriterion("department_part not like", value, "departmentPart");
            return (Criteria) this;
        }

        public Criteria andDepartmentPartIn(List<String> values) {
            addCriterion("department_part in", values, "departmentPart");
            return (Criteria) this;
        }

        public Criteria andDepartmentPartNotIn(List<String> values) {
            addCriterion("department_part not in", values, "departmentPart");
            return (Criteria) this;
        }

        public Criteria andDepartmentPartBetween(String value1, String value2) {
            addCriterion("department_part between", value1, value2, "departmentPart");
            return (Criteria) this;
        }

        public Criteria andDepartmentPartNotBetween(String value1, String value2) {
            addCriterion("department_part not between", value1, value2, "departmentPart");
            return (Criteria) this;
        }

        public Criteria andReadingVolumeIsNull() {
            addCriterion("reading_volume is null");
            return (Criteria) this;
        }

        public Criteria andReadingVolumeIsNotNull() {
            addCriterion("reading_volume is not null");
            return (Criteria) this;
        }

        public Criteria andReadingVolumeEqualTo(Integer value) {
            addCriterion("reading_volume =", value, "readingVolume");
            return (Criteria) this;
        }

        public Criteria andReadingVolumeNotEqualTo(Integer value) {
            addCriterion("reading_volume <>", value, "readingVolume");
            return (Criteria) this;
        }

        public Criteria andReadingVolumeGreaterThan(Integer value) {
            addCriterion("reading_volume >", value, "readingVolume");
            return (Criteria) this;
        }

        public Criteria andReadingVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("reading_volume >=", value, "readingVolume");
            return (Criteria) this;
        }

        public Criteria andReadingVolumeLessThan(Integer value) {
            addCriterion("reading_volume <", value, "readingVolume");
            return (Criteria) this;
        }

        public Criteria andReadingVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("reading_volume <=", value, "readingVolume");
            return (Criteria) this;
        }

        public Criteria andReadingVolumeIn(List<Integer> values) {
            addCriterion("reading_volume in", values, "readingVolume");
            return (Criteria) this;
        }

        public Criteria andReadingVolumeNotIn(List<Integer> values) {
            addCriterion("reading_volume not in", values, "readingVolume");
            return (Criteria) this;
        }

        public Criteria andReadingVolumeBetween(Integer value1, Integer value2) {
            addCriterion("reading_volume between", value1, value2, "readingVolume");
            return (Criteria) this;
        }

        public Criteria andReadingVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("reading_volume not between", value1, value2, "readingVolume");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andIsFloatIsNull() {
            addCriterion("is_float is null");
            return (Criteria) this;
        }

        public Criteria andIsFloatIsNotNull() {
            addCriterion("is_float is not null");
            return (Criteria) this;
        }

        public Criteria andIsFloatEqualTo(String value) {
            addCriterion("is_float =", value, "isFloat");
            return (Criteria) this;
        }

        public Criteria andIsFloatNotEqualTo(String value) {
            addCriterion("is_float <>", value, "isFloat");
            return (Criteria) this;
        }

        public Criteria andIsFloatGreaterThan(String value) {
            addCriterion("is_float >", value, "isFloat");
            return (Criteria) this;
        }

        public Criteria andIsFloatGreaterThanOrEqualTo(String value) {
            addCriterion("is_float >=", value, "isFloat");
            return (Criteria) this;
        }

        public Criteria andIsFloatLessThan(String value) {
            addCriterion("is_float <", value, "isFloat");
            return (Criteria) this;
        }

        public Criteria andIsFloatLessThanOrEqualTo(String value) {
            addCriterion("is_float <=", value, "isFloat");
            return (Criteria) this;
        }

        public Criteria andIsFloatLike(String value) {
            addCriterion("is_float like", value, "isFloat");
            return (Criteria) this;
        }

        public Criteria andIsFloatNotLike(String value) {
            addCriterion("is_float not like", value, "isFloat");
            return (Criteria) this;
        }

        public Criteria andIsFloatIn(List<String> values) {
            addCriterion("is_float in", values, "isFloat");
            return (Criteria) this;
        }

        public Criteria andIsFloatNotIn(List<String> values) {
            addCriterion("is_float not in", values, "isFloat");
            return (Criteria) this;
        }

        public Criteria andIsFloatBetween(String value1, String value2) {
            addCriterion("is_float between", value1, value2, "isFloat");
            return (Criteria) this;
        }

        public Criteria andIsFloatNotBetween(String value1, String value2) {
            addCriterion("is_float not between", value1, value2, "isFloat");
            return (Criteria) this;
        }

        public Criteria andMessageContentIsNull() {
            addCriterion("message_content is null");
            return (Criteria) this;
        }

        public Criteria andMessageContentIsNotNull() {
            addCriterion("message_content is not null");
            return (Criteria) this;
        }

        public Criteria andMessageContentEqualTo(String value) {
            addCriterion("message_content =", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotEqualTo(String value) {
            addCriterion("message_content <>", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentGreaterThan(String value) {
            addCriterion("message_content >", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentGreaterThanOrEqualTo(String value) {
            addCriterion("message_content >=", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLessThan(String value) {
            addCriterion("message_content <", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLessThanOrEqualTo(String value) {
            addCriterion("message_content <=", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLike(String value) {
            addCriterion("message_content like", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotLike(String value) {
            addCriterion("message_content not like", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentIn(List<String> values) {
            addCriterion("message_content in", values, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotIn(List<String> values) {
            addCriterion("message_content not in", values, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentBetween(String value1, String value2) {
            addCriterion("message_content between", value1, value2, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotBetween(String value1, String value2) {
            addCriterion("message_content not between", value1, value2, "messageContent");
            return (Criteria) this;
        }

        public Criteria andFilesUrlIsNull() {
            addCriterion("files_url is null");
            return (Criteria) this;
        }

        public Criteria andFilesUrlIsNotNull() {
            addCriterion("files_url is not null");
            return (Criteria) this;
        }

        public Criteria andFilesUrlEqualTo(String value) {
            addCriterion("files_url =", value, "filesUrl");
            return (Criteria) this;
        }

        public Criteria andFilesUrlNotEqualTo(String value) {
            addCriterion("files_url <>", value, "filesUrl");
            return (Criteria) this;
        }

        public Criteria andFilesUrlGreaterThan(String value) {
            addCriterion("files_url >", value, "filesUrl");
            return (Criteria) this;
        }

        public Criteria andFilesUrlGreaterThanOrEqualTo(String value) {
            addCriterion("files_url >=", value, "filesUrl");
            return (Criteria) this;
        }

        public Criteria andFilesUrlLessThan(String value) {
            addCriterion("files_url <", value, "filesUrl");
            return (Criteria) this;
        }

        public Criteria andFilesUrlLessThanOrEqualTo(String value) {
            addCriterion("files_url <=", value, "filesUrl");
            return (Criteria) this;
        }

        public Criteria andFilesUrlLike(String value) {
            addCriterion("files_url like", value, "filesUrl");
            return (Criteria) this;
        }

        public Criteria andFilesUrlNotLike(String value) {
            addCriterion("files_url not like", value, "filesUrl");
            return (Criteria) this;
        }

        public Criteria andFilesUrlIn(List<String> values) {
            addCriterion("files_url in", values, "filesUrl");
            return (Criteria) this;
        }

        public Criteria andFilesUrlNotIn(List<String> values) {
            addCriterion("files_url not in", values, "filesUrl");
            return (Criteria) this;
        }

        public Criteria andFilesUrlBetween(String value1, String value2) {
            addCriterion("files_url between", value1, value2, "filesUrl");
            return (Criteria) this;
        }

        public Criteria andFilesUrlNotBetween(String value1, String value2) {
            addCriterion("files_url not between", value1, value2, "filesUrl");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdContains(String value) {
            addCriterion("delete_user like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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