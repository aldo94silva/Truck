package com.TruckFlow.dtos;

import com.TruckFlow.models.Caminhao;
import com.TruckFlow.models.Carga;
import com.TruckFlow.models.Cliente;
import com.TruckFlow.models.Endereco;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class FreteDTO {

    private Long id;

    private String origem;

    private String destino;

    private LocalDate data_saida;

    private LocalDate data_chegada;

    private String peso_carga;

    private String valor_frete;

    private CaminhaoDTO caminhao;

    private List<CargaDTO> cargas;

    private ClienteDTO cliente;

    private EnderecoDTO endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getData_saida() {
        return data_saida;
    }

    public void setData_saida(LocalDate data_saida) {
        this.data_saida = data_saida;
    }

    public LocalDate getData_chegada() {
        return data_chegada;
    }

    public void setData_chegada(LocalDate data_chegada) {
        this.data_chegada = data_chegada;
    }

    public String getPeso_carga() {
        return peso_carga;
    }

    public void setPeso_carga(String peso_carga) {
        this.peso_carga = peso_carga;
    }

    public String getValor_frete() {
        return valor_frete;
    }

    public void setValor_frete(String valor_frete) {
        this.valor_frete = valor_frete;
    }

    public CaminhaoDTO getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(CaminhaoDTO caminhao) {
        this.caminhao = caminhao;
    }

    public List<CargaDTO> getCargas() {
        return cargas;
    }

    public void setCargas(List<CargaDTO> cargas) {
        this.cargas = cargas;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
