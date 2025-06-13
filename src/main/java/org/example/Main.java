package org.example;

public class Main {
        public static void main(String[] args) {
                Controller con = new Controller();
                System.out.println("Добро пожаловать..." + '\n'+"Что вы желаете сделать?"+'\n'+"1.Просмотреть список задач."
                        +'\n'+"2.Добавить задачу."+'\n'+"3.Изменить задачу."+'\n'+"4.Удалить задачу."+'\n'+
                        "5.Сортировать задачи по статусу."+'\n'+"6.Показать задачи в процессе."+'\n'+"7.Выйти."+'\n'+"Введите номер раздела: ");
                con.entryChoice();
        }
}
