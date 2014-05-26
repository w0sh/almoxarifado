/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadealmoxarifado;


import br.ufg.inf.almoxarifado.data.DepartamentoDao;
import br.ufg.inf.almoxarifado.data.util.ConnectionFactory;
import br.ufg.inf.almoxarifado.model.Departamento;
import java.sql.SQLException;

/**
 *
 * @author wos
 */
public class SistemaDeAlmoxarifado {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
       // ConnectionFactory.getInstance().getConnection();
        Departamento depto4=new Departamento();
        //depto.setCodigo(1);
        //depto4.setDescricao("departamento dE Limpeza");
       // depto4.setNome("Limpeza");
        //depto3.setCodigo(3);
        
        DepartamentoDao deptoDao=new DepartamentoDao();
        //deptoDao.remover(depto3);
        /*
        for (Departamento depto : deptoDao.listar()) {
            System.out.println(depto.getCodigo()+"/");
            System.out.println(depto.getNome()+"/");
            System.out.println(depto.getDescricao());
        }
        */
        try {
        deptoDao.salvar(depto4);
        } catch(RuntimeException e) {
            System.out.println("Desculpe, ocorreu um erro, contate o Administrador \n" +  e.getMessage());
        }
       
        //System.out.println(deptoDao.getByDepto("Compras").getNome());
    }
    
}
