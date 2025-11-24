/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.List;

public interface ArticuloRepository {
    void crear(Articulo a);
    List<Articulo> listar();
    Articulo buscar(int id);
    void actualizar(Articulo a);
    void eliminar(int id);
}