package cn.zxk.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TLogisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TLogisticsExample() {
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

        public Criteria andLogisticsIdIsNull() {
            addCriterion("logistics_id is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdIsNotNull() {
            addCriterion("logistics_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdEqualTo(Integer value) {
            addCriterion("logistics_id =", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotEqualTo(Integer value) {
            addCriterion("logistics_id <>", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdGreaterThan(Integer value) {
            addCriterion("logistics_id >", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("logistics_id >=", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdLessThan(Integer value) {
            addCriterion("logistics_id <", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdLessThanOrEqualTo(Integer value) {
            addCriterion("logistics_id <=", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdIn(List<Integer> values) {
            addCriterion("logistics_id in", values, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotIn(List<Integer> values) {
            addCriterion("logistics_id not in", values, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdBetween(Integer value1, Integer value2) {
            addCriterion("logistics_id between", value1, value2, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("logistics_id not between", value1, value2, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andWaybillIdIsNull() {
            addCriterion("waybill_id is null");
            return (Criteria) this;
        }

        public Criteria andWaybillIdIsNotNull() {
            addCriterion("waybill_id is not null");
            return (Criteria) this;
        }

        public Criteria andWaybillIdEqualTo(String value) {
            addCriterion("waybill_id =", value, "waybillId");
            return (Criteria) this;
        }

        public Criteria andWaybillIdNotEqualTo(String value) {
            addCriterion("waybill_id <>", value, "waybillId");
            return (Criteria) this;
        }

        public Criteria andWaybillIdGreaterThan(String value) {
            addCriterion("waybill_id >", value, "waybillId");
            return (Criteria) this;
        }

        public Criteria andWaybillIdGreaterThanOrEqualTo(String value) {
            addCriterion("waybill_id >=", value, "waybillId");
            return (Criteria) this;
        }

        public Criteria andWaybillIdLessThan(String value) {
            addCriterion("waybill_id <", value, "waybillId");
            return (Criteria) this;
        }

        public Criteria andWaybillIdLessThanOrEqualTo(String value) {
            addCriterion("waybill_id <=", value, "waybillId");
            return (Criteria) this;
        }

        public Criteria andWaybillIdLike(String value) {
            addCriterion("waybill_id like", value, "waybillId");
            return (Criteria) this;
        }

        public Criteria andWaybillIdNotLike(String value) {
            addCriterion("waybill_id not like", value, "waybillId");
            return (Criteria) this;
        }

        public Criteria andWaybillIdIn(List<String> values) {
            addCriterion("waybill_id in", values, "waybillId");
            return (Criteria) this;
        }

        public Criteria andWaybillIdNotIn(List<String> values) {
            addCriterion("waybill_id not in", values, "waybillId");
            return (Criteria) this;
        }

        public Criteria andWaybillIdBetween(String value1, String value2) {
            addCriterion("waybill_id between", value1, value2, "waybillId");
            return (Criteria) this;
        }

        public Criteria andWaybillIdNotBetween(String value1, String value2) {
            addCriterion("waybill_id not between", value1, value2, "waybillId");
            return (Criteria) this;
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

        public Criteria andLogisticsTypeIsNull() {
            addCriterion("logistics_type is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeIsNotNull() {
            addCriterion("logistics_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeEqualTo(String value) {
            addCriterion("logistics_type =", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeNotEqualTo(String value) {
            addCriterion("logistics_type <>", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeGreaterThan(String value) {
            addCriterion("logistics_type >", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_type >=", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeLessThan(String value) {
            addCriterion("logistics_type <", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeLessThanOrEqualTo(String value) {
            addCriterion("logistics_type <=", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeLike(String value) {
            addCriterion("logistics_type like", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeNotLike(String value) {
            addCriterion("logistics_type not like", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeIn(List<String> values) {
            addCriterion("logistics_type in", values, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeNotIn(List<String> values) {
            addCriterion("logistics_type not in", values, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeBetween(String value1, String value2) {
            addCriterion("logistics_type between", value1, value2, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeNotBetween(String value1, String value2) {
            addCriterion("logistics_type not between", value1, value2, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andStartDotNameIsNull() {
            addCriterion("start_dot_name is null");
            return (Criteria) this;
        }

        public Criteria andStartDotNameIsNotNull() {
            addCriterion("start_dot_name is not null");
            return (Criteria) this;
        }

        public Criteria andStartDotNameEqualTo(String value) {
            addCriterion("start_dot_name =", value, "startDotName");
            return (Criteria) this;
        }

        public Criteria andStartDotNameNotEqualTo(String value) {
            addCriterion("start_dot_name <>", value, "startDotName");
            return (Criteria) this;
        }

        public Criteria andStartDotNameGreaterThan(String value) {
            addCriterion("start_dot_name >", value, "startDotName");
            return (Criteria) this;
        }

        public Criteria andStartDotNameGreaterThanOrEqualTo(String value) {
            addCriterion("start_dot_name >=", value, "startDotName");
            return (Criteria) this;
        }

        public Criteria andStartDotNameLessThan(String value) {
            addCriterion("start_dot_name <", value, "startDotName");
            return (Criteria) this;
        }

        public Criteria andStartDotNameLessThanOrEqualTo(String value) {
            addCriterion("start_dot_name <=", value, "startDotName");
            return (Criteria) this;
        }

        public Criteria andStartDotNameLike(String value) {
            addCriterion("start_dot_name like", value, "startDotName");
            return (Criteria) this;
        }

        public Criteria andStartDotNameNotLike(String value) {
            addCriterion("start_dot_name not like", value, "startDotName");
            return (Criteria) this;
        }

        public Criteria andStartDotNameIn(List<String> values) {
            addCriterion("start_dot_name in", values, "startDotName");
            return (Criteria) this;
        }

        public Criteria andStartDotNameNotIn(List<String> values) {
            addCriterion("start_dot_name not in", values, "startDotName");
            return (Criteria) this;
        }

        public Criteria andStartDotNameBetween(String value1, String value2) {
            addCriterion("start_dot_name between", value1, value2, "startDotName");
            return (Criteria) this;
        }

        public Criteria andStartDotNameNotBetween(String value1, String value2) {
            addCriterion("start_dot_name not between", value1, value2, "startDotName");
            return (Criteria) this;
        }

        public Criteria andTargetDotNameIsNull() {
            addCriterion("target_dot_name is null");
            return (Criteria) this;
        }

        public Criteria andTargetDotNameIsNotNull() {
            addCriterion("target_dot_name is not null");
            return (Criteria) this;
        }

        public Criteria andTargetDotNameEqualTo(String value) {
            addCriterion("target_dot_name =", value, "targetDotName");
            return (Criteria) this;
        }

        public Criteria andTargetDotNameNotEqualTo(String value) {
            addCriterion("target_dot_name <>", value, "targetDotName");
            return (Criteria) this;
        }

        public Criteria andTargetDotNameGreaterThan(String value) {
            addCriterion("target_dot_name >", value, "targetDotName");
            return (Criteria) this;
        }

        public Criteria andTargetDotNameGreaterThanOrEqualTo(String value) {
            addCriterion("target_dot_name >=", value, "targetDotName");
            return (Criteria) this;
        }

        public Criteria andTargetDotNameLessThan(String value) {
            addCriterion("target_dot_name <", value, "targetDotName");
            return (Criteria) this;
        }

        public Criteria andTargetDotNameLessThanOrEqualTo(String value) {
            addCriterion("target_dot_name <=", value, "targetDotName");
            return (Criteria) this;
        }

        public Criteria andTargetDotNameLike(String value) {
            addCriterion("target_dot_name like", value, "targetDotName");
            return (Criteria) this;
        }

        public Criteria andTargetDotNameNotLike(String value) {
            addCriterion("target_dot_name not like", value, "targetDotName");
            return (Criteria) this;
        }

        public Criteria andTargetDotNameIn(List<String> values) {
            addCriterion("target_dot_name in", values, "targetDotName");
            return (Criteria) this;
        }

        public Criteria andTargetDotNameNotIn(List<String> values) {
            addCriterion("target_dot_name not in", values, "targetDotName");
            return (Criteria) this;
        }

        public Criteria andTargetDotNameBetween(String value1, String value2) {
            addCriterion("target_dot_name between", value1, value2, "targetDotName");
            return (Criteria) this;
        }

        public Criteria andTargetDotNameNotBetween(String value1, String value2) {
            addCriterion("target_dot_name not between", value1, value2, "targetDotName");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
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