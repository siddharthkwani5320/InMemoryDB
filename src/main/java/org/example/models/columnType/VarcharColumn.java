package org.example.models.columnType;

import org.example.models.Column;

public class VarcharColumn extends Column {
    public VarcharColumn(String name, Boolean isPrimary) {
        super(name, isPrimary);
    }

    @Override
    protected boolean validate(Object value) {
        return (value instanceof String);
    }
}
