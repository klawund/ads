function validaFaleConosco() {
    const form = document.frmfaleconosco;

    const nome = form.txtnome.value;
    const regExpNome = /^[A-zÀ-ü]{3,}([ ]{1}[A-zÀ-ü]{2,})+$/;

    if (!regExpNome.test(nome)) {
        alert('Campo "nome" inválido!');
        form.txtnome.focus();
        return false;
    }

    const fone = form.txtfone.value;
    const regExpFone = /^[(]{1}[1-9]{2}[)]{1}[0-9]{4,5}[-]{1}[0-9]{4}$/;
    
    if (!regExpFone.test(fone)) {
        alert('Campo "fone" inválido!');
        form.txtfone.focus();
        return false;
    }
    
    if (form.txtemail.value === '') {
        alert('Preencha o campo e-mail!');
        form.txtemail.focus();
        return false;
    }
    
    if (form.selmotivo.value === '') {
        alert('Preencha o campo motivo!');
        form.selmotivo.focus();
        return false;
    } 
    
    if (form.selproduto?.value === '') {
        alert('Preencha o campo produto!')
        form.selproduto.focus();
        return false;
    } 
    
    if (form.txtcomentario.value === '') {
        alert('Preencha o campo comentário!');
        form.txtcomentario.focus();
        return false;
    }
    return true;
}

function verificaMotivo(motivo) {
    const el = document.getElementById('opcaoProduto');

    if (motivo === 'PR') {
        const select = document.createElement('select');
        select.setAttribute('name', 'selproduto');

        const baseOption = document.createElement('option');
        baseOption.setAttribute('value', '');
        baseOption.appendChild(document.createTextNode('Escolha'));
        select.appendChild(baseOption);

        const freezerOption = document.createElement('option');
        freezerOption.setAttribute('value', 'FR');
        freezerOption.appendChild(document.createTextNode('Freezer'));
        select.appendChild(freezerOption);

        const refrigeratorOption = document.createElement('option');
        refrigeratorOption.setAttribute('value', 'GE');
        refrigeratorOption.appendChild(document.createTextNode('Geladeira'));
        select.appendChild(refrigeratorOption);

        el.appendChild(select);
    } else if (el.firstChild) {
        el.removeChild(el.firstChild);
    }
}