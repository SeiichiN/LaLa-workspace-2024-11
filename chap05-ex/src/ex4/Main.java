package ex4;

public class Main {

	public static void main(String[] args) {
		
		double bottom = 10.0;
		double height = 5.0;
		double triangle_area = calcTriangleArea(bottom, height);
		System.out.print("三角形の底辺の長さが" + bottom + "cm、");
		System.out.print("高さが" + height + "の場合、面積は");
		System.out.println(triangle_area + "平方cm");
		
		double radius = 5.0;
		double circle_area = calcCircleArea(radius);
		System.out.print("円の半径が" + radius + "の場合、面積は");
		System.out.println(circle_area + "平方cm");

	}

	public static double calcTriangleArea (double bottom, double height) {
		return bottom * height / 2.0;
	}
	
	public static double calcCircleArea (double radius) {
		return radius * radius * Math.PI;
	}
}
