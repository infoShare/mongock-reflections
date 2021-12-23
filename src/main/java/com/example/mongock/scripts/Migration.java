package com.example.mongock.scripts;

import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;

@ChangeUnit(order = "001", id = "Migration", author = "infoShare")
public class Migration {

    @Execution
    public void executeMigration() {
        System.out.println("Migration executed");
    }

    @RollbackExecution
    public void executeRollback() {
        System.out.println("Rollback executed for " + getClass().getSimpleName());
    }

}

