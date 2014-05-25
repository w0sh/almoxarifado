/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.inf.almoxarifado.model;

/**
 *
 * @author wos
 */
public class ConsumoMensal {
        
    private int expectativaConsumo;
    private String mesAno;
    private Produto produto;
    private Departamento depto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Departamento getDepto() {
        return depto;
    }

    public void setDepto(Departamento depto) {
        this.depto = depto;
    }
    
    public int getExpectativaConsumo() {
        return expectativaConsumo;
    }

    public void setExpectativaConsumo(int expectativaConsumo) {
        this.expectativaConsumo = expectativaConsumo;
    }

    public String getMesAno() {
        return mesAno;
    }

    public void setMesAno(String mesAno) {
        this.mesAno = mesAno;
    }
    
    
}
