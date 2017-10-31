package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import DAO.CategoriaDAO;
import DAO.CondominioDAO;
import DAO.ProdutoDAO;
import DAO.UsuarioDAO;
import Conexao.Conexao;
import Objetos.Categoria;
import Objetos.Condominio;
import Objetos.Produto;
import Objetos.Usuario;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class Services {

    Conexao conexao = new Conexao();
    UsuarioDAO usuarioDAO = new UsuarioDAO(conexao.getConexao());
    CategoriaDAO categoriaDAO = new CategoriaDAO(conexao.getConexao());
    CondominioDAO condominioDAO = new CondominioDAO(conexao.getConexao());
    ProdutoDAO produtoDAO = new ProdutoDAO(conexao.getConexao());

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/usuario/insere")
    public boolean salvaUsuario(@RequestParam(value = "tipoLocal") String tipoLocal, @RequestParam(value = "numero") String numero) {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Lucas");
        usuario.setId_condominio(tipoLocal.equals("condominio") ? 1 : 2);
        usuario.setNr_apartamento(numero);
        usuarioDAO.insert(usuario);
        return true;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/categoria/selectAll")
    public List<Categoria> getAllCategories() {
        return categoriaDAO.selectAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/condominio/selectAll")
    public List<Condominio> getAllCondominios() {
        return condominioDAO.selectAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/produto/insere")
    public boolean produtoInsere(@RequestBody Produto produto) {
        produtoDAO.insert(produto);
        return true;
    }

}

