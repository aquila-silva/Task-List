package silva.aquila.task_list.repositorio;

import org.springframework.stereotype.Repository;

import silva.aquila.task_list.dominio.Usuario;

@Repository 
public class UsuarioLogado {
    
    private Usuario usuarioLogado = new Usuario();

    public UsuarioLogado(){

    }

    public void login(Usuario usuario){

      if(usuarioLogado == null){
        usuarioLogado = usuario;
      }
            
    }

    public Usuario getLogado(){
        return  usuarioLogado;
    }

    public void sair(){
      usuarioLogado.setUsername("");
      usuarioLogado.setPass("");
    }
}
