package silva.aquila.task_list.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import silva.aquila.task_list.dominio.Usuario;

@Repository
public class UsuariosCadastrados{

    private final List<Usuario> usuariosCadastrados = new ArrayList<>();

    public UsuariosCadastrados(){

    }

    public String cadastro(String username, String pass){
        
        if(username == "" || pass == ""){
            return "1";
        }

        for(int i = 0; i<usuariosCadastrados.size(); i++){
            if(usuariosCadastrados.get(i).getUsername() == username){
                return "2";
            }
        }

        usuariosCadastrados.add(new Usuario(username, pass));

        return "0";

    }

    public boolean login(String username, String pass){

        for (int i = 0; i<usuariosCadastrados.size(); i++){
            if(usuariosCadastrados.get(i).getUsername() == username
            && usuariosCadastrados.get(i).getPass() == pass)
            return true;
        }

        return false;

    }

}
