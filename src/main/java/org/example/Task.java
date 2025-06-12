package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class Task {
    private int taskNumber;
    private String taskName;
    private String taskStatus;
    private String taskDescription;

    @Override
    public String toString() {
        return "Task{" +
                "taskNumber=" + taskNumber +
                ", taskName='" + taskName + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                '}';
    }

}
