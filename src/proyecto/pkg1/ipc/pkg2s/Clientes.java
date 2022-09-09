/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.ipc.pkg2s;

import javax.swing.JOptionPane;

/**
 *
 * @author jpsam
 */
public class Clientes {
    
    int CUI;
    String nombre;
    String apellido;
    
    public String StringCli;
    static int correlativo=0;
    public static Clientes[] clientesRegistrados = new Clientes[5];
    public static void AgregarCliente(Clientes nuevoCliente){
        for (Clientes clientesRegistrado : clientesRegistrados) {
            if(clientesRegistrado != null){
                if(clientesRegistrado.CUI == nuevoCliente.CUI){
                    JOptionPane.showMessageDialog(null, "CUI REPETIDO");
                    return;
                }
            }
        }
        for(int i=0; i<clientesRegistrados.length; i++){
            if(clientesRegistrados[i] == null){
                clientesRegistrados[i] = nuevoCliente;
                JOptionPane.showMessageDialog(null, "Cliente creado exitosamente");
                System.out.println("Cui: " + String.valueOf(nuevoCliente.getCUI()) + " nombre: " + nuevoCliente.getNombre() + " Apellido: " + nuevoCliente.getApellido());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se pueden crear más clientes");
    }
    
    public static Clientes buscarClientesCui(String CUI){
        int CuiU = Integer.parseInt(CUI);
        for (Clientes clientesRegistrado : clientesRegistrados) {
            if(clientesRegistrado != null){
                if(clientesRegistrado.CUI == CuiU){
                    return clientesRegistrado;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "El cliente no existe");
        return null;
    }
    
    public Clientes(){
        CUI = -1;
        nombre = "";
        apellido = "";
    }
            
    public Clientes(int CUI, String nombre, String apellido){
        this.CUI = CUI;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCUI() {
        return CUI;
    }

    public void setCUI(int CUI) {
        this.CUI = CUI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return StringCli=(CUI + nombre + apellido);
    }
    
    
}
