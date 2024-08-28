package com.twozo.page.deal;

import com.twozo.web.driver.service.WebAutomationDriver;

import java.util.Objects;

public class KanbanView extends Deal{

    private static KanbanView kanbanView;

    public KanbanView() {
        super();
    }

    public static KanbanView getInstance(){

       // if (Objects.isNull(kanbanView)) {
            kanbanView = new KanbanView();
        //}

        return kanbanView;
    }
}
