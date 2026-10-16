document.getElementById("cadastro").style.display = "none";

document.getElementById("hLogin").addEventListener("click", function(){
    document.getElementById("login").style.display = "block";
    document.getElementById("cadastro").style.display = "none";
})

document.getElementById("hCadastro").addEventListener("click", function(){
    document.getElementById("cadastro").style.display = "block";
    document.getElementById("login").style.display = "none";

})