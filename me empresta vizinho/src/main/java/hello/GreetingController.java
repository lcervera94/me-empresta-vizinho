package hello;

import java.util.concurrent.atomic.AtomicLong;

import DAO.UsuarioDAO;
import Conexao.Conexao;
import Objetos.Usuario;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    Conexao conexao = new Conexao();
    UsuarioDAO usuarioDAO = new UsuarioDAO(conexao.getConexao());

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

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
}

