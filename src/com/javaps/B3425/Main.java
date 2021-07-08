package com.javaps.B3425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

final class Commands {
    final static String NUM = "NUM";
    final static String POP = "POP";
    final static String INV = "INV";
    final static String DUP = "DUP";
    final static String SWP = "SWP";
    final static String ADD = "ADD";
    final static String SUB = "SUB";
    final static String MUL = "MUL";
    final static String DIV = "DIV";
    final static String MOD = "MOD";
    final static String END = "END";
    final static String QUIT = "QUIT";
}


class MMain {
    static int INF;
    static boolean end;
    static int n;
    static boolean errorFlag = false;
    static ArrayList<String> commandList = new ArrayList<>();
    static ArrayList<Integer> commandNum = new ArrayList<>();
    static Deque<Integer> deque = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        INF = (int) Math.pow(10, 9);
        while (true) {
            commandList.clear();
            commandNum.clear();
            while (true) {
                String[] t = br.readLine().split(" ");
                if (t[0].equals(Commands.QUIT)) {
                    System.out.println(sb);
                    return;
                }
                if (t[0].equals(Commands.END)) {
                    break;
                }
                if (t.length == 1) {
                    commandList.add(t[0]);
                } else {
                    commandList.add(t[0]);
                    commandNum.add(Integer.parseInt(t[1]));
                }
            }
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                errorFlag = false;
                deque.clear();
                int tmp = Integer.parseInt(br.readLine());
                deque.push(tmp);

                solve();
                if (errorFlag || deque.size() != 1) {
                    sb.append("ERROR\n");
                } else {
                    sb.append(deque.removeFirst() + "\n");
                }
            }
            sb.append("\n");
            String[] str = br.readLine().split("");
        }
    }

    public static void solve() {
        int commandNum_cnt = 0;
        for (int i = 0; i < commandList.size(); i++) {
            String order = commandList.get(i);
            if (order.equals(Commands.NUM)) {
                deque.addLast(commandNum.get(commandNum_cnt));
                commandNum_cnt++;
            }
            if (order.equals(Commands.POP)) {
                if (deque.size() == 0) {
                    errorFlag = true;
                    break;
                }
                deque.removeLast();
            }
            if (order.equals(Commands.INV)) {
                if (deque.size() == 0) {
                    errorFlag = true;
                    break;
                }
                int tmp = deque.removeLast();
                tmp *= -1;
                deque.addLast(tmp);
            }
            if (order.equals(Commands.DUP)) {
                if (deque.size() == 0) {
                    errorFlag = true;
                    break;
                }
                int tmp = deque.getLast();
                deque.addLast(tmp);
            }
            if (order.equals(Commands.SWP)) {
                if (deque.size() < 2) {
                    errorFlag = true;
                    break;
                }
                int first = deque.removeLast();
                int second = deque.removeLast();

                deque.addLast(first);
                deque.addLast(second);
            }
            if (order.equals(Commands.ADD)) {
                if (deque.size() < 2) {
                    errorFlag = true;
                    break;
                }
                long first = deque.removeLast();
                long second = deque.removeLast();
                long sum = first + second;
                if (sum > INF || sum < INF * -1) {
                    errorFlag = true;
                    break;
                }
                deque.addLast((int) sum);
            }
            if (order.equals(Commands.SUB)) {
                if (deque.size() < 2) {
                    errorFlag = true;
                    break;
                }
                long first = deque.removeLast();
                long second = deque.removeLast();
                long sub = second - first;
                if (sub > INF || sub < INF * -1) {
                    errorFlag = true;
                    break;
                }
                deque.addLast((int) sub);
            }
            if (order.equals(Commands.MUL)) {
                if (deque.size() < 2) {
                    errorFlag = true;
                    break;
                }
                long first = deque.removeLast();
                long second = deque.removeLast();
                long mul = second * first;
                if (mul > INF || mul < INF * -1) { //mul > max_cal도 고려
                    errorFlag = true;
                    break;
                }
                deque.addLast((int) mul);
            }
            if (order.equals(Commands.DIV)) {
                if (deque.size() < 2) {
                    errorFlag = true;
                    break;
                }
                int minus_cnt = 0;    // 음수 가리는 여부
                long first = deque.removeLast();
                long second = deque.removeLast();
                if (first < 0) {
                    minus_cnt++;
                }
                if (second < 0) {
                    minus_cnt++;
                }
                if (first == 0) {
                    errorFlag = true;
                    break;
                }
                long div = Math.abs(second) / Math.abs(first);

                if (minus_cnt == 1) {
                    deque.addLast((int) div * -1);
                } else {
                    deque.addLast((int) div);
                }
            }
            if (order.equals(Commands.MOD)) {
                if (deque.size() < 2) {
                    errorFlag = true;
                    break;
                }
                long first = deque.removeLast();
                long second = deque.removeLast();
                if (first == 0) {
                    errorFlag = true;
                    break;
                }
                long mod = Math.abs(second) % Math.abs(first);
                if (second < 0) {
                    mod *= -1;
                }
                deque.addLast((int) mod);
            }
        }
    }
}

