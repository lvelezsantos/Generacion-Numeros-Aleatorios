package numeros.pruebas;

public class Prueba_Promedios {
   

    public Prueba_Promedios()
    {
        
    }

	public boolean getpromedios(double nps[],double alfa,int periodo)
	{
        
		double media_a,media,varianza,Z0,Za,total=0;
		media=0.5;
		varianza=Math.sqrt((double)1/12);
		Za=alfa;
		
		
		for(int i=0;i<periodo;i++)
		{			
			total+=nps[i];
		}
		media_a=total/periodo;
		Z0=(media_a-media)*Math.sqrt(periodo)/varianza;
		
		if(Math.abs(Z0)<Za)
		{

                        return true;
		}
		else{

            return false;
        }
			
		
	}

}
