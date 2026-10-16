package silva.aquila.task_list.dominio;

public class Usuario{
    private String username, pass;

    public Usuario(){
    }

    public Usuario(String username, String pass){
        this.username = username;
        this.pass = pass;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public String getUsername(){
        return username;
    }

    public String getPass(){
        return pass;
    }


}