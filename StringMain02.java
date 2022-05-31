package lesson01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringMain02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("введите строку, выражение типа: 2 + 2");
        String str = sc.nextLine();
        String[] spl = str.split("\s+");
        HashMap<String, Integer> map = generateStrIntMap();

        int x1 = 0;
        int x2 = 0;
        boolean isRimskie = false;
        if (map.containsKey(spl[0]) & map.containsKey(spl[2])){
            System.out.println("введены римские цифры");
            x1 = map.get(spl[0]);
            x2 = map.get(spl[2]);
            isRimskie = true;
        }else{
            System.out.println("введены не римские цифры");
            x1 = Integer.parseInt(spl[0]);
            x2 = Integer.parseInt(spl[2]);
        }

        int result = 0;

        if (spl[1].equals("+")) {
            result = x1 + x2;
        } else if (spl[1].equals("-")) {
            result = x1 - x2;
        }
        else if (spl[1].equals("*")) {
            result = x1 * x2;
        }
        else if (spl[1].equals("/")) {
            result = x1 / x2;
        }
        else {
            throw new UnsupportedOperationException("operation " + spl[1] + " not supported");
        }

        if (isRimskie){
            System.out.println("результат " + numberToRimskie(result));
        }else{
            System.out.println("результат " + result);
        }
    }


    public static String numberToRimskie(int x){
        if ((x<=0) | (x>100)){
            throw new UnsupportedOperationException("number " + x);
        }
        if (x==100){
            return "C";
        }
        String str = "";
        if (x>=50){
            x = x - 50;
            str = str + "L";
        }

        if (x>=10){
            int t = x / 10;
            x = x - (t *10);
            for (int i = 0; i < t; i++){
                str = str + "X";
            }
        }

        HashMap<Integer, String> integerStringMap = integerStringMap();
        if (integerStringMap.containsKey(x)){
            str = str + integerStringMap.get(x);
        }

        return str;
    }


    public static HashMap<Integer, String> integerStringMap(){
        HashMap<String, Integer> map = generateStrIntMap();
        HashMap<Integer, String> integerStringMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            integerStringMap.put(entry.getValue(), entry.getKey());
        }
        return integerStringMap;
    }



    public static HashMap<String, Integer> generateStrIntMap(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);
        return map;
    }
    }
