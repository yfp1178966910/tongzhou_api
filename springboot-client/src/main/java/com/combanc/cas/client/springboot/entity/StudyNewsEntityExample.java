package com.combanc.cas.client.springboot.entity;

import java.util.ArrayList;
import java.util.List;

public class StudyNewsEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
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

    public StudyNewsEntityExample() {
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

        public Criteria andNewsTitleIsNull() {
            addCriterion("news_title is null");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIsNotNull() {
            addCriterion("news_title is not null");
            return (Criteria) this;
        }

        public Criteria andNewsTitleEqualTo(String value) {
            addCriterion("news_title =", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotEqualTo(String value) {
            addCriterion("news_title <>", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleGreaterThan(String value) {
            addCriterion("news_title >", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleGreaterThanOrEqualTo(String value) {
            addCriterion("news_title >=", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLessThan(String value) {
            addCriterion("news_title <", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLessThanOrEqualTo(String value) {
            addCriterion("news_title <=", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLike(String value) {
            addCriterion("news_title like", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotLike(String value) {
            addCriterion("news_title not like", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIn(List<String> values) {
            addCriterion("news_title in", values, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotIn(List<String> values) {
            addCriterion("news_title not in", values, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleBetween(String value1, String value2) {
            addCriterion("news_title between", value1, value2, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotBetween(String value1, String value2) {
            addCriterion("news_title not between", value1, value2, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionIsNull() {
            addCriterion("brief_introduction is null");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionIsNotNull() {
            addCriterion("brief_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionEqualTo(String value) {
            addCriterion("brief_introduction =", value, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionNotEqualTo(String value) {
            addCriterion("brief_introduction <>", value, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionGreaterThan(String value) {
            addCriterion("brief_introduction >", value, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("brief_introduction >=", value, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionLessThan(String value) {
            addCriterion("brief_introduction <", value, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionLessThanOrEqualTo(String value) {
            addCriterion("brief_introduction <=", value, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionLike(String value) {
            addCriterion("brief_introduction like", value, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionNotLike(String value) {
            addCriterion("brief_introduction not like", value, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionIn(List<String> values) {
            addCriterion("brief_introduction in", values, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionNotIn(List<String> values) {
            addCriterion("brief_introduction not in", values, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionBetween(String value1, String value2) {
            addCriterion("brief_introduction between", value1, value2, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionNotBetween(String value1, String value2) {
            addCriterion("brief_introduction not between", value1, value2, "briefIntroduction");
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

        public Criteria andDisplayLocationIsNull() {
            addCriterion("display_location is null");
            return (Criteria) this;
        }

        public Criteria andDisplayLocationIsNotNull() {
            addCriterion("display_location is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayLocationEqualTo(String value) {
            addCriterion("display_location =", value, "displayLocation");
            return (Criteria) this;
        }

        public Criteria andDisplayLocationNotEqualTo(String value) {
            addCriterion("display_location <>", value, "displayLocation");
            return (Criteria) this;
        }

        public Criteria andDisplayLocationGreaterThan(String value) {
            addCriterion("display_location >", value, "displayLocation");
            return (Criteria) this;
        }

        public Criteria andDisplayLocationGreaterThanOrEqualTo(String value) {
            addCriterion("display_location >=", value, "displayLocation");
            return (Criteria) this;
        }

        public Criteria andDisplayLocationLessThan(String value) {
            addCriterion("display_location <", value, "displayLocation");
            return (Criteria) this;
        }

        public Criteria andDisplayLocationLessThanOrEqualTo(String value) {
            addCriterion("display_location <=", value, "displayLocation");
            return (Criteria) this;
        }

        public Criteria andDisplayLocationLike(String value) {
            addCriterion("display_location like", value, "displayLocation");
            return (Criteria) this;
        }

        public Criteria andDisplayLocationNotLike(String value) {
            addCriterion("display_location not like", value, "displayLocation");
            return (Criteria) this;
        }

        public Criteria andDisplayLocationIn(List<String> values) {
            addCriterion("display_location in", values, "displayLocation");
            return (Criteria) this;
        }

        public Criteria andDisplayLocationNotIn(List<String> values) {
            addCriterion("display_location not in", values, "displayLocation");
            return (Criteria) this;
        }

        public Criteria andDisplayLocationBetween(String value1, String value2) {
            addCriterion("display_location between", value1, value2, "displayLocation");
            return (Criteria) this;
        }

        public Criteria andDisplayLocationNotBetween(String value1, String value2) {
            addCriterion("display_location not between", value1, value2, "displayLocation");
            return (Criteria) this;
        }

        public Criteria andNewsWeightIsNull() {
            addCriterion("news_weight is null");
            return (Criteria) this;
        }

        public Criteria andNewsWeightIsNotNull() {
            addCriterion("news_weight is not null");
            return (Criteria) this;
        }

        public Criteria andNewsWeightEqualTo(Integer value) {
            addCriterion("news_weight =", value, "newsWeight");
            return (Criteria) this;
        }

        public Criteria andNewsWeightNotEqualTo(Integer value) {
            addCriterion("news_weight <>", value, "newsWeight");
            return (Criteria) this;
        }

        public Criteria andNewsWeightGreaterThan(Integer value) {
            addCriterion("news_weight >", value, "newsWeight");
            return (Criteria) this;
        }

        public Criteria andNewsWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("news_weight >=", value, "newsWeight");
            return (Criteria) this;
        }

        public Criteria andNewsWeightLessThan(Integer value) {
            addCriterion("news_weight <", value, "newsWeight");
            return (Criteria) this;
        }

        public Criteria andNewsWeightLessThanOrEqualTo(Integer value) {
            addCriterion("news_weight <=", value, "newsWeight");
            return (Criteria) this;
        }

        public Criteria andNewsWeightIn(List<Integer> values) {
            addCriterion("news_weight in", values, "newsWeight");
            return (Criteria) this;
        }

        public Criteria andNewsWeightNotIn(List<Integer> values) {
            addCriterion("news_weight not in", values, "newsWeight");
            return (Criteria) this;
        }

        public Criteria andNewsWeightBetween(Integer value1, Integer value2) {
            addCriterion("news_weight between", value1, value2, "newsWeight");
            return (Criteria) this;
        }

        public Criteria andNewsWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("news_weight not between", value1, value2, "newsWeight");
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