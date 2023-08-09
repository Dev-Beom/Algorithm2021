package com.javaps.B20055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ConveyorBelt {
    private int currentRobotId = 0;
    List<Block> blocks;
    final int upPosition = 0;
    int downPosition;
    int limitOfMaxDurabilityBlocks;
    int countOfMaxDurabilityBlocks = 0;

    int count = 0;

    ConveyorBelt(int[] durability, int downPosition, int limitOfMaxDurabilityBlocks) {
        blocks = Arrays.stream(durability).mapToObj(Block::new).collect(Collectors.toList());
        this.downPosition = downPosition;
        this.limitOfMaxDurabilityBlocks = limitOfMaxDurabilityBlocks;
    }

    public void execute() {
        while (limitOfMaxDurabilityBlocks > countOfMaxDurabilityBlocks) {
            count++;
            rotation();
            moveRobots();
            upRobot();
        }
        System.out.println(count);
    }

    private void upRobot() {
        Block upPositionBlock = blocks.get(upPosition);
        if (upPositionBlock.getDurability() > 0) {
            upPositionBlock.setRobot(new Robot(currentRobotId++));
            upPositionBlock.decreaseDurability();
            if (upPositionBlock.getDurability() == 0) countOfMaxDurabilityBlocks++;
        }
    }

    private void downRobot() {
        Block downPositionBlock = blocks.get(downPosition);
        downPositionBlock.setRobot(null);
    }

    private void rotation() {
        Block lastBlock = blocks.get(blocks.size() - 1);
        List<Block> subList = blocks.subList(0, blocks.size() - 1);
        blocks = Stream.concat(Stream.of(lastBlock), subList.stream()).collect(Collectors.toList());
        downRobot();
    }

    private void moveRobots() {
        for (int i = blocks.size() - 1; i > 0; i--) {
            Robot currentRobot = blocks.get(i).getRobot();
            if (currentRobot != null && isNotNextRobot(i) && isNextDurabilityActive(i)) {
                int nextIndex = i + 1 == blocks.size() ? 0 : i + 1;
                blocks.get(nextIndex).setRobot(currentRobot);
                blocks.get(i).setRobot(null);
                blocks.get(nextIndex).decreaseDurability();
                if (blocks.get(nextIndex).getDurability() == 0) countOfMaxDurabilityBlocks++;
            }
        }
        downRobot();
    }

    private boolean isNotNextRobot(int currentIndex) {
        int nextIndex = (currentIndex + 1) % blocks.size();
        return blocks.get(nextIndex).getRobot() == null;
    }

    private boolean isNextDurabilityActive(int currentIndex) {
        int nextIndex = (currentIndex + 1) % blocks.size();
        return blocks.get(nextIndex).getDurability() >= 1;
    }
}

class Block {
    private int durability;
    private Robot robot;

    Block(int durability) {
        this.durability = durability;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public void decreaseDurability() {
        this.durability--;
    }

    public int getDurability() {
        return durability;
    }

    public Robot getRobot() {
        return robot;
    }

    @Override
    public String toString() {
        String s1 = "내구: " + this.durability;
        String s2 = "로봇: " + (this.robot == null ? "x" : robot.getId());
        return s1 + "/" + s2 + "\t";
    }
}

class Robot {
    private final int id;

    Robot(int id) {
        this.id = id;
    }

    int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] durability = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ConveyorBelt conveyorBelt = new ConveyorBelt(durability, N - 1, K);
        conveyorBelt.execute();
    }
}
