package solution;

import core.BinPackingSolver;
import java.util.*;
import java.util.stream.Stream;

public class BaseSolver implements BinPackingSolver {
    @Override
    public List<List<Double>> solve(double capacity, List<Double> weights) {
    	System.out.println(capacity);
    	System.out.println(weights.size());
        List<List<Double>> bins = new ArrayList<>();
        double[] pesos = new double[weights.size()];
        
        /*weights.sort(new Comparator<Double>()
		{
			public int compare(Double a, Double b)
			{
				return -Double.compare(a,b);
			}
		});*/
        
        for(int i = 0; i < weights.size(); i++)
        {
        	pesos[i] = weights.get(i);
        }        
        System.out.println(Arrays.toString(pesos));
        boolean cerrar = false;
        //pesos = pesos.stream().filter(s->s>=capacity).toList();
        
        while(!cerrar)
        {
        	double valor = -1;
        	List<Double> listaMeter = new LinkedList<Double>();
        	for(int i = 0; i < pesos.length; i++)
        	{
        		if(pesos[i] > 0)
        		{
        			valor = pesos[i];
        			pesos[i] = -1;
        			break;
        		}
        	}
        	listaMeter.add(valor);
        	System.out.println("Creado un nuevo contenedor" + valor);

        	int vueltas = 0;
        	
        	while(vueltas < 5)
        	{
        		System.out.println(vueltas<5);
        		System.out.println(String.format("Numero de vueltas: %d", vueltas));
        		for(int i = 0; i < pesos.length; i++)
        		{
        			
        			//System.out.println(i);
        			//System.out.println(pesos[i]);
        			//System.out.println("Tamaño valores: "+tamValores(listaMeter));
        			if(pesos[i] > 0)
        			{
        				//System.out.println("eo");
        				//System.out.println(tamValores(listaMeter) + pesos[i] <= capacity);
        				if(tamValores(listaMeter) + pesos[i] <= capacity)
                		{
                			//System.out.println(String.format("Metiendo %d", pesos[i]));
                			listaMeter.add(pesos[i]);
                			pesos[i] = -1;
                		}
        			}
        		}
        		vueltas++;
        		System.out.println(vueltas);
        	}
        	bins.add(listaMeter);
        	//System.out.println(Arrays.toString(pesos));
        	//System.out.println(todoNegativo(pesos));
        	if(todoNegativo(pesos))
        	{
        		cerrar = true;
        	}
        }

        return bins;
    }
    
    public static double tamValores(List<Double> array)
    {
    	int tamano = 0;
    	for(double d : array)
    	{
    		tamano += d;
    	}
    	return tamano;
    }
    
    public static boolean todoNegativo(double [] array)
    {
    	System.out.println(Arrays.toString(array));
    	boolean bool = true;
    	for(int i = 0; i<array.length;i++)
    	{
    		if(array[i] > 0)
    		{
    			return false;
    		}
    	}
    	return bool;
    }
}