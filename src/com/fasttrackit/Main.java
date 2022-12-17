package com.fasttrackit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        ex2(scan);
//        ex3(scan);
//        ex4(scan);
//        ex5(scan);
//        ex5Decrypter(scan);
        bruteForceDecrypter(scan);
    }

    public static void ex2(Scanner scan) {
        System.out.print("Enter a string to find out how many words it contains: ");
        String str = scan.nextLine();
        char ch[] = new char[str.length()];
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
            if (((i > 0) && (ch[i] != ' ') && (ch[i - 1] == ' ')) || ((ch[0] != ' ') && (i == 0))) {
                count++;
            }
        }
        System.out.println("========== " + count + " words ========== ");
    }



    public static void ex3(Scanner scan) {
        System.out.print("Enter a string to reverse it : ");
        String str = scan.nextLine();
        char ch[] = str.toCharArray();
        String rev = "";
        for (int i = ch.length - 1; i >= 0; i--) {
            rev += ch[i];
        }
        System.out.print("reversed string: " + rev);
    }


    public static void ex4(Scanner scan) {
        System.out.print("Enter a Roman numeral: ");
        String roman = scan.nextLine();
        int result = 0;
        int current = 0;
        int previous = 0;
        char ch = 0;
        for (int i = roman.length() - 1; i >= 0; i--) {
            ch = roman.charAt(i);
            switch (ch) {
                case 'I':
                    current = 1;
                    break;
                case 'V':
                    current = 5;
                    break;
                case 'X':
                    current = 10;
                    break;
                case 'L':
                    current = 50;
                    break;
                case 'C':
                    current = 100;
                    break;
                case 'D':
                    current = 500;
                    break;
                case 'M':
                    current = 1000;
                    break;
            }
            if (current >= previous) {
                result += current;
            } else {
                result -= current;
            }
            previous = current;
        }
        System.out.println("Integer value: " + result);
    }

    public static void ex5(Scanner scan) {
        System.out.print("Enter a message to encrypt: ");
        String message = scan.nextLine();
        System.out.print("Enter a key (1-25): ");
        int key = scan.nextInt();
        scan.close();
        StringBuilder encrypted = new StringBuilder();

        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                encrypted.append((char) ((c - base + key) % 26 + base));
            } else {
                encrypted.append(c);
            }
        }

        System.out.println("The encrypted message is: " + encrypted.toString());

    }

    public static void ex5Decrypter(Scanner scan) {

        System.out.println("===========DECRYPT===========");
        System.out.print("Enter a message you want to decrypt: ");
        String message = scan.nextLine();
        System.out.print("Enter a key (1-25): ");
        int key = scan.nextInt();
        scan.close();

        StringBuilder decrypted = new StringBuilder();

        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                decrypted.append((char) ((c - base - key + 26) % 26 + base));
            } else {
                decrypted.append(c);
            }
        }
        System.out.println("The decrypted message is: " + decrypted.toString());

    }

    public static void bruteForceDecrypter(Scanner scan) {
        System.out.println("========BRUTEFORCE========");
        System.out.print("Enter the encrypted text: ");
        String encryptedText = scan.nextLine();
        System.out.print("Enter the known word: ");
        String knownWord = scan.nextLine();

        for (int shift = 1; shift <= 26; shift++) {
            String decrypted = "";

            for (char c : encryptedText.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    int shifted = (c - 'A' - shift + 26) % 26;
                    decrypted += (char)(shifted + 'A');
                } else if (c >= 'a' && c <= 'z') {
                    int shifted = (c - 'a' - shift + 26) % 26;
                    decrypted += (char)(shifted + 'a');
                } else {
                    decrypted += c;
                }
            }

            if (decrypted.contains(knownWord)) {
                System.out.println("Shift value: " + shift);
                System.out.println("Decrypted text: " + decrypted);
            }
            else {
                System.out.println("Can't find the encryption pattern for your given known word. TRY AGAIN !");
                break;
            }
        }
    }
}





