/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapters;

import Application.ArticuloService;
import Domain.Articulo;
import java.util.Scanner;

public class FlujoArticulo {

    private final ArticuloService service;
    private final Scanner sc = new Scanner(System.in);

    public FlujoArticulo(ArticuloService service) {
        this.service = service;
    }

    public void iniciarFlujo() {

        while (true) {
            System.out.println("===== FLUJO ARTICULOS =====");
            System.out.println("1. Crear Artículo");
            System.out.println("2. Listar Artículos");
            System.out.println("3. Buscar Artículo por ID");
            System.out.println("4. Actualizar Artículo");
            System.out.println("5. Eliminar Artículo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> crear();
                case 2 -> listar();
                case 3 -> buscar();
                case 4 -> actualizar();
                case 5 -> eliminar();
                case 0 -> { return; }
                default -> System.out.println("Opción inválida");
            }
        }
    }

    private void crear() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Resumen: ");
        String resumen = sc.nextLine();

        System.out.print("Revista: ");
        String revista = sc.nextLine();

        System.out.print("Año: ");
        int year = sc.nextInt();
        sc.nextLine();

        service.crearArticulo(new Articulo(id, titulo, resumen, revista, year));
        System.out.println("Artículo creado.\n");
    }

    private void listar() {
        service.listarArticulos().forEach(
            a -> System.out.println(
                a.getId() + " - " + a.getTitulo() + " (" + a.getRevista() + ") " + a.getYear()
            )
        );
        System.out.println();
    }

    private void buscar() {
        System.out.print("ID a buscar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Articulo a = service.buscarArticulo(id);

        if (a != null)
            System.out.println(
                a.getId() + " - " + a.getTitulo() + " (" + a.getRevista() + ") " + a.getYear()
            );
        else
            System.out.println("No encontrado");

        System.out.println();
    }

    private void actualizar() {
        System.out.print("ID a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Articulo a = service.buscarArticulo(id);

        if (a == null) {
            System.out.println("Artículo no encontrado.\n");
            return;
        }

        System.out.print("Nuevo título (" + a.getTitulo() + "): ");
        String titulo = sc.nextLine();
        if (!titulo.isBlank()) a.setTitulo(titulo);

        System.out.print("Nuevo resumen (" + a.getResumen() + "): ");
        String resumen = sc.nextLine();
        if (!resumen.isBlank()) a.setResumen(resumen);

        System.out.print("Nueva revista (" + a.getRevista() + "): ");
        String revista = sc.nextLine();
        if (!revista.isBlank()) a.setRevista(revista);

        System.out.print("Nuevo año (" + a.getYear() + "): ");
        String yearStr = sc.nextLine();
        if (!yearStr.isBlank()) a.setYear(Integer.parseInt(yearStr));

        service.actualizarArticulo(a);
        System.out.println("Artículo actualizado.\n");
    }

    private void eliminar() {
        System.out.print("ID a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();

        service.eliminarArticulo(id);
        System.out.println("Artículo eliminado.\n");
    }
}
