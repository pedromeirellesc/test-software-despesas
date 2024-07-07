const cepInput = document.getElementById('cep');
const estadoInput = document.getElementById('estado');
const cidadeInput = document.getElementById('cidade');
const bairroInput = document.getElementById('bairro');
const ruaInput = document.getElementById('rua');
const successMessage = document.getElementById('successMessage');

function buscarEndereco() {
  const cep = cepInput.value.replace(/[^0-9]/g, '');

  if (cep.length >= 8) {
    fetch(`https://viacep.com.br/ws/${cep}/json/`)
      .then(response => response.json())
      .then(data => {
        if (data.erro) {
          // Handle error (e.g., display error message)
          return;
        }

        estadoInput.value = data.uf;
        cidadeInput.value = data.localidade;
        bairroInput.value = data.bairro;
        ruaInput.value = data.logradouro;

        // Enable disabled input fields
        estadoInput.disabled = false;
        cidadeInput.disabled = false;
        bairroInput.disabled = false;
        ruaInput.disabled = false;
      })
      .catch(error => {
        console.error('Error:', error);
        // Handle network or other errors
      });
  }
}

const nomeCredorInput = document.getElementById('creditorName');
const nameError = document.getElementById('nameError');
const celularInput = document.getElementById('creditorCelular');
const telefoneInput = document.getElementById('creditorTelefone');
const cellphoneError = document.getElementById('cellphoneError');
const phoneError = document.getElementById('phoneError');


const form = document.getElementById('creditorForm');
const nomeCredor = document.getElementById('creditorName');
const nomeCredorError = document.createElement('span');
nomeCredorError.className = 'error';
nomeCredorError.style.display = 'none';
nomeCredorError.textContent = 'Nome do Credor é obrigatório.';
nomeCredor.parentNode.insertBefore(nomeCredorError, nomeCredor.nextSibling);

form.addEventListener('submit', function (event) {
    let isValid = true;

    // Verificação do campo Nome do Credor
    if (nomeCredor.value.trim() === '') {
        nomeCredorError.style.display = 'inline';
        isValid = false;
    } else {
        nomeCredorError.style.display = 'none';
    }


});




function validateNumericInput(input, errorElement) {
  const regex = /^[0-9]*$/;
  if (!regex.test(input.value)) {
      errorElement.style.display = 'inline';
      input.value = input.value.replace(/[^0-9]/g, '');
  } else {
      errorElement.style.display = 'none';
  }
}

celularInput.addEventListener('input', () => validateNumericInput(celularInput, cellphoneError));
telefoneInput.addEventListener('input', () => validateNumericInput(telefoneInput, phoneError));


function validateName() {
    const regex = /^[A-Za-z\s]+$/;
    if (!regex.test(nomeCredorInput.value)) {
        nameError.style.display = 'inline';
        nomeCredorInput.value = nomeCredorInput.value.replace(/[^A-Za-z\s]/g, '');
    } else {
        nameError.style.display = 'none';
    }
}

nomeCredorInput.addEventListener('input', validateName);

function handleSubmit(event) {
  event.preventDefault();

  // Simulate form submission process
  setTimeout(() => {
    successMessage.style.display = 'block';
  }, 500);
}
