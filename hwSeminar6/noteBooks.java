package hwSeminar6;
// Добавить атрибуты класса с соответствующими типами.
// Например,
// - идентификатор
// - производитель
// - название модели
// - RAM
// - объем HD
// - операционная система
// - и т.д.
// Добавить конструктор класса.
// Добавить необходимые методы класса.
// Создать множество ноутбуков (множество объектов класса ноутбук).
// 3-10 штук
// Написать метод, который будет запрашивать у пользователя критерий фильтрации (один) и выведет ноутбуки, отвечающие критерию.
// Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - RAM
// 2 - Объем HD
// 3 - Операционная система
// 4 - Цвет …
// Для критериев объем и память необходимо запросить дополнительно диапазон.
// Например,
// "Введите минимальное значение"
// "Введите максимальное значение"
// Отфильтровать ноутбуки и вывести проходящие по критерию.
// Пример вывода:
// Ноутбуки с объем HD от 256 до 512
// 1 HP EliteBook...
// 2..
// 3...
// Пример вывода:
// Ноутбуки с цвет Серебристый
// 1 Honor ...
// 2..
// 3...

import java.util.Map;
import java.util.Scanner;


public class noteBooks {
    String firm, model, os, color;
    int ram, hd, price;
    int id;

    
    public noteBooks(int id, String firm, String model, String os, String color, int ram, int hd, int price) {   
        this.id = id;
        this.firm = firm;
        this.model = model;
        this.os = os;
        this.color = color;
        this.ram = ram;
        this.hd = hd;
        this.price = price;     
    }
    

    @Override //вывести ноутбук со всеми характеристиками
    public String toString() {
        return String.format("id: %d, firm: %s, model: %s, os: %s, color: %s, ram: %s, hd: %d, price: %d", id, firm, model, os, color, ram, hd, price);  
    }


    public static StringBuilder getByFirm(noteBooks [] nbooks, int num) {//метод доб-я характеристик объектов в строку по фирме
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (noteBooks b : nbooks) {
            if (b.id == num) {
                res.append("\n" + "Вариант N" + ++count + "\n" + "Модель: " + b.model + "\n" + "ОС: " + b.os + "\n" + "цвет: " + b.color + "\n" + b.hd + "\n" + "RAM: " + b.ram + "\n" + "Цена: " + b.price + "\n");
            }
        }
        return res;
    }


    public static StringBuilder getByPrice(noteBooks [] nbooks, int min, int max) {//метод добавления в строку по цене
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (noteBooks b : nbooks) {
            if ((b.price <= max) && (min <= b.price)) {
                res.append("\n" + "Вариант N" + ++count + "\n" + "Фирма: " + b.firm +  "Модель: " + b.model + "\n" + "ОС: " + b.os + "\n" + "цвет: " + b.color + "\n" + "HD: " + b.hd + "\n" + "RAM: " + b.ram + "\n" + "Цена: " + b.price + "\n");
            }
        }
        return res;
    }
    
    
    public static StringBuilder getByRam(noteBooks [] nbooks, Integer user, Map <Integer, Integer> ram) {//строка по RAM
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (var item : ram.entrySet()) {
            for (noteBooks b : nbooks) {
                if (item.getValue().equals(user)) {//находим по выбору пользователя нужное значение с ключом
                    if (b.ram == item.getKey()) {//по найденному ключу находим нужную RAM
                        res.append("\n" + "Вариант N" + ++count + "\n" + "Фирма: " + b.firm + "\n" + "Модель: " + b.model + "\n" + "цвет: " + b.color + "\n" + "HD: " + b.hd + "\n" + "ОС: " + b.os + "\n" + "Цена: " + b.price + "\n"); 
                    }
                }
            }
        }
        return res;   
    }


