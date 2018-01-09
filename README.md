# Empresa_Aerea
Projeto de uma empresa aérea para controle de voo

Plano de desenvolvimento

Como metodologia de desenvolvimento, considero utilizar o TDD onde se escreve primeiro os testes antes de implementar o sistema. Como cenário ideal considero a criação de testes unitários ou de componentes, onde torna o processo mais confiável e reduz custos, visto que desenvolvemos e já sabemos os erros. Para criação do projeto utilizando essa metodologia, demanda um tempo um pouco maior na criação, mas se ganha tempo no fechamento do projeto, onde a incidência de erros é bem menor. Para esse projeto foram criados alguns testes unitários, mas como é um tiro curto (pouco tempo de desenvolvimento), o desenvolvimento foi criado e depois foi realizado alguns testes.

Estrutura e organização

Na criação do projeto, foi desenvolvido um módulo web onde contempla os requisitos descritos no enunciado. Visto que o projeto inicialmente tempo poucos requisitos e o desenvolvimento é rápido, foi criado um único módulo web onde contempla a parte model, controller e a view do projeto. Analisando um cenário com mais requisitos, com vários desenvolvedores trabalhando e uma escalabilidade maior, o correto seria distribuir as partes de model, controller e view em módulos separados priorizando a clareza do código e a divisão de tarefas entre os desenvolvedores. Como organização de front-end, é utilizado o framework Angular.js  que é divido no modelo MVC (model-view-control) em classes javascript onde se mantém os controllers, constants, services, etc.., e também os templates utilizados como view do sistema.

Gerenciamento de dependências

Como gerenciador de dependências é utilizado o maven que é responsável pela integração de todas as dependências necessárias para o projeto funcionar. Através do seu repository que armazena as libs necessárias, o maven é configurável no projeto pelo arquivo pom.xml, onde cuida das dependências de cada módulo. É utilizado também o spring framework que cuida da autenticação através do spring security, injeção de dependências entre outras funcionalidades que aumentam o desempenho da aplicação.

Modelo de trabalho

Trabalho com a metodologia scrum, onde prioriza a gestão e o planejamento do projeto. Os projetos são divididos em ciclos geralmente mensais chamados de sprints. Uma sprint representa um conjunto de atividades a desenvolver dentro de um tempo estabelecido. Geralmente os commits são baseados em entregas de atividades e requisitos dentro das sprints.

Banco de dados

O framework para mapeamento de objeto relacional utilizado é o hibernate, onde facilita a criação das tabelas e todo mapeamento de chaves e restrições criadas no sistema. O banco de dados utilizado é o Postgres que é um banco relacional open source.

Testes de integração
É comum utilizar selenium para criação de testes de integração no sistema. Para esse projeto, foi utilizado uma extensão ou plug-in do navegador Chrome chamada Sideex que tem basicamente as mesmas funcionalidades do selenium, porém a configuração e a utilização é bem simples.

Controle de versão
No cenário atual existem duas ferramentas que geralmente são utilizadas para o controle de versionamento, são elas: SVN tortoise e o GitHub. No caso do projeto é utilizado o GitHub para armazenamento do código e possíveis versionamentos.

Servidor de Aplicação
O servidor de aplicação utilizado no projeto é o tomcat 8, mas também foi realizado testes no jboss wildfly 9. Para o deploy da aplicação é executado o servidor de aplicação, onde é criar um arquivo .war que disponibiliza a aplicação em um endereço pré definido. No caso de endereço local geralmente se usa http://localhost:8080.

Configurações de desenvolvimento
O Java instalado para executar o sistema é o Java 7. A IDE de desenvolvimento é o eclipse MARS, e também testado no intellij Idea Community.
