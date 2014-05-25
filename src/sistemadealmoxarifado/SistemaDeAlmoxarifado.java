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
     */
    public static void main(String[] args) throws SQLException {
       // ConnectionFactory.getInstance().getConnection();
        Departamento depto2=new Departamento();
        //depto.setCodigo(1);
        depto2.setDescricao("departamento dE LOGÍSTICA");
        depto2.setNome("Logística");
        
        DepartamentoDao deptoDao=new DepartamentoDao();
        deptoDao.salvar(depto2);
        
    }
    
}
