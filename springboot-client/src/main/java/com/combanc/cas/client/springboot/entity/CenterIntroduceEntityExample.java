package com.combanc.cas.client.springboot.entity;

import java.util.ArrayList;
import java.util.List;

public class CenterIntroduceEntityExample {
    protected String orderByClause;

    protected boolean distinct;
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
    protected List<Criteria> oredCriteria;

    public CenterIntroduceEntityExample() {
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

        public Criteria andIntroduceTitleIsNull() {
            addCriterion("introduce_title is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceTitleIsNotNull() {
            addCriterion("introduce_title is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceTitleEqualTo(String value) {
            addCriterion("introduce_title =", value, "introduceTitle");
            return (Criteria) this;
        }

        public Criteria andIntroduceTitleNotEqualTo(String value) {
            addCriterion("introduce_title <>", value, "introduceTitle");
            return (Criteria) this;
        }

        public Criteria andIntroduceTitleGreaterThan(String value) {
            addCriterion("introduce_title >", value, "introduceTitle");
            return (Criteria) this;
        }

        public Criteria andIntroduceTitleGreaterThanOrEqualTo(String value) {
            addCriterion("introduce_title >=", value, "introduceTitle");
            return (Criteria) this;
        }

        public Criteria andIntroduceTitleLessThan(String value) {
            addCriterion("introduce_title <", value, "introduceTitle");
            return (Criteria) this;
        }

        public Criteria andIntroduceTitleLessThanOrEqualTo(String value) {
            addCriterion("introduce_title <=", value, "introduceTitle");
            return (Criteria) this;
        }

        public Criteria andIntroduceTitleLike(String value) {
            addCriterion("introduce_title like", value, "introduceTitle");
            return (Criteria) this;
        }

        public Criteria andIntroduceTitleNotLike(String value) {
            addCriterion("introduce_title not like", value, "introduceTitle");
            return (Criteria) this;
        }

        public Criteria andIntroduceTitleIn(List<String> values) {
            addCriterion("introduce_title in", values, "introduceTitle");
            return (Criteria) this;
        }

        public Criteria andIntroduceTitleNotIn(List<String> values) {
            addCriterion("introduce_title not in", values, "introduceTitle");
            return (Criteria) this;
        }

        public Criteria andIntroduceTitleBetween(String value1, String value2) {
            addCriterion("introduce_title between", value1, value2, "introduceTitle");
            return (Criteria) this;
        }

        public Criteria andIntroduceTitleNotBetween(String value1, String value2) {
            addCriterion("introduce_title not between", value1, value2, "introduceTitle");
            return (Criteria) this;
        }

        public Criteria andIntroduceBriefIsNull() {
            addCriterion("introduce_brief is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceBriefIsNotNull() {
            addCriterion("introduce_brief is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceBriefEqualTo(String value) {
            addCriterion("introduce_brief =", value, "introduceBrief");
            return (Criteria) this;
        }

        public Criteria andIntroduceBriefNotEqualTo(String value) {
            addCriterion("introduce_brief <>", value, "introduceBrief");
            return (Criteria) this;
        }

        public Criteria andIntroduceBriefGreaterThan(String value) {
            addCriterion("introduce_brief >", value, "introduceBrief");
            return (Criteria) this;
        }

        public Criteria andIntroduceBriefGreaterThanOrEqualTo(String value) {
            addCriterion("introduce_brief >=", value, "introduceBrief");
            return (Criteria) this;
        }

        public Criteria andIntroduceBriefLessThan(String value) {
            addCriterion("introduce_brief <", value, "introduceBrief");
            return (Criteria) this;
        }

        public Criteria andIntroduceBriefLessThanOrEqualTo(String value) {
            addCriterion("introduce_brief <=", value, "introduceBrief");
            return (Criteria) this;
        }

        public Criteria andIntroduceBriefLike(String value) {
            addCriterion("introduce_brief like", value, "introduceBrief");
            return (Criteria) this;
        }

        public Criteria andIntroduceBriefNotLike(String value) {
            addCriterion("introduce_brief not like", value, "introduceBrief");
            return (Criteria) this;
        }

        public Criteria andIntroduceBriefIn(List<String> values) {
            addCriterion("introduce_brief in", values, "introduceBrief");
            return (Criteria) this;
        }

        public Criteria andIntroduceBriefNotIn(List<String> values) {
            addCriterion("introduce_brief not in", values, "introduceBrief");
            return (Criteria) this;
        }

        public Criteria andIntroduceBriefBetween(String value1, String value2) {
            addCriterion("introduce_brief between", value1, value2, "introduceBrief");
            return (Criteria) this;
        }

        public Criteria andIntroduceBriefNotBetween(String value1, String value2) {
            addCriterion("introduce_brief not between", value1, value2, "introduceBrief");
            return (Criteria) this;
        }

        public Criteria andBackPicIsNull() {
            addCriterion("back_pic is null");
            return (Criteria) this;
        }

        public Criteria andBackPicIsNotNull() {
            addCriterion("back_pic is not null");
            return (Criteria) this;
        }

        public Criteria andBackPicEqualTo(String value) {
            addCriterion("back_pic =", value, "backPic");
            return (Criteria) this;
        }

        public Criteria andBackPicNotEqualTo(String value) {
            addCriterion("back_pic <>", value, "backPic");
            return (Criteria) this;
        }

        public Criteria andBackPicGreaterThan(String value) {
            addCriterion("back_pic >", value, "backPic");
            return (Criteria) this;
        }

        public Criteria andBackPicGreaterThanOrEqualTo(String value) {
            addCriterion("back_pic >=", value, "backPic");
            return (Criteria) this;
        }

        public Criteria andBackPicLessThan(String value) {
            addCriterion("back_pic <", value, "backPic");
            return (Criteria) this;
        }

        public Criteria andBackPicLessThanOrEqualTo(String value) {
            addCriterion("back_pic <=", value, "backPic");
            return (Criteria) this;
        }

        public Criteria andBackPicLike(String value) {
            addCriterion("back_pic like", value, "backPic");
            return (Criteria) this;
        }

        public Criteria andBackPicNotLike(String value) {
            addCriterion("back_pic not like", value, "backPic");
            return (Criteria) this;
        }

        public Criteria andBackPicIn(List<String> values) {
            addCriterion("back_pic in", values, "backPic");
            return (Criteria) this;
        }

        public Criteria andBackPicNotIn(List<String> values) {
            addCriterion("back_pic not in", values, "backPic");
            return (Criteria) this;
        }

        public Criteria andBackPicBetween(String value1, String value2) {
            addCriterion("back_pic between", value1, value2, "backPic");
            return (Criteria) this;
        }

        public Criteria andBackPicNotBetween(String value1, String value2) {
            addCriterion("back_pic not between", value1, value2, "backPic");
            return (Criteria) this;
        }

        public Criteria andIntroduceTypeIsNull() {
            addCriterion("introduce_type is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceTypeIsNotNull() {
            addCriterion("introduce_type is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceTypeEqualTo(String value) {
            addCriterion("introduce_type =", value, "introduceType");
            return (Criteria) this;
        }

        public Criteria andIntroduceTypeNotEqualTo(String value) {
            addCriterion("introduce_type <>", value, "introduceType");
            return (Criteria) this;
        }

        public Criteria andIntroduceTypeGreaterThan(String value) {
            addCriterion("introduce_type >", value, "introduceType");
            return (Criteria) this;
        }

        public Criteria andIntroduceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("introduce_type >=", value, "introduceType");
            return (Criteria) this;
        }

        public Criteria andIntroduceTypeLessThan(String value) {
            addCriterion("introduce_type <", value, "introduceType");
            return (Criteria) this;
        }

        public Criteria andIntroduceTypeLessThanOrEqualTo(String value) {
            addCriterion("introduce_type <=", value, "introduceType");
            return (Criteria) this;
        }

        public Criteria andIntroduceTypeLike(String value) {
            addCriterion("introduce_type like", value, "introduceType");
            return (Criteria) this;
        }

        public Criteria andIntroduceTypeNotLike(String value) {
            addCriterion("introduce_type not like", value, "introduceType");
            return (Criteria) this;
        }

        public Criteria andIntroduceTypeIn(List<String> values) {
            addCriterion("introduce_type in", values, "introduceType");
            return (Criteria) this;
        }

        public Criteria andIntroduceTypeNotIn(List<String> values) {
            addCriterion("introduce_type not in", values, "introduceType");
            return (Criteria) this;
        }

        public Criteria andIntroduceTypeBetween(String value1, String value2) {
            addCriterion("introduce_type between", value1, value2, "introduceType");
            return (Criteria) this;
        }

        public Criteria andIntroduceTypeNotBetween(String value1, String value2) {
            addCriterion("introduce_type not between", value1, value2, "introduceType");
            return (Criteria) this;
        }

        public Criteria andIntroduceWeightIsNull() {
            addCriterion("introduce_weight is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceWeightIsNotNull() {
            addCriterion("introduce_weight is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceWeightEqualTo(Integer value) {
            addCriterion("introduce_weight =", value, "introduceWeight");
            return (Criteria) this;
        }

        public Criteria andIntroduceWeightNotEqualTo(Integer value) {
            addCriterion("introduce_weight <>", value, "introduceWeight");
            return (Criteria) this;
        }

        public Criteria andIntroduceWeightGreaterThan(Integer value) {
            addCriterion("introduce_weight >", value, "introduceWeight");
            return (Criteria) this;
        }

        public Criteria andIntroduceWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("introduce_weight >=", value, "introduceWeight");
            return (Criteria) this;
        }

        public Criteria andIntroduceWeightLessThan(Integer value) {
            addCriterion("introduce_weight <", value, "introduceWeight");
            return (Criteria) this;
        }

        public Criteria andIntroduceWeightLessThanOrEqualTo(Integer value) {
            addCriterion("introduce_weight <=", value, "introduceWeight");
            return (Criteria) this;
        }

        public Criteria andIntroduceWeightIn(List<Integer> values) {
            addCriterion("introduce_weight in", values, "introduceWeight");
            return (Criteria) this;
        }

        public Criteria andIntroduceWeightNotIn(List<Integer> values) {
            addCriterion("introduce_weight not in", values, "introduceWeight");
            return (Criteria) this;
        }

        public Criteria andIntroduceWeightBetween(Integer value1, Integer value2) {
            addCriterion("introduce_weight between", value1, value2, "introduceWeight");
            return (Criteria) this;
        }

        public Criteria andIntroduceWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("introduce_weight not between", value1, value2, "introduceWeight");
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