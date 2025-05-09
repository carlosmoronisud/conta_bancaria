# Banco Beth 82 - Sistema de Conta Bancária

![Java](https://img.shields.io/badge/Java-17%2B-blue)
![License](https://img.shields.io/badge/License-MIT-green)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

## 📝 Descrição

O Banco Beth 82 é um sistema bancário em Java que permite gerenciar contas correntes e poupanças, com operações como saque, depósito, transferência e consultas. Desenvolvido como projeto acadêmico, implementa conceitos de POO, tratamento de exceções e boas práticas de programação.

## ✨ Funcionalidades

- ✅ Criação de contas (corrente e poupança)
- 🔍 Consulta de contas por número ou titular
- 💰 Operações financeiras (saque, depósito, transferência)
- ✏️ Atualização de dados cadastrais
- 🗑️ Exclusão de contas
- 📊 Listagem completa de todas as contas

## 🛠️ Tecnologias Utilizadas

- **Java 17+** - Linguagem principal
- **Scanner** - Para entrada de dados
- **Tratamento de Exceções** - Validação de entradas
- **POO** - Programação Orientada a Objetos
- **Console Colors** - Melhoria na interface

## 📦 Estrutura do Projeto

```
conta_bancaria/
├── src/
│   ├── controller/       # Lógica de controle
│   ├── model/            # Classes de domínio
│   ├── util/             # Utilitários e exceções
│   └── Menu.java         # Interface principal
└── README.md
```

## 🚀 Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/carlosmoronisud/conta_bancaria.git
```

2. Navegue até o diretório do projeto:
```bash
cd conta_bancaria
```

3. Compile e execute:
```bash
javac src/Menu.java
java -cp src Menu
```

## 🧑‍💻 Autor

**Carlos Moroni Garcia**  
📧 carlosmoronisud@gmail.com  
🔗 [GitHub](https://github.com/carlosmoronisud)  
🔗 [LinkedIn](https://www.linkedin.com/in/carlosmoronisud)

## 📄 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

---

> 💡 **Dica**: O sistema já vem com contas de teste pré-cadastradas para facilitar os testes.  
> João da Silva (CC) e Maria da Silva (CP) com saldo inicial de R$1000,00.