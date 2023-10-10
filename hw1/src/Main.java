import java.util.Scanner;

public class Main {
    //Метод проверяет является ли переданная строка палиндромом
    public static boolean isPalindrome(String str) {
        str=str.replace(" ",""); //Удаляем все пробелы
        str=str.toLowerCase(); //Приводим строку к одному регистру
        str=str.replaceAll("\\p{Punct}", ""); //Удаляем все знаки пунктуации
        for(int i=0; i<str.length()/2; i++){
            if (str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false; //Если символы не совпали, то дальше нет смысла проверять, это не палиндром
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Введите строку для проверки:");
        str=scanner.nextLine();
        if(isPalindrome(str)) {
            System.out.println("Строка является палиндромом");
        }
        else {
            System.out.println("Строка не является палиндромом");
        }
    }
}