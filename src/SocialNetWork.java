import com.google.common.collect.*;

import java.util.*;

public class SocialNetWork
{
    private Map<String, Persona> personasByName = new HashMap<>();
    private Map<Long, Persona> personasById = new HashMap<>();
    private BiMap <Persona, Persona> parejas = HashBiMap.create();
    private TreeMultimap<Persona, Persona> multimapAmigos = TreeMultimap.create();
    //private Map<Persona, Persona>


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

    public void addAmigos (Persona p1, Persona... amigos)
    {
        for(Persona amigo: amigos)
        {
            addAmigos(p1, amigo);
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

    public Integer getNumeroAmigos (Persona persona)
    {

        return getAmigos(persona).size();
    }

    public List<Persona> popularidad (Persona persona)
    {
        List<Persona> personaList = new ArrayList<>(personasByName.values()); // guardamos el map de personas en un array list
        Collections.sort(personaList, (p1, p2) -> {

            int numAmigos1 = getNumeroAmigos(p1);
            int numAmigos2 = getNumeroAmigos(p2);
            if (numAmigos1<numAmigos2)
            {
            return 1;
            }
            if (numAmigos1>numAmigos2)
            {
            return -1;
            }
            else return 0;

        });

        return personaList;
    }


    public boolean getGradoConexionAmistad (Persona p1, Persona p2) // devuelve el grado de conexión entre dos personas (1,2,3...)
    {

            Set<Persona> personasVisitadas = new TreeSet<>(); // está vacio porqué aun no hemos visitado nada
            Queue<Persona> colaAmigos = new LinkedList<>();

            Persona siguientePersona = p1;
            boolean amigoEncontrado = false;
            personasVisitadas.add(p1);

            lazosGlobales:

        while (siguientePersona != null)
        {
            for (Persona amigo : getAmigos(siguientePersona))
            {
                if (amigo.equals(p2))
                {
                  amigoEncontrado = true;
                    break lazosGlobales;
                }

                if(!personasVisitadas.contains(amigo))
                {
                  personasVisitadas.add(amigo);
                  colaAmigos.offer(amigo);
                }
            }
            siguientePersona = colaAmigos.poll();
        }
            return amigoEncontrado;
    }



    public int getGradoConexion (Persona p1, Persona p2)
    {
        int GA = 0;

        if (p1 == p2)
        {
            return GA;
        }
        GA++;

         return GA;

    }

}
