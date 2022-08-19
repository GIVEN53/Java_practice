import java.util.*;

public class TreeBFS {
    public static void main(String[] args) {
        Solution40.tree root = new Solution40.tree("1");
        Solution40.tree rootChild1 = root.addChildNode(new Solution40.tree("2"));
        Solution40.tree rootChild2 = root.addChildNode(new Solution40.tree("3"));
        Solution40.tree leaf1 = rootChild1.addChildNode(new Solution40.tree("4"));
        Solution40.tree leaf2 = rootChild1.addChildNode(new Solution40.tree("5"));

        ArrayList<String> output = Solution40.bfs(root);
        System.out.println(output);

        leaf1.addChildNode(new Solution40.tree("6"));
        rootChild2.addChildNode(new Solution40.tree("7"));
        output = Solution40.bfs(root);
        System.out.println(output);
    }
}

// tree를 구성하는 노드 중 하나의 Node 객체를 입력받아 해당 노드를 시작으로 BFS.
// 이 때 순서대로 노드의 값이 저장된 ArrayList 리턴
class Solution40 {
    public static ArrayList<String> bfs(tree node) {
        ArrayList<String> result = new ArrayList<>();

        Queue<tree> queue = new LinkedList<>();
        queue.add(node); // 첫 노드 추가

        while (queue.size() > 0) {
            tree getNode = queue.poll(); // 맨 앞 노드 꺼냄

            result.add(getNode.getValue());
            if(getNode.getChildrenNode() != null) { // 자식 노드 있으면 전부 추가
                queue.addAll(getNode.getChildrenNode());
            }
        }
        return result;
    }

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

        public String getValue() { //현재 노드의 데이터를 반환
            return value;
        }

        public ArrayList<tree> getChildrenNode() {
            return children;
        }
    }
}
