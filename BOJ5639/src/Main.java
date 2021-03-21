import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String value = br.readLine();
		
		Node root = new Node(Integer.parseInt(value));
		String str = "";
		
		while((str = br.readLine()) != null && str.length() != 0) {
			Node node = new Node(Integer.parseInt(str));
			insert(root, node);
		}
		
		postOrder(root);

	}
	
	public static void insert(Node root, Node node) {
		if(node.value < root.value) {
			if(root.left == null) root.left = node;
			else insert(root.left, node);
		}
		else {
			if(root.right == null) root.right = node;
			else insert(root.right, node);
		}
	}
	
	public static void postOrder(Node node) {
		if(node.left != null) postOrder(node.left);
		if(node.right != null) postOrder(node.right);
		System.out.println(node.value);
	}
	
	public static class Node {
		Node left;
		Node right;
		int value;
		
		Node (int value) {
			this.value = value;
		}
	}

}
