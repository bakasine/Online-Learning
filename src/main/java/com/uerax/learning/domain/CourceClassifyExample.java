package com.uerax.learning.domain;

import java.util.ArrayList;
import java.util.List;

public class CourceClassifyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourceClassifyExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCourceNameIsNull() {
            addCriterion("cource_name is null");
            return (Criteria) this;
        }

        public Criteria andCourceNameIsNotNull() {
            addCriterion("cource_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourceNameEqualTo(String value) {
            addCriterion("cource_name =", value, "courceName");
            return (Criteria) this;
        }

        public Criteria andCourceNameNotEqualTo(String value) {
            addCriterion("cource_name <>", value, "courceName");
            return (Criteria) this;
        }

        public Criteria andCourceNameGreaterThan(String value) {
            addCriterion("cource_name >", value, "courceName");
            return (Criteria) this;
        }

        public Criteria andCourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("cource_name >=", value, "courceName");
            return (Criteria) this;
        }

        public Criteria andCourceNameLessThan(String value) {
            addCriterion("cource_name <", value, "courceName");
            return (Criteria) this;
        }

        public Criteria andCourceNameLessThanOrEqualTo(String value) {
            addCriterion("cource_name <=", value, "courceName");
            return (Criteria) this;
        }

        public Criteria andCourceNameLike(String value) {
            addCriterion("cource_name like", value, "courceName");
            return (Criteria) this;
        }

        public Criteria andCourceNameNotLike(String value) {
            addCriterion("cource_name not like", value, "courceName");
            return (Criteria) this;
        }

        public Criteria andCourceNameIn(List<String> values) {
            addCriterion("cource_name in", values, "courceName");
            return (Criteria) this;
        }

        public Criteria andCourceNameNotIn(List<String> values) {
            addCriterion("cource_name not in", values, "courceName");
            return (Criteria) this;
        }

        public Criteria andCourceNameBetween(String value1, String value2) {
            addCriterion("cource_name between", value1, value2, "courceName");
            return (Criteria) this;
        }

        public Criteria andCourceNameNotBetween(String value1, String value2) {
            addCriterion("cource_name not between", value1, value2, "courceName");
            return (Criteria) this;
        }

        public Criteria andCourceCodeIsNull() {
            addCriterion("cource_code is null");
            return (Criteria) this;
        }

        public Criteria andCourceCodeIsNotNull() {
            addCriterion("cource_code is not null");
            return (Criteria) this;
        }

        public Criteria andCourceCodeEqualTo(String value) {
            addCriterion("cource_code =", value, "courceCode");
            return (Criteria) this;
        }

        public Criteria andCourceCodeNotEqualTo(String value) {
            addCriterion("cource_code <>", value, "courceCode");
            return (Criteria) this;
        }

        public Criteria andCourceCodeGreaterThan(String value) {
            addCriterion("cource_code >", value, "courceCode");
            return (Criteria) this;
        }

        public Criteria andCourceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("cource_code >=", value, "courceCode");
            return (Criteria) this;
        }

        public Criteria andCourceCodeLessThan(String value) {
            addCriterion("cource_code <", value, "courceCode");
            return (Criteria) this;
        }

        public Criteria andCourceCodeLessThanOrEqualTo(String value) {
            addCriterion("cource_code <=", value, "courceCode");
            return (Criteria) this;
        }

        public Criteria andCourceCodeLike(String value) {
            addCriterion("cource_code like", value, "courceCode");
            return (Criteria) this;
        }

        public Criteria andCourceCodeNotLike(String value) {
            addCriterion("cource_code not like", value, "courceCode");
            return (Criteria) this;
        }

        public Criteria andCourceCodeIn(List<String> values) {
            addCriterion("cource_code in", values, "courceCode");
            return (Criteria) this;
        }

        public Criteria andCourceCodeNotIn(List<String> values) {
            addCriterion("cource_code not in", values, "courceCode");
            return (Criteria) this;
        }

        public Criteria andCourceCodeBetween(String value1, String value2) {
            addCriterion("cource_code between", value1, value2, "courceCode");
            return (Criteria) this;
        }

        public Criteria andCourceCodeNotBetween(String value1, String value2) {
            addCriterion("cource_code not between", value1, value2, "courceCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeIsNull() {
            addCriterion("parent_code is null");
            return (Criteria) this;
        }

        public Criteria andParentCodeIsNotNull() {
            addCriterion("parent_code is not null");
            return (Criteria) this;
        }

        public Criteria andParentCodeEqualTo(String value) {
            addCriterion("parent_code =", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotEqualTo(String value) {
            addCriterion("parent_code <>", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeGreaterThan(String value) {
            addCriterion("parent_code >", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("parent_code >=", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLessThan(String value) {
            addCriterion("parent_code <", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLessThanOrEqualTo(String value) {
            addCriterion("parent_code <=", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLike(String value) {
            addCriterion("parent_code like", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotLike(String value) {
            addCriterion("parent_code not like", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeIn(List<String> values) {
            addCriterion("parent_code in", values, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotIn(List<String> values) {
            addCriterion("parent_code not in", values, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeBetween(String value1, String value2) {
            addCriterion("parent_code between", value1, value2, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotBetween(String value1, String value2) {
            addCriterion("parent_code not between", value1, value2, "parentCode");
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