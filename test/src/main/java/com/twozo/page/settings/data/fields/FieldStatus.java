package com.twozo.page.settings.data.fields;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldStatus {

    private boolean isDraggable;
    private String name;
    private String fieldType;
    private boolean isAddView;
    private boolean isRequired;
    private boolean isEditable;
    private boolean isHideable;
    private boolean isDeletable;

}
