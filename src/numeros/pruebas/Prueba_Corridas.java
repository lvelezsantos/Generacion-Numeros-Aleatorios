

package numeros.pruebas;




public class Prueba_Corridas {
	
	
	Chi2 chi2;
	public Prueba_Corridas()
	{
        
		chi2=chi2.getchi2();
	}
	
	public boolean getcorridas(double vec[],int n,double alfa,int periodo)
	{
		double fei[],x02=0,xan1;
		int R[],N=periodo,bin[],flag=0,aux=0,ultimo=0,Z=0;
		
		bin=new int[periodo];
		
		getbin(vec,bin,N);
		R=new int[N];
		fei=new double[N];
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
		double xx=0;
        if(N<=20){
		for(int i=0;i<N;i++)
		{
			if(i!=N-1){
                xx=(2*(N*(i*i)+3*i+1)-(i*i*i+3*i*i-i-4));
			fei[i]=xx/fact(i+3);
            }
			else
				fei[i]=2/fact(N);
		}
		      
		rodar(R,fei,N);
		
		for(int i=0;fei[i]!=0;i++)
		{
			
			x02+=Math.pow(R[i]-fei[i],2)/fei[i];
		}
        }
        else
            x02=Long.MAX_VALUE;
		xan1=chi2.ObtenerChi(alfa, n-1);
		if(x02<xan1)
        {
            return true;
        }
		else
        {
            return false;
        }
		
	}
	public void rodar(int a[],double fe[],int N)
	{
		for(int i=1;i<N;i++)
		{
			if(fe[i]<5)
			{
				for(int j=i-1;j>=0;j--)
				{
					if(fe[j]>0)
					{
						fe[j]+=fe[i];
						fe[i]=0;
						a[j]+=a[i];
						a[i]=0;
					}
						
				}
			}
		}
	}
	public long fact(int a)
	{
		long f=1;
		for(int i=2;i<=a;i++)
			f*=i;
		return f;
	}
	public void getbin(double a[],int b[],int N)
	{
		for(int i=0;i<N-1;i++)
		{
			if(a[i]<a[i+1])
				b[i]=0;
			else
				b[i]=1;
		}
		
	}

}






