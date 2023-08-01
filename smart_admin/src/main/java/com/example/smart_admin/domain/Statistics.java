package com.example.smart_admin.domain;

import java.time.LocalDateTime;

public class Statistics {
    private int id;
    private String name;
    private int count;
    private int successCount;
    private LocalDateTime lastUpdated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", successCount=" + successCount +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
