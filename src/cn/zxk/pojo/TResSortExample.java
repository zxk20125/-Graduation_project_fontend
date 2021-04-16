package cn.zxk.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TResSortExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TResSortExample() {
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

        public Criteria andResSortIdIsNull() {
            addCriterion("res_sort_id is null");
            return (Criteria) this;
        }

        public Criteria andResSortIdIsNotNull() {
            addCriterion("res_sort_id is not null");
            return (Criteria) this;
        }

        public Criteria andResSortIdEqualTo(Integer value) {
            addCriterion("res_sort_id =", value, "resSortId");
            return (Criteria) this;
        }

        public Criteria andResSortIdNotEqualTo(Integer value) {
            addCriterion("res_sort_id <>", value, "resSortId");
            return (Criteria) this;
        }

        public Criteria andResSortIdGreaterThan(Integer value) {
            addCriterion("res_sort_id >", value, "resSortId");
            return (Criteria) this;
        }

        public Criteria andResSortIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("res_sort_id >=", value, "resSortId");
            return (Criteria) this;
        }

        public Criteria andResSortIdLessThan(Integer value) {
            addCriterion("res_sort_id <", value, "resSortId");
            return (Criteria) this;
        }

        public Criteria andResSortIdLessThanOrEqualTo(Integer value) {
            addCriterion("res_sort_id <=", value, "resSortId");
            return (Criteria) this;
        }

        public Criteria andResSortIdIn(List<Integer> values) {
            addCriterion("res_sort_id in", values, "resSortId");
            return (Criteria) this;
        }

        public Criteria andResSortIdNotIn(List<Integer> values) {
            addCriterion("res_sort_id not in", values, "resSortId");
            return (Criteria) this;
        }

        public Criteria andResSortIdBetween(Integer value1, Integer value2) {
            addCriterion("res_sort_id between", value1, value2, "resSortId");
            return (Criteria) this;
        }

        public Criteria andResSortIdNotBetween(Integer value1, Integer value2) {
            addCriterion("res_sort_id not between", value1, value2, "resSortId");
            return (Criteria) this;
        }

        public Criteria andResSortIsNull() {
            addCriterion("res_sort is null");
            return (Criteria) this;
        }

        public Criteria andResSortIsNotNull() {
            addCriterion("res_sort is not null");
            return (Criteria) this;
        }

        public Criteria andResSortEqualTo(String value) {
            addCriterion("res_sort =", value, "resSort");
            return (Criteria) this;
        }

        public Criteria andResSortNotEqualTo(String value) {
            addCriterion("res_sort <>", value, "resSort");
            return (Criteria) this;
        }

        public Criteria andResSortGreaterThan(String value) {
            addCriterion("res_sort >", value, "resSort");
            return (Criteria) this;
        }

        public Criteria andResSortGreaterThanOrEqualTo(String value) {
            addCriterion("res_sort >=", value, "resSort");
            return (Criteria) this;
        }

        public Criteria andResSortLessThan(String value) {
            addCriterion("res_sort <", value, "resSort");
            return (Criteria) this;
        }

        public Criteria andResSortLessThanOrEqualTo(String value) {
            addCriterion("res_sort <=", value, "resSort");
            return (Criteria) this;
        }

        public Criteria andResSortLike(String value) {
            addCriterion("res_sort like", value, "resSort");
            return (Criteria) this;
        }

        public Criteria andResSortNotLike(String value) {
            addCriterion("res_sort not like", value, "resSort");
            return (Criteria) this;
        }

        public Criteria andResSortIn(List<String> values) {
            addCriterion("res_sort in", values, "resSort");
            return (Criteria) this;
        }

        public Criteria andResSortNotIn(List<String> values) {
            addCriterion("res_sort not in", values, "resSort");
            return (Criteria) this;
        }

        public Criteria andResSortBetween(String value1, String value2) {
            addCriterion("res_sort between", value1, value2, "resSort");
            return (Criteria) this;
        }

        public Criteria andResSortNotBetween(String value1, String value2) {
            addCriterion("res_sort not between", value1, value2, "resSort");
            return (Criteria) this;
        }

        public Criteria andResSortMoneyIsNull() {
            addCriterion("res_sort_money is null");
            return (Criteria) this;
        }

        public Criteria andResSortMoneyIsNotNull() {
            addCriterion("res_sort_money is not null");
            return (Criteria) this;
        }

        public Criteria andResSortMoneyEqualTo(BigDecimal value) {
            addCriterion("res_sort_money =", value, "resSortMoney");
            return (Criteria) this;
        }

        public Criteria andResSortMoneyNotEqualTo(BigDecimal value) {
            addCriterion("res_sort_money <>", value, "resSortMoney");
            return (Criteria) this;
        }

        public Criteria andResSortMoneyGreaterThan(BigDecimal value) {
            addCriterion("res_sort_money >", value, "resSortMoney");
            return (Criteria) this;
        }

        public Criteria andResSortMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("res_sort_money >=", value, "resSortMoney");
            return (Criteria) this;
        }

        public Criteria andResSortMoneyLessThan(BigDecimal value) {
            addCriterion("res_sort_money <", value, "resSortMoney");
            return (Criteria) this;
        }

        public Criteria andResSortMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("res_sort_money <=", value, "resSortMoney");
            return (Criteria) this;
        }

        public Criteria andResSortMoneyIn(List<BigDecimal> values) {
            addCriterion("res_sort_money in", values, "resSortMoney");
            return (Criteria) this;
        }

        public Criteria andResSortMoneyNotIn(List<BigDecimal> values) {
            addCriterion("res_sort_money not in", values, "resSortMoney");
            return (Criteria) this;
        }

        public Criteria andResSortMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("res_sort_money between", value1, value2, "resSortMoney");
            return (Criteria) this;
        }

        public Criteria andResSortMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("res_sort_money not between", value1, value2, "resSortMoney");
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