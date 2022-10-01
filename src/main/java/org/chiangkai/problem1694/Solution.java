package org.chiangkai.problem1694;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChiangKai
 * @date 2022/10/1
 */
class Solution {
    public String reformatNumber(String number) {
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != ' ' && number.charAt(i) != '-') {
                characterList.add(number.charAt(i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (characterList.size() == 2) {
            return stringBuilder.append(characterList.get(0)).append(characterList.get(1)).toString();
        }
        int remained = characterList.size() % 3;
        switch (remained) {
            case 0: {
                for (int i = 1; i <= characterList.size(); i++) {
                    stringBuilder.append(characterList.get(i-1));
                    if (i % 3 == 0 && i != characterList.size()) {
                        stringBuilder.append('-');
                    }
                }
                break;
            }
            case 1: {
                for (int i = 1; i <= characterList.size(); i++) {
                    stringBuilder.append(characterList.get(i-1));
                    if (i == characterList.size() - 2) {
                        stringBuilder.append('-');
                    } else if (i == characterList.size()) {
                        break;
                    } else if (i % 3 == 0 && i + 3 < characterList.size()) {
                        stringBuilder.append('-');
                    }
                }
                break;
            }
            default: {
                if (characterList.size() == 4){
                    stringBuilder
                            .append(characterList.get(0))
                            .append(characterList.get(1))
                            .append('-')
                            .append(characterList.get(2))
                            .append(characterList.get(3));
                    break;
                }
                for (int i = 1; i <= characterList.size(); i++) {
                    stringBuilder.append(characterList.get(i-1));
                    if (i == characterList.size() - 2) {
                        stringBuilder.append('-');
                    }  else if (i == characterList.size()) {
                        break;
                    } else if (i % 3 == 0 && i + 3 < characterList.size()) {
                        stringBuilder.append('-');
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
