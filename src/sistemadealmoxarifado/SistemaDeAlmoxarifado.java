/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadealmoxarifado;


import br.ufg.inf.almoxarifado.data.DepartamentoDao;
import br.ufg.inf.almoxarifado.data.ProdutoDao;
import br.ufg.inf.almoxarifado.data.TipoProdutoDao;
import br.ufg.inf.almoxarifado.data.util.ConnectionFactory;
import br.ufg.inf.almoxarifado.model.Departamento;
import br.ufg.inf.almoxarifado.model.Produto;
import br.ufg.inf.almoxarifado.model.TipoProduto;
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
       
        for (Departamento depto : deptoDao.listar()) {
            System.out.println(depto.getCodigo()+"/");
            System.out.println(depto.getNome()+"/");
            System.out.println(depto.getDescricao());
        }
       
       
       
        TipoProduto tproduto=new TipoProduto();
        tproduto.setCodigo(1);
        tproduto.setNome("laticinios");
        tproduto.setDescricao("Produtos a base de lactose");
        
        
        TipoProdutoDao tdao=new TipoProdutoDao();
        /*try {
        tdao.salvar(tproduto);
         } catch(RuntimeException e) {
            System.out.println("Desculpe, ocorreu um erro, contate o Administrador \n" +  e.getMessage());
        }
        */
        
        
        
        Produto produto2=new Produto();
        
        produto2.setValor(2.67);
        produto2.setValidade("04/03/2015");
        produto2.setEstoqueMinimo(40);
        produto2.setEstoque(70);
        produto2.setNome("laranja");
        produto2.setDescricao("laranja branca");
        produto2.setTipo(tproduto);
        produto2.getTipo().setCodigo(tproduto.getCodigo());
        
        
        System.out.println(produto2.getTipo().getCodigo());
        ProdutoDao pdao=new ProdutoDao();
        
        pdao.salvar(produto2);
        
        for (Produto prod : pdao.listar()) {
            System.out.println(prod.getCodigo());
            System.out.println(prod.getNome());
            System.out.println(prod.getDescricao());
            System.out.println(prod.getEstoqueMinimo());
            System.out.println(prod.getEstoque());
            System.out.println(prod.getValidade());
            System.out.println(prod.getValor());
        }
        
        
        //System.out.println(deptoDao.getByDepto("Compras").getNome());
    }
    
}
