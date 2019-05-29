package Jdbc;

public class Test {
	public static void main(String[] args) {
		int i,j;
		outer:
			for(i=1;i<3;i++) {
			inner:
				for(j=1;j<2;j++) {
				if(j==2) {
					continue outer;
					
				}
				System.out.println("i="+i+",j="+j);
			}
		}
	} 
}
