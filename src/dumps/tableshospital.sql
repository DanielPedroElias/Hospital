CREATE TABLE Endereco (
    id INT AUTO_INCREMENT PRIMARY KEY,
    logradouro VARCHAR(255),
    numero INT,
    bairro VARCHAR(255),
    CEP VARCHAR(10)
);

CREATE TABLE Pessoa (
    nome VARCHAR(255) PRIMARY KEY,
    dataNascimento DATE,
    endereco_id INT,
    FOREIGN KEY (endereco_id) REFERENCES Endereco(id)
);

CREATE TABLE Plano (
    nome VARCHAR(255) PRIMARY KEY,
    mensalidade DOUBLE
);

CREATE TABLE Paciente (
    CPF VARCHAR(14) PRIMARY KEY,
    nome VARCHAR(255),
    dataNascimento DATE,
    endereco_id INT,
    plano_nome VARCHAR(255),
    FOREIGN KEY (plano_nome) REFERENCES Plano(nome),
    FOREIGN KEY (nome) REFERENCES Pessoa(nome)
);

CREATE TABLE Medico (
    nome VARCHAR(255) ,
    CRM INT PRIMARY KEY,
    valorHora DOUBLE,
    dataNascimento DATE,
    endereco_id INT,
	especialidade VARCHAR(255),
    FOREIGN KEY (nome) REFERENCES Pessoa(nome)
);

CREATE TABLE Sala (
    nome VARCHAR(255) PRIMARY KEY
);

CREATE TABLE Procedimento (
    paciente_cpf VARCHAR(14),
    medico_nome VARCHAR(255),
    data DATE,
    sala VARCHAR(255),
    valor DOUBLE,
    tempoDuracao INT,
    FOREIGN KEY (sala) REFERENCES Sala(nome),
    FOREIGN KEY (paciente_cpf) REFERENCES Paciente(CPF),
    FOREIGN KEY (medico_nome) REFERENCES Medico(nome)
);

CREATE TABLE Consulta (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    paciente_cpf VARCHAR(255),
    medico_nome VARCHAR(255),
    data DATE,
    FOREIGN KEY (paciente_cpf) REFERENCES Paciente(CPF),
    FOREIGN KEY (medico_nome) REFERENCES Medico(nome)
);


CREATE TABLE Especialidade (
    especialidade VARCHAR(255) primary key
);
	
CREATE TABLE Medico_Especialidade (
    medico_crm INT ,
    especialidade VARCHAR(255),
    FOREIGN KEY (medico_crm) REFERENCES Medico(CRM),
    FOREIGN KEY (especialidade) REFERENCES Especialidade(especialidade),
    PRIMARY KEY (medico_crm, especialidade)
);

CREATE TABLE ITransmissaoDadoMinisterio (
    id INT AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE Neurocirurgia (
    id INT AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE Faringoplastia (
    id INT AUTO_INCREMENT PRIMARY KEY
);
