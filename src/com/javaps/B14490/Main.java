package com.javaps.B14490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(":");
        int[] nums = new int[2];
        nums[0] = Integer.parseInt(strings[0]);
        nums[1] = Integer.parseInt(strings[1]);
        int min = Math.min(nums[0], nums[1]);
        int max = Math.max(nums[0], nums[1]);
        for (int i = min; i >= 0; i--) {
            if (min % i == 0 && max % i == 0) {
                System.out.println((nums[0] / i) + ":" + (nums[1] / i));
                return;
            }
        }
    }
}