    public static StringBuilder getByOs(noteBooks [] nbooks, Integer user, Map <String, Integer> os) {//строка по ОС
        StringBuilder res = new StringBuilder();//получаем строку с ноутбуками выбранной ОС
        int count = 0;
        for (var item : os.entrySet()) {
            for (noteBooks b : nbooks) {
                if (item.getValue().equals(user)) {//находим по выбору пользователя нужное значение с ключом
                    if (b.os == item.getKey()) {//по найденному ключу находим нужную ОС
                        res.append("\n" + "Вариант N" + ++count + "\n" + "Фирма: " + b.firm + "\n" + "Модель: " + b.model + "\n" + "цвет: " + b.color + "\n" + "HD: " + b.hd + "\n" + "RAM: " + b.ram + "\n" + "Цена: " + b.price + "\n"); 
                    }
                }
            }
        }
        return res;   
    }


    public static StringBuilder getByColor(noteBooks [] nbooks, Integer user, Map <String, Integer> col) {//строка по цвету
        StringBuilder res = new StringBuilder();//получаем строку с ноутбуками выбранного цвета
        int count = 0;
        for (var item : col.entrySet()) {
            for (noteBooks b : nbooks) {
                if (item.getValue().equals(user)) {//находим по выбору пользователя нужное значение с ключом
                    if (b.color == item.getKey()) {//по найденному ключу находим нужному цвету
                        res.append("\n" + "Вариант N" + ++count + "\n" + "Фирма: " + b.firm + "\n" + "Модель: " + b.model + "\n" + "ОС: " + b.os + "\n" + "HD: " + b.hd + "\n" + "RAM: " + b.ram + "\n" + "Цена: " + b.price + "\n"); 
                    }
                }
            }
        }
        return res;   
    }


    public static void getFirm(Map <Integer, String> f, noteBooks [] nbooks) {//метод, получ-ий знач-ие от польз. по фирме
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите цифру, соот-ую фирме: ");
        System.out.println(f);
        int choice = iScanner.nextInt();
        StringBuilder res = getByFirm(nbooks, choice);//вызываем метод формирования строки из нужных фирм
        System.out.println(res);
        iScanner.close();
    }


    public static void getPrice(noteBooks [] nbooks) {//метод, получ-ий диапазон цен от пользователя
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите через пробел диапазон цены от мин до макс: ");
        String [] choice = iScanner.nextLine().split(" ");
        int min = Integer.parseInt(choice[0]);
        int max = Integer.parseInt(choice[1]);
        StringBuilder res = getByPrice(nbooks, min, max);//вызываем метод формирования строки из нужных цен
        System.out.println(res);
        iScanner.close();
    }


    public static void getOs(Map <String, Integer> i, noteBooks [] nbooks) {//метод, получ-ий знач-ие от польз. по ОС
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите цифру, соот-ую ОС: ");
        System.out.println(i);
        Integer choice = iScanner.nextInt();
        StringBuilder res = getByOs(nbooks, choice, i);//вызываем метод формирования строки из нужных ОС
        System.out.println(res);
        iScanner.close();
    }


    public static void getRam(Map <Integer, Integer> i, noteBooks [] nbooks) {//метод, получ-ий знач-ие от польз. по Ram
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите цифру, соот-ую Ram: ");
        for (var el : i.entrySet()) {
            System.out.printf("%d Гб - %d\n", el.getKey(), el.getValue());
        }
        Integer choice = iScanner.nextInt();
        StringBuilder res = getByRam(nbooks, choice, i);//вызываем метод формирования строки из нужных Ram
        System.out.println(res);
        iScanner.close();
    }


    public static void getCol(Map <String, Integer> i, noteBooks [] nbooks) {//метод, получ-ий знач-ие от польз. по цвету
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите цифру, соот-ую цвету: ");
        System.out.println(i);
        Integer choice = iScanner.nextInt();
        StringBuilder res = getByColor(nbooks, choice, i);//вызываем метод формирования строки из нужный цвет
        System.out.println(res);
        iScanner.close();
    }
}
