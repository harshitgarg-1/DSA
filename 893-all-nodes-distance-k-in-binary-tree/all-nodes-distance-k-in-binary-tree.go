/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func distanceK(root *TreeNode, target *TreeNode, k int) []int {
    result := []int{}
    
    var dfs func(*TreeNode) int
    dfs = func(node *TreeNode) int {
        if node == nil {
            return -1
        }
        
        // If current node is target, find all nodes at distance k downwards
        if node == target {
            findNodesAtDistance(node, k, &result)
            return 0 // Distance from target to itself is 0
        }
        
        // Check left subtree
        leftDistance := dfs(node.Left)
        if leftDistance != -1 {
            // Target found in left subtree
            if leftDistance+1 == k {
                // Current node is at distance k from target
                result = append(result, node.Val)
            } else {
                // Find nodes in right subtree at distance k - leftDistance - 2
                findNodesAtDistance(node.Right, k-leftDistance-2, &result)
            }
            return leftDistance + 1
        }
        
        // Check right subtree
        rightDistance := dfs(node.Right)
        if rightDistance != -1 {
            // Target found in right subtree
            if rightDistance+1 == k {
                // Current node is at distance k from target
                result = append(result, node.Val)
            } else {
                // Find nodes in left subtree at distance k - rightDistance - 2
                findNodesAtDistance(node.Left, k-rightDistance-2, &result)
            }
            return rightDistance + 1
        }
        
        return -1 // Target not found in this subtree
    }
    
    dfs(root)
    return result
}

func findNodesAtDistance(node *TreeNode, distance int, result *[]int) {
    if node == nil || distance < 0 {
        return
    }
    
    if distance == 0 {
        *result = append(*result, node.Val)
        return
    }
    
    findNodesAtDistance(node.Left, distance-1, result)
    findNodesAtDistance(node.Right, distance-1, result)
}