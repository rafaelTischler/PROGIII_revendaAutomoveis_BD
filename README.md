# Sistema de Gerenciamento de Automóveis 🚗  

Este é um sistema de gerenciamento de automóveis desenvolvido em **Java** com interface gráfica utilizando **Swing**. 
Ele foi projetado para ser uma solução intuitiva e eficiente para administrar o estoque de veículos em uma revenda, 
abrangendo desde o login de usuários até a exclusão de automóveis.  

## 🛠️ Funcionalidades Principais  

### 1. **Login e Cadastro de Usuários**  
- **Tela de Login:**  
  - Autenticação de usuários com validação de credenciais.  
  - Interface amigável para acesso seguro ao sistema.  

- **Tela de Cadastro de Usuários:**  
  - Formulário para criação de contas de novos usuários com campos como nome, e-mail e senha.  
  - Validações para evitar dados inconsistentes.  

### 2. **Cadastro de Automóveis**  
- Adicione novos veículos ao estoque preenchendo informações como marca, modelo, ano de fabricação, cor e tipo de combustível.  
- Validações para evitar campos vazios ou dados inválidos.  

### 3. **Consulta de Automóveis**  
- Pesquise veículos cadastrados com base em diferentes critérios (ex.: marca, modelo, ID).  
- Visualize a lista completa de veículos armazenados no sistema.  

### 4. **Alteração de Dados**  
- Atualize as informações de veículos existentes no sistema.  
- Permite a busca pelo ID do veículo para preencher automaticamente os campos com os dados atuais.  

### 5. **Remoção de Automóveis**  
- Exclua veículos do sistema informando seu ID.  
- Confirmação para evitar exclusões acidentais.  

### 6. **Navegação Intuitiva**  
- Menus interativos para acessar rapidamente as diferentes telas do sistema.  
- Feedback visual para interações, como alterações de cor ao passar o mouse sobre os menus.  

### 7. **Interface Customizada**  
- Design responsivo utilizando **MigLayout** para uma organização clara e adaptável.  
- Imagem de fundo personalizada para cada tela.  

## 🌟 Screenshots  

> **Telas disponíveis no sistema (com prints para documentação):**  

1. **Tela de Login**  
   - Formulário para autenticação do usuário com validação de credenciais.
     ![image](https://github.com/user-attachments/assets/27b12df8-0c96-4e73-b259-831a245d5c86)


2. **Tela de Cadastro de Usuário**  
   - Formulário para criação de novos usuários com validações.
     ![image](https://github.com/user-attachments/assets/cd5c7f77-ec88-410e-9933-009dc9da819d)


3. **Tela Inicial (Menu Principal)**  
   - Acesso rápido a todas as funcionalidades: cadastro, consulta, alteração e remoção.
     ![WhatsApp Image 2024-12-08 at 14 28 52](https://github.com/user-attachments/assets/5bee3e53-7714-4a98-be94-95115ae9fea0)


4. **Tela de Cadastro de Automóveis**  
   - Formulário para inserção de novos veículos.  
   - Botões para salvar os dados e limpar o formulário.
     ![WhatsApp Image 2024-12-08 at 14 28 52](https://github.com/user-attachments/assets/bf5aaade-db03-4718-aa93-509325794fea)


5. **Tela de Consulta de Automóveis**  
   - Lista completa dos veículos cadastrados.  
   - Opção para buscar veículos específicos.
     ![WhatsApp Image 2024-12-08 at 14 28 51](https://github.com/user-attachments/assets/3bc6586b-af22-4a19-8dc2-2cbafab629b5)


6. **Tela de Alteração e Remoção de Automóveis**  
   - Campos editáveis para atualizar informações do veículo.  
   - Botões para salvar alterações ou remover o veículo do estoque.
     ![WhatsApp Image 2024-12-08 at 14 28 53](https://github.com/user-attachments/assets/8aaa21e6-124b-47e6-9512-e81c2870a025)


## 🚀 Como Executar  

1. Clone o repositório para sua máquina local:  
   ```bash  
   git clone [https://github.com/rafaelTischler/PROGIII_revendaAutomoveis_BD.git]
   ```  
2. Importe o projeto para sua IDE favorita (ex.: IntelliJ IDEA, Eclipse).  
3. Configure o caminho para as imagens na pasta `src/img`.  
4. Compile e execute o arquivo principal `JFrame_automoveis.java`.  

## 🛡️ Tecnologias Utilizadas  

- **Linguagem:** Java  
- **Interface Gráfica:** Swing  
- **Gerenciamento de Layout:** MigLayout  
- **Banco de Dados:** Conexão JDBC com banco relacional  
- **IDE:** Eclipse/IntelliJ IDEA  
