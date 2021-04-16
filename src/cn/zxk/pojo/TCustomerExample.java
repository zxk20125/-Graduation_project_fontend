package cn.zxk.pojo;

import java.util.ArrayList;
import java.util.List;

public class TCustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCustomerExample() {
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

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerLoginNameIsNull() {
            addCriterion("customer_login_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerLoginNameIsNotNull() {
            addCriterion("customer_login_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerLoginNameEqualTo(String value) {
            addCriterion("customer_login_name =", value, "customerLoginName");
            return (Criteria) this;
        }

        public Criteria andCustomerLoginNameNotEqualTo(String value) {
            addCriterion("customer_login_name <>", value, "customerLoginName");
            return (Criteria) this;
        }

        public Criteria andCustomerLoginNameGreaterThan(String value) {
            addCriterion("customer_login_name >", value, "customerLoginName");
            return (Criteria) this;
        }

        public Criteria andCustomerLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_login_name >=", value, "customerLoginName");
            return (Criteria) this;
        }

        public Criteria andCustomerLoginNameLessThan(String value) {
            addCriterion("customer_login_name <", value, "customerLoginName");
            return (Criteria) this;
        }

        public Criteria andCustomerLoginNameLessThanOrEqualTo(String value) {
            addCriterion("customer_login_name <=", value, "customerLoginName");
            return (Criteria) this;
        }

        public Criteria andCustomerLoginNameLike(String value) {
            addCriterion("customer_login_name like", value, "customerLoginName");
            return (Criteria) this;
        }

        public Criteria andCustomerLoginNameNotLike(String value) {
            addCriterion("customer_login_name not like", value, "customerLoginName");
            return (Criteria) this;
        }

        public Criteria andCustomerLoginNameIn(List<String> values) {
            addCriterion("customer_login_name in", values, "customerLoginName");
            return (Criteria) this;
        }

        public Criteria andCustomerLoginNameNotIn(List<String> values) {
            addCriterion("customer_login_name not in", values, "customerLoginName");
            return (Criteria) this;
        }

        public Criteria andCustomerLoginNameBetween(String value1, String value2) {
            addCriterion("customer_login_name between", value1, value2, "customerLoginName");
            return (Criteria) this;
        }

        public Criteria andCustomerLoginNameNotBetween(String value1, String value2) {
            addCriterion("customer_login_name not between", value1, value2, "customerLoginName");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordIsNull() {
            addCriterion("customer_password is null");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordIsNotNull() {
            addCriterion("customer_password is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordEqualTo(String value) {
            addCriterion("customer_password =", value, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordNotEqualTo(String value) {
            addCriterion("customer_password <>", value, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordGreaterThan(String value) {
            addCriterion("customer_password >", value, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("customer_password >=", value, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordLessThan(String value) {
            addCriterion("customer_password <", value, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordLessThanOrEqualTo(String value) {
            addCriterion("customer_password <=", value, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordLike(String value) {
            addCriterion("customer_password like", value, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordNotLike(String value) {
            addCriterion("customer_password not like", value, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordIn(List<String> values) {
            addCriterion("customer_password in", values, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordNotIn(List<String> values) {
            addCriterion("customer_password not in", values, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordBetween(String value1, String value2) {
            addCriterion("customer_password between", value1, value2, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordNotBetween(String value1, String value2) {
            addCriterion("customer_password not between", value1, value2, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeIsNull() {
            addCriterion("customer_age is null");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeIsNotNull() {
            addCriterion("customer_age is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeEqualTo(Integer value) {
            addCriterion("customer_age =", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeNotEqualTo(Integer value) {
            addCriterion("customer_age <>", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeGreaterThan(Integer value) {
            addCriterion("customer_age >", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_age >=", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeLessThan(Integer value) {
            addCriterion("customer_age <", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeLessThanOrEqualTo(Integer value) {
            addCriterion("customer_age <=", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeIn(List<Integer> values) {
            addCriterion("customer_age in", values, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeNotIn(List<Integer> values) {
            addCriterion("customer_age not in", values, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeBetween(Integer value1, Integer value2) {
            addCriterion("customer_age between", value1, value2, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_age not between", value1, value2, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerSexIsNull() {
            addCriterion("customer_sex is null");
            return (Criteria) this;
        }

        public Criteria andCustomerSexIsNotNull() {
            addCriterion("customer_sex is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerSexEqualTo(String value) {
            addCriterion("customer_sex =", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexNotEqualTo(String value) {
            addCriterion("customer_sex <>", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexGreaterThan(String value) {
            addCriterion("customer_sex >", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexGreaterThanOrEqualTo(String value) {
            addCriterion("customer_sex >=", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexLessThan(String value) {
            addCriterion("customer_sex <", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexLessThanOrEqualTo(String value) {
            addCriterion("customer_sex <=", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexLike(String value) {
            addCriterion("customer_sex like", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexNotLike(String value) {
            addCriterion("customer_sex not like", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexIn(List<String> values) {
            addCriterion("customer_sex in", values, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexNotIn(List<String> values) {
            addCriterion("customer_sex not in", values, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexBetween(String value1, String value2) {
            addCriterion("customer_sex between", value1, value2, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexNotBetween(String value1, String value2) {
            addCriterion("customer_sex not between", value1, value2, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneIsNull() {
            addCriterion("customer_phone is null");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneIsNotNull() {
            addCriterion("customer_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneEqualTo(String value) {
            addCriterion("customer_phone =", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotEqualTo(String value) {
            addCriterion("customer_phone <>", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneGreaterThan(String value) {
            addCriterion("customer_phone >", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("customer_phone >=", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLessThan(String value) {
            addCriterion("customer_phone <", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLessThanOrEqualTo(String value) {
            addCriterion("customer_phone <=", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLike(String value) {
            addCriterion("customer_phone like", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotLike(String value) {
            addCriterion("customer_phone not like", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneIn(List<String> values) {
            addCriterion("customer_phone in", values, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotIn(List<String> values) {
            addCriterion("customer_phone not in", values, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneBetween(String value1, String value2) {
            addCriterion("customer_phone between", value1, value2, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotBetween(String value1, String value2) {
            addCriterion("customer_phone not between", value1, value2, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andIdCardNoIsNull() {
            addCriterion("id_card_no is null");
            return (Criteria) this;
        }

        public Criteria andIdCardNoIsNotNull() {
            addCriterion("id_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardNoEqualTo(String value) {
            addCriterion("id_card_no =", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotEqualTo(String value) {
            addCriterion("id_card_no <>", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoGreaterThan(String value) {
            addCriterion("id_card_no >", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_no >=", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLessThan(String value) {
            addCriterion("id_card_no <", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLessThanOrEqualTo(String value) {
            addCriterion("id_card_no <=", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLike(String value) {
            addCriterion("id_card_no like", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotLike(String value) {
            addCriterion("id_card_no not like", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoIn(List<String> values) {
            addCriterion("id_card_no in", values, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotIn(List<String> values) {
            addCriterion("id_card_no not in", values, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoBetween(String value1, String value2) {
            addCriterion("id_card_no between", value1, value2, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotBetween(String value1, String value2) {
            addCriterion("id_card_no not between", value1, value2, "idCardNo");
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