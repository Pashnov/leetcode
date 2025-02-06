package org.axp.medium;

import java.util.LinkedList;
import java.util.List;

public class _443_StringCompression {

    public static void main(String[] args) {
//        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c'}));
//        System.out.println(6);

//        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
//        System.out.println(6);

        System.out.println(compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
        System.out.println(4);
    }

    public static int compress(char[] chars) {
        List<Tuple> list = new LinkedList<>();
        int count = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i+1]) {
                count++;
            } else {
                list.add(new Tuple(chars[i], count));
                count = 1;
            }
        }
        list.add(new Tuple(chars[chars.length - 1], count));

        List<Character> listC = new LinkedList<>();
        for (Tuple tuple : list) {
            listC.add(tuple.symbol);
            if (tuple.count > 1) {
                for (char aChar : toChars(tuple.count)) {
                    listC.add(aChar);
                }
            }
        }
        int index = 0;
        for (Character c : listC) {
            chars[index++] = c;
        }
        return listC.size();
    }

    private static char[] toChars(int count) {
        return String.valueOf(count).toCharArray();
    }


    static class Tuple {
        char symbol;
        int count;

        public Tuple(char symbol, int count) {
            this.symbol = symbol;
            this.count = count;
        }
    }
}
