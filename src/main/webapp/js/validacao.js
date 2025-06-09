function validarFormulario() {
    const titulo = document.getElementById('titulo').value.trim();

    if (titulo === "") {
        alert("Por favor, preencha o título da tarefa.");
        document.getElementById('titulo').focus();
        return false; // impede o envio do formulário
    }
    return true; // permite o envio
}
