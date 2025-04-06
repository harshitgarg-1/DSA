/**
 * A network router implementation that handles packet routing, storage and retrieval.
 * This class manages a queue of network packets with memory limits and provides
 * functionality for adding, forwarding, and querying packets.
 */
class Router {
    /**
     * Represents a network packet with source, destination, and timestamp information.
     */
    static class Packet {
        private final int sourceId;
        private final int destinationId;
        private final int timestamp;
        
        /**
         * Constructs a new packet with the specified attributes.
         *
         * @param sourceId      The source identifier
         * @param destinationId The destination identifier
         * @param timestamp     The time when the packet was created
         */
        public Packet(int sourceId, int destinationId, int timestamp) {
            this.sourceId = sourceId;
            this.destinationId = destinationId;
            this.timestamp = timestamp;
        }
        
        /**
         * Checks if this packet equals another object.
         *
         * @param obj The object to compare with
         * @return true if the objects are equal, false otherwise
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Packet)) return false;
            Packet packet = (Packet) obj;
            return sourceId == packet.sourceId && 
                   destinationId == packet.destinationId && 
                   timestamp == packet.timestamp;
        }
        
        /**
         * Generates a hash code for this packet.
         *
         * @return The hash code
         */
        @Override
        public int hashCode() {
            return Objects.hash(sourceId, destinationId, timestamp);
        }
    }
    
    private int availableMemory;
    private final Queue<Packet> packetQueue;
    private final Set<Packet> packetSet;
    private final Map<Integer, List<Packet>> destinationToPacketsMap;
    
    /**
     * Constructs a new router with the specified memory limit.
     *
     * @param memoryLimit The maximum number of packets that can be stored
     */
    public Router(int memoryLimit) {
        this.availableMemory = memoryLimit;
        this.packetQueue = new LinkedList<>();
        this.packetSet = new HashSet<>();
        this.destinationToPacketsMap = new HashMap<>();
    }
    
    /**
     * Adds a new packet to the router if it doesn't already exist.
     * If the router is at memory capacity, the oldest packet is removed.
     *
     * @param source      The source identifier
     * @param destination The destination identifier
     * @param timestamp   The timestamp of the packet
     * @return true if the packet was added, false if it already exists
     */
    public boolean addPacket(int source, int destination, int timestamp) {
        Packet newPacket = new Packet(source, destination, timestamp);
        
        // Check if the packet already exists
        if (packetSet.contains(newPacket)) {
            return false;
        }
        
        // Handle memory constraints
        if (availableMemory > 0) {
            availableMemory--;
        } else {
            // Remove the oldest packet
            Packet oldestPacket = packetQueue.remove();
            packetSet.remove(oldestPacket);
            
            // Update destination mapping
            List<Packet> packetsForDestination = destinationToPacketsMap.get(oldestPacket.destinationId);
            if (packetsForDestination != null) {
                packetsForDestination.remove(0);
                if (packetsForDestination.isEmpty()) {
                    destinationToPacketsMap.remove(oldestPacket.destinationId);
                }
            }
        }
        
        // Add the new packet
        packetQueue.add(newPacket);
        packetSet.add(newPacket);
        
        // Update destination mapping
        destinationToPacketsMap.computeIfAbsent(destination, k -> new ArrayList<>())
                             .add(newPacket);
        
        return true;
    }
    
    /**
     * Forwards the oldest packet in the queue.
     *
     * @return An array containing [source, destination, timestamp] of the forwarded packet,
     *         or an empty array if the queue is empty
     */
    public int[] forwardPacket() {
        if (packetQueue.isEmpty()) {
            return new int[]{};
        }
        
        // Remove and get the oldest packet
        Packet packet = packetQueue.remove();
        int[] packetData = {packet.sourceId, packet.destinationId, packet.timestamp};
        
        // Update data structures
        packetSet.remove(packet);
        
        List<Packet> packetsForDestination = destinationToPacketsMap.get(packet.destinationId);
        if (packetsForDestination != null) {
            packetsForDestination.remove(0);
            if (packetsForDestination.isEmpty()) {
                destinationToPacketsMap.remove(packet.destinationId);
            }
        }
        
        // Restore memory
        availableMemory++;
        
        return packetData;
    }
    
    /**
     * Counts packets with a specific destination within a time range.
     *
     * @param destination The destination identifier
     * @param startTime   The start of the time range (inclusive)
     * @param endTime     The end of the time range (inclusive)
     * @return The number of matching packets
     */
    public int getCount(int destination, int startTime, int endTime) {
        List<Packet> packetsForDestination = destinationToPacketsMap.get(destination);
        
        // Handle case when no packets exist for this destination
        if (packetsForDestination == null || packetsForDestination.isEmpty()) {
            return 0;
        }
        
        // Use binary search to find packets within the time range efficiently
        int lowerBoundIndex = findLowerBound(packetsForDestination, startTime);
        int upperBoundIndex = findUpperBound(packetsForDestination, endTime);
        
        return upperBoundIndex - lowerBoundIndex;
    }
    
    /**
     * Finds the index of the first packet with a timestamp greater than or equal to the given time.
     *
     * @param packets  The list of packets
     * @param time     The target time
     * @return The index of the first packet that meets the criteria
     */
    private int findLowerBound(List<Packet> packets, int time) {
        int left = 0;
        int right = packets.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (packets.get(mid).timestamp >= time) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    /**
     * Finds the index of the first packet with a timestamp greater than the given time.
     *
     * @param packets  The list of packets
     * @param time     The target time
     * @return The index of the first packet that meets the criteria
     */
    private int findUpperBound(List<Packet> packets, int time) {
        int left = 0;
        int right = packets.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (packets.get(mid).timestamp > time) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}