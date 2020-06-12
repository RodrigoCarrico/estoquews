package br.com.caelum.estoque.ws;

import br.com.caelum.estoque.modelo.item.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.util.List;

@WebService
public class EstoqueWS {

    private ItemDao dao = new ItemDao();

    @WebMethod(operationName = "todosOsItens")
    @ResponseWrapper(localName="itens")
    @WebResult(name = "itens")
    @RequestWrapper(localName="listaItens")
    public List<Item> getItens(@WebParam(name="filtros") Filtros filtros) {
        System.out.println("Chamando todosItens()");
        List<Filtro> lista = filtros.getLista();
        return dao.todosItens(lista);
    }

    @WebMethod(exclude=true)
    public void outroMetodo() {
        //nao vai fazer parte do WSDL
    }
}