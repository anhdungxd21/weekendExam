import java.util.Scanner;

public class WeekendExam {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        int[] array;
        int sizeOfArray = 0;
        do{
            menu();
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    positiveIntegerOdd();
                    break;
                case 2:
                    System.out.println("Check number prime.");
                    System.out.print("Enter number need check: ");
                    int number = input.nextInt();
                    if(isPrime(number)){
                        System.out.print(number+" is prime.");
                    } else {
                        System.out.print(number+" is not prime.");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter length of Prime need to print: ");
                    int lengthPrint = input.nextInt();
                    printPrime(lengthPrint);
                    break;
                case 4:
                    System.out.print("Enter size of array: ");
                    do{
                        sizeOfArray = input.nextInt();
                    }while (sizeOfArray <= 0);
                    array = new int[sizeOfArray];
                    for (int i = 0; i < array.length; i++) {
                        System.out.print("Enter element of array: ");
                        array[i] = input.nextInt();
                    }
                    menuArray();
                    System.out.print("Enter your choice: ");
                    choice = input.nextInt();
                        switch (choice) {
                            case 1:
                                printArray(array);
                                break;
                            case 2:
                                System.out.println("Prime in array: ");
                                for (int i = 0; i < array.length; i++) {
                                    if(isPrime(array[i])){
                                        System.out.printf(array[i]+"\t");
                                    }
                                }
                                System.out.println();
                                break;
                            case 3:
                                System.out.printf("Enter value want to check: ");
                                int checkValue = input.nextInt();
                                int index = 0;
                                boolean isIn = true;
                                for (int i = 0; i < array.length; i++) {
                                    if(checkValue == array[i]){
                                        index = i;
                                        System.out.printf("%d is exist in array and index in %d",checkValue,index);
                                    }else {
                                        isIn = false;
                                    }
                                }
                                if(!isIn){
                                    System.out.printf("%d is not exist in array",checkValue);
                                }
                                System.out.println();
                                break;
                            case 4:
                                System.out.printf("Enter value want to delete: ");
                                int valueInput = input.nextInt();
                                for (int i = 0; i < array.length; i++) {
                                    if(array[i] == valueInput){
                                        for (int j = i; j < array.length -1; j++) {
                                            array[j] = array[j+1];
                                        }
                                        array[array.length-1] = 0;
                                    }
                                }
                                printArray(array);
                                System.out.println();
                            case 5:
                                System.out.println("Sort array");
                                printArray(array);
                                bubbleSort(array);
                                printArray(array);
                                break;
                            case 6:
                                System.out.println("Add value in array");
                                System.out.print("Enter value: ");
                                int value = input.nextInt();
                                array = arrayPush(array,value);
                                bubbleSort(array);
                                printArray(array);
                                break;
                        }
                    break;

            }
        }while(choice != 0);
    }

    public static void menu() {
        System.out.println("1. Nhập số N (N lẻ dương), yêu cầu nhập cho đến khi N thỏa mãn điều kiện");
        System.out.println("2. Kiểm tra N có là số nguyên tố");
        System.out.println("3. Hiển thị danh sách N số nguyên tố đầu tiên");
        System.out.println("4. Nhập vào mảng gồm N phần tử");
        System.out.println("0. Exit");
    }

    public static void menuArray() {
        System.out.println("1. Hiển thị danh sách mảng vừa nhập ở 4");
        System.out.println("2. Liệt kê danh sách các số nguyên tố trong mảng vừa nhập");
        System.out.println("3. Kiểm tra N có tồn tại trong mảng vừa nhập, nếu có trả về vị trí của N trong mảng");
        System.out.println("4. Xóa N khỏi mảng vừa nhập");
        System.out.println("5. Sắp xếp các phần tử của mảng vừa nhập ở 4 theo thứ tự tăng dần");
        System.out.println("6. Nhập vào 1 số X, chèn X vào mảng sắp xếp ở bước 7 sao cho không làm thay đổi thứ tự sắp xếp của mảng");
        System.out.println("0. Exit");
    }

    public static void positiveIntegerOdd() {
        Scanner input = new Scanner(System.in);
        int number;
        boolean choice = false;
        do{
            System.out.print("Enter positive and odd number");
            number = input.nextInt();
            if(number >= 0 && number % 2 == 0) {
                choice = true;
                System.out.println("It must be positive and odd number!");
            } else {
                choice = false;
            }
        }while(choice);
    }
    public static void printPrime(int length) {
        int count = 0;
        int number = 2;
        while(count < length){
            if(isPrime(number)){
                System.out.print(number+",");
                count++;
            }
            number++;
        }
        System.out.println();
    }
    public static void printArray(int...x){
        for(int a:x){
            System.out.printf(a+"\t");
        }
        System.out.println();
    }
    public static boolean isPrime(int number) {
        if(number < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number) ; i++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            for (int j = 0; j < array.length -i -1; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static int[] arrayPush(int[] array, int value) {
        int[] arrayNew = new int[array.length+1];
        for (int i = 0; i < array.length; i++) {
            arrayNew[i] = array[i];
        }
        arrayNew[array.length] = value;
        return arrayNew;
    }
}