public class Main {

    public static ArrayList<String> commandsLogic = new ArrayList<>();
    public static ArrayList<String> print = new ArrayList<>();
    public static Stack<Integer> stack = new Stack<>();
    public static int INF = (int) Math.pow(10, 9);


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase;
        while (true) {
            String command = br.readLine();
            if (command.equals(Commands.QUIT)) break;
            if (command.equals(Commands.END)) {
                testCase = Integer.parseInt(br.readLine());
                for (int i = 0; i < testCase; i++) {
                    int value = Integer.parseInt(br.readLine());
                    if (logic(value)) System.out.println(stack.peek());
                    else System.out.println("ERROR");
                }
                commandsLogic.clear();
                System.out.println();
            }
            if (command.contains(Commands.NUM)) {
                String[] numCommands = command.split(" ");
                commandsLogic.add(numCommands[0]);
                commandsLogic.add(numCommands[1]);
            } else {
                commandsLogic.add(command);
            }
        }

    }

    public static boolean logic(int value) {
        stack.clear();
        stack.push(value);
        for (int i = 0; i < commandsLogic.size(); i++) {
            String command = commandsLogic.get(i);
            if (command.equals(Commands.NUM)) {
                stack.push(Integer.valueOf(commandsLogic.get(i + 1)));
                i++;
            } else if (command.equals(Commands.POP)) {
                if (stack.isEmpty()) return false;
                else stack.pop();
            } else if (command.equals(Commands.INV)) {
                if (stack.isEmpty()) return false;
                else {
                    int peek = stack.pop();
                    stack.push(peek * -1);
                }
            } else if (command.equals(Commands.DUP)) {
                if (stack.isEmpty()) return false;
                else {
                    stack.push(stack.peek());
                }
            } else if (command.equals(Commands.SWP)) {
                if (stack.size() < 2) return false;
                else {
                    int tmpA = stack.pop();
                    int tmpB = stack.pop();
                    stack.push(tmpA);
                    stack.push(tmpB);
                }
            } else if (command.equals(Commands.ADD)) {
                if (stack.size() < 2) return false;
                else {
                    long tmpA = stack.pop();
                    long tmpB = stack.pop();
                    long result = tmpA + tmpB;
                    if (result > INF || Math.abs(result) > INF) return false;
                    stack.push((int) result);
                }
            } else if (command.equals(Commands.SUB)) {
                if (stack.size() < 2) return false;
                else {
                    long tmpA = stack.pop();
                    long tmpB = stack.pop();
                    long result = tmpB - tmpA;
                    if (result > INF || Math.abs(result) > INF) return false;
                    stack.push((int) result);
                }
            } else if (command.equals(Commands.MUL)) {
                if (stack.size() < 2) return false;
                else {
                    long tmpA = stack.pop();
                    long tmpB = stack.pop();
                    long result = tmpA * tmpB;
                    if (result > INF || Math.abs(result) > INF) return false;
                    stack.push((int) result);
                }
            } else if (command.equals(Commands.DIV)) {
                if (stack.size() < 2) return false;
                else {
                    long tmpA = stack.pop();
                    long tmpB = stack.pop();
                    if (tmpA == 0 || tmpB == 0) return false;
                    boolean aIsPositive = tmpA < 0;
                    boolean bIsPositive = tmpB < 0;
                    tmpA = Math.abs(tmpA);
                    tmpB = Math.abs(tmpB);
                    long result = tmpB / tmpA;
                    if ((aIsPositive && !bIsPositive) || (!aIsPositive && bIsPositive)) result *= -1;
                    if (result > INF || Math.abs(result) > INF) return false;
                    stack.push((int) result);
                }
            } else if (command.equals(Commands.MOD)) {
                if (stack.size() < 2) return false;
                else {
                    long tmpA = stack.pop();
                    long tmpB = stack.pop();
                    if (tmpA == 0 || tmpB == 0) return false;
                    boolean aIsPositive = tmpA < 0;
                    boolean bIsPositive = tmpB < 0;
                    tmpA = Math.abs(tmpA);
                    tmpB = Math.abs(tmpB);
                    long result = tmpB % tmpA;
                    if (result > INF || Math.abs(result) > INF) return false;
                    stack.push((int) result);
                }
            }
        }
        if (stack.size() != 1) return false;
        return true;
    }
}
