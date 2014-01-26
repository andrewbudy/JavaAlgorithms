import java.util.Random;

public class SystemsOfRandomNumbers {
	/**
	 * �������� ������
	 */
	private static final int n = 1000;

	
	public static void main(String[] args) {
		double[] arrayX = new double[n];
		double[] arrayY = new double[n];
		generateArrayX(arrayX);
		generateArrayY(arrayY, arrayX);
		System.out.println("\n mean X =  " + mean(arrayX));
		System.out.println("\n mean Y =  " + mean(arrayY));
		System.out.println("\n standart deviation X =  " + standartDeviation(arrayX));
		System.out.println("\n standart deviation Y =  " + standartDeviation(arrayY));
		System.out.println("\n correlation =  " + correlation(arrayX, arrayY));
	}
	
	
	
	/**
	 * ��������� ������ � x, ����������� �� ������� �������� ��������
	 * ��������� (�������� ������� �������)
	 * @param array
	 */
	public static void generateArrayX(double [] arrayX){
		double[] arrayRandoms = new double[n];
		generateRandom(arrayRandoms);
		for(int i = 0; i < arrayX.length; i++){
			arrayX[i] = (1 - Math.sqrt(1-arrayRandoms[i]));
		}
	}
	
	public static void generateArrayY(double[] arrayY, double[] arrayX){
		double[] arrayRandoms = new double[n];
		generateRandom(arrayRandoms);
		for(int i = 0; i < arrayX.length; i++){
			arrayY[i] = arrayRandoms[i]* (1-arrayX[i]);
		}
	}
	
	
	/**
	 * ����������� ����������.
	 * ���������� �� ������ �������� ������
	 * @param array ����� ������
	 * @return aver ����������� ���������� m
	 */
	public static double mean(double[] array){
		double Sum = 0.0;
		double aver = 0.0;
		for (int i = 0; i < array.length; i++){
			Sum += array[i]; 
		}
		aver = Sum/array.length;
		return aver;
	}
	
	/**
	 * ������������������� ��������� ��������� ��������
	 * @param array	������
	 * @return �������� �����
	 */
	public static double standartDeviation(double[] array){
		double disp = 0;
		for(int i = 0; i < array.length; i++) {
			disp += Math.pow((array[i] - mean(array)), 2);
		}
		disp = disp/array.length;
		return Math.sqrt(disp);	//����� - ����� �� �������
	}
	
	/**
	 * ��������� ������ ���� �������
	 * @param arrayX ������ X
	 * @param arrayY ������ Y
	 * @return cov
	 */
	public static double covariance(double[] arrayX, double[] arrayY){
		double cov = 0;
		for(int i = 0; i < arrayX.length; i++) {
			cov += (arrayX[i] - mean(arrayX)) * (arrayY[i] - mean(arrayY));
		}
		cov = cov/arrayX.length;
		return cov;
	}
	
	/**
	 * ���������� ���������
	 * @param arrayX ������ X
	 * @param arrayY ������ Y
	 * @return cor = cov/(sigmaX, sigmaY)
	 */
	public static double correlation(double[] arrayX, double[] arrayY){
		return covariance(arrayX, arrayY)/(standartDeviation(arrayX) * 
				standartDeviation(arrayY));
	}
	
	/**
	 * ������ ����� ��������� ����� �� ��������� [0, 1]
	 * @param array
	 */
	public static void generateRandom(double [] array){
		Random R = new Random();
		for (int i = 0; i < array.length; i++){
			array[i] = R.nextDouble();	
		}
	}
	

}
