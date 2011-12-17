package numeros.pruebas;

public class Prueba_Poker {

 
	public Prueba_Poker()
	{
		
	}
	
	public boolean getpoker(double nps[],int n,double alfa,int periodo)
	{
		int vec[],vec_fo[];
		double vec_fei[],x02=0,xan1,pmano[]={0.324,0.504,0.108,0.072,0.009,0.0045,0.0001};
		int N=periodo;
		vec=new int[periodo];
		vec_fo=new int[7];
		vec_fei=new double[7];
		for(int i=0;i<periodo;i++)
		{
			vec[i]=(int)(nps[i]*100000);
		}
		getfo(vec,vec_fo);
		for(int i=0;i<vec_fo.length;i++)
		{
			vec_fei[i]=pmano[i]*N;
		}
		rodar(vec_fo,vec_fei);
		for(int i=0;vec_fei[i]<vec_fei.length;i++)
		{
			x02+=Math.pow(vec_fo[i]-vec_fei[i],2)/vec_fei[i];
		}
		xan1=Chi2.getchi2().ObtenerChi(alfa, n-1);
		if(x02<xan1){

                        return true;
        }
		else{

                        return false;
        }
	}
	public void rodar(int a[],double fe[])
	{
		for(int i=1;i<fe.length;i++)
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
	public void limpiar(int digitos[])
	{
		for(int i=0;i<digitos.length;i++)
			digitos[i]=0;
	}
	public void getfo(int vec[],int vec_fo[])
	{
		int max=0,max2=0,index=0,sapo=0;
		String aux="";
		int digitos[]=new int[10];
		limpiar(digitos);
		
		for(int i=0;i<vec.length;i++)
		{
			aux="";
			max=max2=0;
			aux+=vec[i];
			limpiar(digitos);
			if(aux.length()<5)
				digitos[0]=5-aux.length();
			for(int j=0;j<aux.length();j++)
			{
				index=aux.charAt(j)-'0';
				digitos[index]++;
				if(digitos[index]>max){
					max=digitos[index];
					sapo=index;
				}
			}
			if(max==4)
				vec_fo[5]++;
			else if(max==5)
				vec_fo[6]++;
			else if(max<=3)
			{
				for(int i1=0;i1<digitos.length;i1++)
				{
					if(digitos[i1]>max2 && i1!=sapo)
						max2=digitos[i1];						
				}
				if(max==3 && max2==1)
				{					
					vec_fo[3]++;
					
				}
				else if(max==3 && max2==2){
					vec_fo[4]++;
					
				}
				else if(max==2 && max2==2)
					vec_fo[2]++;
				else if(max==2 && max2==1)
					vec_fo[1]++;
				else if(max==1)
					vec_fo[0]++;
			}
			
			
		}
		
	}

}
