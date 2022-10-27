package ua.alexshent.crm.controller;

import java.util.List;

public class EntitiesPage<T> {

    private List<T> entities;

    private long total;

    public List<T> getEntities() {
        return entities;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
