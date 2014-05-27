/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.inf.almoxarifado.data;

import br.ufg.inf.almoxarifado.data.util.ConnectionFactory;
import br.ufg.inf.almoxarifado.model.Departamento;
import br.ufg.inf.almoxarifado.model.Fornecedor;
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
public class FornecedorDao {
    
            
    private final String CODIGO="cnpj";
    private final String FONE="fone";
    private final String RAZAO_SOCIAL="razao_social";
    private final String ENDERECO="endereco";
    private final String TABELA="fornecedor";
    
    Connection conexao;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
        
    public void salvar(Fornecedor fornec) {
        
    try {
    conexao=ConnectionFactory.getInstance().getConnection();        
    String sql="INSERT INTO "+TABELA+"("+CODIGO+","+FONE+","+RAZAO_SOCIAL+","+ENDERECO+") values(?,?,?,?)";
    ps=conexao.prepareStatement(sql);
    ps.setInt(1, fornec.getCNPJ());
    ps.setString(2, fornec.getFone());
    ps.setString(3, fornec.getRazaoSocial());
    ps.setString(4, fornec.getEndereco());
    ps.executeQuery();
    } 
    
    catch (SQLException ex) {
           throw new RuntimeException("Erro de SQL: "+ex.getLocalizedMessage());
        }
    catch(RuntimeException ec) {
         throw new RuntimeException("Erro em tempo de execução: "+ec.getLocalizedMessage());
    }
    }
    
    public void atualizar(Fornecedor fornec) throws SQLException {
    
        conexao=ConnectionFactory.getInstance().getConnection();
        String sql="UPDATE "+TABELA+" SET " + CODIGO + " = ?, " + FONE + " = ? , " + RAZAO_SOCIAL + " = ? , " + ENDERECO + " = ?WHERE " + CODIGO + " = ? ";
        ps=conexao.prepareStatement(sql);
        ps.setInt(1, fornec.getCNPJ());
        ps.setString(2, fornec.getFone());
        ps.setString(3, fornec.getRazaoSocial());
        ps.setString(4, fornec.getEndereco());
        ps.setInt(5, fornec.getCNPJ());
        ps.executeUpdate();
     
    }
    
    public void remover(Fornecedor fornec) throws SQLException {
        
        conexao=ConnectionFactory.getInstance().getConnection();
        String sql = "DELETE FROM " + TABELA + " WHERE " + CODIGO + "= ?";
        ps=conexao.prepareStatement(sql);
        ps.setInt(1, fornec.getCNPJ());
        ps.executeUpdate();
    }
    
    public List<Fornecedor> listar() throws SQLException {
        List<Fornecedor> fornecedores = new ArrayList<>();

        conexao=ConnectionFactory.getInstance().getConnection();
        String sql="SELECT * FROM "+TABELA;
        st=conexao.createStatement();
        rs = st.executeQuery(sql);
        
        while (rs.next()) {
                Fornecedor fornec = new Fornecedor();
                fornec.setCNPJ(rs.getInt(CODIGO));
                fornec.setFone(rs.getString(FONE));
                fornec.setRazaoSocial(rs.getString(RAZAO_SOCIAL));
                fornec.setEndereco(rs.getString(ENDERECO));
                fornecedores.add(fornec);
            }
        return fornecedores;
    }
    
    
    public Fornecedor getByCNPJ(String cnpj) throws SQLException {

        Fornecedor fornec = null;
        
        conexao = ConnectionFactory.getInstance().getConnection();
        String sql = "SELECT * from " + TABELA + " WHERE " + CODIGO + " = ?";

            ps = conexao.prepareStatement(sql);

            ps.setString(1, cnpj);
            rs = ps.executeQuery();
            while (rs.next()) {
                fornec = new Fornecedor();
                fornec.setCNPJ(rs.getInt(CODIGO));
                fornec.setFone(rs.getString(FONE));
                fornec.setRazaoSocial(rs.getString(RAZAO_SOCIAL));
                fornec.setEndereco(rs.getString(ENDERECO));
            }
            return fornec;
    }
    
}
