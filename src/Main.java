import java.util.*;

public class Main {


    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {


        Persona cristina = new Persona(1L, "Cristina", "Lopez", 21);
        Persona juan = new Persona(2L, "Juan", "Fernandez", 25);
        Persona pedro = new Persona(3L, "Pedro", "Rodriguez", 22);
        Persona julia = new Persona(4L, "Julia", "Iglesias", 20);
        Persona carol = new Persona(5L, "Carol", "Hernandez", 19);
        Persona ana = new Persona(6L, "Ana", "Sanchez", 24);
        Persona antonio = new Persona(7L, "Antonio", "Vega", 25);
        Persona marc = new Persona(8L, "Marc", "Martinez", 19);


        SocialNetWork socialNetWork = new SocialNetWork();

        socialNetWork.addPersona(cristina);
        socialNetWork.addPersona(juan);
        socialNetWork.addPersona(ana);
        socialNetWork.addPersona(marc);
        socialNetWork.addPersona(antonio);
        socialNetWork.addPersona(pedro);
        socialNetWork.addPersona(carol);
        socialNetWork.addPersona(julia);

        System.out.println("Mostrar personas por id: ");
        System.out.println("Id 1: " + socialNetWork.getPersona(1L));
        System.out.println("Id 2: " + socialNetWork.getPersona(2L));
        System.out.println("Id 3: " + socialNetWork.getPersona(3L));
        System.out.println("Id 4: " + socialNetWork.getPersona(4L));
        System.out.println("Id 5: " + socialNetWork.getPersona(5L));
        System.out.println("Id 6: " + socialNetWork.getPersona(6L));
        System.out.println("Id 7: " + socialNetWork.getPersona(7L));
        System.out.println("Id 8: " + socialNetWork.getPersona(8L));


        System.out.println("Mostrar persona por nombre: ");
        System.out.println("Nombre Cristina: "
                + socialNetWork.getPersona("Cristina"));
        System.out.println("Nombre Juan: "
                + socialNetWork.getPersona("Juan"));
        System.out.println("Nombre Ana: "
                + socialNetWork.getPersona("Ana"));
        System.out.println("Nombre Marc: "
                + socialNetWork.getPersona("Marc"));
        System.out.println("Nombre Antonio: "
                + socialNetWork.getPersona("Antonio"));
        System.out.println("Nombre Pedro: "
                + socialNetWork.getPersona("Pedro"));
        System.out.println("Nombre Carol: "
                + socialNetWork.getPersona("Carol"));
        System.out.println("Nombre Julia: "
                + socialNetWork.getPersona("Julia"));


        socialNetWork.addParejas(cristina, juan);
        socialNetWork.addParejas(antonio, pedro);
        socialNetWork.addParejas(ana, marc);


        socialNetWork.addAmigos(juan, antonio);
        socialNetWork.addAmigos(juan, marc);
        socialNetWork.addAmigos(pedro, cristina);
        socialNetWork.addAmigos(pedro, julia);
        socialNetWork.addAmigos(carol, julia);
        socialNetWork.addAmigos(ana, antonio);
        socialNetWork.addAmigos(ana, julia);
        socialNetWork.addAmigos(antonio, marc);


        System.out.println("1. Mostrar la pareja ");

        /*socialNetWork.addParejas(antonio, pedro); nos lanza una excepción y finaliza la ejecución porqué antonio ya tiene una pareja y
         el boolean nos devuelve cierto porqué el es una Key en el biMap de parejas */

        /*socialNetWork.addParejas(pedro, antonio); nos lanza una excepción y finaliza la ejecución porqué antonio ya tiene una pareja y
         el boolean nos devuelve cierto porqué el es un Value en el biMap de parejas*/

        System.out.println("La pareja de Cristina es: " + socialNetWork.getParejas(cristina));
        System.out.println("La pareja de Juan es:  " + socialNetWork.getParejas(juan));
        System.out.println("La pareja de Ana es: " + socialNetWork.getParejas(ana));
        System.out.println("La pareja de Marc es: " + socialNetWork.getParejas(marc));
        System.out.println("La pareja de Antonio es: " + socialNetWork.getParejas(antonio));
        System.out.println("La pareja de Pedro es: " + socialNetWork.getParejas(pedro));
        System.out.println("La pareja de Carol es: " + socialNetWork.getParejas(carol));
        System.out.println("La pareja de Julia es: " + socialNetWork.getParejas(julia));


        System.out.println("2. Mostrar todos los amigos de la persona ");
        System.out.println("Los amigos de Cristina son : " + socialNetWork.getAmigos(cristina));
        System.out.println("Los amigos de Juan son : " + socialNetWork.getAmigos(juan));
        System.out.println("Los amigos de Ana son : " + socialNetWork.getAmigos(ana));
        System.out.println("Los amigos de Marc son : " + socialNetWork.getAmigos(marc));
        System.out.println("Los amigos de Antonio son : " + socialNetWork.getAmigos(antonio));
        System.out.println("Los amigos de Pedro son : " + socialNetWork.getAmigos(pedro));
        System.out.println("Los amigos de Carol son : " + socialNetWork.getAmigos(carol));
        System.out.println("Los amigos de Julia son : " + socialNetWork.getAmigos(julia));


        System.out.println("3. Mostrar los amigos de la pareja: ");
        System.out.println("Los amigos de la pareja de Cristina son: " + socialNetWork.getAmigosPareja(cristina));
        System.out.println("Los amigos de la pareja de Juan son: " + socialNetWork.getAmigosPareja(juan));
        System.out.println("Los amigos de la pareja de Ana son: " + socialNetWork.getAmigosPareja(ana));
        System.out.println("Los amigos de la pareja de Marc son: " + socialNetWork.getAmigosPareja(marc));
        System.out.println("Los amigos de la pareja de Antonio son: " + socialNetWork.getAmigosPareja(antonio));
        System.out.println("Los amigos de la pareja de Pedro son: " + socialNetWork.getAmigosPareja(pedro));
        System.out.println("Los amigos de la pareja de Carol son: " + socialNetWork.getAmigosPareja(carol));
        System.out.println("Los amigos de la pareja de Julia son: " + socialNetWork.getAmigosPareja(julia));


        System.out.println("4. Muestra la pareja de los amigos de la persona: ");
        System.out.println("Las parejas de los amigos de Cristina son: " + socialNetWork.getParejaAmigos(cristina));
        System.out.println("Las parejas de los amigos de Juan son: " + socialNetWork.getParejaAmigos(juan));
        System.out.println("Las parejas de los amigos de Ana son: " + socialNetWork.getParejaAmigos(ana));
        System.out.println("Las parejas de los amigos de Marc son: " + socialNetWork.getParejaAmigos(marc));
        System.out.println("Las parejas de los amigos de Antonio son: " + socialNetWork.getParejaAmigos(antonio));
        System.out.println("Las parejas de los amigos de Pedro son: " + socialNetWork.getParejaAmigos(pedro));
        System.out.println("Las parejas de los amigos de Carol son: " + socialNetWork.getParejaAmigos(carol));
        System.out.println("Las parejas de los amigos de Julia son: " + socialNetWork.getParejaAmigos(julia));





    }
}
