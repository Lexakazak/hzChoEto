package org.example;
import lombok.Data;

import java.util.HashMap;
@Data
public class TaskList {
        HashMap<Integer, Task> taskList = new HashMap<>();

}
