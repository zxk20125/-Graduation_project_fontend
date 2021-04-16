package cn.zxk.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TShipAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TShipAddressExample() {
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

        public Criteria andShipAddressIdIsNull() {
            addCriterion("ship_address_id is null");
            return (Criteria) this;
        }

        public Criteria andShipAddressIdIsNotNull() {
            addCriterion("ship_address_id is not null");
            return (Criteria) this;
        }

        public Criteria andShipAddressIdEqualTo(Integer value) {
            addCriterion("ship_address_id =", value, "shipAddressId");
            return (Criteria) this;
        }

        public Criteria andShipAddressIdNotEqualTo(Integer value) {
            addCriterion("ship_address_id <>", value, "shipAddressId");
            return (Criteria) this;
        }

        public Criteria andShipAddressIdGreaterThan(Integer value) {
            addCriterion("ship_address_id >", value, "shipAddressId");
            return (Criteria) this;
        }

        public Criteria andShipAddressIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ship_address_id >=", value, "shipAddressId");
            return (Criteria) this;
        }

        public Criteria andShipAddressIdLessThan(Integer value) {
            addCriterion("ship_address_id <", value, "shipAddressId");
            return (Criteria) this;
        }

        public Criteria andShipAddressIdLessThanOrEqualTo(Integer value) {
            addCriterion("ship_address_id <=", value, "shipAddressId");
            return (Criteria) this;
        }

        public Criteria andShipAddressIdIn(List<Integer> values) {
            addCriterion("ship_address_id in", values, "shipAddressId");
            return (Criteria) this;
        }

        public Criteria andShipAddressIdNotIn(List<Integer> values) {
            addCriterion("ship_address_id not in", values, "shipAddressId");
            return (Criteria) this;
        }

        public Criteria andShipAddressIdBetween(Integer value1, Integer value2) {
            addCriterion("ship_address_id between", value1, value2, "shipAddressId");
            return (Criteria) this;
        }

        public Criteria andShipAddressIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ship_address_id not between", value1, value2, "shipAddressId");
            return (Criteria) this;
        }

        public Criteria andStartAddressIsNull() {
            addCriterion("start_address is null");
            return (Criteria) this;
        }

        public Criteria andStartAddressIsNotNull() {
            addCriterion("start_address is not null");
            return (Criteria) this;
        }

        public Criteria andStartAddressEqualTo(String value) {
            addCriterion("start_address =", value, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressNotEqualTo(String value) {
            addCriterion("start_address <>", value, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressGreaterThan(String value) {
            addCriterion("start_address >", value, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressGreaterThanOrEqualTo(String value) {
            addCriterion("start_address >=", value, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressLessThan(String value) {
            addCriterion("start_address <", value, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressLessThanOrEqualTo(String value) {
            addCriterion("start_address <=", value, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressLike(String value) {
            addCriterion("start_address like", value, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressNotLike(String value) {
            addCriterion("start_address not like", value, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressIn(List<String> values) {
            addCriterion("start_address in", values, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressNotIn(List<String> values) {
            addCriterion("start_address not in", values, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressBetween(String value1, String value2) {
            addCriterion("start_address between", value1, value2, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressNotBetween(String value1, String value2) {
            addCriterion("start_address not between", value1, value2, "startAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressIsNull() {
            addCriterion("end_address is null");
            return (Criteria) this;
        }

        public Criteria andEndAddressIsNotNull() {
            addCriterion("end_address is not null");
            return (Criteria) this;
        }

        public Criteria andEndAddressEqualTo(String value) {
            addCriterion("end_address =", value, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressNotEqualTo(String value) {
            addCriterion("end_address <>", value, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressGreaterThan(String value) {
            addCriterion("end_address >", value, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressGreaterThanOrEqualTo(String value) {
            addCriterion("end_address >=", value, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressLessThan(String value) {
            addCriterion("end_address <", value, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressLessThanOrEqualTo(String value) {
            addCriterion("end_address <=", value, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressLike(String value) {
            addCriterion("end_address like", value, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressNotLike(String value) {
            addCriterion("end_address not like", value, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressIn(List<String> values) {
            addCriterion("end_address in", values, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressNotIn(List<String> values) {
            addCriterion("end_address not in", values, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressBetween(String value1, String value2) {
            addCriterion("end_address between", value1, value2, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressNotBetween(String value1, String value2) {
            addCriterion("end_address not between", value1, value2, "endAddress");
            return (Criteria) this;
        }

        public Criteria andShipAddressMoneyIsNull() {
            addCriterion("ship_address_money is null");
            return (Criteria) this;
        }

        public Criteria andShipAddressMoneyIsNotNull() {
            addCriterion("ship_address_money is not null");
            return (Criteria) this;
        }

        public Criteria andShipAddressMoneyEqualTo(BigDecimal value) {
            addCriterion("ship_address_money =", value, "shipAddressMoney");
            return (Criteria) this;
        }

        public Criteria andShipAddressMoneyNotEqualTo(BigDecimal value) {
            addCriterion("ship_address_money <>", value, "shipAddressMoney");
            return (Criteria) this;
        }

        public Criteria andShipAddressMoneyGreaterThan(BigDecimal value) {
            addCriterion("ship_address_money >", value, "shipAddressMoney");
            return (Criteria) this;
        }

        public Criteria andShipAddressMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ship_address_money >=", value, "shipAddressMoney");
            return (Criteria) this;
        }

        public Criteria andShipAddressMoneyLessThan(BigDecimal value) {
            addCriterion("ship_address_money <", value, "shipAddressMoney");
            return (Criteria) this;
        }

        public Criteria andShipAddressMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ship_address_money <=", value, "shipAddressMoney");
            return (Criteria) this;
        }

        public Criteria andShipAddressMoneyIn(List<BigDecimal> values) {
            addCriterion("ship_address_money in", values, "shipAddressMoney");
            return (Criteria) this;
        }

        public Criteria andShipAddressMoneyNotIn(List<BigDecimal> values) {
            addCriterion("ship_address_money not in", values, "shipAddressMoney");
            return (Criteria) this;
        }

        public Criteria andShipAddressMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ship_address_money between", value1, value2, "shipAddressMoney");
            return (Criteria) this;
        }

        public Criteria andShipAddressMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ship_address_money not between", value1, value2, "shipAddressMoney");
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