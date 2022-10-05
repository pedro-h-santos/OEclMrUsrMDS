package br.com.springboot.dao;
import java.util.List;

public interface CRUD<T, ID> {
    T pesquisaPeloID(ID id);/*retornar o objeto 
    cadastrado no banco de dados cujo ID passado no parâmetro*/
    List<T> lista();//retorna os dados cadastrados
    void insere(T t);//insere mais dados
    void atualiza(T t);//atualiza os dados inseridos
    void remove(T t);//remove os dados
}
