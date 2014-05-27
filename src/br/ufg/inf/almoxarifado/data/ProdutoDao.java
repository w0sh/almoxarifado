/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.inf.almoxarifado.data;

import br.ufg.inf.almoxarifado.data.util.ConnectionFactory;
import br.ufg.inf.almoxarifado.model.Produto;
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
public class ProdutoDao {
    
    Connection conexao;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
        
    public void salvar(Produto produto) {
        
    try {
    conexao=ConnectionFactory.getInstance().getConnection();        
    String sql="INSERT INTO produto (ultimo_preco_compra, validade, estoque_min, nome, descricao, estoque, cod_tipo)"
            + "VALUES(?,?,?,?,?,?,?)";            
        ps=conexao.prepareStatement(sql);
        // ps.setInt(1, depto.getCodigo());
        ps.setDouble(1, produto.getValor());
        ps.setString(2,produto.getValidade());
        ps.setInt(3, produto.getEstoqueMinimo());
        ps.setString(4, produto.getNome());
        ps.setString(5, produto.getDescricao());
        ps.setInt(6, produto.getEstoque());
        ps.setInt(7, produto.getTipo().getCodigo());
        ps.executeQuery();
    } 
    
    catch (SQLException ex) {
           throw new RuntimeException("Erro de SQL: "+ex.getLocalizedMessage());
        }
    catch(RuntimeException ec) {
         throw new RuntimeException("Erro em tempo de execução: "+ec.getLocalizedMessage());
    }
    }
    
    public void atualizar(Produto produto) throws SQLException {
    
        conexao=ConnectionFactory.getInstance().getConnection();
        String sql="UPDATE produto SET ultimo_preco_compra=?,validade=?,estoque_min=?,nome=?,descricao=?,estoque=?,cod_tipo=? WHERE cod_produto=?";
        ps=conexao.prepareStatement(sql);
        ps.setDouble(1, produto.getValor());
        ps.setString(2,produto.getValidade());
        ps.setInt(3, produto.getEstoqueMinimo());
        ps.setString(4, produto.getNome());
        ps.setString(5, produto.getDescricao());
        ps.setInt(6, produto.getEstoque());
        ps.setInt(7, produto.getTipo().getCodigo());
        ps.setInt(8, produto.getCodigo());
        ps.executeUpdate();
     
    }
    
    public void remover(Produto produto) throws SQLException {
        
        conexao=ConnectionFactory.getInstance().getConnection();
        String sql = "DELETE FROM produto WHERE cod_produto= ?";
        ps=conexao.prepareStatement(sql);
        ps.setInt(1, produto.getCodigo());
        ps.executeUpdate();
    }
    
    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        conexao=ConnectionFactory.getInstance().getConnection();
        String sql="SELECT * FROM produto";
        st=conexao.createStatement();
        rs = st.executeQuery(sql);
        
        
      
        
        while (rs.next()) {
                Produto produto = new Produto();
                TipoProduto tipo=new TipoProduto();
                produto.setCodigo(rs.getInt("cod_produto"));
                produto.setValor(rs.getDouble("ultimo_preco_compra"));
                produto.setValidade(rs.getString("validade"));
                produto.setEstoqueMinimo(rs.getInt("estoque_min"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setEstoque(rs.getInt("estoque"));                
                produto.setTipo(tipo);                
                produto.getTipo().setCodigo(rs.getInt("cod_tipo"));
                produtos.add(produto);
            }
        return produtos;
    }
    
    
    public Produto getByProduto(String nomeProduto) throws SQLException {

        Produto produto = null;
        TipoProduto tipo=new TipoProduto();
        conexao = ConnectionFactory.getInstance().getConnection();
        String sql = "SELECT * from produto WHERE nome = ?";

            ps = conexao.prepareStatement(sql);

            ps.setString(1, nomeProduto);
            rs = ps.executeQuery();
            while (rs.next()) {
                produto = new Produto();
                produto.setCodigo(rs.getInt("cod_produto"));
                produto.setValor(rs.getDouble("ultimo_preco_compra"));
                produto.setValidade(rs.getString("validade"));
                produto.setEstoqueMinimo(rs.getInt("estoque_min"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setEstoque(rs.getInt("estoque"));
                produto.setTipo(tipo);                
                produto.getTipo().setCodigo(rs.getInt("cod_tipo"));
                
            }
            return produto;
    }
    
}
