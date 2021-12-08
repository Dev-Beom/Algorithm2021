package com.javaps.B3107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String rawAddress = br.readLine();

        String[] answer = new String[8];
        Arrays.fill(answer, "0000");

        if (rawAddress.contains("::")) {
            String[] splitString = {"", ""};
            int count = 0;
            for (String str : rawAddress.split("::")) {
                splitString[count++] = str;
            }
            String[] leftAddress = splitString[0].split(":");
            String[] rightAddress = splitString[1].split(":");
            for (int i = 0; i < leftAddress.length; i++) {
                answer[i] = getAddressBlock(leftAddress[i]);
            }
            int end = 7 - rightAddress.length;
            int idx = rightAddress.length - 1;
            for (int i = 7; i > end; i--) {
                answer[i] = getAddressBlock(rightAddress[idx--]);
            }
        } else {
            String[] address = rawAddress.split(":");
            for (int i = 0; i < address.length; i++) {
                answer[i] = getAddressBlock(address[i]);
            }
        }
        System.out.println(String.join(":", answer));
    }

    private static String getAddressBlock(String rawBlock) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4 - rawBlock.length(); i++) {
            sb.append("0");
        }
        sb.append(rawBlock);
        return sb.toString();
    }
}
