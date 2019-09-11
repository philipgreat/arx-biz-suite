```
package com.doublechain.bank;

public class MathTest {

	
	public static double toAngle(double radius) {
		return radius*(180/Math.PI);
	}
	
	public static double toRadius(double angle) {
		return angle/(180/Math.PI);
	}
	
	public static void rotate(double x, double y, double rotateAngle) {
		
		double initAngle = Math.atan(x/y)*(180/Math.PI);
		
		//System.out.printf("%f\n",initAngle);
		
		//System.out.printf("%f\n",Math.cos(toRadius(45)));
		
		//System.out.printf("toAngle(rotateAngle) %f\n",toRadius(rotateAngle));
		//System.out.printf("%f\n",Math.cos(toRadius(initAngle)+toRadius(rotateAngle)));
		
		double newY = Math.sqrt(x*x+y*y)*Math.cos(toRadius(initAngle+rotateAngle));
		double newX = Math.sqrt(x*x+y*y)*Math.sin(toRadius(initAngle+rotateAngle));
		
		System.out.printf("rotate %f: (%f,%f)\n",rotateAngle,newX,newY);
	}
	
	
	public static void main(String[] args) {
		
		for(int i=45;i<=360;i+=1) {
			rotate(1,1,(double)i);
		}
		
		
		
		
	}

}

```
