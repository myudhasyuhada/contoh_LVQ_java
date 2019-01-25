import java.util.Arrays;

public class Lvq {
	private double learningRate;
    private final double minLearningRate;
    private final double maxEpoch;
    double euclideanApple; // apple 1
    double euclideanOrange; // orange -1
    double[] w1 = new double[2]; // target apple
    double[] w2 = new double[2]; // target orange
    
    public Lvq() {
    	//inisialisasi
        this.learningRate = 0.5;
        this.minLearningRate = 0.00001;
        this.maxEpoch = 10000;
        this.w1[0] = 3;
        this.w1[1] = 1;
        this.w2[0] = 7;
        this.w2[1] = 4;
    }

	public void train(int[] x1, int[] x2, int[] t) {
		// TODO Auto-generated method stub
		
		//inisial epoh
		int epoch = 1;
		
		//inisial learning rate;
		double ln = this.learningRate;
		
		//perulangan per epoh
		while(ln > this.minLearningRate && epoch <= this.maxEpoch){
			//perulangan per data
			for(int i = 0; i < x1.length; i++) {
				//untuk setiap data
				
				//hitung euclidean ke target
				this.euclideanApple = this.euclidean(x1[i], x2[i], w1);
				this.euclideanOrange = this.euclidean(x1[i], x2[i], w2);
				
				//ambil target dari data
				int targetSeharusnya = t[i];
				
				//tentukan target berdasarkan perhitungan euclidean
                int targetEuclidean;
                if(this.euclideanApple < this.euclideanOrange){
                    targetEuclidean = 1; //apple
                } else {
                    targetEuclidean = -1; //orange
                }
                
                //cek apakah target sama untuk menentukan persamaan bobot
                if(targetSeharusnya == targetEuclidean){
                    //update dengan +
                    if(targetEuclidean == 1){
                        //update bobot apple
                        w1 = this.updatePositif(ln, x1[i], x2[i], w1);
                    }
                    else{
                        //update bobot orange
                        w2 = this.updatePositif(ln, x1[i], x2[i], w2);
                    }
                }
                else{
                    //update dengan -
                    if(targetEuclidean == 1){
                        //update bobot apple
                    	w1 = this.updateNegatif(ln, x1[i], x2[i], w1);
                    }
                    else{
                        //update bobot orange
                    	w2 = this.updateNegatif(ln, x1[i], x2[i], w2);
                    }
                }
                System.out.println(Arrays.toString(w1));
    	        System.out.println(Arrays.toString(w2));
    	        System.out.println();
			}
			
			//tambah epoch
	        epoch++;
	        
	        //reduce learning rate
	        ln = this.learningRate * (1 - (epoch / this.maxEpoch));
//	        System.out.println(Arrays.toString(w1));
//	        System.out.println(Arrays.toString(w2));
//	        System.out.println();
//	        System.out.println("Progress Learning rate = "+ (epoch / this.maxEpoch));
		}
		
		System.out.println("Berhenti pada epoh ke : "+epoch);
		System.out.println("learning rate : "+ln);
	}

	private double[] updateNegatif(double ln, int x1, int x2, double[] w) {
		// TODO Auto-generated method stub
		double[] hasil = new double[2];
        
        hasil[0] = (double) (w[0] - ln * (x1 - w[0]));
        hasil[1] = (double) (w[1] - ln * (x2 - w[1]));
        
        return hasil;
	}

	private double[] updatePositif(double ln, double x1, double x2, double[] w) {
		// TODO Auto-generated method stub
		double[] hasil = new double[2];
        
        hasil[0] = (double) (w[0] + ln * (x1 - w[0]));
        hasil[1] = (double) (w[1] + ln * (x2 - w[1]));
        
        return hasil;
	}

	private double euclidean(double x1, double x2, double[] w) {
		// TODO Auto-generated method stub
		double hasil = w.length;
        
        hasil = 0;
        hasil += Math.pow((x1 - w[0]), 2);
        hasil += Math.pow((x2 - w[1]), 2);
        hasil = (double) Math.sqrt(hasil);
        
        return hasil;
	}

}
