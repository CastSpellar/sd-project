#a
#b
#c


  1. ### Sinopse ###
O trabalho consiste no desenvolvimento de um sistema que permita a visualização/audição de ficheiros multimédia disponibilizados por múltiplos utilizadores.

  1. Contexto
> > O contexto de implanta»c~ao do sistema ¶e o de uma organiza»c~ao em que a
maioria dos utilizadores utilizam computadores pessoais ligados por uma
rede local interna de elevada capacidade.
Sup~oe-se que n~ao existe, no sistema, nenhuma m¶aquina com capacidade
de armazenamento e conectividade su¯ciente para armazenar os recursos
disponibilizados por todos os utilizadores. Cada utilizador disp~oe de alguma
capacidade de armazenamento que pode ser usada pelo sistema a implemen-
tar.

  1. Objectivos
3.1 Objectivos gerais
Pretende-se com este sistema permitir aos utilizadores o acesso aos conte¶udos
multim¶edia disponibilizados por todos os participantes do sistema. O sistema
deve ser desenhado de forma a permitir melhorar a disponibilidade dos recur-
sos mais populares e a manter a carga dos clientes que disponibilizam estes
recursos em valores razo¶aveis, permitindo assim um bom desempenho.

  1. Arquitectura geral
As caracter¶³sticas espec¶³¯cas da arquitectura do sistema s~ao completamente
livres, exceptuando o facto do sistema se integrar com a interface gr¶a¯ca
disponibilizada atrav¶es da interface de¯nida pela mesma.
A natureza, o n¶umero e o modo de organiza»c~ao e interac»c~ao dos compo-
nentes do sistema s~ao completamente livres. ¶E permitido, tamb¶em, combinar
v¶arias tecnologias de suporte µa comunica»c~ao: UDP, TCP, RMI e IP Multi-
cast.

  1. Fases do trabalho
Fase 1 A primeira fase consiste num relat¶orio com o desenho preliminar do
sistema, de acordo com um relat¶orio modelo disponibilizado para o efeito.
A entrega ser¶a efectuada de acordo com as regras a especi¯car oportuna-
mente.
Fases 2 e 3 As fases 2 e 3 consistem na implementa»c~ao de um sistema
que satisfa»ca, pelo menos, as funcionalidades base de¯nidas para cada fase
respectivamente.
A entrega das funcionalidades opcionais pode ser deixada para a terceira
fase, embora esta abordagem n~ao seja aconselhada.
A entrega das fases 2 e 3 consiste na entrega do c¶odigo fonte do sistema
a funcionar e de um relat¶orio do trabalho efectuado, de acordo com os re-
lat¶orios modelo disponibilizados para o efeito.
A entrega ser¶a efectuada de forma electr¶onica, de acordo com as regras a
especi¯car oportunamente.

  1. Datas Importantes
Fase 1 A primeira fase do trabalho deve ser entregue at¶e µas 11:00 do dia
25 de Mar»co de 2007.
Os trabalhos entregues a seguir a esta data t^em uma penaliza»c~ao na nota
¯nal do trabalho de 0,25 valores por dia (ou frac»c~ao de dia). A entrega da
fase 1 ¶e obrigat¶oria.
Fase 2 A segunda fase do trabalho deve ser entregue at¶e µas 11:00 do dia 2
de Maio de 2007.

Os trabalhos entregues ap¶os esta data t^em uma penaliza»c~ao na nota ¯nal
do trabalho de 0,02 valores por cada hora (ou frac»c~ao de hora), at¶e uma
penaliza»c~ao m¶axima de 2 valores. Quem n~ao entregue a segunda fase ter¶a
uma penaliza»c~ao de 2 valores na nota ¯nal.
Fase 3 A terceira fase do trabalho deve ser entregue at¶e µas 23:59 do dia 25
de Maio de 2007.
Os trabalhos entregues ap¶os esta data t^em uma penaliza»c~ao na nota ¯nal
do trabalho de 0,05 valores por hora (ou frac»c~ao de hora).

  1. Ambiente de execu»c~ao
O trabalho dever¶a executar em ambiente Linux, usando a vers~ao JDK 6.0 da
linguagem Java. Com este enunciado ser¶a fornecido um conjunto de classes
que implementam uma interface gr¶a¯ca a incorporar na solu»c~ao a desenvolver.
Nota: Para evitar con°itos, os alunos devem utilizar o n¶umero de aluno
para os portos a usar pelo sistema (sockets, rmiregistry, etc.).

  1. Funcionalidades
