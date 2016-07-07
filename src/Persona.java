import java.util.Comparator;

/**
 * Created by professor on 04/07/2016.
 */
public class Persona  implements Comparable <Persona>
{
    private Long iD;
    private String nombre;
    private String apellido;
    private int edad;

    public Persona(Long iD, String nombre, String apellido, int edad) {
        this.iD = iD;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "iD=" + iD +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        if (getEdad() != persona.getEdad()) return false;
        if (!getiD().equals(persona.getiD())) return false;
        if (!getNombre().equals(persona.getNombre())) return false;
        return getApellido().equals(persona.getApellido());

    }

    @Override
    public int hashCode() {
        int result = getiD().hashCode();
        result = 31 * result + getNombre().hashCode();
        result = 31 * result + getApellido().hashCode();
        result = 31 * result + getEdad();
        return result;
    }

    @Override
    public int compareTo(Persona persona) {
        return (this.iD.compareTo(persona.iD));
    }
}
