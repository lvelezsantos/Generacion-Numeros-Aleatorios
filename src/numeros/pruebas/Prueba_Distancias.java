

package numeros.pruebas;




public class Prueba_Distancias {

    
	Chi2 chi2;

    public Prueba_Distancias()
    {
        
    }
	public boolean getdistancias(double vec[],int n,double alfa,int periodo)
	{
        
		double p[],foi,fei,a=0.3,b=0.7,x02,x0a;
		int N=periodo,fototal,ultimo=0;
		int hueco[];
		hueco=new int[periodo];
				
		p=new double[n+1]; //vector de probabilidades
		int aux=0,sapo=0;		
			for(int j=0;j<N;j++){
				if(vec[j]>=a && vec[j]<=b)
				{
					aux=j;
					ultimo=j;
					sapo=-1;
					do{
						sapo++;
						aux++;						
						if(aux>=N-1)
							break;
					}while(vec[aux]<a || vec[aux]>b);
					if(sapo>=n)
						sapo=n;
					hueco[sapo]++;
                                    //    System.out.println("inicial="+j+" final="+aux+" hueco="+sapo);
				}
				
			}
			if(ultimo!=N-1)
				hueco[N-1-ultimo]++;
			fototal=0;
			for(int i=0;i<=n;i++)
			{
				fototal+=hueco[i];
				p[i]=(b-a)*Math.pow((1-(b-a)),i);
			}
			p[n]=Math.pow((1-(b-a)),n);
			x02=0;                        
			for(int i=0;i<=n;i++)
			{
                            fei=fototal*p[i];
				x02+=(hueco[i]-fei)/fei;                                
			}
			
			x0a=chi2.getchi2().ObtenerChi(alfa, n);
		
			if(x02<x0a)
			{

                                return true;
			}
			else{

                                return false;
            }
			
		
	}

}


