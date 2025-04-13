class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        // hashmap to store current position of each person
        Map<Integer,Integer> position = new HashMap<>();
        for (int i=0; i<n; i++) {
            position.put(row[i], i);
        }

        // Greedily swap if couple is not present
        int swaps = 0;
        for (int i=0; i<=n-2; i+=2) {
            int person1 = row[i];
            int person2;
            if (person1 % 2 == 0) // 0 1 case
                person2 = person1 + 1;
            else // 1 0 case
                person2 = person1 - 1;
            
            // couple not forming, swap 
            if (row[i+1] != person2) {
                swaps++;
                int person2index = position.get(person2);
                // swap person2 with person at index i+1
                position.put(row[i+1], person2index);
                row[person2index] = row[i+1];

                position.put(person2, i+1);
                row[i+1] = person2;
            }
        }
        return swaps;
    }
}