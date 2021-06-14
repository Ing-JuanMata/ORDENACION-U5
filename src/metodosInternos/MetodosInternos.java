/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosInternos;

/**
 *
 * @author codeboy1028
 */
public class MetodosInternos {
    
     public int[] A= new int[65535];
   
    
    public void arreglo(){
          for(int n=0; n < 65535; n++){
          double v = Math.random()*1000000000;
        int d = (int)v;
        A[n]=d;
        }
    }

    public void shell() {

        int salto, aux, i;
        boolean cambios;

        for (salto = A.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {   // Mientras se intercambie algún elemento                                         
                cambios = false;
                for (i = salto; i < 65535; i++) // se da una pasada
                {
                    if (A[i - salto] > A[i]) {       // y si están desordenados
                        aux = A[i];                  // se reordenan
                        A[i] = A[i - salto];
                        A[i - salto] = aux;
                        cambios = true;              // y se marca como cambio.                                   
                    }
                }
            }
        }
    }
    
    public void radix(){
        int x,i,j;
        for(x=Integer.SIZE; x>=0; x--){
            int auxiliar[] = new int[A.length];
            j=0;
            for(i =0; i<A.length; i++){
                boolean mover = A[i] << x >=0;
                if(x==0 ? !mover:mover){
                    auxiliar[j]=A[i];
                    j++;
                }else{
                    A[i-j]=A[i];
                }
            }
            for(i=j; i<auxiliar.length; i++){
                auxiliar[i]=A[i-j];
            }
            A=auxiliar;
        }
    }
    
    
    public void burbuja(){
        int Aux=0;
        for(int i=0;i< 65535; i++){
            for(int j=i+1;j< 65535;j++){
                if(A[j]<A[i]){
                    Aux=A[i];
                    A[i]=A[j];
                    A[j]=Aux;
                }
            }
        }
    }
    
    public void Quicksort(){
        Quicksort(A, 0, A.length -1);
    }
    
    private void Quicksort(int numeros[], int primero, int ultimo){
        int pivote = numeros[primero];
        int i = primero; 
        int j = ultimo; 
        int aux;

        while(i<j){
           while (numeros[i] <= pivote && i < j) i++;

           while (numeros[j] > pivote) j--;   

           if (i<j){                                     
               aux = numeros[i];                  
               numeros[i]= numeros[j];
               numeros[j]=aux;
           }
        }
         numeros[primero] = numeros[j]; 
         numeros[j] = pivote;

         if (primero < j-1)
            Quicksort(numeros,primero,j-1);

         if (j+1 < ultimo)
            Quicksort(numeros,j+1,ultimo);
    }
    
    
    
    public String  Impresion (){
      String cad="";
      for (int i = 0; i < 65535; i++) {
      cad+= (i+":["+A[i]+"]  ");
      if (i%10 == 0){
          cad+="\n";
      }
 }
      
   return cad;
 }


}
