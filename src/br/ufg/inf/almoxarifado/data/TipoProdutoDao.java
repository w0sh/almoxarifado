/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.inf.almoxarifado.data;

import br.ufg.inf.almoxarifado.data.util.ConnectionFactory;
import br.ufg.inf.almoxarifado.model.TipoProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author wos
 */
public class TipoProdutoDao {
    private final String TABELA="tipo";
    private final String CODIGO="cod_tipo";
    private final String NOME="nome";
    private final String DESCRICAO="descricao";
        
    Connection conexao;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
        
    public void salvar(TipoProduto tipo) {
        
    try {
    conexao=ConnectionFactory.getInstance().getConnection();        
    String sql="INSERT INTO "+TABELA+"("+NOME+","+DESCRICAO+") values(?,?)";
    ps=conexao.prepareStatement(sql);
   // ps.setInt(1, depto.getCodigo());
    ps.setString(1, tipo.getNome());
    ps.setString(2, tipo.getDescricao());
    ps.executeQuery();
    } 
    
    catch (SQLException ex) {
           throw new RuntimeException("Erro de SQL: "+ex.getLocalizedMessage());
        }
    catch(RuntimeException ec) {
         throw new RuntimeException("Erro em tempo de execução: "+ec.getLocalizedMessage());
    }
    }
    
    public void atualizar(TipoProduto tipo) throws SQLException {
    
        conexao=ConnectionFactory.getInstance().getConnection();
        String sql="UPDATE "+TABELA+" SET " + NOME + " = ?, " + DESCRICAO + " = ? WHERE " + CODIGO + " = ? ";
        ps=conexao.prepareStatement(sql);
        ps.setString(1, tipo.getNome());
        ps.setString(2, tipo.getDescricao());
        ps.setInt(3, tipo.getCodigo());
        ps.executeUpdate();
     
    }
    
    public void remover(TipoProduto tipo) throws SQLException {
        
        conexao=ConnectionFactory.getInstance().getConnection();
        String sql = "DELETE FROM " + TABELA + " WHERE " + CODIGO + "= ?";
        ps=conexao.prepareStatement(sql);
        ps.setInt(1, tipo.getCodigo());
        ps.executeUpdate();
    }
    
    public List<TipoProduto> listar() throws SQLException {
        List<TipoProduto> tipos = new ArrayList<>();

        conexao=ConnectionFactory.getInstance().getConnection();
        String sql="SELECT * FROM "+TABELA;
        st=conexao.createStatement();
        rs = st.executeQuery(sql);
        
        while (rs.next()) {
                TipoProduto tipo = new TipoProduto();
                tipo.setCodigo(rs.getInt(CODIGO));
                tipo.setNome(rs.getString(NOME));
                tipo.setDescricao(rs.getString(DESCRICAO));
                tipos.add(tipo);
            }
        return tipos;
    }
    
    
    public TipoProduto getByTipo(String nome) throws SQLException {

        TipoProduto tipo = null;
        
        conexao = ConnectionFactory.getInstance().getConnection();
        String sql = "SELECT * from " + TABELA + " WHERE " + NOME + " = ?";

            ps = conexao.prepareStatement(sql);

            ps.setString(1, nome);
            rs = ps.executeQuery();
            while (rs.next()) {
                tipo = new TipoProduto();
                tipo.setCodigo(rs.getInt(CODIGO));
                tipo.setNome(rs.getString(NOME));
                tipo.setDescricao(rs.getString(DESCRICAO));
            }
            return tipo;
    }
    
}
