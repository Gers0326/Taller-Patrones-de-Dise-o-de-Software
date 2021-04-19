/** 
 * @author Gersson Peña Herrera.
 * Cód. 202110147
 * Acá implemeté el Patrón Comportamental "Iterator."
*/

//¿Qué característica(s) de calidad impacta este patrón?

/** Este patrón lo que permite es recorrer los elementos basados
* en un bloque de datos, permitiendo la manipulación de ellos
* sin alterar o exponer la estructura interna.
*/

/** Para mi la caracteristica apropiada para este patrón es la
* de EFICIENCIA DE DESEMPEÑO debido a que representa un mejor
* desempeño con los recursos manejados, porque como decia permite 
* la manipulación de los recursos sin alterar o exponer la 
* estructura interna lo que das mayor rapidez en el flujo de datos.
*/

package patrones_diseño;

class Notificacion{
    String notificacion;
    
    public Notificacion(String notificacion){
        this.notificacion = notificacion;
    }
    
    public String getNotificacion(){
        return notificacion;
    }
}

interface Collection{
    public Iterator createIterator();
}

class NotificacionCollection implements Collection{
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    Notificacion[] notificacionList;
    
    public NotificacionCollection(){
        notificacionList = new Notificacion[MAX_ITEMS];
        
        addItem("Notificación 1");
	addItem("Notificación 2");
	addItem("Notificación 3");
        addItem("Notificación 4");
    }
    
    public void addItem(String str){
        Notificacion notificacion = new Notificacion(str);
        if (numberOfItems >= MAX_ITEMS)
            System.err.println("Completa");
        else{
            notificacionList[numberOfItems] = notificacion;
            numberOfItems = numberOfItems + 1;
        }
    }
    
    public Iterator createIterator(){
        return new NotificacionIterator(notificacionList);
    }
}

interface Iterator{
    
    boolean hasNext();
    
    Object next();
}

class NotificacionIterator implements Iterator{
    Notificacion[] notificacionList;
    
    int pos = 0;
    
    public NotificacionIterator (Notificacion[] notificacionList){
        this.notificacionList = notificacionList;
    }
    
    public Object next(){
        Notificacion notificacion = notificacionList[pos];
        pos += 1;
        return notificacion;
    }
    
    public boolean hasNext(){
        if (pos >= notificacionList.length || notificacionList[pos] == null)
            return false;
        else
            return true;
    }
}

class NotificacionBar{
    NotificacionCollection notificaciones;
    
    public NotificacionBar(NotificacionCollection notificaciones){
        this.notificaciones = notificaciones;
    }
    
    public void printNotificaciones(){
        Iterator iterator = notificaciones.createIterator();
        System.out.println("== NOTIFICACIÓN BAR ==");
        while (iterator.hasNext()){
            Notificacion n = (Notificacion)iterator.next();
            System.out.println(n.getNotificacion());
        }
    }
}

class Main{
    
    public static void main(String args[]){
        NotificacionCollection nc = new NotificacionCollection();
        NotificacionBar nb = new NotificacionBar(nc);
        nb.printNotificaciones();
    }
}