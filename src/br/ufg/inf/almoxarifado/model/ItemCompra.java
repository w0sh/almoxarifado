/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.inf.almoxarifado.model;

import java.time.LocalDate;

/**
 *
 * @author wos
 */
public class ItemCompra {
    
    private double preco;
    private int quantidade;
    private LocalDate dataEntregaItem;
    private Compra compra;
    private Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataEntregaItem() {
        return dataEntregaItem;
    }

    public void setDataEntregaItem(LocalDate dataEntregaItem) {
        this.dataEntregaItem = dataEntregaItem;
    }
    
    
}
