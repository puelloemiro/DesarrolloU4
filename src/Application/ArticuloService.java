/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import Domain.Articulo;
import Domain.ArticuloRepository;
import java.util.List;

public class ArticuloService {

    private final ArticuloRepository repository;

    public ArticuloService(ArticuloRepository repository) {
        this.repository = repository;
    }

    public void crearArticulo(Articulo a) {
        repository.crear(a);
    }

    public List<Articulo> listarArticulos() {
        return repository.listar();
    }

    public Articulo buscarArticulo(int id) {
        return repository.buscar(id);
    }

    public void actualizarArticulo(Articulo a) {
        repository.actualizar(a);
    }

    public void eliminarArticulo(int id) {
        repository.eliminar(id);
    }
}
