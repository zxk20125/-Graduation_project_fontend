package cn.zxk.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TResWeightExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TResWeightExample() {
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

        public Criteria andResWeightIdIsNull() {
            addCriterion("res_weight_id is null");
            return (Criteria) this;
        }

        public Criteria andResWeightIdIsNotNull() {
            addCriterion("res_weight_id is not null");
            return (Criteria) this;
        }

        public Criteria andResWeightIdEqualTo(Integer value) {
            addCriterion("res_weight_id =", value, "resWeightId");
            return (Criteria) this;
        }

        public Criteria andResWeightIdNotEqualTo(Integer value) {
            addCriterion("res_weight_id <>", value, "resWeightId");
            return (Criteria) this;
        }

        public Criteria andResWeightIdGreaterThan(Integer value) {
            addCriterion("res_weight_id >", value, "resWeightId");
            return (Criteria) this;
        }

        public Criteria andResWeightIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("res_weight_id >=", value, "resWeightId");
            return (Criteria) this;
        }

        public Criteria andResWeightIdLessThan(Integer value) {
            addCriterion("res_weight_id <", value, "resWeightId");
            return (Criteria) this;
        }

        public Criteria andResWeightIdLessThanOrEqualTo(Integer value) {
            addCriterion("res_weight_id <=", value, "resWeightId");
            return (Criteria) this;
        }

        public Criteria andResWeightIdIn(List<Integer> values) {
            addCriterion("res_weight_id in", values, "resWeightId");
            return (Criteria) this;
        }

        public Criteria andResWeightIdNotIn(List<Integer> values) {
            addCriterion("res_weight_id not in", values, "resWeightId");
            return (Criteria) this;
        }

        public Criteria andResWeightIdBetween(Integer value1, Integer value2) {
            addCriterion("res_weight_id between", value1, value2, "resWeightId");
            return (Criteria) this;
        }

        public Criteria andResWeightIdNotBetween(Integer value1, Integer value2) {
            addCriterion("res_weight_id not between", value1, value2, "resWeightId");
            return (Criteria) this;
        }

        public Criteria andResWeightIsNull() {
            addCriterion("res_weight is null");
            return (Criteria) this;
        }

        public Criteria andResWeightIsNotNull() {
            addCriterion("res_weight is not null");
            return (Criteria) this;
        }

        public Criteria andResWeightEqualTo(Integer value) {
            addCriterion("res_weight =", value, "resWeight");
            return (Criteria) this;
        }

        public Criteria andResWeightNotEqualTo(Integer value) {
            addCriterion("res_weight <>", value, "resWeight");
            return (Criteria) this;
        }

        public Criteria andResWeightGreaterThan(Integer value) {
            addCriterion("res_weight >", value, "resWeight");
            return (Criteria) this;
        }

        public Criteria andResWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("res_weight >=", value, "resWeight");
            return (Criteria) this;
        }

        public Criteria andResWeightLessThan(Integer value) {
            addCriterion("res_weight <", value, "resWeight");
            return (Criteria) this;
        }

        public Criteria andResWeightLessThanOrEqualTo(Integer value) {
            addCriterion("res_weight <=", value, "resWeight");
            return (Criteria) this;
        }

        public Criteria andResWeightIn(List<Integer> values) {
            addCriterion("res_weight in", values, "resWeight");
            return (Criteria) this;
        }

        public Criteria andResWeightNotIn(List<Integer> values) {
            addCriterion("res_weight not in", values, "resWeight");
            return (Criteria) this;
        }

        public Criteria andResWeightBetween(Integer value1, Integer value2) {
            addCriterion("res_weight between", value1, value2, "resWeight");
            return (Criteria) this;
        }

        public Criteria andResWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("res_weight not between", value1, value2, "resWeight");
            return (Criteria) this;
        }

        public Criteria andResWeightMoneyIsNull() {
            addCriterion("res_weight_money is null");
            return (Criteria) this;
        }

        public Criteria andResWeightMoneyIsNotNull() {
            addCriterion("res_weight_money is not null");
            return (Criteria) this;
        }

        public Criteria andResWeightMoneyEqualTo(BigDecimal value) {
            addCriterion("res_weight_money =", value, "resWeightMoney");
            return (Criteria) this;
        }

        public Criteria andResWeightMoneyNotEqualTo(BigDecimal value) {
            addCriterion("res_weight_money <>", value, "resWeightMoney");
            return (Criteria) this;
        }

        public Criteria andResWeightMoneyGreaterThan(BigDecimal value) {
            addCriterion("res_weight_money >", value, "resWeightMoney");
            return (Criteria) this;
        }

        public Criteria andResWeightMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("res_weight_money >=", value, "resWeightMoney");
            return (Criteria) this;
        }

        public Criteria andResWeightMoneyLessThan(BigDecimal value) {
            addCriterion("res_weight_money <", value, "resWeightMoney");
            return (Criteria) this;
        }

        public Criteria andResWeightMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("res_weight_money <=", value, "resWeightMoney");
            return (Criteria) this;
        }

        public Criteria andResWeightMoneyIn(List<BigDecimal> values) {
            addCriterion("res_weight_money in", values, "resWeightMoney");
            return (Criteria) this;
        }

        public Criteria andResWeightMoneyNotIn(List<BigDecimal> values) {
            addCriterion("res_weight_money not in", values, "resWeightMoney");
            return (Criteria) this;
        }

        public Criteria andResWeightMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("res_weight_money between", value1, value2, "resWeightMoney");
            return (Criteria) this;
        }

        public Criteria andResWeightMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("res_weight_money not between", value1, value2, "resWeightMoney");
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