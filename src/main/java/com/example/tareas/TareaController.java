package com.example.tareas;
import org.springframework.aot.generate.GeneratedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.form.TextareaTag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tareas")

public class TareaController {
    private List<Tarea> tareas= new ArrayList<>();
    private int siguineteId = 1;

    public TareaController(){
        tareas.add(new Tarea(siguineteId++, "Aprender Java", false));
        tareas.add(new Tarea(siguineteId++, "Practicar Spring Boot", false));
        tareas.add(new Tarea(siguineteId++, "Subir proyecto a GitHub", true));
    }

    private Tarea buscarPorId(int id){
        for (  Tarea t : tareas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
    //


    @GetMapping
    public List<Tarea> listar() {

        return tareas;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtener(@PathVariable int id) {
        Tarea tarea = buscarPorId(id);
        if (tarea == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarea);
    }

    @PostMapping
    public ResponseEntity<Tarea> crear(@RequestBody Tarea nueva){
        nueva.setId((siguineteId++));
        tareas.add(nueva);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizar(@PathVariable int id, @RequestBody Tarea
            datos) {
        Tarea tarea = buscarPorId(id);
        if (tarea == null) {
            return ResponseEntity.notFound().build();
        }
        tarea.setTitulo(datos.getTitulo());
        tarea.setCompletada(datos.isCompletada());
        return ResponseEntity.ok(tarea);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        Tarea tarea = buscarPorId(id);
        if (tarea == null) {
            return ResponseEntity.notFound().build();
        }
        tareas.remove(tarea);
        return ResponseEntity.noContent().build();
    }
}
