package br.com.springboot.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.springboot.dao.CRUD;
import br.com.springboot.dao.ClienteDAO;
import br.com.springboot.model.Cliente;

@Service

public class ClienteBO implements CRUD<Cliente, Long> {
    @Autowired
    private ClienteDAO dao;
    
    @Override
    public Cliente pesquisaPeloId(Long id){
            return dao.pesquisaPeloId(id);
    }
    @Override
    public List<Cliente> lista(){
        return dao.listaTodos();
    }
    @Override
    public void insere(Cliente cliente){
        dao.insere(cliente);
    }
    @Override
    public void atualiza(Cliente cliente){
        dao.atualiza(cliente);
    }
    @Override
    public void remove(Cliente cliente){
        dao.remove(cliente);
    }
    
    public void inativa(Cliente cliente){
        cliente.setAtivo(false);
        dao.atualiza(cliente);
    }
    
}
