package org.example;

import java.util.Scanner;

public class Controller {
   TaskList taskList = new TaskList();
     Scanner scan = new Scanner(System.in);
     int counter = 0;
    public void entryChoice(){
        int fc = scan.nextInt();
        if(fc==1){
            watchTaskList();
        }else if(fc==2){
            addTask();
        } else if(fc==3){
            changeTask();
        } else if(fc==4){
            deleteTask();
        } else if(fc==5){
            exit();
        } else{
            System.out.println("Такого варианта не существует. Выберете нужную из списка:");
            entryChoice();
        }
    }
    public void mainMenu(){
        System.out.println("Что вы желаете сделать?"+'\n'+"1.Просмотреть список задач."
                +'\n'+"2.Добавить задачу."+'\n'+"3.Изменить задачу."+'\n'+"4.Удалить задачу."+'\n'+"5.Выйти."+'\n'+"Введите номер раздела: ");
        entryChoice();
    }
    public void watchTaskList(){
        System.out.println(taskList.taskList);
        System.out.println("1.Вернуться в главное меню.");
        int tmm = scan.nextInt();
        if(tmm==1){
            mainMenu();
        } else {
            System.out.println("Нет такого варианта.");
            watchTaskList();
        }
    }
    public void addTask(){
        System.out.println("Введите название задачи: ");
        scan.nextLine();
        String name = scan.nextLine();
        System.out.println("Введите описание задачи: ");
        String description = scan.nextLine();
        System.out.println("Установите статус задачи"+'\n'+"1.Запланировано"+'\n'+"2.В процессе."+'\n'+"3. Завершено.");
        String taskStatus;
        int status = scan.nextInt();
       while(true){
           if(status==1){
               taskStatus = EnumStatus.PLANNED.name();
               break;
           } else if(status==2){
               taskStatus = EnumStatus.IN_PROGRESS.name();
               break;
           } else if(status==3){
               taskStatus = EnumStatus.READY.name();
               break;
           }else {
               System.out.println("Не верно");
           }
       }
        Task task = new Task();
       task.setTaskNumber(counter++);
        task.setTaskName(name);
        task.setTaskDescription(description);
        task.setTaskStatus(taskStatus);
        taskList.taskList.put(task.getTaskNumber(), task);
        mainMenu();
    }
    public void changeTask(){
        if(taskList.taskList.isEmpty()){
            System.out.println("Задачи не обнаружены. Возвращение в главное меню.");
            mainMenu();
        }
        System.out.println(taskList.taskList);
        System.out.println("Введите номер задачи:");
        scan.nextLine();
        int number = scan.nextInt();

        System.out.println("Что вы хотите изменить?"+'\n'+"1.Название."+'\n'+"2.Описание."+'\n'+"3.Статус.");
        int choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("Введите новое имя задачи: ");
                scan.nextLine();
                String newName = scan.nextLine();
                taskList.taskList.get(number).setTaskName(newName);
                System.out.println("Успешно");
            } else if (choice == 2) {
                System.out.println("Введите новое описание:");
                scan.nextLine();
                String newDescription = scan.nextLine();
                taskList.taskList.get(number).setTaskDescription(newDescription);
                System.out.println("Успешно");
            } else if (choice == 3) {
                System.out.println("Установите новый статус(пжлст):" + '\n' + "1.Запланировано." + '\n' + "2.В процессе." + '\n' + "3.Завершено.");
                String taskStatus = "";
                scan.nextLine();
                int status = scan.nextInt();
                    if (status == 1) {
                        taskStatus = EnumStatus.PLANNED.name();
                    } else if (status == 2) {
                        taskStatus = EnumStatus.IN_PROGRESS.name();
                    } else if (status == 3) {
                        taskStatus = EnumStatus.READY.name();
                    } else {
                        System.out.println("Не верно");
                        changeTask();
                    }
                taskList.taskList.get(number).setTaskStatus(taskStatus);
                System.out.println("Успешно");
            } else {
                System.out.println("Нет такого варината.");
                changeTask();
            }
            mainMenu();
    }
    public void deleteTask(){
        if(taskList.taskList.isEmpty()){
            System.out.println("Задачи не обнаружены. Возвращение в главное меню.");
            mainMenu();
        }
        System.out.println(taskList.taskList);
        System.out.println("Введите id задачи, которую нужно удалить: ");
        scan.nextLine();
        int number = scan.nextInt();
        taskList.taskList.remove(number);
        System.out.println("Задача была удалена.");
        mainMenu();
    }
    public void sortTask(){

    }
    public void exit(){
        System.out.println("Всего доброго...");
    }
}
