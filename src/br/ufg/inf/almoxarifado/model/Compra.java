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
public class Compra {
    
    private int codigo;
    private LocalDate dataEntrega;
    private LocalDate dataPrevista;
    private LocalDate dataCompra;
    private Fornecedor fornecedor;
    private Almoxarife almoxarife;

    public Almoxarife getAlmoxarife() {
        return almoxarife;
    }

    public void setAlmoxarife(Almoxarife almoxarife) {
        this.almoxarife = almoxarife;
    }
            
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(LocalDate dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }
    
    
}
