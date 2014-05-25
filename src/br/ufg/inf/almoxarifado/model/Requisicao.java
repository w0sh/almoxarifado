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
public class Requisicao {
    
    private int codigo;
    private StatusRequisicao status;
    private LocalDate dataRequisicao;
    private String motivoRejeicao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public StatusRequisicao getStatus() {
        return status;
    }

    public void setStatus(StatusRequisicao status) {
        this.status = status;
    }

    public LocalDate getDataRequisicao() {
        return dataRequisicao;
    }

    public void setDataRequisicao(LocalDate dataRequisicao) {
        this.dataRequisicao = dataRequisicao;
    }

    public String getMotivoRejeicao() {
        return motivoRejeicao;
    }

    public void setMotivoRejeicao(String motivoRejeicao) {
        this.motivoRejeicao = motivoRejeicao;
    }
    
    
}