8.1 Funcionalidades B¶asicas [valores](12.md)
O sistema a implementar deve permitir a um utilizador disponibilizar um
conjunto de ¯cheiro para acesso por outros utilizadores. O utilizador que
disponibiliza um ¯cheiro deve manter uma c¶opia do mesmo enquanto pre-
tender continuar a disponibiliz¶a-lo. Um utilizador pode decidir terminar a
disponibiliza»c~ao dum ¯cheiro em qualquer momento { esta decis~ao n~ao im-
plica que o ¯cheiro deixe de estar dispon¶³vel no sistema, caso o mesmo esteja
tamb¶em a ser disponibilizado por outros utilizadores.

8.1.1 Pesquisa [2](Fase.md)
A solu»c~ao apresentada deve permitir a um utilizador descobrir quais os
¯cheiros dispon¶³veis no sistema. A informa»c~ao obtida pode n~ao ser completa.
Quando esta informa»c~ao ¶e apresentada ao utilizador, deve ser poss¶³vel
o utilizador saber, pelo menos, o nome dos ¯cheiros e se os mesmos est~ao
dispon¶³veis localmente ou atrav¶es da rede.

8.1.2 Selec»c~ao [2](Fase.md)
A solu»c~ao apresentada deve permitir a um utilizador seleccionar, a partir da
pesquisa efectuada, uma lista de ¯cheiros para visualiza»c~ao/audi»c~ao. Para
cada ¯cheiro seleccionado, o sistema deve obter uma c¶opia de forma a que a
interface gr¶a¯ca disponibilizada possa fazer a sua apresenta»c~ao. A estrat¶egia
utilizada deve permitir, sempre que poss¶³vel, que a apresenta»c~ao seja efectu-
ada de forma cont¶³nua, i.e., sem pausas entre diferentes ¯cheiros (a interface
gr¶a¯ca garantir¶a esta propriedade caso os ¯cheiros estejam dispon¶³veis local-
mente).

8.1.3 Disponibilidade [2](Fase.md)
A solu»c~ao apresentada deve usar todas as c¶opias existentes dum dado recurso
para fornecer uma maior disponibilidade do mesmo.

8.1.4 Carga/fairness [2](Fase.md)
A solu»c~ao apresentada deve garantir que a carga de cada elemento do sistema
¶e razo¶avel, face aos recursos que o mesmo disponibiliza, i.e., dois elementos
com o mesmo conjunto de recursos devem apresentar cargas semelhantes.

8.1.5 Robustez [3](Fase.md)
Os sistema deve tolerar falhas inesperadas de comunica»c~ao ou de compo-
nentes de software e ser capaz de mascarar as mesmas.
Concretamente, devem-se mascarar as falhas no sistema de comunica»c~oes
ou nos elementos do sistema que durem menos de 30 segundos.

8.1.6 Seguran»ca [3](Fase.md)
A detalhar oportunamente.

8.2 Funcionalidades Opcionais [A](Grupo.md)
As funcionalidades seguintes permitem valorizar a solu»c~ao proposta at¶e um
m¶aximo acumulado de 4 valores. A contribui»c~ao m¶axima de cada funcional-
idade ¶e indicada na sec»c~ao respectiva. Solu»c~oes triviais para os problemas
enunciados n~ao ser~ao consideradas.

8.2.1 Auto-con¯gura»c~ao [valor](1.md)
O sistema deve incluir mecanismos que minimizem a necessidade de con-
¯gura»c~ao manual.

8.2.2 In¶³cio antecipado [valores](1.md)
O sistema deve permitir o in¶³cio da apresenta»c~ao de ¯cheiros dos quais se est¶a
a obter uma c¶opia, garantindo que a apresenta»c~ao n~ao ser¶a interrompida caso
o conjunto de m¶aquinas dispon¶³veis e as condi»c~oes da rede n~ao se alterem
signi¯cativamente.

8.2.3 Redund^ancia/Replica»c~ao [1.5 valores]
O sistema deve incorporar mecanismos/algoritmos activos de replica»c~ao dos
¯cheiros disponibilizados pelos utilizadores. Estes mecanismos devem ser
activos, garantindo a redund^ancia de todos os ¯cheiros, incluindo os menos
populares.

8.2.4 Suporte para utilizadores remotos com conectividade as-
sim¶etrica [at¶e 2.5 valores]
O sistema deve incorporar solu»c~oes que permitam aos utilizadores com conec-
tividade assim¶etrica participar e contribuir para o sistema.
Suponha que estes utilizadores disp~oem de uma conex~ao de capacidade
menor e assim¶etrica, com maior capacidade de download do que de upload
(por exemplo, 8Mb de download e 256 Kb de upload). Adicionalmente, leve
em conta que a disponibilidade de comunica»c~ao multi-ponto est¶a circunscrita
a redes locais, n~ao incluindo estes utilizadores.

8.2.5 Inter-opera»c~ao [at¶e 2 valores]
Esta op»c~ao consiste em implementar mecanismos que permitam a inter-
opera»c~ao entre solu»c~oes desenvolvidas por diferentes grupos. A valoriza»c~ao
da solu»c~ao depende da diferen»ca das solu»c~oes implementadas. Em caso de
d¶uvida sobre o valor de uma dada solu»c~ao, a mesma pode ser discutida an-
tecipadamente com o docente da cadeira.

8.2.6 Originalidade [at¶e 2 valores]
Quaisquer outras funcionalidades n~ao contempladas no enunciado que se rev-
elem originais e interessantes ser~ao um factor de valoriza»c~ao extra do tra-
balho. Recomenda-se que estas funcionalidades sejam discutidas antecipada-
mente com o docente da cadeira.

8.3 Funcionalidades Opcionais de Seguran»ca [Grupo
B]
A detalhar oportunamente.

8.4 Funcionalidades Opcionais [C](Grupo.md)
A detalhar oportunamente.
