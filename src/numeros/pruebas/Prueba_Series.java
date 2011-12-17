package numeros.pruebas;




public class Prueba_Series {

    
	double vec_sub[];
	int m_fo[][];
	Chi2 chi2;
	public Prueba_Series()
	{
		
	}
	
	public boolean getseries(double vec[],int n,double alfa,int periodo)
	{
		
		double fei=0,x02=0,xn2=0;
		int N=periodo;
		
		
		vec_sub=new double[n];
		m_fo=new int[n][n];
		
		fei=(N-1)/Math.pow(n, 2);
		for(int i=0;i<n;i++)
		{
			vec_sub[i]=(double)i/n;
		}
		for(int i=0;i<N-1;i++)
		{
			ubicar(vec[i],vec[i+1],n);
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				x02+=Math.pow(m_fo[i][j]-fei,2);
			}
			

		}
	
		x02*=Math.pow(n, 2)/(N-1);
		chi2=chi2.getchi2();
		xn2=chi2.ObtenerChi(alfa,n*n-2);
		if(x02<xn2)
        {

                        return true;
        }
		else{

                        return false;
        }
		
		
	}
	
	public void ubicar(double a,double b,int n)
	{
		int aux1=-1,aux2=-1;
		for(int i=0;i<n-1;i++)
		{
			if(a>=vec_sub[i] && a<vec_sub[i+1])
				aux1=i;	
			else if(i==n-2 && a>=vec_sub[i+1] && a<=1)
				aux1=i+1;
			if(b>=vec_sub[i] && b<vec_sub[i+1])
				aux2=i;
			else if(i==n-2 && b>=vec_sub[i+1] && b<=1)
			   aux2=i+1;
		}
		m_fo[aux1][aux2]++;
	}

}










