package com.example.smart_admin.domain;

import com.example.smart_admin.base.base;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Equipment extends base implements Serializable  {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String equipmentCode;

    private String equipmentName;

    private String equipmentType;

    private String equipmentUser;

    public String getEquipmentUser() {
        return equipmentUser;
    }

    public void setEquipmentUser(String equipmentUser) {
        this.equipmentUser = equipmentUser;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;

    private String state;

    private static final long serialVersionUID = 1L;

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode == null ? null : equipmentCode.trim();
    }


    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName == null ? null : equipmentName.trim();
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType == null ? null : equipmentType.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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
        Equipment other = (Equipment) that;
        return (this.getEquipmentCode() == null ? other.getEquipmentCode() == null : this.getEquipmentCode().equals(other.getEquipmentCode()))
            && (this.getEquipmentName() == null ? other.getEquipmentName() == null : this.getEquipmentName().equals(other.getEquipmentName()))
            && (this.getEquipmentType() == null ? other.getEquipmentType() == null : this.getEquipmentType().equals(other.getEquipmentType()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEquipmentCode() == null) ? 0 : getEquipmentCode().hashCode());
        result = prime * result + ((getEquipmentName() == null) ? 0 : getEquipmentName().hashCode());
        result = prime * result + ((getEquipmentType() == null) ? 0 : getEquipmentType().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", equipmentCode=").append(equipmentCode);
        sb.append(", equipmentName=").append(equipmentName);
        sb.append(", equipmentType=").append(equipmentType);
        sb.append(", date=").append(date);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}