import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Node[] node = new Node[N + 66];
		
		for(int i = 65; i <= N + 65; i++) {
			node[i] = new Node(null, null, (char) i);
		}
		
		for(int i = 1; i <= N; i++) {
			char[] ch = br.readLine().toCharArray();
			
			if(ch[2] != '.') node[ch[0]].left = node[ch[2]];
			if(ch[4] != '.') node[ch[0]].right = node[ch[4]];
		}
		
		preorder(node[65]);
		System.out.println();
		inorder(node[65]);
		System.out.println();
		postorder(node[65]);

	}
	
	public static void preorder(Node node) {
		System.out.print(node.value);
		if(node.left != null) preorder(node.left);
		if(node.right != null) preorder(node.right);
	}
	
	public static void inorder(Node node) {
		if(node.left != null) inorder(node.left);
		System.out.print(node.value);
		if(node.right != null) inorder(node.right);
	}
	
	public static void postorder(Node node) {
		if(node.left != null) postorder(node.left);
		if(node.right != null) postorder(node.right);
		System.out.print(node.value);
	}
	
	public static class Node {
		Node left;
		Node right;
		char value;
		
		Node(Node left, Node right, char value) {
			this.left = left;
			this.right = right;
			this.value = value;
		}
	}

}
