package com.jvhuaxia.pojo;

import java.util.List;

public class Role {
    private String id;
    private String name;
    private String note;
    private List<Permission> permissions;


    public Role() {

    }

    public Role(String id) {
        this.id = id;
    }

    public Role(String name, String note, List<Permission> permissions) {
        this.name = name;
        this.note = note;
        this.permissions = permissions;
    }

    public Role(String id, String name, String note, List<Permission> permissions) {
        this.id = id;
        this.name = name;
        this.note = note;
        this.permissions = permissions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
