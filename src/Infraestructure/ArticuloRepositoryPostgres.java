/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infraestructure;

import Domain.Articulo;
import Domain.ArticuloRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticuloRepositoryPostgres implements ArticuloRepository {

    private final Connection conn;

    public ArticuloRepositoryPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void crear(Articulo a) {
        String sql = "INSERT INTO articulos(id, titulo, resumen, revista, year) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, a.getId());
            stmt.setString(2, a.getTitulo());
            stmt.setString(3, a.getResumen());
            stmt.setString(4, a.getRevista());
            stmt.setInt(5, a.getYear());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear artículo", e);
        }
    }

    @Override
    public List<Articulo> listar() {
        List<Articulo> lista = new ArrayList<>();
        String sql = "SELECT * FROM articulos";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Articulo a = new Articulo(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("resumen"),
                        rs.getString("revista"),
                        rs.getInt("year")
                );
                lista.add(a);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al listar artículos", e);
        }

        return lista;
    }

    @Override
    public Articulo buscar(int id) {
        String sql = "SELECT * FROM articulos WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Articulo(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("resumen"),
                        rs.getString("revista"),
                        rs.getInt("year")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar artículo", e);
        }
        return null;
    }

    @Override
    public void actualizar(Articulo a) {
        String sql = "UPDATE articulos SET titulo = ?, resumen = ?, revista = ?, year = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, a.getTitulo());
            stmt.setString(2, a.getResumen());
            stmt.setString(3, a.getRevista());
            stmt.setInt(4, a.getYear());
            stmt.setInt(5, a.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar artículo", e);
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM articulos WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar artículo", e);
        }
    }
}