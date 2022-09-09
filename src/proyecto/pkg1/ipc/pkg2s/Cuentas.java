/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.ipc.pkg2s;
import javax.swing.JOptionPane;
import proyecto.pkg1.ipc.pkg2s.Clientes;
/**
 *
 * @author jpsam
 */
public class Cuentas {
    
    public int id_cuenta;
    public Clientes ClienteAsociado;
    public double monto;
    
    static int numeroCuenta=1;
    public static Cuentas[] cuentasRegistradas = new Cuentas[25];
    private static int cuentasClientes(Clientes cliente){
        int NUMcuentas = 0;
        for(Cuentas cuenta : cuentasRegistradas){
            if(cuenta != null){
                if(cuenta.ClienteAsociado.equals(cliente)){
                    NUMcuentas += 1;
                }
            }
        }
        return NUMcuentas;
    }
    public static void CrearCuentaBanc(Cuentas cuenta){
        if(cuentasClientes(cuenta.ClienteAsociado)==5){
            JOptionPane.showMessageDialog(null, "Ya no se pueden crear más cuentas");
            return;
        }
        for(int i=0; i<cuentasRegistradas.length; i++){
            if(cuentasRegistradas[i] == null){
                cuenta.id_cuenta = i+1;
                cuentasRegistradas[i] = cuenta;
                JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente");
                System.out.println("Cuenta creada: " + cuenta.id_cuenta + " " +cuenta.ClienteAsociado.CUI);
                return;
            }
        }
    }
    
    
    public Cuentas(Clientes cliente){
        id_cuenta = -1;
        ClienteAsociado = cliente;
        monto = 0;
    }
    
    public void DepMon(double monto){
        if(monto <= 0){
            JOptionPane.showMessageDialog(null, "El monto debe ser mayor 0");
            return;
        }
        this.monto += monto;
        JOptionPane.showMessageDialog(null, "Deposito realizado");
        System.out.println("Monto realizado: " + monto + " Nuevo Saldo: " +this.monto);
    }
    
    public void TransferenciaMon(double monto, Cuentas cuentaDest){
        if(this.monto < monto){
            JOptionPane.showMessageDialog(null, "");
        }
    }
    
    public static Cuentas[] BuscarCuentasCUI(String CUI){
        Clientes clienteA = Clientes.buscarClientesCui(CUI);
        if(clienteA == null){
            return null;
        }
        int NumCuenta = cuentasClientes(clienteA);
        Cuentas[] CuentasA = new Cuentas[NumCuenta];
        int cont =0;
        for(Cuentas cuenta : cuentasRegistradas){
            if(cuenta != null){
                if(cuenta.ClienteAsociado.equals(clienteA)){
                    CuentasA[cont] = cuenta;
                    cont +=1;
                }
            }
        }
        return CuentasA;
    }
    
}
