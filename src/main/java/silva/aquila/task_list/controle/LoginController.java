package silva.aquila.task_list.controle;

import silva.aquila.task_list.dominio.Usuario;
import silva.aquila.task_list.repositorio.UsuarioLogado;
import silva.aquila.task_list.repositorio.UsuariosCadastrados;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginController {

    UsuarioLogado usuarioLogado = new UsuarioLogado();

    UsuariosCadastrados usuariosCadastrados = new UsuariosCadastrados();



    @GetMapping("") 
    public String inicio(Model model) {
        model.addAttribute("usuario", new Usuario());

        if(usuarioLogado.getLogado().getUsername().equals("")){
            return "login";
        }

        return "home";
    }
    
    @GetMapping("/login")
    public String inicioLogin(Model model) {

        model.addAttribute("usuario", new Usuario());

        if(usuarioLogado.getLogado().getUsername().equals("")){
            return "login";
        }

        return "home";
    }

    @PostMapping("/login")
    public String postMethodName(@ModelAttribute Usuario usuario, Model model) {
        model.addAttribute("usuario", new Usuario());

        if(usuariosCadastrados.login(usuario.getUsername(), usuario.getPass())){
            return "home";
        }

        model.addAttribute("erroLogin", "Login inválido! Usuario ou senha incorretos.");
        
        return "login";
    }
    

    @PostMapping("/cadastro")
    public String postCadastro(@ModelAttribute Usuario usuario, Model model) {

        model.addAttribute("usuario", new Usuario());

        String validaLogin = usuariosCadastrados.cadastro(usuario.getUsername(), usuario.getPass());

        if (validaLogin.equals("0")) {
            model.addAttribute("confirm", "Cadastro realizado com sucesso!");
            model.addAttribute("erro", "");
        }else if(validaLogin.equals("1")){
            model.addAttribute("confirm", "");
            model.addAttribute("erro", "Cadastro Inválido! Preencha todos os campos");
        }else if(validaLogin.equals("2")){
            model.addAttribute("confirm", "");
            model.addAttribute("erro", "Cadastro Inválido! Usuario já Cadastrado");
        }

        return "login";
    }


    @PostMapping("/sair")
    public String Sair() {
        
        usuarioLogado.sair();

        return "login";
        
  
    }
    

}
