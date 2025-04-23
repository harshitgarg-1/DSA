
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int[][] roomMoveTime = moveTime;  
        int totalRows = roomMoveTime.length;
        int totalCols = roomMoveTime[0].length;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        priorityQueue.offer(new int[]{0, 0, 0, 1});
        
        int[][] minimumArrivalTime = new int[totalRows][totalCols];
        for (int[] row : minimumArrivalTime) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minimumArrivalTime[0][0] = 0;

        int[][] adjacentDirections = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!priorityQueue.isEmpty()) {
            int[] currentState = priorityQueue.poll();
            int currentTime = currentState[0], currentRow = currentState[1], currentCol = currentState[2], currentStepCost = currentState[3];

            if (currentRow == totalRows - 1 && currentCol == totalCols - 1) {
                return currentTime;
            }

            for (int[] direction : adjacentDirections) {
                int nextRow = currentRow + direction[0];
                int nextCol = currentCol + direction[1];

                if (nextRow >= 0 && nextRow < totalRows && nextCol >= 0 && nextCol < totalCols) {
                    int waitTime = Math.max(roomMoveTime[nextRow][nextCol] - currentTime, 0);
                    int newArrivalTime = currentTime + currentStepCost + waitTime;
                    if (newArrivalTime < minimumArrivalTime[nextRow][nextCol]) {
                        minimumArrivalTime[nextRow][nextCol] = newArrivalTime;
                        int nextStepCost = (currentStepCost == 2) ? 1 : 2;
                        priorityQueue.offer(new int[]{newArrivalTime, nextRow, nextCol, nextStepCost});
                    }
                }
            }
        }

        return -1;
    }
}