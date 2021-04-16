package cn.zxk.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TStaffExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TStaffExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andStaffIdIsNull() {
            addCriterion("staff_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(Integer value) {
            addCriterion("staff_id =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(Integer value) {
            addCriterion("staff_id <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(Integer value) {
            addCriterion("staff_id >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("staff_id >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(Integer value) {
            addCriterion("staff_id <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(Integer value) {
            addCriterion("staff_id <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<Integer> values) {
            addCriterion("staff_id in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<Integer> values) {
            addCriterion("staff_id not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(Integer value1, Integer value2) {
            addCriterion("staff_id between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(Integer value1, Integer value2) {
            addCriterion("staff_id not between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNull() {
            addCriterion("staff_name is null");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNotNull() {
            addCriterion("staff_name is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNameEqualTo(String value) {
            addCriterion("staff_name =", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotEqualTo(String value) {
            addCriterion("staff_name <>", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThan(String value) {
            addCriterion("staff_name >", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("staff_name >=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThan(String value) {
            addCriterion("staff_name <", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThanOrEqualTo(String value) {
            addCriterion("staff_name <=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLike(String value) {
            addCriterion("staff_name like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotLike(String value) {
            addCriterion("staff_name not like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameIn(List<String> values) {
            addCriterion("staff_name in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotIn(List<String> values) {
            addCriterion("staff_name not in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameBetween(String value1, String value2) {
            addCriterion("staff_name between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotBetween(String value1, String value2) {
            addCriterion("staff_name not between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffLoginNameIsNull() {
            addCriterion("staff_login_name is null");
            return (Criteria) this;
        }

        public Criteria andStaffLoginNameIsNotNull() {
            addCriterion("staff_login_name is not null");
            return (Criteria) this;
        }

        public Criteria andStaffLoginNameEqualTo(String value) {
            addCriterion("staff_login_name =", value, "staffLoginName");
            return (Criteria) this;
        }

        public Criteria andStaffLoginNameNotEqualTo(String value) {
            addCriterion("staff_login_name <>", value, "staffLoginName");
            return (Criteria) this;
        }

        public Criteria andStaffLoginNameGreaterThan(String value) {
            addCriterion("staff_login_name >", value, "staffLoginName");
            return (Criteria) this;
        }

        public Criteria andStaffLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("staff_login_name >=", value, "staffLoginName");
            return (Criteria) this;
        }

        public Criteria andStaffLoginNameLessThan(String value) {
            addCriterion("staff_login_name <", value, "staffLoginName");
            return (Criteria) this;
        }

        public Criteria andStaffLoginNameLessThanOrEqualTo(String value) {
            addCriterion("staff_login_name <=", value, "staffLoginName");
            return (Criteria) this;
        }

        public Criteria andStaffLoginNameLike(String value) {
            addCriterion("staff_login_name like", value, "staffLoginName");
            return (Criteria) this;
        }

        public Criteria andStaffLoginNameNotLike(String value) {
            addCriterion("staff_login_name not like", value, "staffLoginName");
            return (Criteria) this;
        }

        public Criteria andStaffLoginNameIn(List<String> values) {
            addCriterion("staff_login_name in", values, "staffLoginName");
            return (Criteria) this;
        }

        public Criteria andStaffLoginNameNotIn(List<String> values) {
            addCriterion("staff_login_name not in", values, "staffLoginName");
            return (Criteria) this;
        }

        public Criteria andStaffLoginNameBetween(String value1, String value2) {
            addCriterion("staff_login_name between", value1, value2, "staffLoginName");
            return (Criteria) this;
        }

        public Criteria andStaffLoginNameNotBetween(String value1, String value2) {
            addCriterion("staff_login_name not between", value1, value2, "staffLoginName");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordIsNull() {
            addCriterion("staff_password is null");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordIsNotNull() {
            addCriterion("staff_password is not null");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordEqualTo(String value) {
            addCriterion("staff_password =", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordNotEqualTo(String value) {
            addCriterion("staff_password <>", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordGreaterThan(String value) {
            addCriterion("staff_password >", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("staff_password >=", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordLessThan(String value) {
            addCriterion("staff_password <", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordLessThanOrEqualTo(String value) {
            addCriterion("staff_password <=", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordLike(String value) {
            addCriterion("staff_password like", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordNotLike(String value) {
            addCriterion("staff_password not like", value, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordIn(List<String> values) {
            addCriterion("staff_password in", values, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordNotIn(List<String> values) {
            addCriterion("staff_password not in", values, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordBetween(String value1, String value2) {
            addCriterion("staff_password between", value1, value2, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffPasswordNotBetween(String value1, String value2) {
            addCriterion("staff_password not between", value1, value2, "staffPassword");
            return (Criteria) this;
        }

        public Criteria andStaffAgeIsNull() {
            addCriterion("staff_age is null");
            return (Criteria) this;
        }

        public Criteria andStaffAgeIsNotNull() {
            addCriterion("staff_age is not null");
            return (Criteria) this;
        }

        public Criteria andStaffAgeEqualTo(Integer value) {
            addCriterion("staff_age =", value, "staffAge");
            return (Criteria) this;
        }

        public Criteria andStaffAgeNotEqualTo(Integer value) {
            addCriterion("staff_age <>", value, "staffAge");
            return (Criteria) this;
        }

        public Criteria andStaffAgeGreaterThan(Integer value) {
            addCriterion("staff_age >", value, "staffAge");
            return (Criteria) this;
        }

        public Criteria andStaffAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("staff_age >=", value, "staffAge");
            return (Criteria) this;
        }

        public Criteria andStaffAgeLessThan(Integer value) {
            addCriterion("staff_age <", value, "staffAge");
            return (Criteria) this;
        }

        public Criteria andStaffAgeLessThanOrEqualTo(Integer value) {
            addCriterion("staff_age <=", value, "staffAge");
            return (Criteria) this;
        }

        public Criteria andStaffAgeIn(List<Integer> values) {
            addCriterion("staff_age in", values, "staffAge");
            return (Criteria) this;
        }

        public Criteria andStaffAgeNotIn(List<Integer> values) {
            addCriterion("staff_age not in", values, "staffAge");
            return (Criteria) this;
        }

        public Criteria andStaffAgeBetween(Integer value1, Integer value2) {
            addCriterion("staff_age between", value1, value2, "staffAge");
            return (Criteria) this;
        }

        public Criteria andStaffAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("staff_age not between", value1, value2, "staffAge");
            return (Criteria) this;
        }

        public Criteria andStaffSexIsNull() {
            addCriterion("staff_sex is null");
            return (Criteria) this;
        }

        public Criteria andStaffSexIsNotNull() {
            addCriterion("staff_sex is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSexEqualTo(String value) {
            addCriterion("staff_sex =", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotEqualTo(String value) {
            addCriterion("staff_sex <>", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexGreaterThan(String value) {
            addCriterion("staff_sex >", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexGreaterThanOrEqualTo(String value) {
            addCriterion("staff_sex >=", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexLessThan(String value) {
            addCriterion("staff_sex <", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexLessThanOrEqualTo(String value) {
            addCriterion("staff_sex <=", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexLike(String value) {
            addCriterion("staff_sex like", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotLike(String value) {
            addCriterion("staff_sex not like", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexIn(List<String> values) {
            addCriterion("staff_sex in", values, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotIn(List<String> values) {
            addCriterion("staff_sex not in", values, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexBetween(String value1, String value2) {
            addCriterion("staff_sex between", value1, value2, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotBetween(String value1, String value2) {
            addCriterion("staff_sex not between", value1, value2, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneIsNull() {
            addCriterion("staff_phone is null");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneIsNotNull() {
            addCriterion("staff_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneEqualTo(String value) {
            addCriterion("staff_phone =", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotEqualTo(String value) {
            addCriterion("staff_phone <>", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneGreaterThan(String value) {
            addCriterion("staff_phone >", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("staff_phone >=", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneLessThan(String value) {
            addCriterion("staff_phone <", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneLessThanOrEqualTo(String value) {
            addCriterion("staff_phone <=", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneLike(String value) {
            addCriterion("staff_phone like", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotLike(String value) {
            addCriterion("staff_phone not like", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneIn(List<String> values) {
            addCriterion("staff_phone in", values, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotIn(List<String> values) {
            addCriterion("staff_phone not in", values, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneBetween(String value1, String value2) {
            addCriterion("staff_phone between", value1, value2, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotBetween(String value1, String value2) {
            addCriterion("staff_phone not between", value1, value2, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andHiredateIsNull() {
            addCriterion("hiredate is null");
            return (Criteria) this;
        }

        public Criteria andHiredateIsNotNull() {
            addCriterion("hiredate is not null");
            return (Criteria) this;
        }

        public Criteria andHiredateEqualTo(Date value) {
            addCriterionForJDBCDate("hiredate =", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotEqualTo(Date value) {
            addCriterionForJDBCDate("hiredate <>", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateGreaterThan(Date value) {
            addCriterionForJDBCDate("hiredate >", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hiredate >=", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateLessThan(Date value) {
            addCriterionForJDBCDate("hiredate <", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hiredate <=", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateIn(List<Date> values) {
            addCriterionForJDBCDate("hiredate in", values, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotIn(List<Date> values) {
            addCriterionForJDBCDate("hiredate not in", values, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hiredate between", value1, value2, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hiredate not between", value1, value2, "hiredate");
            return (Criteria) this;
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