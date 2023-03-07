package com.example.smart_admin.domain;

import java.io.Serializable;
import java.util.Date;

public class Repair implements Serializable {
    private String repairCode;

    private String equipmentCode;

    private Date repairTime;

    private Date createTime;

    private String repairUser;

    private Date date;

    private Date finishTime;

    private String state;

    private static final long serialVersionUID = 1L;

    public String getRepairCode() {
        return repairCode;
    }

    public void setRepairCode(String repairCode) {
        this.repairCode = repairCode == null ? null : repairCode.trim();
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode == null ? null : equipmentCode.trim();
    }

    public Date getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(Date repairTime) {
        this.repairTime = repairTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRepairUser() {
        return repairUser;
    }

    public void setRepairUser(String repairUser) {
        this.repairUser = repairUser == null ? null : repairUser.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
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
        Repair other = (Repair) that;
        return (this.getRepairCode() == null ? other.getRepairCode() == null : this.getRepairCode().equals(other.getRepairCode()))
            && (this.getEquipmentCode() == null ? other.getEquipmentCode() == null : this.getEquipmentCode().equals(other.getEquipmentCode()))
            && (this.getRepairTime() == null ? other.getRepairTime() == null : this.getRepairTime().equals(other.getRepairTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getRepairUser() == null ? other.getRepairUser() == null : this.getRepairUser().equals(other.getRepairUser()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRepairCode() == null) ? 0 : getRepairCode().hashCode());
        result = prime * result + ((getEquipmentCode() == null) ? 0 : getEquipmentCode().hashCode());
        result = prime * result + ((getRepairTime() == null) ? 0 : getRepairTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getRepairUser() == null) ? 0 : getRepairUser().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", repairCode=").append(repairCode);
        sb.append(", equipmentCode=").append(equipmentCode);
        sb.append(", repairTime=").append(repairTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", repairUser=").append(repairUser);
        sb.append(", date=").append(date);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}