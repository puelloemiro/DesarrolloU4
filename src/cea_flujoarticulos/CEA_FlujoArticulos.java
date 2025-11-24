/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cea_flujoarticulos;


import Infraestructure.ArticuloRepositoryPostgres;
import Application.ArticuloService;
import Adapters.FlujoArticulo;
import java.sql.Connection;
import java.sql.DriverManager;

public class CEA_FlujoArticulos {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/DesarrolloU4",
                "postgres",
                "123456"
            );

            ArticuloRepositoryPostgres repo = new ArticuloRepositoryPostgres(conn);
            ArticuloService service = new ArticuloService(repo);
            FlujoArticulo flujo = new FlujoArticulo(service);

            flujo.iniciarFlujo();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}