package org.example.models.columnType;

import org.example.models.Column;

public class IntColumn extends Column {

    public IntColumn(String name, Boolean isPrimary) {
        super(name, isPrimary);
    }

    @Override
    protected boolean validate(Object value) {
        return (value instanceof Integer);
    }
}
