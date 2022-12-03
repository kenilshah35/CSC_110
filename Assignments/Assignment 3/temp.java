import java.util.*;

public class temp{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		double b=0,sum=0;
		
		for(int i=1;i<=5;i++){
			
			System.out.print("#"+i+" ==>");
			b = sc.nextDouble();
				
				do{
					if(b>10 || b<0){
						System.out.println("	wrong input");
						System.out.print("#"+i+" ==>");
						b = sc.nextDouble();
					}
					
				}while(b>10 || b<0);
			
			sum += b;
		}
		System.out.printf("%5.2f\n",sum);
	}
}