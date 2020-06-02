package com.ezgroceries.shoppinglist;

import java.util.List;

public class Resources<T> {

    private List<T> resources;

    public Resources(List<T> resources) {
        setResources(resources);
    }

    public List<T> getResources() {
        return resources;
    }

    public void setResources(List<T> resources) {
        this.resources = resources;
    }
}
