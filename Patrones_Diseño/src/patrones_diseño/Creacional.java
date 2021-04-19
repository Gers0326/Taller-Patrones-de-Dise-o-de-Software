/**
 * @author Gersson Peña Herrera.
 * Cód. 202110147
 * Acá implemeté el Patrón Creacional "Builder."
 */

//¿Qué característica(s) de calidad impacta este patrón?

/** Este patrón va orientado valga la redundancia a la programación 
 *orientada a objetos donde ayuda a tener soluciones flexible en lo
 * que respecta a problemas de creación de objetos.
*/

/** La caracteristica apropiada para este patrón es la de FIABILIDAD,
* trae circunstancias apropiadas para contar con un software en un periodo
* de tiempo determinado gracias a su flexibilidad, lo que conlleva a estar 
* operativo y accesible para su uso cuando se requiere.
*/

package patrones_diseño;

interface PlanCasa{
    public void setSotano(String sotano);
    public void setEstructura(String estructura);
    public void setTecho(String techo);
    public void setInterior(String interior);
}

class Casa implements PlanCasa{
    private String sotano;
    private String estructura;
    private String techo;
    private String interior;
    
    public void setSotano(String sotano){
        this.sotano = sotano;
    }
    
    public void setEstructura(String estructura){
        this.estructura = estructura;
    }
    
    public void setTecho(String techo){
        this.techo = techo;
    }
    
    public void setInterior(String interior){
        this.interior = interior;
    }
}

interface BuilderCasa{
    
    public void buildSotano();
    public void buildEstructura();
    public void buildTecho();
    public void buildInterior();
    public Casa getCasa();
}

class IgluCasaBuilder implements BuilderCasa{
    
    private Casa casa;
    
    public IgluCasaBuilder(){
        this.casa = new Casa();
    }
    
    public void buildSotano(){
        casa.setSotano("Barras de hielo");
    }
    
    public void buildEstructura(){
        casa.setEstructura("Bloques de hielo");
    }
    
    public void buildTecho(){
        casa.setTecho("Domo de hielo");
    }
    
    public void buildInterior(){
        casa.setInterior("Tallas de hielo");
    }
    
    public Casa getCasa(){
        return this.casa;
    }
}

class TiposCasaBuilder implements BuilderCasa{
    
    private Casa casa;
    
    public TiposCasaBuilder(){
        this.casa = new Casa();
    }
    
    public void buildSotano(){
        casa.setSotano("Postes de madera");
    }
    
    public void buildEstructura(){
        casa.setEstructura("Madera e hielo");
    }
    
    public void buildTecho(){
        casa.setTecho("Madera, pieles de caribú y foca");
    }
    
    public void buildInterior(){
        casa.setInterior("Leña");
    }
    
    public Casa getCasa(){
        return this.casa;
    }
}

class IngenieriaCivil{
    
    private BuilderCasa Buildercasa;
    
    public IngenieriaCivil(BuilderCasa Buildercasa){
        this.Buildercasa = Buildercasa;
    }
    
    public Casa getCasa(){
        return this.Buildercasa.getCasa();
    }
    
    public void constructCasa(){
        this.Buildercasa.buildSotano();
        this.Buildercasa.buildEstructura();
        this.Buildercasa.buildTecho();
        this.Buildercasa.buildInterior();
    }
}

class Builder{
    
    public static void main(String[] args){
        BuilderCasa igluBuilder = new IgluCasaBuilder();
        IngenieriaCivil ingenieria = new IngenieriaCivil(igluBuilder);
        
        ingenieria.constructCasa();
        Casa casa = ingenieria.getCasa();
        System.out.println("Constructor construido: "+ casa);
    }
}