package com.example.CrudEstudiante.demo;

import com.example.CrudEstudiante.demo.EstudianteDao.EstudianteDao;
import com.example.CrudEstudiante.demo.Model.Estudiante;
import com.example.CrudEstudiante.demo.ServicesImplements.StudentServiceImplement;
import java.util.Optional;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.MockitoAnnotations;

public class StudentServiceImplementTest {

    // Creo mi mock falso
    @Mock
    private EstudianteDao estudiantedao;

    // Creo la instancia a la que le voy hacer el test
    @InjectMocks
    private StudentServiceImplement StudentServiceImplementPrueba;

    // Creo Estudiante simulado
    private Estudiante estudiante;

    // Creo Estudiante esperado
    private Estudiante estudiante2;

    // Inicializo mockito (Antes del test) y cuando se inicializa la clase de test
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        // Creo un estudiante , este es el objeto que va a devoolver el  Mockito.when(estudiantedao.save(solo se utiliza ahi )
        estudiante = new Estudiante();
        estudiante.setCodigo(123);
        estudiante.setNombre("Martin");
        estudiante.setApellido("Cantillo");
        estudiante.setPrograma("Ingenieria de sistema ");

        //este es el estudiante que yo espero o quiero  que me devuelva osea el estudianre esperado(se usa en el asserts para comparar lo que me respondio y lo esperado
        estudiante2 = new Estudiante();
        estudiante2.setCodigo(123);
        estudiante2.setNombre("Martin");
        estudiante2.setApellido("Cantillo");
        estudiante2.setPrograma("Ingenieria de sistema");
    }

    @Test
    public void save() {
        //simular el metodo save  con el objeto estudiante (simulacion) esto eso es lo que va a retornar el metodo save el estudiante
        //que cree
        Mockito.when(estudiantedao.save(Mockito.any(Estudiante.class))).thenReturn(estudiante);

        //Ahora pruebo el Mokito.when para ver si me retorna lo que dije(estudiante), se prueba en el servicio
        final Estudiante estudianteResultado = StudentServiceImplementPrueba.guardar(estudiante);
        Assertions.assertEquals(estudiante2.getNombre(), estudianteResultado.getNombre());
    }

    @Test
    public void findById() {
        // Crear un Optional que contenga el Estudiante, cuando se maneja con optional , el findById es de tipo optional

        Optional<Estudiante> estudianteOptional = Optional.of(estudiante2);//objeto simulado
        //estudiante objeto 
        Mockito.when(estudiantedao.findById(estudiante.getCodigo())).thenReturn(estudianteOptional);
        
        final Estudiante estResultado=StudentServiceImplementPrueba.encontrarEstudiante(estudiante);
        Assertions.assertEquals(estudiante2.getCodigo(), estudiante.getCodigo());
    }
}
