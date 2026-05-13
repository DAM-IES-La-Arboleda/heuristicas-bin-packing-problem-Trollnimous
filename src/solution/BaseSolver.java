package solution;

import core.BinPackingSolver;
import java.util.*;
import java.util.stream.Stream;

public class BaseSolver implements BinPackingSolver {
    @Override
    public List<List<Double>> solve(double capacity, List<Double> weights) {
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
        boolean cerrar = false;
        //pesos = pesos.stream().filter(s->s>=capacity).toList();
        
        while(!cerrar)
        {
        	System.out.println("Creado un nuevo contenedor");
        	List<Double> listaMeter = new LinkedList<Double>();
        	listaMeter.add(pesos[0]);
        	pesos[0] = -1;
        	int vueltas = 0;
        	while(vueltas < 5)
        	{
        		System.out.println(String.format("Numero de vueltas: %d, %d", vueltas, pesos[0]));
        		for(int i = 0; i < pesos.length; i++)
        		{
        			if(pesos[i] < 0)
        			{
        				continue;
        			}
            		if(listaMeter.size()+pesos[i] <= capacity)
            		{
            			System.out.println(String.format("Metiendo %d", pesos[i]));
            			listaMeter.add(pesos[i]);
            			pesos[i] = -1;
            		}
            		if(listaMeter.size() == capacity)
            		{
            			vueltas = Integer.MAX_VALUE;
            		}
            		
        		}
        		vueltas++;
        	}
        	bins.add(listaMeter);
        	if(todoNegativo(pesos))
        	{
        		cerrar = true;
        	}
        }

        return bins;
    }
    
    public static boolean todoNegativo(double [] array)
    {
    	boolean bool = true;
    	for(int i = 0; i<array.length;i++)
    	{
    		if(i < 0)
    		{
    			return false;
    		}
    	}
    	return bool;
    }
}