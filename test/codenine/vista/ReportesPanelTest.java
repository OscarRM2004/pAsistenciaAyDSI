package codenine.vista;

// Importaciones de JUNIT 4
import org.junit.Test;
import static org.junit.Assert.*;

// El resto de las importaciones son las mismas
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Pruebas unitarias para la clase ReportesPanel (escritas con sintaxis de JUnit 4).
 */
public class ReportesPanelTest {

    @Test // Esta anotación ahora viene de org.junit.Test
    public void testMergeSort_DeberiaOrdenarFechasDescendentemente() {
        System.out.println("Ejecutando prueba para mergeSort con JUnit 4");
        
        try {
            // 1. Instancia de la clase a probar
            Menu menu = new Menu();
            ReportesPanel instance = new ReportesPanel(menu);

            // 2. Preparar datos de entrada desordenados
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date[] arrayDesordenado = {
                sdf.parse("2025-07-12"),
                sdf.parse("2025-07-15"),
                sdf.parse("2025-07-10")
            };

            // 3. Preparar el resultado esperado (orden descendente)
            Date[] resultadoEsperado = {
                sdf.parse("2025-07-15"),
                sdf.parse("2025-07-12"),
                sdf.parse("2025-07-10")
            };

            // 4. Usar Reflection para acceder al método privado 'mergeSort'
            Method method = ReportesPanel.class.getDeclaredMethod("mergeSort", Date[].class);
            method.setAccessible(true);

            // 5. Invocar el método y obtener el resultado
            Date[] resultadoReal = (Date[]) method.invoke(instance, (Object) arrayDesordenado);

            // 6. Verificar que el resultado real es igual al esperado (usando el assert de JUnit 4)
            assertArrayEquals(resultadoEsperado, resultadoReal);

        } catch (Exception e) {
            // El método fail() también viene de org.junit.Assert
            fail("La prueba falló debido a una excepción: " + e.getMessage());
        }
    }
}