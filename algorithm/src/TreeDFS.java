import java.util.*;

public class TreeDFS {
    public static void main(String[] args) {
        Solution39.tree root = new Solution39.tree("1");
        Solution39.tree rootChild1 = root.addChildNode(new Solution39.tree("2"));
        Solution39.tree rootChild2 = root.addChildNode(new Solution39.tree("3"));
        Solution39.tree leaf1 = rootChild1.addChildNode(new Solution39.tree("4"));
        Solution39.tree leaf2 = rootChild1.addChildNode(new Solution39.tree("5"));

        ArrayList<String> output = Solution39.dfs(root);
        System.out.println(output);

        leaf1.addChildNode(new Solution39.tree("6"));
        rootChild2.addChildNode(new Solution39.tree("7"));
        output = Solution39.dfs(root);
        System.out.println(output);
    }
}

// tree를 구성하는 노드 중 하나의 Node 객체를 입력받아 해당 노드를 시작으로 DFS.
// 이 때 순서대로 노드의 값이 저장된 ArrayList 리턴
class Solution39 {
    public static ArrayList<String> dfs(tree node) {
        ArrayList<String> result = new ArrayList<>();

        Queue<tree> queue = new LinkedList<>();
        queue = getQueue(queue, node);

        while (queue.size() > 0) {
            tree getNode = queue.poll();
            result.add(getNode.getValue());
        }
        return result;
    }

    public static Queue<tree> getQueue(Queue<tree> queue, tree node) {
        queue.add(node); // 노드 큐에 추가
        if (node.getChildrenNode() == null) { // 자식 노드가 없으면 리턴
            return queue;
        }

        ArrayList<tree> child = node.getChildrenNode();
        for (int i = 0; i < child.size(); i++) {
            queue = getQueue(queue, child.get(i)); // 자식 노드들 재귀
        }
        return queue;
    }

    // 다른 풀이
    /*
    public static ArrayList<String> dfs(tree node) {
        ArrayList<String> result = new ArrayList<>();
        result.add(node.getValue());

        if (node.getChildrenNode() != null) {
            for(int i = 0; i < node.getChildrenNode().size(); i++) {
                ArrayList<String> childList = dfs(node.getChildrenNode().get(i));
                result.addAll(childList);
            }
        }
        return result;
    }
    */

    // 트리 구현 클래스
    public static class tree {
        private String value;
        private ArrayList<tree> children;

        public tree(String data) {
            this.value = data;
            this.children = null;
        }

        public tree addChildNode(tree node) {
            if(children == null) children = new ArrayList<>();
            children.add(node);
            return children.get(children.size() - 1);
        }

        public String getValue() { //현재 노드의 값을 반환
            return value;
        }

        public ArrayList<tree> getChildrenNode() {
            return children;
        }
    }
}
