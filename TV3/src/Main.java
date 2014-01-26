import java.util.Random;

public class Main {
	public static void main(final String[] args){
		double[] x=new double[100000];
		double[] y=new double[100000];
		int n = 0;
		Random r=new Random();
		for(int i=0;i< x.length;i++){
			x[i]=forX(r.nextDouble())*2;
			y[i]=forX(r.nextDouble())/2;
			if(x[i] == 2*y[i])
				n++; 
				
		}
		System.out.println(n/x.length);
		
		System.out.println("Мат. очікування х=" + mean(x));
		System.out.println("Мат. очікування у=" + mean(y));
		System.out.println("Дисперсія х=" + Math.pow(dispertion(x),2));
		System.out.println("Дисперсія у=" + Math.pow(dispertion(y),2));
		System.out.println("Середнє квадратичне відхилення х=" + dispertion(x));
		System.out.println("Середнє квадратичне відхилення у=" + dispertion(y));
		System.out.println("Кореляція=" + corel(1,1,x,y));
	}
	
	static double mean(double[] n){
		double Sum=0.0;
		double m=0.0;
		for(int i=0; i<= n.length-1;i++){
			Sum+=n[i];
		}
		m = Sum/n.length;
		return m;
	}
	static double cov(double xx,double yy,double[] x,double[] y){
		double n = 0;
		for(int i=0; i< 1000;i++){
			n+=(x[i]-mean(x))*(y[i]-mean(y));
		}
		n=n/1000;
		return n;
	}
	static double corel(double xx,double yy,double[] x,double[] y){
		return cov(xx,yy,x,y)/(dispertion(x)*dispertion(y));
	}
	
static double dispertion(double[] r){
		double v=0;
		double m=mean(r);
		for(int i=0; i<= r.length-1;i++){
			v+=Math.pow((r[i]-m), 2);
		}
		v=v/r.length;
		return Math.sqrt(v);
	}
	
// Генерація
	static double forX(double r){
		return r;
	}
}
