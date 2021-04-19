/**
 * @author Gersson Peña Herrera.
 * Cód. 202110147
 * Acá implemeté el Patrón Estructural "Decorator."
 */

//¿Qué característica(s) de calidad impacta este patrón?

/** Este patrón se enfoca en añadir funcionalidades de manera
 * dinámica a un objeto y con la ayuda del encapsulamiento por ejemplo
 * poder almacenar las nuevas funcionalidades de una clase para que sean 
 * implementadas y asociarlas a la primera.
*/  

/** La caracteristica para este patrón creeria que es la de USABILIDAD,
* porque maneja una fácil adecuación y adaptación para ser usado; adicional
* puede llegar a tener interfaces amigables que estimulen la interacción
* con el usuario.
*/

package patrones_diseño;

abstract class Pizza{
    String descripcion = "Pizza desconocida";
    
    public String getDescripcion()
    {
        return descripcion;
    }
    
    public abstract int getCosto();
}

abstract class DecoradorCobertura extends Pizza{
    public abstract String getDescripcion();
}

class TresCarnes extends Pizza{
    
    public TresCarnes(){
        descripcion = "Tres_Carnes";
    }
    public int getCosto(){ 
        return 15000; 
    }
}

class Caprichosa extends Pizza{
    
    public Caprichosa(){
        descripcion = "Caprichosa";
    }
    public int getCosto(){
        return 25000;
    }
}

class TomateFresco extends DecoradorCobertura{
    Pizza pizza;
    
    public TomateFresco(Pizza pizza){
        this.pizza = pizza;
    }
    
    public String getDescripcion(){
        return pizza.getDescripcion() + ", Tomate fresco ";
    }
    
    public int getCosto(){
        return 4000 + pizza.getCosto();
    }
}

class Barbacoa extends DecoradorCobertura{
    Pizza pizza;
    
    public Barbacoa(Pizza pizza){
        this.pizza = pizza;
    }
    
    public String getDescripcion(){
        return pizza.getDescripcion() + ", Barbacoa ";
    }
    
    public int getCosto(){
        return 4500 + pizza.getCosto();
    }
}

class TiendaPizza{
    
    public static void main(String args[]){
        Pizza pizza = new TresCarnes();
        System.out.println( pizza.getDescripcion() +" Costo: " + pizza.getCosto());
        
        Pizza pizza2 = new Caprichosa();
        
        pizza2 = new TomateFresco(pizza2);
        
        pizza2 = new Barbacoa(pizza2);
        
        System.out.println( pizza2.getDescripcion() +"Costo: " + pizza2.getCosto());
    }
}