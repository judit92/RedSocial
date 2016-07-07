import com.google.common.collect.*;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class SocialNetWork
{
    private Map<String, Persona> personasByName = new HashMap<>();
    private Map<Long, Persona> personasById = new HashMap<>();
    private BiMap <Persona, Persona> parejas = HashBiMap.create();
    private TreeMultimap<Persona, Persona> multimapAmigos = TreeMultimap.create();
    private Multimap <Persona, Persona> multimapAmigosPareja = HashMultimap.create();

    public void addPersona (Persona persona)
    {
        personasByName.put (persona.getNombre(), persona);
        personasById.put (persona.getiD(), persona);
    }
    public Persona getPersona (Long id)
    {
        return personasById.get(id);
    }
    public Persona getPersona (String nombre)
    {
        return personasByName.get(nombre);
    }
    public void addParejas (Persona p1, Persona p2)
    {



       /* if (parejas.containsKey(p1)|| parejas.values().contains(p1))
        {
            System.out.println("La persona " + p1.getNombre() + " ya tiene pareja ");
            throw new RuntimeException("La persona " + p1.getNombre()+ "ya tiene pareja");
        }

       if ( parejas.containsValue(p2) || parejas.values().contains (p2))
       {
           System.out.println("La persona " + p2.getNombre() + "ya tiene pareja ");
           throw new RuntimeException("La persona " + p2.getNombre()+ "ya tiene pareja"); // lanzar un error y parar la ejecución
       }*/

        //el codigo anterior es lo mismo que:

        comprobarParejas (p1);
        comprobarParejas (p2);
        parejas.put(p1, p2);


    }
    private void comprobarParejas (Persona p1)
    {
        if (parejas.containsKey(p1) || parejas.values().contains(p1))
        {
            System.out.println("La persona  " + p1.getNombre()+ " ya tiene pareja ");
            throw new RuntimeException("La persona " + p1.getNombre() + " ya tiene pareja"); // lanzar un error y parar la ejecución
        }
    }
    public Persona getParejas(Persona persona)
    {
        Persona pareja = parejas.get(persona);
        if (pareja !=null)
            return pareja;
        else
        {
            pareja = parejas.inverse().get (persona);
            return pareja;
        }
    }
    public void addAmigos(Persona p1, Persona p2)
    {
        comprobarAmistad(p1, p2);
        multimapAmigos.put (p1, p2);

        comprobarAmistad(p2, p1);
        multimapAmigos.put (p2, p1);
    }
    public void comprobarAmistad (Persona p1, Persona p2) {
        if (multimapAmigos.containsKey(p1)&& multimapAmigos.get(p1).contains(p2)) {
            System.out.println(p2.getNombre() + " ya es amigo de " + p1.getNombre());
            throw new  RuntimeException(p2.getNombre() + "ya es amigo de " + p1.getNombre());
        }
    }
    public Set <Persona> getAmigos(Persona persona) // Set y no List para que no haya amigos duplicados
    {
        return multimapAmigos.get(persona);
    }
    public Set<Persona> getAmigosPareja(Persona p1 )
    {
        Persona p2 = getParejas(p1); // pedimos la pareja de p1
        if (p2 == null)
        {
            return new TreeSet<>(); // conjunto vacio
        }
        return getAmigos(p2);
    }

    public Set<Persona> getParejaAmigos (Persona persona)
    {
        Set<Persona> amigos = getAmigos(persona);
        Set<Persona> parejas = new HashSet<>();
        for (Persona amigo: amigos)
        {
            Persona pareja = getParejas(amigo);
            if (pareja != null)
            {
                parejas.add(pareja);
            }
        }

        return parejas;
    }

    public Set<Persona> getPeople (Persona persona) {return null;}// devuelve de mayor a menor el numero de amigos que tienen todas las personas

       public int getConnectionDegree (Persona p1, Persona p2) {return 0;}
    public SortedSet<Persona> getConnectionDegreePath (Persona p1, Persona p2) {return null;}  //
}
