package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import DAO.CategoriaDAO;
import DAO.CondominioDAO;
import DAO.ProdutoDAO;
import DAO.UsuarioDAO;
import Objetos.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class Services {

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    CategoriaDAO categoriaDAO = new CategoriaDAO();
    CondominioDAO condominioDAO = new CondominioDAO();
    ProdutoDAO produtoDAO = new ProdutoDAO();

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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/pedido/getAll")
    public List<Pedido> getAll() {
        return new ArrayList<Pedido>();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/usuario")
    public Usuario getAll(@RequestParam("id") int id) {
        return usuarioDAO.findUserById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/produtos/getById")
    public List<Produto> getProdutosPorId(@RequestParam(value = "id") int idUsuario) {
        return produtoDAO.findProductsByUserId(idUsuario);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/produto/devolveu")
    public boolean devolveuProduto(@RequestParam(value = "id") int id) {
        Produto p = produtoDAO.findProductById(id);
        if (p != null) {
            p.setNomeTomador(null);
            p.setIdTomador(0);
            p.setEmprestado(false);
            p.setAprovado(false);
            return true;
        }
        return false;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/produto/devolver")
    public boolean devolverProduto(@RequestParam(value = "id") int id) {
        Produto p = produtoDAO.findProductById(id);
        if (p != null) {
            p.setNomeTomador(null);
            p.setIdTomador(0);
            p.setEmprestado(false);
            p.setAprovado(false);
            return true;
        }
        return false;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/produto/comigo")
    public List<Produto> comigo(@RequestParam(value = "id") int id) {
        return produtoDAO.selectAll().stream().filter(x -> 1 == x.getIdTomador() && x.isEmprestado() && x.isAprovado()).collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/produto/pedidos")
    public List<Produto> pedidos(@RequestParam(value = "id") int id) {
        return produtoDAO.selectAll().stream().filter(x -> 1 == x.getIdUsuario() && x.isEmprestado() && !x.isAprovado()).collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/produto/negar")
    public boolean negar(@RequestParam(value = "id") int id) {
        Produto p = produtoDAO.findProductById(id);
        if(p != null) {
            p.setAprovado(false);
            p.setEmprestado(false);
            p.setIdTomador(0);
            p.setNomeTomador(null);
            return true;
        }
        return false;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/produto/aceitar")
    public boolean aceitar(@RequestParam(value = "id") int id) {
        Produto p = produtoDAO.findProductById(id);
        if(p != null) {
            p.setAprovado(true);
            p.setEmprestado(true);
            p.setIdTomador(2);
            p.setNomeTomador("Redher Wetzl");
            return true;
        }
        return false;
    }

}

