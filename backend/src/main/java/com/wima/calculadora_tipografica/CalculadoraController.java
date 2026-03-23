package com.wima.calculadora_tipografica;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;

// Esta etiqueta le dice a Spring que esta clase manejará peticiones de internet y devolverá JSON
@RestController
// Esta etiqueta define la ruta base. Todas las peticiones deberán empezar con /api
@RequestMapping("/api")
public class CalculadoraController {

    // Esta etiqueta indica que esta función solo responderá a peticiones tipo POST en la ruta /api/calcular
    @PostMapping("/calcular")
    public Map<String, Object> calcularGrilla(@RequestBody Map<String, Object> datosEntrada) {
        
        // 1. Imprimimos en la consola del servidor lo que nos envíe el frontend para comprobar que llega
        System.out.println("Datos recibidos del frontend: " + datosEntrada);

        // 2. Armamos la respuesta estática (nuestro contrato "mock")
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("estado_licencia", "gratuita");
        
        Map<String, Object> resultados = new HashMap<>();
        resultados.put("interlineado_optimo_pt", 14.4);
        resultados.put("grilla_base_pt", 14.4);
        
        Map<String, Integer> escalaModular = new HashMap<>();
        escalaModular.put("h1_pt", 24);
        escalaModular.put("h2_pt", 18);
        escalaModular.put("parrafo_pt", 12);
        
        resultados.put("escala_modular", escalaModular);
        
        respuesta.put("resultados", resultados);
        respuesta.put("formulas_aplicadas", "Suscripción Premium requerida para visualizar el desarrollo matemático.");

        // 3. Spring Boot tomará este "Map" de Java y lo convertirá automáticamente en un texto JSON perfecto
        return respuesta; 
    }
}