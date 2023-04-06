package com.example.smart_admin.domain;

import com.example.smart_admin.base.base;

import java.io.Serializable;
import java.util.Date;

public class Task extends base implements Serializable {
    private String taskCode;

    private Date taskTime;

    private String taskType;

    private String taskYield;

    private String state;

    private String data;

    private static final long serialVersionUID = 1L;

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode == null ? null : taskCode.trim();
    }

    public Date getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(Date taskTime) {
        this.taskTime = taskTime;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public String getTaskYield() {
        return taskYield;
    }

    public void setTaskYield(String taskYield) {
        this.taskYield = taskYield == null ? null : taskYield.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Task other = (Task) that;
        return (this.getTaskCode() == null ? other.getTaskCode() == null : this.getTaskCode().equals(other.getTaskCode()))
            && (this.getTaskTime() == null ? other.getTaskTime() == null : this.getTaskTime().equals(other.getTaskTime()))
            && (this.getTaskType() == null ? other.getTaskType() == null : this.getTaskType().equals(other.getTaskType()))
            && (this.getTaskYield() == null ? other.getTaskYield() == null : this.getTaskYield().equals(other.getTaskYield()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getData() == null ? other.getData() == null : this.getData().equals(other.getData()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTaskCode() == null) ? 0 : getTaskCode().hashCode());
        result = prime * result + ((getTaskTime() == null) ? 0 : getTaskTime().hashCode());
        result = prime * result + ((getTaskType() == null) ? 0 : getTaskType().hashCode());
        result = prime * result + ((getTaskYield() == null) ? 0 : getTaskYield().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getData() == null) ? 0 : getData().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", taskCode=").append(taskCode);
        sb.append(", taskTime=").append(taskTime);
        sb.append(", taskType=").append(taskType);
        sb.append(", taskYield=").append(taskYield);
        sb.append(", state=").append(state);
        sb.append(", data=").append(data);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}