package numeros.pruebas;





public class Prueba_Frecuencia {

	Chi2 chi2= new Chi2();
	
    
	public Prueba_Frecuencia()
	{
        
	}
	
	public boolean getfrecuencias(double vec[],int n,double alfa,int periodo)
	{
        
		int N=periodo,FOi=0;
		double vec_sub[],vec_fo[],FEi=0,X02=0,Xan=0;        
        
		FEi=(double)N/n;		
		vec_fo=new double[n];
		vec_sub=new double[n];
		Xan=chi2.ObtenerChi(alfa, n-2);
		for(int i=0;i<n;i++)
		{
			vec_sub[i]=(double)i/n;
			vec_fo[i]=0;
		}
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(vec[i]>=vec_sub[j] && vec[i]<vec_sub[j+1])
					vec_fo[j]++;
				else if(j==n-2 && vec[i]>=vec_sub[j+1] && vec[i]<=1)
					vec_fo[j+1]++;
			}
		}
		
		for(int i=0;i<n;i++)
		{
			X02+=Math.pow(vec_fo[i]-FEi,2)/FEi;
		}
	
		if(X02<Xan){

                        return true;
        }
		else{

                        return false;
        }
		
		
	}
}
