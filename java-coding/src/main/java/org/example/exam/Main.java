package org.example.exam;

import java.util.TreeSet;

class ExamRoom {
    private int n;
    private TreeSet<Integer> seats;

    public ExamRoom(int n) {
        this.n = n;
        seats = new TreeSet<>();
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }

        int prev = -1;
        int maxDist = 0;
        int seatToSit = 0;

        // Check distance from 0 to the first seat
        if (!seats.contains(0)) {
            int dist = seats.first();
            if (dist > maxDist) {
                maxDist = dist;
                seatToSit = 0;
            }
        }

        // Check distances between occupied seats
        for (int seat : seats) {
            if (prev != -1) {
                int dist = (seat - prev) / 2;
                if (dist > maxDist) {
                    maxDist = dist;
                    seatToSit = prev + dist;
                }
            }
            prev = seat;
        }

        // Check distance from last seat to the end
        if (!seats.contains(n - 1)) {
            int dist = n - 1 - seats.last();
            if (dist > maxDist) {
                seatToSit = n - 1;
            }
        }

        seats.add(seatToSit);
        return seatToSit;
    }

    public void leave(int p) {
        seats.remove(p);
    }
}

public class Main {
    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        System.out.println(examRoom.seat()); // 0
        System.out.println(examRoom.seat()); // 9
        System.out.println(examRoom.seat()); // 4
        System.out.println(examRoom.seat()); // 2
        examRoom.leave(4);
        System.out.println(examRoom.seat()); // 5
    }
}
