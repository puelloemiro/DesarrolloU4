/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;


public class Articulo {
    private int id;
    private String titulo;
    private String resumen;
    private String revista;
    private int year;

    public Articulo(int id, String titulo, String resumen, String revista, int year) {
        this.id = id;
        this.titulo = titulo;
        this.resumen = resumen;
        this.revista = revista;
        this.year = year;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getResumen() { return resumen; }
    public String getRevista() { return revista; }
    public int getYear() { return year; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setResumen(String resumen) { this.resumen = resumen; }
    public void setRevista(String revista) { this.revista = revista; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return id + " | " + titulo + " | " + revista + " | " + year;
    }
}
