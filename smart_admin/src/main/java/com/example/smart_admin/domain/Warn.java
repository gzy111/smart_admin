package com.example.smart_admin.domain;

import com.example.smart_admin.base.base;

import java.io.Serializable;
import java.util.Date;

public class Warn extends base implements Serializable {
    private String warnCode;

    private String equipmentCode;

    private String warnType;

    private Date createTime;

    private String warnData;

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private static final long serialVersionUID = 1L;

    public String getWarnCode() {
        return warnCode;
    }

    public void setWarnCode(String warnCode) {
        this.warnCode = warnCode == null ? null : warnCode.trim();
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode == null ? null : equipmentCode.trim();
    }

    public String getWarnType() {
        return warnType;
    }

    public void setWarnType(String warnType) {
        this.warnType = warnType == null ? null : warnType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getWarnData() {
        return warnData;
    }

    public void setWarnData(String warnData) {
        this.warnData = warnData == null ? null : warnData.trim();
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
        Warn other = (Warn) that;
        return (this.getWarnCode() == null ? other.getWarnCode() == null : this.getWarnCode().equals(other.getWarnCode()))
            && (this.getEquipmentCode() == null ? other.getEquipmentCode() == null : this.getEquipmentCode().equals(other.getEquipmentCode()))
            && (this.getWarnType() == null ? other.getWarnType() == null : this.getWarnType().equals(other.getWarnType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getWarnData() == null ? other.getWarnData() == null : this.getWarnData().equals(other.getWarnData()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWarnCode() == null) ? 0 : getWarnCode().hashCode());
        result = prime * result + ((getEquipmentCode() == null) ? 0 : getEquipmentCode().hashCode());
        result = prime * result + ((getWarnType() == null) ? 0 : getWarnType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getWarnData() == null) ? 0 : getWarnData().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", warnCode=").append(warnCode);
        sb.append(", equipmentCode=").append(equipmentCode);
        sb.append(", warnType=").append(warnType);
        sb.append(", createTime=").append(createTime);
        sb.append(", warnData=").append(warnData);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}