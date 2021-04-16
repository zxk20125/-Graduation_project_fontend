package cn.zxk.pojo;

import java.util.ArrayList;
import java.util.List;

public class TDotExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDotExample() {
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

        public Criteria andDotIdIsNull() {
            addCriterion("dot_id is null");
            return (Criteria) this;
        }

        public Criteria andDotIdIsNotNull() {
            addCriterion("dot_id is not null");
            return (Criteria) this;
        }

        public Criteria andDotIdEqualTo(Integer value) {
            addCriterion("dot_id =", value, "dotId");
            return (Criteria) this;
        }

        public Criteria andDotIdNotEqualTo(Integer value) {
            addCriterion("dot_id <>", value, "dotId");
            return (Criteria) this;
        }

        public Criteria andDotIdGreaterThan(Integer value) {
            addCriterion("dot_id >", value, "dotId");
            return (Criteria) this;
        }

        public Criteria andDotIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dot_id >=", value, "dotId");
            return (Criteria) this;
        }

        public Criteria andDotIdLessThan(Integer value) {
            addCriterion("dot_id <", value, "dotId");
            return (Criteria) this;
        }

        public Criteria andDotIdLessThanOrEqualTo(Integer value) {
            addCriterion("dot_id <=", value, "dotId");
            return (Criteria) this;
        }

        public Criteria andDotIdIn(List<Integer> values) {
            addCriterion("dot_id in", values, "dotId");
            return (Criteria) this;
        }

        public Criteria andDotIdNotIn(List<Integer> values) {
            addCriterion("dot_id not in", values, "dotId");
            return (Criteria) this;
        }

        public Criteria andDotIdBetween(Integer value1, Integer value2) {
            addCriterion("dot_id between", value1, value2, "dotId");
            return (Criteria) this;
        }

        public Criteria andDotIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dot_id not between", value1, value2, "dotId");
            return (Criteria) this;
        }

        public Criteria andDotCityIsNull() {
            addCriterion("dot_city is null");
            return (Criteria) this;
        }

        public Criteria andDotCityIsNotNull() {
            addCriterion("dot_city is not null");
            return (Criteria) this;
        }

        public Criteria andDotCityEqualTo(String value) {
            addCriterion("dot_city =", value, "dotCity");
            return (Criteria) this;
        }

        public Criteria andDotCityNotEqualTo(String value) {
            addCriterion("dot_city <>", value, "dotCity");
            return (Criteria) this;
        }

        public Criteria andDotCityGreaterThan(String value) {
            addCriterion("dot_city >", value, "dotCity");
            return (Criteria) this;
        }

        public Criteria andDotCityGreaterThanOrEqualTo(String value) {
            addCriterion("dot_city >=", value, "dotCity");
            return (Criteria) this;
        }

        public Criteria andDotCityLessThan(String value) {
            addCriterion("dot_city <", value, "dotCity");
            return (Criteria) this;
        }

        public Criteria andDotCityLessThanOrEqualTo(String value) {
            addCriterion("dot_city <=", value, "dotCity");
            return (Criteria) this;
        }

        public Criteria andDotCityLike(String value) {
            addCriterion("dot_city like", value, "dotCity");
            return (Criteria) this;
        }

        public Criteria andDotCityNotLike(String value) {
            addCriterion("dot_city not like", value, "dotCity");
            return (Criteria) this;
        }

        public Criteria andDotCityIn(List<String> values) {
            addCriterion("dot_city in", values, "dotCity");
            return (Criteria) this;
        }

        public Criteria andDotCityNotIn(List<String> values) {
            addCriterion("dot_city not in", values, "dotCity");
            return (Criteria) this;
        }

        public Criteria andDotCityBetween(String value1, String value2) {
            addCriterion("dot_city between", value1, value2, "dotCity");
            return (Criteria) this;
        }

        public Criteria andDotCityNotBetween(String value1, String value2) {
            addCriterion("dot_city not between", value1, value2, "dotCity");
            return (Criteria) this;
        }

        public Criteria andDotAddressIsNull() {
            addCriterion("dot_address is null");
            return (Criteria) this;
        }

        public Criteria andDotAddressIsNotNull() {
            addCriterion("dot_address is not null");
            return (Criteria) this;
        }

        public Criteria andDotAddressEqualTo(String value) {
            addCriterion("dot_address =", value, "dotAddress");
            return (Criteria) this;
        }

        public Criteria andDotAddressNotEqualTo(String value) {
            addCriterion("dot_address <>", value, "dotAddress");
            return (Criteria) this;
        }

        public Criteria andDotAddressGreaterThan(String value) {
            addCriterion("dot_address >", value, "dotAddress");
            return (Criteria) this;
        }

        public Criteria andDotAddressGreaterThanOrEqualTo(String value) {
            addCriterion("dot_address >=", value, "dotAddress");
            return (Criteria) this;
        }

        public Criteria andDotAddressLessThan(String value) {
            addCriterion("dot_address <", value, "dotAddress");
            return (Criteria) this;
        }

        public Criteria andDotAddressLessThanOrEqualTo(String value) {
            addCriterion("dot_address <=", value, "dotAddress");
            return (Criteria) this;
        }

        public Criteria andDotAddressLike(String value) {
            addCriterion("dot_address like", value, "dotAddress");
            return (Criteria) this;
        }

        public Criteria andDotAddressNotLike(String value) {
            addCriterion("dot_address not like", value, "dotAddress");
            return (Criteria) this;
        }

        public Criteria andDotAddressIn(List<String> values) {
            addCriterion("dot_address in", values, "dotAddress");
            return (Criteria) this;
        }

        public Criteria andDotAddressNotIn(List<String> values) {
            addCriterion("dot_address not in", values, "dotAddress");
            return (Criteria) this;
        }

        public Criteria andDotAddressBetween(String value1, String value2) {
            addCriterion("dot_address between", value1, value2, "dotAddress");
            return (Criteria) this;
        }

        public Criteria andDotAddressNotBetween(String value1, String value2) {
            addCriterion("dot_address not between", value1, value2, "dotAddress");
            return (Criteria) this;
        }

        public Criteria andDotNameIsNull() {
            addCriterion("dot_name is null");
            return (Criteria) this;
        }

        public Criteria andDotNameIsNotNull() {
            addCriterion("dot_name is not null");
            return (Criteria) this;
        }

        public Criteria andDotNameEqualTo(String value) {
            addCriterion("dot_name =", value, "dotName");
            return (Criteria) this;
        }

        public Criteria andDotNameNotEqualTo(String value) {
            addCriterion("dot_name <>", value, "dotName");
            return (Criteria) this;
        }

        public Criteria andDotNameGreaterThan(String value) {
            addCriterion("dot_name >", value, "dotName");
            return (Criteria) this;
        }

        public Criteria andDotNameGreaterThanOrEqualTo(String value) {
            addCriterion("dot_name >=", value, "dotName");
            return (Criteria) this;
        }

        public Criteria andDotNameLessThan(String value) {
            addCriterion("dot_name <", value, "dotName");
            return (Criteria) this;
        }

        public Criteria andDotNameLessThanOrEqualTo(String value) {
            addCriterion("dot_name <=", value, "dotName");
            return (Criteria) this;
        }

        public Criteria andDotNameLike(String value) {
            addCriterion("dot_name like", value, "dotName");
            return (Criteria) this;
        }

        public Criteria andDotNameNotLike(String value) {
            addCriterion("dot_name not like", value, "dotName");
            return (Criteria) this;
        }

        public Criteria andDotNameIn(List<String> values) {
            addCriterion("dot_name in", values, "dotName");
            return (Criteria) this;
        }

        public Criteria andDotNameNotIn(List<String> values) {
            addCriterion("dot_name not in", values, "dotName");
            return (Criteria) this;
        }

        public Criteria andDotNameBetween(String value1, String value2) {
            addCriterion("dot_name between", value1, value2, "dotName");
            return (Criteria) this;
        }

        public Criteria andDotNameNotBetween(String value1, String value2) {
            addCriterion("dot_name not between", value1, value2, "dotName");
            return (Criteria) this;
        }

        public Criteria andDotPhoneIsNull() {
            addCriterion("dot_phone is null");
            return (Criteria) this;
        }

        public Criteria andDotPhoneIsNotNull() {
            addCriterion("dot_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDotPhoneEqualTo(String value) {
            addCriterion("dot_phone =", value, "dotPhone");
            return (Criteria) this;
        }

        public Criteria andDotPhoneNotEqualTo(String value) {
            addCriterion("dot_phone <>", value, "dotPhone");
            return (Criteria) this;
        }

        public Criteria andDotPhoneGreaterThan(String value) {
            addCriterion("dot_phone >", value, "dotPhone");
            return (Criteria) this;
        }

        public Criteria andDotPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("dot_phone >=", value, "dotPhone");
            return (Criteria) this;
        }

        public Criteria andDotPhoneLessThan(String value) {
            addCriterion("dot_phone <", value, "dotPhone");
            return (Criteria) this;
        }

        public Criteria andDotPhoneLessThanOrEqualTo(String value) {
            addCriterion("dot_phone <=", value, "dotPhone");
            return (Criteria) this;
        }

        public Criteria andDotPhoneLike(String value) {
            addCriterion("dot_phone like", value, "dotPhone");
            return (Criteria) this;
        }

        public Criteria andDotPhoneNotLike(String value) {
            addCriterion("dot_phone not like", value, "dotPhone");
            return (Criteria) this;
        }

        public Criteria andDotPhoneIn(List<String> values) {
            addCriterion("dot_phone in", values, "dotPhone");
            return (Criteria) this;
        }

        public Criteria andDotPhoneNotIn(List<String> values) {
            addCriterion("dot_phone not in", values, "dotPhone");
            return (Criteria) this;
        }

        public Criteria andDotPhoneBetween(String value1, String value2) {
            addCriterion("dot_phone between", value1, value2, "dotPhone");
            return (Criteria) this;
        }

        public Criteria andDotPhoneNotBetween(String value1, String value2) {
            addCriterion("dot_phone not between", value1, value2, "dotPhone");
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