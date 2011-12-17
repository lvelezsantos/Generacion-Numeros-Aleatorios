package numeros.pruebas;




public class Prueba_corridas2 {
	
	
	Chi2 chi2;
	public Prueba_corridas2()
	{
        
		chi2=chi2.getchi2();
	}
	
	public boolean getcorridas_p(double vec[],int n,double alfa,int periodo)
	{
		
		double beta=0.5,fei=0,x02=0,xan1;
		int R[],N=periodo,bin[],flag=0,aux=0,ultimo=0,Z=0;
		
		bin=new int[periodo];
		
		getbin(vec,bin,N);
		n=(N+1)/2;
		R=new int[n];
		for(int j=0;j<N;j++){
			flag=bin[j];
			
				aux=j;
				ultimo=j;
				Z=-1;
				do{
					Z++;
					aux++;						
					if(aux>=N-1)
						break;
				}while(bin[aux]!=flag);
				if(Z>=n)
					Z=n;
				R[Z]++;
                                
			
			
		}
		if(ultimo!=N-1)
			R[N-1-ultimo]++;
		for(int i=0;i<n;i++)
		{
			fei=(N-i-3)/(Math.pow(2,i+1 ));
			x02+=Math.pow(R[i]-fei,2)/fei;
		}
		xan1=chi2.ObtenerChi(alfa, n-1);
		if(x02<xan1)
        {
        
                        return true;
        }
		else{

                        return false;
        }
		
	}
	
	public void getbin(double a[],int b[],int N)
	{
		for(int i=0;i<N;i++)
		{
			if(a[i]<0.5)
				b[i]=0;
			else
				b[i]=1;
		}
	}

}






