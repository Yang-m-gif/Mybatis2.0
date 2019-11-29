package com.sui.Util;

import lombok.Data;

public class Info {

    private String column;

    private String columntype;

    private String columntypeurl;

    private String columnSqltype;

    private String notes;

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getColumntype() {
        return columntype;
    }

    public void setColumntype(String columntype) {
        this.columntype = columntype;
    }

    public String getColumntypeurl() {
        return columntypeurl;
    }

    public void setColumntypeurl(String columntypeurl) {
        this.columntypeurl = columntypeurl;
    }

    public String getColumnSqltype() {
        return columnSqltype;
    }

    public void setColumnSqltype(String columnSqltype) {
        this.columnSqltype = columnSqltype;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
