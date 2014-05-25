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
        
    public void salvar(Departamento depto) throws SQLException {
    conexao=ConnectionFactory.getInstance().getConnection();
    String sql="INSERT INTO "+TABELA+"("+NOME+","+DESCRICAO+") values(?,?)";
    ps=conexao.prepareStatement(sql);
    //ps.setInt(1, depto.getCodigo());
    ps.setString(1, depto.getNome());
    ps.setString(2, depto.getDescricao());
    ps.executeQuery();
    }
    
}
