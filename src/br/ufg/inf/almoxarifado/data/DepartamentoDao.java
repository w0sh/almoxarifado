/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.inf.almoxarifado.data;

import br.ufg.inf.almoxarifado.data.util.ConnectionFactory;
import br.ufg.inf.almoxarifado.model.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wos
 */
public class DepartamentoDao {
    
    private final String CODIGO="cod_depto";
    private final String NOME="nome";
    private final String DESCRICAO="descricao";
    private final String TABELA="departamento";
    
    Connection conexao;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
        
    public void salvar(Departamento depto) {
        
    try {
    conexao=ConnectionFactory.getInstance().getConnection();        
    String sql="INSERT INTO "+TABELA+"("+NOME+","+DESCRICAO+") values(?,?)";
    ps=conexao.prepareStatement(sql);
   // ps.setInt(1, depto.getCodigo());
    ps.setString(1, depto.getNome());
    ps.setString(2, depto.getDescricao());
    ps.executeQuery();
    } 
    
    catch (SQLException ex) {
           throw new RuntimeException("Erro de SQL: "+ex.getLocalizedMessage());
        }
    catch(RuntimeException ec) {
         throw new RuntimeException("Erro em tempo de execução: "+ec.getLocalizedMessage());
    }
    }
    
    public void atualizar(Departamento depto) throws SQLException {
    
        conexao=ConnectionFactory.getInstance().getConnection();
        String sql="UPDATE "+TABELA+" SET " + NOME + " = ?, " + DESCRICAO + " = ? WHERE " + CODIGO + " = ? ";
        ps=conexao.prepareStatement(sql);
        ps.setString(1, depto.getNome());
        ps.setString(2, depto.getDescricao());
        ps.setInt(3, depto.getCodigo());
        ps.executeUpdate();
     
    }
    
    public void remover(Departamento depto) throws SQLException {
        
        conexao=ConnectionFactory.getInstance().getConnection();
        String sql = "DELETE FROM " + TABELA + " WHERE " + CODIGO + "= ?";
        ps=conexao.prepareStatement(sql);
        ps.setInt(1, depto.getCodigo());
        ps.executeUpdate();
    }
    
    public List<Departamento> listar() throws SQLException {
        List<Departamento> deptos = new ArrayList<>();

        conexao=ConnectionFactory.getInstance().getConnection();
        String sql="SELECT * FROM "+TABELA;
        st=conexao.createStatement();
        rs = st.executeQuery(sql);
        
        while (rs.next()) {
                Departamento depto = new Departamento();
                depto.setCodigo(rs.getInt(CODIGO));
                depto.setNome(rs.getString(NOME));
                depto.setDescricao(rs.getString(DESCRICAO));
                deptos.add(depto);
            }
        return deptos;
    }
    
    
    public Departamento getByDepto(String nome) throws SQLException {

        Departamento depto = null;
        
        conexao = ConnectionFactory.getInstance().getConnection();
        String sql = "SELECT * from " + TABELA + " WHERE " + NOME + " = ?";

            ps = conexao.prepareStatement(sql);

            ps.setString(1, nome);
            rs = ps.executeQuery();
            while (rs.next()) {
                depto = new Departamento();
                depto.setCodigo(rs.getInt(CODIGO));
                depto.setNome(rs.getString(NOME));
                depto.setDescricao(rs.getString(DESCRICAO));
            }
            return depto;
    }
    
}
