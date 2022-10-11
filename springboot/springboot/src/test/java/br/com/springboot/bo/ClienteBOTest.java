package br.com.springboot.bo;
import java.time.LocalDate;
import java.util.List;


import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.springboot.model.Cliente;
import br.com.springboot.model.Sexo;



@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class ClienteBOTest {
    @Autowired
    private ClienteBO bo;
    @Test
    @Order(1)
    public void insere(){
        Cliente cliente = new Cliente();
        cliente.setNome("JULIANA ALVORADA");
        cliente.setCpf("12345678900");
        cliente.setDataNasc(LocalDate.of(200,1,8));
        cliente.setSexo(Sexo.FEMININO);
        cliente.setEmail("meuemail@servidor.com");
        cliente.setTelefone("13568945");
        cliente.setCelular("99544422");
        cliente.setAtivo(true);
        bo.insere(cliente);
    }  
    @Test
    @Order(2)
    public void pesquisaPeloId(){
        Cliente cliente = bo.pesquisaPeloId(1L);
        System.out.println(cliente);
    }
    @Test
    @Order(3)
    public void atualiza(){
        Cliente cliente = bo.pesquisaPeloId(1L);
        cliente.setCpf("2347987");
        cliente.setTelefone("88464868");
        cliente.setCelular("4448888");
        bo.atualiza(cliente);
    }
    @Test
    @Order(4)
    public void lista(){
        List<Cliente> clientes = bo.listaTodos();
        for (Cliente cliente : clientes){
            System.out.println(cliente);
        }

    }
    @Test
    @Order(5)
    public void inativa(){
        Cliente cliente = bo.pesquisaPeloId(1L);
        bo.inativa(cliente);
    }
    @Test
    @Order(6)
    public void remove(){
        Cliente cliente = bo.pesquisaPeloId(1L);
        bo.remove(cliente);
    }
}
